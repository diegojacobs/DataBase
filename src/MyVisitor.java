import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Stack;

import org.antlr.v4.runtime.misc.NotNull;

/**
@author Diego Jacobs (jewish boy)
Date: Mar 19, 2016
 */
public class MyVisitor<T> extends sqlBaseVisitor<Object> {

	// Atributos
	
	private String dataPath;
	private ArrayList<String> errores = new ArrayList<String>();
	private DataBases dataBases = new DataBases();
	private DataBase actual = new DataBase();	
	
	/**
	 * @return the errores
	 */
	public ArrayList<String> getErrores() {
		return errores;
	}
	
	/**
	 * @return the errores in toString form
	 */
	public String erroresToString()
	{
		String res = "Errores:\n";
		int cont = 1;
		for (String i: this.errores)
		{
			res += "Error #" + Integer.toString(cont) + " -> " + i + "\n";
			cont++;
		}
		res += Integer.toString(cont-1) + " ERRORES EN TOTAL";
		if (cont == 1)
			res = "";
		return res;
	}

	/**
	 * @param errores the errores to set
	 */
	public void setErrores(ArrayList<String> errores) {
		this.errores = errores;
	}
	
	/*
	 * Cargar las DataBases (directorios) ya creados
	 */
	public MyVisitor()
	{
		Path currentRelativePath = Paths.get("");
		dataPath = currentRelativePath.toAbsolutePath().toString() + "\\data\\";
		cargarDBs();		
	}
	
