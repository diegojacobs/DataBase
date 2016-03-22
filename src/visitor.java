import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.antlr.v4.runtime.misc.NotNull;


/**
@author Diego Jacobs
Date: Mar 19, 2016
 */
public class visitor<T> extends sqlBaseVisitor<Object> {

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
	 * @param errores the errores to set
	 */
	public void setErrores(ArrayList<String> errores) {
		this.errores = errores;
	}
	
	public visitor()
	{
		Path currentRelativePath = Paths.get("");
		dataPath = currentRelativePath.toAbsolutePath().toString() + "\\data\\";
		cargarDBs();
	}
	
	public void cargarDBs()
	{
		try {
			FileInputStream fis = new FileInputStream(this.dataPath+"dbs.bin");
			ObjectInputStream in = new ObjectInputStream(fis);
			this.dataBases = (DataBases)in.readObject();
			//in.close();
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
	
	public void guardarDBs()
	{
		try {
			FileOutputStream fos = new FileOutputStream(this.dataPath+"dbs.bin");
			ObjectOutputStream out = new ObjectOutputStream(fos);            
            // Escribir el objeto en el fichero
            out.writeObject(this.dataBases);            
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override 
	public T visitSql2003Parser(@NotNull sqlParser.Sql2003ParserContext ctx) 
	{ 
		for (int i = 0;i<ctx.getChildCount();i++){
            this.visit(ctx.getChild(i));
         }
        return (T)new String(); 
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
			String rule_5 = "No se puede usar la DataBase " + ID + " porque no ha sido creada @line: " + ctx.getStop().getLine();
			this.errores.add(rule_5);
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
        	String rule_1 = "Error al crear el directorio " + ID + " @line: " + ctx.getStop().getLine();
        	this.errores.add(rule_1);
        }
        else
        {
        	this.dataBases.addDataBase(new_DB);
    		guardarDBs();
        }
		return (T)"";
		//return visitChildren(ctx); 
	}
	
	
	/****************************************************************
	 * Tipo_literal
	 * Debemos ver si es char tomar el tamaño del char
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
	 * Validamos el dia segun el mes y el año
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
	 * Debemos revisar el tamaño de este texto
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
	 * Un año solo es bisiesto si es divisible entre 4
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