	/*
	 * Des serializa el objeto
	 */
	public void cargarDBs()
	{
		try {
			FileInputStream fis = new FileInputStream(this.dataPath+"dbs.bin");
			BufferedReader br = new BufferedReader(new FileReader(this.dataPath+"dbs.bin"));     
			if (br.readLine() != null)
			{
				ObjectInputStream in = new ObjectInputStream(fis);
				this.dataBases = (DataBases)in.readObject();
				fis.close();
				in.close();
			}			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * Serializa el objeto
	 */
	public void guardarDBs()
	{
		try {
			FileOutputStream fos = new FileOutputStream(this.dataPath+"dbs.bin");
			ObjectOutputStream out = new ObjectOutputStream(fos);            
            // Escribir el objeto en el fichero
            out.writeObject(this.dataBases);
            //out.close();
            //fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override 
	public T visitUse_schema_statement(@NotNull sqlParser.Use_schema_statementContext ctx) 
	{ 
		String ID = ctx.ID().getText();
		boolean find = false;
		for (DataBase i: this.dataBases.getDataBases())
			if (i.getName().equals(ID))
			{
				find = true;
				this.actual = i;
				break;
			}
		if (! find)
		{
			this.actual = new DataBase();
			String rule_5 = "No se puede usar la Base de Datos \"" + ID + "\" porque no ha sido creada @line: " + ctx.getStop().getLine();
			this.errores.add(rule_5);
		}
		else
		{
			System.out.println("DataBase \"" + ID + "\" actualmente en uso");
		}
		return (T)"";
		//return visitChildren(ctx); 
	}
	
	
	@Override 
	public T visitSchema_definition(@NotNull sqlParser.Schema_definitionContext ctx)
	{ 		
		String ID = ctx.ID().getText();
		DataBase new_DB = new DataBase(ID);
        File new_directory = new File(this.dataPath+ID);
        boolean succes = new_directory.mkdirs();        
        if (!succes)
        {
        	String rule_1 = "No se puede crear la Base de Datos " + ID + " porque ya existe otra con el mismo nombre @line: " + ctx.getStop().getLine();
        	this.errores.add(rule_1);
        }
        else
        {
        	System.out.println("DataBase \"" + ID + "\" creada exitosamente");
        	this.dataBases.addDataBase(new_DB);
    		guardarDBs();
        }
		return (T)"";
		//return visitChildren(ctx); 
	}	
	
	/* (non-Javadoc)
	 * @see sqlBaseVisitor#visitDrop_schema_statement(sqlParser.Drop_schema_statementContext)
	 */
	@Override
	public Object visitDrop_schema_statement(sqlParser.Drop_schema_statementContext ctx) {
		// TODO Auto-generated method stub
		String ID = ctx.ID().getText();
		File directory = new File(this.dataPath+ID);
		if (directory.exists())
		{			
			// Establecer nuevo set de DataBases
			ArrayList<DataBase> new_dataBases = new ArrayList<DataBase>();
			boolean exist = false;
			for(DataBase i: this.dataBases.getDataBases())
				if (! i.getName().equals(ID))
					new_dataBases.add(i);
				else
					exist = true;
			if (exist)
			{
				this.dataBases.setDataBases(new_dataBases);
				// Guardar nuevo set de DataBases
				guardarDBs();
				// Verificar si la DataBase actual es la eliminada para quitar la referencia
				if (this.actual.getName().equals(ID))
					this.actual = new DataBase();
				// Borrar directorio
				File[] currList;
				Stack<File> stack = new Stack<File>();
				stack.push(directory);
				while (! stack.isEmpty())
				{
				    if (stack.lastElement().isDirectory())
				    {
				        currList = stack.lastElement().listFiles();
				        if (currList != null)
				        {
					        if (currList.length > 0)
					        {
					            for (File curr: currList)
					                stack.push(curr);
					        }
					        else			        
					            stack.pop().delete();
				        }
				    } 
				    else
				        stack.pop().delete();
				}
				System.out.println("DataBase \"" + ID + "\" eliminada exitosamente");
			}
			else
			{
				String no_database_exist = "No se puede eliminar la Base de Datos \"" + ID + "\" porque no ha sido creada @line: " + ctx.getStop().getLine();
	        	this.errores.add(no_database_exist);
			}
		}
		else
		{
			String no_database_exist = "No se puede eliminar la Base de Datos \"" + ID + "\" porque no ha sido creada @line: " + ctx.getStop().getLine();
        	this.errores.add(no_database_exist);
		}
		return (T)"";
		//return super.visitDrop_schema_statement(ctx);
	}

	/****************************************************************
	 * Tipo_literal
	 * Debemos ver si es char tomar el tama�o del char
	 * 
	 * (non-Javadoc)
	 * @see sqlBaseVisitor#visitTipo_literal(sqlParser.Tipo_literalContext)
	 *****************************************************************/
	@Override 
	public T visitTipo_literal(@NotNull sqlParser.Tipo_literalContext ctx) 
	{ 
		int cant = 0;
		
		if (ctx.getChildCount() > 1)
		{
			cant = Integer.parseInt(ctx.INT().getText());
		}
		
		return (T)visitChildren(ctx); 
	}
	
	
	/****************************
	 * Recibimos un numero
	 * Si este contiene un punto
	 * quitamos todo lo que este despues del punto
	 ****************************/
	@Override 
	public T visitInt_literal(@NotNull sqlParser.Int_literalContext ctx) 
	{ 
		String num = ctx.NUM().getText();
		
		if (num.contains("."))
		{
			int index = num.indexOf('.');
			num = num.substring(0, index);
		}
		
		return (T)"int"; 
	}
	
	
	/****************************
	 * Recibimos un numero
	 * Si este no contiene punto
	 * le agregamos .0
	 ****************************/
	@Override 
	public T visitFloat_literal(@NotNull sqlParser.Float_literalContext ctx) 
	{ 
		String num = ctx.NUM().getText();
		
		if (!num.contains("."))
		{
			num += ".0";
		}
		
		return (T)"float"; 
	}
	
	
	/******************************************
	 * YEAR-MONTH-DAY
	 * 1<=MONTH<=12
	 * Validamos el dia segun el mes y el a�o
	 *******************************************/
	@Override 
	public T visitDate_literal(@NotNull sqlParser.Date_literalContext ctx) 
	{ 
		String fecha = ctx.DATE().getText(); 
		
		fecha = fecha.replace("'", "");
		
		String[] date = fecha.split("-");
		
		int anio = Integer.parseInt(date[0]);
		int mes = Integer.parseInt(date[1]);
		int dia = Integer.parseInt(date[2]);
		
		if (1 <= mes && mes<= 12 && dia>=1)
		{
			if (bisiesto(anio))
			{
				if (mes == 2)
				{
					if (dia<=29)
					{
						return (T)"Date";
					}
				}
				else
				{
					if (dia<=maxday(mes))
					{
						return (T)"Date";
					}
				}
			}
			else
			{
				if (mes == 2)
				{
					if (dia<=28)
					{
						return (T)"Date";
					}
				}
				else
				{
					if (dia<=maxday(mes))
					{
						return (T)"Date";
					}
				}
			}
		}
		else
		{
			return (T)"Error";
		}
		return (T)"Error"; 
	}
	
	
	/****************************
	 * Recibimos un texto
	 * Debemos revisar el tama�o de este texto
	 ****************************/
	@Override 
	public T visitChar_literal(@NotNull sqlParser.Char_literalContext ctx) 
	{ 
		String text = ctx.CHAR().getText();
		
		text = text.substring(1, text.length() - 1);
		
		int length = text.length();
		
		return (T)"Char"; 
	}
	
	
	/******************
	 * Un a�o solo es bisiesto si es divisible entre 4
	 * pero no dentro de 100 pero si dentro de 400
	 * @param anio
	 * @return
	 */
	public boolean bisiesto(int anio)
	{
		return (anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0));
	}
	
	
	/************************
	 * Segun el mes que recsivamos 
	 * devolvemos le maximo dia que puede tener
	 * @param mes
	 * @return
	 */
	public int maxday(int mes)
	{
		int dia = 0;
		
		if (mes == 1 || dia == 3 || dia == 5 || dia == 7 || dia == 8 || dia == 10 || dia == 12)
			dia = 31;
		else
			dia = 30;
		
		return dia;
	}
	
}
