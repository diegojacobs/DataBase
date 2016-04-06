import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import java.util.Comparator;
import java.net.URL;
import java.net.URLClassLoader;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;


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
	private Table table_use = new Table();
	private int inserted_rows = 0;
	private int deleted_rows = 0;
	private int updated_rows = 0;
	
	public void resetValues(){
		errores = new ArrayList<String>();
		table_use = new Table();
		inserted_rows = 0;
		deleted_rows = 0;
		updated_rows = 0;
	}
	
	public int getInserted_rows() {
		return inserted_rows;
	}

	public void setInserted_rows(int inserted_rows) {
		this.inserted_rows = inserted_rows;
	}

	public int getDeleted_rows() {
		return deleted_rows;
	}

	public void setDeleted_rows(int deleted_rows) {
		this.deleted_rows = deleted_rows;
	}

	public int getUpdated_rows() {
		return updated_rows;
	}

	public void setUpdated_rows(int updated_rows) {
		this.updated_rows = updated_rows;
	}

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
				//fis.close();
				//in.close();
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
	
	/*
	 * Serializa una Tabla
	 */
	public void saveTable(String dbName, String name, Table t)
	{
		try {
			FileOutputStream fos = new FileOutputStream(this.dataPath + "\\" + dbName + "\\" + name + ".bin");
			ObjectOutputStream out = new ObjectOutputStream(fos);            
            // Escribir el objeto en el fichero
            out.writeObject(t);
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
				this.setActual(i);
				break;
			}
		if (find == false)
		{
			this.setActual(new DataBase());
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
    		//guardarDBs();
        }
		return (T)"";
		//return visitChildren(ctx); 
	}	
	
	/* (non-Javadoc)
	 * @see sqlBaseVisitor#visitDrop_schema_statement(sqlParser.Drop_schema_statementContext)
	 * 
	 * FALTAN IMPLEMENTAR LA SIGUIENTE RESTRICCION
	 *	Verificación para DROP DATABASE. Para esta instrucción se debe hacer una doble verificación con el usuario del DBMS
		mostrando el siguiente mensaje: “¿Borrar base de datos nombre_BD con N registros? (si/no)” Donde N es la sumatoria de los
		registros de todas las tablas en la base de datos.
	 * 
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
				// Guardar nuevo set de DataBases
				this.dataBases.setDataBases(new_dataBases);
				//guardarDBs();
				// Verificar si la DataBase actual es la eliminada para quitar la referencia
				if (this.getActual().getName().equals(ID))
					this.setActual(new DataBase());
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

	/* (non-Javadoc)
	 * @see sqlBaseVisitor#visitAlter_database_statement(sqlParser.Alter_database_statementContext)
	 */
	@Override
	public Object visitAlter_database_statement(sqlParser.Alter_database_statementContext ctx) {
		// TODO Auto-generated method stub
		String ID = ctx.ID(0).getText();
		String NEW_ID = ctx.ID(1).getText();
		File directory = new File(this.dataPath + ID);
		// Verificar que los ID no sean iguales porque si son iguales no se hace nada
		if (! ID.equals(NEW_ID))
		{
			boolean exist = false;
			for(DataBase i: this.dataBases.getDataBases())
				if (i.getName().equals(ID))
				{
					// Si encuentra una ocurrencia se hace el cambio de nombre
					i.setName(NEW_ID);
					exist = true;
					break;
				}
			// Verificar si existe la DataBase a renombrar
			if (exist)
			{
				// Guardar el cambio
				//guardarDBs();
				// Verificar si hay que cambiar tambien el nombre de la DataBase actual
				if (this.getActual().getName().equals(ID))
					this.getActual().setName(NEW_ID);
				// Renombrar el directorio
				directory.renameTo(new File(this.dataPath + NEW_ID));
				System.out.println("DataBase \"" + ID + "\" renombrada a \"" + NEW_ID +"\" exitosamente");
			}
			else
			{
				String no_database_exist = "No se puede renombrar la Base de Datos \"" + ID + "\" porque no ha sido creada @line: " + ctx.getStop().getLine();
	        	this.errores.add(no_database_exist);
			}
				
		}
		return (T)"";
		//return super.visitAlter_database_statement(ctx);
	}

	/* (non-Javadoc)
	 * @see sqlBaseVisitor#visitRename_table_statement(sqlParser.Rename_table_statementContext)	 
	 */
	@Override
	public Object visitRename_table_statement(sqlParser.Rename_table_statementContext ctx) {
		// TODO Auto-generated method stub
		String ID = ctx.ID(0).getText();
		String NEW_ID = ctx.ID(1).getText();		
		// Verificar que los ID no sean iguales porque si son iguales no se hace nada
		if (! ID.equals(NEW_ID))
		{
			// Verificar que se este utilizando una base de datos
			if (this.getActual().getName().isEmpty())
			{
				String no_database_in_use = "No hay una Base de Datos en uso @line: " + ctx.getStop().getLine();
	        	this.errores.add(no_database_in_use);
			}
			else
			{
				// Verificar que la tabla con ID exista
				if (this.getActual().existTable(ID))
				{
					// Verificar que no exista una tabla ya creada con ID == NEW_ID
					if (! this.getActual().existTable(NEW_ID))
					{						
						//System.out.println("Before rename");
						//System.out.println(this.actual);
						// Renombrar referencias
						if (this.getActual().existRef(ID))
						{
							for (Table i: this.getActual().getTables())
								i.renameRefIdFK(ID, NEW_ID);
						}
						this.getActual().renameRef(ID, NEW_ID);
						System.out.println("La Tabla \"" + ID + "\" se ha renombrado exitosamente a \"" + NEW_ID + "\"");
						Table new_table = this.getActual().getTable(ID);
						new_table.setName(NEW_ID);
						File directory = new File(this.dataPath + "\\" + this.getActual().getName() + "\\" + ID + ".bin");
						// Renombrar el directorio
						directory.renameTo(new File(this.dataPath + "\\" + this.getActual().getName() + "\\" + NEW_ID + ".bin"));						
						// Guardar cambio en la DB
						//guardarDBs();
						//System.out.println("After rename");
						//System.out.println(this.actual);
					}
					else
					{
						String table_already_exist = "Ya existe una tabla con el mismo nombre en la Base de Datos \"" + this.getActual().getName() + "\" @line: " + ctx.getStop().getLine();
			        	this.errores.add(table_already_exist);
					}
				}
				else
				{
					String table_not_found = "La Tabla \"" + ID + "\" no existe en la Base de Datos \"" + this.getActual().getName() + "\" @line: " + ctx.getStop().getLine();
					this.errores.add(table_not_found);
				}
			}
		}
		return (T)"";
		//return super.visitRename_table_statement(ctx);
	}

	/* (non-Javadoc)
	 * @see sqlBaseVisitor#visitTable_definition(sqlParser.Table_definitionContext)
	 */
	@Override
	public Object visitTable_definition(sqlParser.Table_definitionContext ctx) {
		// TODO Auto-generated method stub
		String name = ctx.ID().getText();
		ArrayList<Atributo> atrs = new ArrayList<Atributo>();
		ArrayList<Constraint> pks = new ArrayList<Constraint>();
		ArrayList<Constraint> fks = new ArrayList<Constraint>();
		ArrayList<Constraint> checks = new ArrayList<Constraint>();
		ArrayList<String> const_ids = new ArrayList<String>();
		int errores = 0;
		// Verificar que se este utilizando una base de datos
		if (this.getActual().getName().isEmpty())
		{
			String no_database_in_use = "No hay una Base de Datos en uso @line: " + ctx.getStop().getLine();
        	this.errores.add(no_database_in_use);
        	errores++;
		}
		else
		{		
			// No se puede repetir nombre en las tablas
			if (! this.getActual().existTable(name))
			{
				for(int i = 4; i < ctx.getChildCount()-2; i++)
				{			
					ParseTree child = ctx.getChild(i);
					String child_text = child.getText();
					// Ignorar la coma
					if (! child_text.equals(","))
					{
						// Atributo
						if (child.getChildCount() == 2)
							atrs.add((Atributo)this.visit(child));
						// Constraint
						else
						{
							Constraint co = (Constraint)this.visit(child);
							const_ids.add(co.getId());
							switch (co.getTipo())
							{
								case "Primary Key": 
									if (pks.isEmpty())
										pks.add(co);
									// Solo puede haber una PK
									else
									{
										String more_than_one_pk = "Una tabla no puede tener declarada mas de una Primary Key @line: " + ctx.getStop().getLine();
							        	this.errores.add(more_than_one_pk);
							        	errores++;
									}
									break;
								case "Foreign Key":
									fks.add(co);								
									break;
								case "Check":
									checks.add(co);
									break;
							}
						}
					}
				}
				// Validaciones
				if (errores == 0)
				{
					// Ningun atributo se puede llamar igual
					ArrayList<String> attrs_names = new ArrayList<String>();
					boolean err1 = false;
					int i_cont = 0;
					for (Atributo i: atrs)
					{
						String name_i = i.getId();
						attrs_names.add(name_i);
						err1 = false;
						for (Atributo j: atrs.subList(i_cont+1, atrs.size()))
							if (name_i.equals(j.getId()))
							{
								err1 = true;
								errores++;
								break;
							}
						if (err1 == true)
						{
							String attr_declared = "El atributo \"" + name_i + "\" esta declarado mas de una vez @line: " + ctx.getStop().getLine();
				        	this.errores.add(attr_declared);
						}
						i_cont++;
					}
					// Ninguna constraint se puede llamar igual
					err1 = false;
					i_cont = 0;
					for (String i: const_ids)
					{
						err1 = false;
						for (String j: const_ids.subList(i_cont+1, const_ids.size()))
							if (i.equals(j))
							{
								err1 = true;
								errores++;
								break;
							}
						if (err1 == true)
						{
							String const_declared = "La Constraint \"" + i + "\" esta declarada mas de una vez @line: " + ctx.getStop().getLine();
				        	this.errores.add(const_declared);
						}
						i_cont++;
					}
					// Local IDS pertenecen a la tabla
					if (errores == 0)
					{			
						// Primary Keys
						if (! pks.isEmpty())
						{
							Constraint pk = pks.get(0);
							ArrayList<String> ids = pk.getIDS_local();
							for (String i: ids)
								if (! attrs_names.contains(i))
								{
									String local_id_not_found = "El atributo \"" + i + "\" de la Primary Key \"" + pk.getId() + "\" no esta declarado en la tabla \"" + name + "\" @line: " + ctx.getStop().getLine();
						        	this.errores.add(local_id_not_found);
						        	errores++;
								}		
						}
						// Foreign Keys
						for (Constraint i: fks)
						{
							// Local IDS
							for (String j: i.getIDS_local())
								if (! attrs_names.contains(j))										
								{
									String local_id_not_found = "El atributo \"" + j + "\" de la Foreign Key \"" + i.getId() + "\" no esta declarado en la tabla \"" + name + "\" @line: " + ctx.getStop().getLine();
						        	this.errores.add(local_id_not_found);
						        	errores++;
								}
							// Ref IDS
							// Buscar que exista una tabla con el nombre al que se hace referencia
							if (! this.getActual().existTable(i.getId_ref()))
							{
								String table_not_found = "La tabla \"" + i.getId_ref() + "\" que hace referencia la Foreign Key \"" + i.getId() + "\" no esta declarada en la Base de Datos \"" + this.getActual().getName() + "\" @line: " + ctx.getStop().getLine();
					        	this.errores.add(table_not_found);
					        	errores++;
							}
							else
							{
								Table table_ref = this.getActual().getTable(i.getId_ref());
								// Verificar que los RefIDS pertenezcan a la tabla
								for (String j: i.getIDS_refs())
									if (! table_ref.hasAtributo(j))
									{
										String ref_id_not_found = "El atributo \"" + j + "\" no esta declarado en la tabla \"" + i.getId_ref() + "\" que hace referencia la Foreign Key \"" + i.getId() + "\" @line: " + ctx.getStop().getLine();
							        	this.errores.add(ref_id_not_found);
							        	errores++;
									}
							}
						}
						// Check
						for (Constraint i: checks)
						{
							String id1 = i.getIDS_local().get(0);
							String id2 = i.getIDS_local().get(1);
							if (! attrs_names.contains(id1) )
							{
								String local_id_not_found = "El atributo \"" + id1 + "\" del Check \"" + i.getId() + "\" no esta declarado en la tabla \"" + name + "\" @line: " + ctx.getStop().getLine();
					        	this.errores.add(local_id_not_found);
					        	errores++;
							}
							if (! attrs_names.contains(id2) )
							{
								String local_id_not_found = "El atributo \"" + id2 + "\" del Check \"" + i.getId() + "\" no esta declarado en la tabla \"" + name + "\" @line: " + ctx.getStop().getLine();
					        	this.errores.add(local_id_not_found);
					        	errores++;
							} 
						}
						// Si no hay errores se guarda la tabla
						if (errores == 0)
						{			
							Table new_table = new Table(name, atrs, pks, fks, checks);
							// Agregar referencias de las Foreign Key
							for (Constraint i: fks)
								this.getActual().addRef(i.getId_ref());
							// Agregar tabla a la DB
							this.getActual().addTable(new_table);
							System.out.println("Tabla \"" + name + "\" agregada exitosamente a la Base de Datos \"" + this.getActual().getName() + "\"");
							System.out.println();
							System.out.println(this.getActual().toString());
							// Guardar tabla en directorio
							saveTable(this.getActual().getName(), name, new_table);
							// Guardar cambio en la DB
							//guardarDBs();
						}
					}
				}
			}
			else
			{				
				String table_already_exist = "Ya existe una tabla con el mismo nombre en la Base de Datos \"" + this.getActual().getName() + "\" @line: " + ctx.getStop().getLine();
	        	this.errores.add(table_already_exist);
			}
		}
		return (T)"";
		//return super.visitTable_definition(ctx);
	}

	/* (non-Javadoc)
	 * @see sqlBaseVisitor#visitColumn_literal(sqlParser.Column_literalContext)
	 */
	@Override
	public Object visitColumn_literal(sqlParser.Column_literalContext ctx) {
		// TODO Auto-generated method stub
		// Obtener tipo del atributo
		Atributo atr = (Atributo) this.visit(ctx.tipo_literal());
		// Establecer ID del atributo
		atr.setId(ctx.ID().getText());
		return (T) atr;
		//return super.visitColumn_literal(ctx);
	}

	/* (non-Javadoc)
	 * @see sqlBaseVisitor#visitColumn_constraint(sqlParser.Column_constraintContext)
	 */
	@Override
	public Object visitColumn_constraint(sqlParser.Column_constraintContext ctx) {
		// TODO Auto-generated method stub
		Constraint con = (Constraint) this.visit(ctx.constraint());
		return (T)con;
		//return super.visitColumn_constraint(ctx);
	}

	/* (non-Javadoc)
	 * @see sqlBaseVisitor#visitConstraint(sqlParser.ConstraintContext)
	 */
	@Override
	public Object visitConstraint(sqlParser.ConstraintContext ctx) {
		// TODO Auto-generated method stub
		Constraint con = (Constraint) this.visit(ctx.constraintType());
		return (T)con;
		//return super.visitConstraint(ctx);
	}

	/* (non-Javadoc)
	 * @see sqlBaseVisitor#visitLocalIDS(sqlParser.LocalIDSContext)
	 */
	@Override
	public Object visitLocalIDS(sqlParser.LocalIDSContext ctx) {
		// TODO Auto-generated method stub
		ArrayList<String> ids = new ArrayList<String>();
		ids.add(ctx.ID().getText());
		if (ctx.getChildCount() != 1)
		{
			ids.addAll((ArrayList<String>) this.visit(ctx.localIDS()));
		}
		return (T)ids;
		//return super.visitLocalIDS(ctx);
	}

	/* (non-Javadoc)
	 * @see sqlBaseVisitor#visitRefIDS(sqlParser.RefIDSContext)
	 */
	@Override
	public Object visitRefIDS(sqlParser.RefIDSContext ctx) {
		// TODO Auto-generated method stub
		ArrayList<String> ids = new ArrayList<String>();
		ids.add(ctx.ID().getText());
		if (ctx.getChildCount() != 1)
		{
			ids.addAll((ArrayList<String>) this.visit(ctx.refIDS()));
		}
		return (T)ids;
		//return super.visitRefIDS(ctx);
	}

	/* (non-Javadoc)
	 * @see sqlBaseVisitor#visitIdRef(sqlParser.IdRefContext)
	 */
	@Override
	public Object visitIdRef(sqlParser.IdRefContext ctx) {
		// TODO Auto-generated method stub
		return (T)ctx.ID().getText();
		//return super.visitIdRef(ctx);
	}

	/* (non-Javadoc)
	 * @see sqlBaseVisitor#visitConstraintTypeForeignKey(sqlParser.ConstraintTypeForeignKeyContext)
	 */
	@Override
	public Object visitConstraintTypeForeignKey(sqlParser.ConstraintTypeForeignKeyContext ctx) {
		// TODO Auto-generated method stub
		Constraint const_pk = new Constraint(ctx.getChild(0).getText(), "Foreign Key");
		const_pk.setIDS_local((ArrayList<String>)this.visit(ctx.localIDS()));
		const_pk.setIDS_refs((ArrayList<String>)this.visit(ctx.refIDS()));
		const_pk.setId_ref((String)this.visit(ctx.idRef()));
		return (T)const_pk;
		//return super.visitConstraintTypeForeignKey(ctx);
	}

	/* (non-Javadoc)
	 * @see sqlBaseVisitor#visitConstraintTypePrimaryKey(sqlParser.ConstraintTypePrimaryKeyContext)
	 */
	@Override
	public Object visitConstraintTypePrimaryKey(sqlParser.ConstraintTypePrimaryKeyContext ctx) {
		// TODO Auto-generated method stub
		Constraint const_pk = new Constraint(ctx.getChild(0).getText(), "Primary Key");
		const_pk.setIDS_local((ArrayList<String>)this.visit(ctx.localIDS()));
		/*
		for(int i = 4; i < ctx.getChildCount()-2; i++)
		{
			String child_text = ctx.getChild(i).getText();
			if (! child_text.equals(","))
			{
				const_pk.addLocalID(child_text);
			}
		}*/
		return (T)const_pk;
		//return super.visitConstraintTypePrimaryKey(ctx);
	}

	/* (non-Javadoc)
	 * @see sqlBaseVisitor#visitConstraintTypeCheck(sqlParser.ConstraintTypeCheckContext)
	 */
	@Override
	public Object visitConstraintTypeCheck(sqlParser.ConstraintTypeCheckContext ctx) {
		// TODO Auto-generated method stub
		Constraint const_check = new Constraint(ctx.getChild(0).getText(), "Check");
		String id_1 = ctx.getChild(3).getText();
		String id_2 = ctx.getChild(5).getText();
		String exp = (String) this.visit(ctx.exp());
		const_check.addLocalID(id_1);
		const_check.addLocalID(id_2);
		const_check.setExp(exp);
		return (T)const_check;
		//return super.visitConstraintTypeCheck(ctx);
	}

	/* (non-Javadoc)
	 * @see sqlBaseVisitor#visitExp_relational(sqlParser.Exp_relationalContext)
	 */
	@Override
	public Object visitExp_relational(sqlParser.Exp_relationalContext ctx) {
		// TODO Auto-generated method stub
		return (T)ctx.getText();
		//return super.visitExp_relational(ctx);
	}

	/* (non-Javadoc)
	 * @see sqlBaseVisitor#visitExp_logic(sqlParser.Exp_logicContext)
	 */
	@Override
	public Object visitExp_logic(sqlParser.Exp_logicContext ctx) {
		// TODO Auto-generated method stub
		return (T)this.visit(ctx.logic());
		//return super.visitExp_logic(ctx);
	}

	/* (non-Javadoc)
	 * @see sqlBaseVisitor#visitLogic_and(sqlParser.Logic_andContext)
	 */
	@Override
	public Object visitLogic_and(sqlParser.Logic_andContext ctx) {
		// TODO Auto-generated method stub
		return (T)"AND";
		//return super.visitLogic_and(ctx);
	}

	/* (non-Javadoc)
	 * @see sqlBaseVisitor#visitLogic_not(sqlParser.Logic_notContext)
	 */
	@Override
	public Object visitLogic_not(sqlParser.Logic_notContext ctx) {
		// TODO Auto-generated method stub
		return (T)"NOT";
		//return super.visitLogic_not(ctx);
	}

	/* (non-Javadoc)
	 * @see sqlBaseVisitor#visitLogic_or(sqlParser.Logic_orContext)
	 */
	@Override
	public Object visitLogic_or(sqlParser.Logic_orContext ctx) {
		// TODO Auto-generated method stub
		return (T)"OR";
		//return super.visitLogic_or(ctx);
	}

	/* (non-Javadoc)
	 * @see sqlBaseVisitor#visitTipo_lit_date(sqlParser.Tipo_lit_dateContext)
	 */
	@Override
	public Object visitTipo_lit_date(sqlParser.Tipo_lit_dateContext ctx) {
		// TODO Auto-generated method stub
		Atributo date_atr = new Atributo("", "date");
		return (T) date_atr;
		//return super.visitTipo_lit_date(ctx);
	}

	/* (non-Javadoc)
	 * @see sqlBaseVisitor#visitTipo_lit_char(sqlParser.Tipo_lit_charContext)
	 */
	@Override
	public Object visitTipo_lit_char(sqlParser.Tipo_lit_charContext ctx) {
		// TODO Auto-generated method stub		
		Atributo char_atr = new Atributo("", "char", Integer.valueOf(ctx.INT().getText()));
		return (T) char_atr;
		//return super.visitTipo_lit_char(ctx);
	}

	/* (non-Javadoc)
	 * @see sqlBaseVisitor#visitTipo_lit_float(sqlParser.Tipo_lit_floatContext)
	 */
	@Override
	public Object visitTipo_lit_float(sqlParser.Tipo_lit_floatContext ctx) {
		// TODO Auto-generated method stub
		Atributo float_atr = new Atributo("", "float");
		return (T) float_atr;
		//return super.visitTipo_lit_float(ctx);
	}

	/* (non-Javadoc)
	 * @see sqlBaseVisitor#visitTipo_lit_int(sqlParser.Tipo_lit_intContext)
	 */
	@Override
	public Object visitTipo_lit_int(sqlParser.Tipo_lit_intContext ctx) {
		// TODO Auto-generated method stub
		Atributo int_atr = new Atributo("", "int");
		return (T) int_atr;
		//return super.visitTipo_lit_int(ctx);
	}	
	
	/* (non-Javadoc)
	 * @see sqlBaseVisitor#visitAlterAddColumn(sqlParser.AlterAddColumnContext)
	 */
	@Override
	public Object visitAlterAddColumn(sqlParser.AlterAddColumnContext ctx) {
		// TODO Auto-generated method stub
		String ID_Table = (String) this.visit(ctx.idTable());
		String ID_Column = (String) this.visit(ctx.idColumn());
		// Verificar que haya un DB en uso
		if (this.getActual().getName().isEmpty())
		{
			String no_database_in_use = "No hay una Base de Datos en uso @line: " + ctx.getStop().getLine();
        	this.errores.add(no_database_in_use);
		}
		else
		{
			// Verificar que exista la tabla
			if (this.getActual().existTable(ID_Table))
			{
				Table toAlter = this.getActual().getTable(ID_Table);
				ArrayList<String> attrs_names = toAlter.getAtributosNames();
				// Obtener tipo del atributo
				Atributo atr = (Atributo) this.visit(ctx.tipo_literal());
				// Establecer ID del atributo
				atr.setId(ID_Column);
				// Obtener constraint
				Constraint con = (Constraint) this.visit(ctx.constraint());
				
				boolean insertAtr = toAlter.canAddAtributo(atr);
				boolean insertConst = toAlter.canAddConstraint(con);
				
				// Verificar que se puedan agregar ambos valores
				if ( insertAtr && insertConst)
				{					
					// Verificar errores de la constraint
					int errores = 0;
					
					// Local IDS pertenecen a la tabla
					ArrayList<String> ids = con.getIDS_local();								
					for (String i: ids)
						if (! attrs_names.contains(i))
						{
							String local_id_not_found = "El atributo \"" + i + "\" de la " + con.getTipo() +"\"" + con.getId() + "\" no esta declarado en la tabla \"" + toAlter.getName() + "\" @line: " + ctx.getStop().getLine();
				        	this.errores.add(local_id_not_found);
				        	errores++;
						}
					
					switch (con.getTipo())
					{
						case "Primary Key":
							// Solo puede haber una PK
							if (! toAlter.getPrimaryKeys().isEmpty())
							{
								String more_than_one_pk = "Una tabla no puede tener declarada mas de una Primary Key @line: " + ctx.getStop().getLine();
					        	this.errores.add(more_than_one_pk);
								errores++;								
							}							
							break;
						case "Foreign Key":
							// Ref IDS
							// Buscar que exista una tabla con el nombre al que se hace referencia
							if (! this.getActual().existTable(con.getId_ref()))
							{
								String table_not_found = "La tabla \"" + con.getId_ref() + "\" que hace referencia la Foreign Key \"" + con.getId() + "\" no esta declarada en la Base de Datos \"" + this.getActual().getName() + "\" @line: " + ctx.getStop().getLine();
					        	this.errores.add(table_not_found);
					        	errores++;
							}
							else
							{
								Table table_ref = this.getActual().getTable(con.getId_ref());
								// Verificar que los RefIDS pertenezcan a la tabla
								for (String j: con.getIDS_refs())
									if (! table_ref.hasAtributo(j))
									{
										String ref_id_not_found = "El atributo \"" + j + "\" no esta declarado en la tabla \"" + con.getId_ref() + "\" que hace referencia la Foreign Key \"" + con.getId() + "\" @line: " + ctx.getStop().getLine();
							        	this.errores.add(ref_id_not_found);
							        	errores++;
									}
							}
							break;
						case "Check":
							String id1 = con.getIDS_local().get(0);
							String id2 = con.getIDS_local().get(1);
							if (! attrs_names.contains(id1) )
							{
								String local_id_not_found = "El atributo \"" + id1 + "\" del Check \"" + con.getId() + "\" no esta declarado en la tabla \"" + toAlter.getName() + "\" @line: " + ctx.getStop().getLine();
					        	this.errores.add(local_id_not_found);
					        	errores++;
							}
							if (! attrs_names.contains(id2) )
							{
								String local_id_not_found = "El atributo \"" + id2 + "\" del Check \"" + con.getId() + "\" no esta declarado en la tabla \"" + toAlter.getName() + "\" @line: " + ctx.getStop().getLine();
					        	this.errores.add(local_id_not_found);
					        	errores++;
							}
							break;
					}
					
					if (errores == 0)
					{
						// Agregar atributo
						toAlter.addAtributo(atr);
						// Agregar constraint
						toAlter.addConstraint(con);					
						// Agrega la referencia si es Foreign Key
						if (con.getTipo().equals("Foreign Key"))
							this.getActual().addRef(con.getId_ref());
						System.out.println("Columna \"" + ID_Column + "\" y Constraint \"" + con.getId() + "\" agregadas exitosamente a la tabla \"" + toAlter.getName() + "\"");
					}
				}
				else
				{
					// Reportar errores
					if (! insertAtr)
					{
						String column_repeated = "No se puede agregar la columna \"" + ID_Column + "\" porque existe otra con el mismo nombre @line: " + ctx.getStop().getLine();
						this.errores.add(column_repeated);
					}
					if (! insertConst)
					{
						String constraint_repeated = "No se puede agregar la constraint \"" + con.getId() + "\" porque existe otra con el mismo nombre @line: " + ctx.getStop().getLine();
						this.errores.add(constraint_repeated);
					}
				}				
			}
			else
			{
				String table_not_found = "La Tabla \"" + ID_Table + "\" no existe en la Base de Datos \"" + this.getActual().getName() + "\" @line: " + ctx.getStop().getLine();
				this.errores.add(table_not_found);
			}
		}
		return (T)"";
		//return super.visitAlterAddColumn(ctx);
	}

	/* (non-Javadoc)
	 * @see sqlBaseVisitor#visitAlterAddConstraint(sqlParser.AlterAddConstraintContext)
	 */
	@Override
	public Object visitAlterAddConstraint(sqlParser.AlterAddConstraintContext ctx) {
		// TODO Auto-generated method stub
		String ID_Table = (String) this.visit(ctx.idTable());
		// Verificar que haya un DB en uso
		if (this.getActual().getName().isEmpty())
		{
			String no_database_in_use = "No hay una Base de Datos en uso @line: " + ctx.getStop().getLine();
        	this.errores.add(no_database_in_use);
		}
		else
		{
			// Verificar que exista la tabla
			if (this.getActual().existTable(ID_Table))
			{
				Table toAlter = this.getActual().getTable(ID_Table);
				ArrayList<String> attrs_names = toAlter.getAtributosNames();				
				// Obtener constraint
				Constraint con = (Constraint) this.visit(ctx.constraint());
				
				boolean insertConst = toAlter.canAddConstraint(con);
				
				// Verificar que se puedan agregar la constraint
				if (insertConst)
				{					
					// Verificar errores de la constraint
					int errores = 0;
					
					// Local IDS pertenecen a la tabla
					ArrayList<String> ids = con.getIDS_local();								
					for (String i: ids)
						if (! attrs_names.contains(i))
						{
							String local_id_not_found = "El atributo \"" + i + "\" de la " + con.getTipo() +"\"" + con.getId() + "\" no esta declarado en la tabla \"" + toAlter.getName() + "\" @line: " + ctx.getStop().getLine();
				        	this.errores.add(local_id_not_found);
				        	errores++;
						}
					
					switch (con.getTipo())
					{
						case "Primary Key":
							// Solo puede haber una PK
							if (! toAlter.getPrimaryKeys().isEmpty())
							{
								String more_than_one_pk = "Una tabla no puede tener declarada mas de una Primary Key @line: " + ctx.getStop().getLine();
					        	this.errores.add(more_than_one_pk);
								errores++;								
							}							
							break;
						case "Foreign Key":
							// Ref IDS
							// Buscar que exista una tabla con el nombre al que se hace referencia
							if (! this.getActual().existTable(con.getId_ref()))
							{
								String table_not_found = "La tabla \"" + con.getId_ref() + "\" que hace referencia la Foreign Key \"" + con.getId() + "\" no esta declarada en la Base de Datos \"" + this.getActual().getName() + "\" @line: " + ctx.getStop().getLine();
					        	this.errores.add(table_not_found);
					        	errores++;
							}
							else
							{
								Table table_ref = this.getActual().getTable(con.getId_ref());
								// Verificar que los RefIDS pertenezcan a la tabla
								for (String j: con.getIDS_refs())
									if (! table_ref.hasAtributo(j))
									{
										String ref_id_not_found = "El atributo \"" + j + "\" no esta declarado en la tabla \"" + con.getId_ref() + "\" que hace referencia la Foreign Key \"" + con.getId() + "\" @line: " + ctx.getStop().getLine();
							        	this.errores.add(ref_id_not_found);
							        	errores++;
									}
							}
							break;
						case "Check":
							String id1 = con.getIDS_local().get(0);
							String id2 = con.getIDS_local().get(1);
							if (! attrs_names.contains(id1) )
							{
								String local_id_not_found = "El atributo \"" + id1 + "\" del Check \"" + con.getId() + "\" no esta declarado en la tabla \"" + toAlter.getName() + "\" @line: " + ctx.getStop().getLine();
					        	this.errores.add(local_id_not_found);
					        	errores++;
							}
							if (! attrs_names.contains(id2) )
							{
								String local_id_not_found = "El atributo \"" + id2 + "\" del Check \"" + con.getId() + "\" no esta declarado en la tabla \"" + toAlter.getName() + "\" @line: " + ctx.getStop().getLine();
					        	this.errores.add(local_id_not_found);
					        	errores++;
							}
							break;
					}
					
					if (errores == 0)
					{
						// Agregar constraint
						toAlter.addConstraint(con);					
						// Agrega la referencia si es Foreign Key
						if (con.getTipo().equals("Foreign Key"))
							this.getActual().addRef(con.getId_ref());
						System.out.println("Constraint \"" + con.getId() + "\" agregada exitosamente a la tabla \"" + toAlter.getName() + "\"");
					}
				}
				else
				{
					// Reportar errores
					if (! insertConst)
					{
						String constraint_repeated = "No se puede agregar la constraint \"" + con.getId() + "\" porque existe otra con el mismo nombre @line: " + ctx.getStop().getLine();
						this.errores.add(constraint_repeated);
					}
				}				
			}
			else
			{
				String table_not_found = "La Tabla \"" + ID_Table + "\" no existe en la Base de Datos \"" + this.getActual().getName() + "\" @line: " + ctx.getStop().getLine();
				this.errores.add(table_not_found);
			}
		}
		return (T)"";

		//return super.visitAlterAddConstraint(ctx);
	}

	/* (non-Javadoc)
	 * @see sqlBaseVisitor#visitAlterDropColumn(sqlParser.AlterDropColumnContext)
	 */
	@Override
	public Object visitAlterDropColumn(sqlParser.AlterDropColumnContext ctx) {
		// TODO Auto-generated method stub
		String ID_Table = (String) this.visit(ctx.idTable());
		String ID_Column = (String) this.visit(ctx.idColumn());
		// Verificar que haya un DB en uso
		if (this.getActual().getName().isEmpty())
		{
			String no_database_in_use = "No hay una Base de Datos en uso @line: " + ctx.getStop().getLine();
        	this.errores.add(no_database_in_use);
		}
		else
		{
			// Verificar que exista la tabla
			if (this.getActual().existTable(ID_Table))
			{
				Table toAlter = this.getActual().getTable(ID_Table);
				ArrayList<String> attrs_names = toAlter.getAtributosNames();
				// Verificar que la columna que se quiere borrar pertenezca a la tabla
				if (attrs_names.contains(ID_Column))
				{
					// Verificar errores de referencia
					int errores = 0;
					// Pk que lo contiene
					ArrayList<Constraint> pks = toAlter.getPrimaryKeys();
					if (! pks.isEmpty())
					{
						Constraint pk = pks.get(0);
						ArrayList<String> locals = pk.getIDS_local();
						if (locals.contains(ID_Column))
						{
							String delete_pk_first = "La Primary Key \"" + pk.getId() + "\" contiene el atributo \"" + ID_Column + "\" que se quiere eliminar, por lo tanto se debe realizar primero el DROP CONSTRAINT correspondiente @ line: " + ctx.getStop().getLine();
							this.errores.add(delete_pk_first);
							errores++;
						}
					}
					// Checks lo contiene
					ArrayList<Constraint> cks = toAlter.getChecks();
					if (!cks.isEmpty())
					{
						for (Constraint i: cks)
						{
							ArrayList<String> locals = i.getIDS_local();
							String id1 = locals.get(0);
							String id2 = locals.get(1);
							if ( (id1.equals(ID_Column)) || (id2.equals(ID_Column)) )
							{
								String delete_check_first = "El Check \"" + i.getId() + "\" contiene el atributo \"" + ID_Column + "\" que se quiere eliminar, por lo tanto se debe realizar primero el DROP CONSTRAINT correspondiente @ line: " + ctx.getStop().getLine();
					        	this.errores.add(delete_check_first);
					        	errores++;
							}							
						}
					}
					// En Ref_IDs de Fk de otras tablas en la misma DB
					if (this.getActual().existRef(ID_Table))
					{
						for (Table i: this.getActual().getTables())
							if (! i.getName().equals(ID_Table))
								for(Constraint j: i.getForeignKey())
								{
									ArrayList<String> refs = j.getIDS_refs();
									if (refs.contains(ID_Column))
									{
										String delete_fk_first = "La Foreign Key \"" + j.getId() + "\" de la Tabla \"" + i.getName() + "\" contiene el atributo \"" + ID_Column + "\" que se quiere eliminar, por lo tanto se debe realizar primero el DROP CONSTRAINT correspondiente @ line: " + ctx.getStop().getLine();
										this.errores.add(delete_fk_first);
										errores++;
									}
								}
					}
					// Si no hay errores se procede a borrar la columna
					if (errores == 0)
					{
						toAlter.deleteAtributo(ID_Column);
						System.out.println("El atributo \"" + ID_Column + "\" se ha eliminado exitosamente de la Tabla \"" + ID_Table + "\"");					
					}
				}
				else
				{
					String attr_not_found = "El atributo \"" + ID_Column + "\" no existe en la Tabla \"" + toAlter.getName() + "\" @line: " + ctx.getStop().getLine();
					this.errores.add(attr_not_found);
				}
			}
			else
			{
				String table_not_found = "La Tabla \"" + ID_Table + "\" no existe en la Base de Datos \"" + this.getActual().getName() + "\" @line: " + ctx.getStop().getLine();
				this.errores.add(table_not_found);
			}
		}
		return (T)"";
		//return super.visitAlterDropColumn(ctx);
	}

	/* (non-Javadoc)
	 * @see sqlBaseVisitor#visitAlterDropConstraint(sqlParser.AlterDropConstraintContext)
	 */
	@Override
	public Object visitAlterDropConstraint(sqlParser.AlterDropConstraintContext ctx) {
		// TODO Auto-generated method stub
		String ID_Table = (String) this.visit(ctx.idTable());
		String ID_Constraint = (String) this.visit(ctx.idConstraint());
		// Verificar que haya un DB en uso
		if (this.getActual().getName().isEmpty())
		{
			String no_database_in_use = "No hay una Base de Datos en uso @line: " + ctx.getStop().getLine();
        	this.errores.add(no_database_in_use);
		}
		else
		{
			// Verificar que exista la tabla
			if (this.getActual().existTable(ID_Table))
			{
				Table toAlter = this.getActual().getTable(ID_Table);
				// Verificar que exista la Constraint
				if (toAlter.existeConstraint(ID_Constraint))
				{
					// Verificar si hay que borrarlo de constraints_refs
					Constraint to_drop = toAlter.getConstraint(ID_Constraint);
					if (to_drop.getTipo().equals("Foreign Key"))
					{
						int cont = 0;
						for (Table i: this.getActual().getTables())
							if (! i.getName().equals(ID_Table))
							{
								for (Constraint j: i.getForeignKey())
									if (j.getId_ref().equals(to_drop.getId_ref()))
									{
										cont++;
										break;
									}
							}
						if (cont == 0)
							this.getActual().deleteRef(to_drop.getId_ref());
								
					}
					// Eliminar constraint
					toAlter.deleteConstraint(to_drop);
					System.out.println("La Constraint \"" + ID_Constraint + "\" se ha eliminado exitosamente de la Tabla \"" + ID_Table + "\"");					
				}
				else
				{
					String const_not_found = "La Constraint \"" + ID_Constraint + "\" no existe en la Tabla \"" + toAlter.getName() + "\" @line: " + ctx.getStop().getLine();
					this.errores.add(const_not_found);
				}
			}
			else
			{
				String table_not_found = "La Tabla \"" + ID_Table + "\" no existe en la Base de Datos \"" + this.getActual().getName() + "\" @line: " + ctx.getStop().getLine();
				this.errores.add(table_not_found);
			}
		}
		return (T)"";
		//return super.visitAlterDropConstraint(ctx);
	}

	/* (non-Javadoc)
	 * @see sqlBaseVisitor#visitIdTable(sqlParser.IdTableContext)
	 */
	@Override
	public Object visitIdTable(sqlParser.IdTableContext ctx) {
		// TODO Auto-generated method stub
		return (T)ctx.ID().getText();
		//return super.visitIdTable(ctx);
	}

	/* (non-Javadoc)
	 * @see sqlBaseVisitor#visitIdColumn(sqlParser.IdColumnContext)
	 */
	@Override
	public Object visitIdColumn(sqlParser.IdColumnContext ctx) {
		// TODO Auto-generated method stub
		return (T)ctx.ID().getText();
		//return super.visitIdColumn(ctx);
	}

	/* (non-Javadoc)
	 * @see sqlBaseVisitor#visitIdConstraint(sqlParser.IdConstraintContext)
	 */
	@Override
	public Object visitIdConstraint(sqlParser.IdConstraintContext ctx) {
		// TODO Auto-generated method stub
		return (T)ctx.ID().getText();
		//return super.visitIdConstraint(ctx);
	}

	/* (non-Javadoc)
	 * @see sqlBaseVisitor#visitDrop_table_statement(sqlParser.Drop_table_statementContext)
	 */
	@Override
	public Object visitDrop_table_statement(sqlParser.Drop_table_statementContext ctx) {
		// TODO Auto-generated method stub
		String ID_Table = ctx.ID().getText();
		// Verificar que haya un DB en uso
				if (this.getActual().getName().isEmpty())
				{
					String no_database_in_use = "No hay una Base de Datos en uso @line: " + ctx.getStop().getLine();
		        	this.errores.add(no_database_in_use);
				}
				else
				{
					// Verificar que exista la tabla
					if (this.getActual().existTable(ID_Table))
					{
						Table toAlter = this.getActual().getTable(ID_Table);
						// Verificar si tiene referencias en fks
						if (this.getActual().existRef(ID_Table))
						{
							for (Table i: this.getActual().getTables())
								if (! i.getName().equals(ID_Table))
								{
									for (Constraint j: i.getForeignKey())
										if (j.getId_ref().equals(ID_Table))
										{
											String delete_fk_first = "La Foreign Key \"" + j.getId() + "\" de la Tabla \"" + i.getName() + "\" hace referenca a la Tabla \"" + ID_Table + "\" que se quiere eliminar, por lo tanto se debe realizar primero el DROP CONSTRAINT correspondiente @ line: " + ctx.getStop().getLine();
											this.errores.add(delete_fk_first);
										}
								}
						}
						else
						{							
							// Eliminar tabla de la data persistente
							try
							{					    		
					    		File file = new File(this.dataPath+this.getActual().getName()+"\\"+ID_Table+".bin");					    		
					    		
					    		if(file.delete())
					    		{
					    			// Eliminar tabla del objeto					
									this.getActual().deleteTable(ID_Table);
					    			System.out.println("La Tabla \"" + ID_Table + "\" se ha eliminado exitosamente de la Base de Datos \"" + this.getActual().getName() + "\"");
					    		}
					    		else
					    			System.out.println("Error al eliminar la Tabla \"" + ID_Table + "\" de la data persistente" );					    	   
					    	}
							catch(Exception e)
							{					    		
					    		e.printStackTrace();					    		
					    	}							
						}
					}
					else
					{
						String table_not_found = "La Tabla \"" + ID_Table + "\" no existe en la Base de Datos \"" + this.getActual().getName() + "\" @line: " + ctx.getStop().getLine();
						this.errores.add(table_not_found);
					}
				}
		return (T)"";
		//return super.visitDrop_table_statement(ctx);
	}

	/**************************
	 * INSERT
	 * validamos el numero de columnas y valores
	 * el tipo de cada columna con el valor ingresado
	 * debemos ver que columnas no fueron ingresadas 
	 * para llenarlas con NULL y que la tabla exista
	 */
	@Override
	public Object visitInsert_value(sqlParser.Insert_valueContext ctx) 
	{
		String id = ctx.ID().getText();
		
		if (this.actual.existTable(id))
		{
			//debemos revisar si existe la tabla en la base de datos actual
			table_use = this.getActual().getTable(id);
			
			ArrayList<String> fila = new ArrayList();
			
			//Si no fueron ingresadas columnas tomamos el total en la tabla
			int columnas;
			int values;
			if (ctx.getChildCount()==7)
			{
				columnas = ctx.getChild(3).getChildCount();
				values = ctx.getChild(5).getChildCount();
				
			}
			else
			{
				columnas = table_use.getAtributos().size()-1;
				values = ctx.getChild(4).getChildCount();
				
			}
			
			//Cantidad de errores antes de hacer el insert
			int contErrores = this.errores.size();
			
			//llenamos la fila con NULL
			int numCols = table_use.getAtributos().size();
			for (int i=0;i<numCols;i++)
			{
				fila.add("NULL");
			}
			
			if (table_use != null)
			{
				//comparamos numero de columas es mayor o igual  a valores con y sin parentesis
				if ( columnas <= values || (columnas+2 <= values && ctx.getChild(3).getText().contains("(")) || (columnas <= values+2 && ctx.getChild(5).getText().contains("(")))
				{
					
					ArrayList<Atributo> cols;
					ArrayList<Value> vals;
					
					//Si no fueron ingresadas columnas tomamos todas las de la tabla
					if (ctx.getChildCount()==7)
					{
						cols = (ArrayList<Atributo>)this.visit(ctx.getChild(3));
						vals = (ArrayList<Value>)this.visit(ctx.getChild(5));
						
					}
					else
					{
						cols = table_use.getAtributos();
						vals = (ArrayList<Value>)this.visit(ctx.getChild(4));
						
					}
					
					//si los array no son del mismo tamaño hubo algun error en el camino
					//debemos revisar que el tipo del atributo sea igual al tipo del valor
					//int cont = 0;
					//if (cols.size()==vals.size())
					{
						for (int cont=0;cont<cols.size() && cont<vals.size();cont++)
						{
							Atributo atr = cols.get(cont);
							Value valor = vals.get(cont);
							if (atr.getTipo().equals(valor.getTipo()))
							{
								if (atr.getTipo().equals("char"))
								{
									if (atr.getSize()>=valor.getSize()-2)
									{
										//agrego el valor a la fila en el index del atributo
										int index = this.table_use.getAtributos().indexOf(atr);
										fila.set(index, valor.getValue());
									}
									else
									{
										//error tamaño del valor mayor
										String rule_5 = "El tamaño de '" + valor.getValue() + "' es mayor al tamaño reservado en la base de datos para '"+ atr.getId() +"' @line: " + ctx.getStop().getLine();
										this.errores.add(rule_5);
									}
								}
								else
								{
									//agrego el valor a la fila en el index del atributo
									int index = this.table_use.getAtributos().indexOf(atr);
									fila.set(index, valor.getValue());
								}
							}
							else
							{
								//debo revisar si pueden ser casteados
								if (atr.getTipo().equals("int") && valor.getTipo().equals("float"))
								{
									String num = valor.getValue();
									int index = num.indexOf('.');
									num = num.substring(0, index);
									valor.setValue(num);
									valor.setTipo("int");
									
									//agrego el valor a la fila en el index del atributo
									int index2 = this.table_use.getAtributos().indexOf(atr);
									fila.set(index2, valor.getValue());
								}
								else
								{
									if (valor.getTipo().equals("int") && atr.getTipo().equals("float"))
									{
										String num = valor.getValue();
										num += ".0";
										valor.setValue(num);
										valor.setTipo("float");
										
										//agrego el valor a la fila en el index del atributo
										int index = this.table_use.getAtributos().indexOf(atr);
										fila.set(index, valor.getValue());
									}
									else
										if (atr.getTipo().equals("char") && valor.getTipo().equals("date"))
										{
											if (atr.getSize() >= valor.getValue().length()-2)
											{
												//agrego el valor a la fila en el index del atributo
												int index = this.table_use.getAtributos().indexOf(atr);
												fila.set(index, valor.getValue());
											}
											else
											{
												//error tamaño del valor mayor
												String rule_5 = "El tamaño de '" + valor.getValue() + "' es mayor al tamaño reservado en la base de datos para '"+ atr.getId() +"' @line: " + ctx.getStop().getLine();
												this.errores.add(rule_5);
											}
										}
										else
										{
											if (atr.getTipo().equals("date") && valor.getTipo().equals("char"))
											{
												if (checkDate(valor.getValue()))
												{
													int index = this.table_use.getAtributos().indexOf(atr);
													fila.set(index, valor.getValue());
												}
												else
												{
													String rule_5 = "El valor '" + valor.getValue() + "', no puede ser casteado a '"+ atr.getTipo() +" @line: " + ctx.getStop().getLine();
													this.errores.add(rule_5);
												}
											}
											else
											{
												String rule_5 = "El tipo de del valor'" + valor.getValue() + "' no puede ser casteado a '"+ atr.getTipo() +"' @line: " + ctx.getStop().getLine();
												this.errores.add(rule_5);
											}
										}
								}
							}
							//cont++;
						}
						
						//Agrego la fila solo si el numero de errores sigue siendo el mismo
						if (contErrores == this.errores.size())
						{
							if (PrimaryKey(fila, -1))
							{	
								this.table_use.addData(fila);
								this.inserted_rows++;
							}
							else
							{
								String rule_5 = "No se puede hacer INSERT. Primary Key @line: " + ctx.getStop().getLine();
								this.errores.add(rule_5);
							}
						}
					}
				}
				else
				{	
					String rule_5 = "No se puede hacer INSERT con mayor numero de columnas  que valores a insertar @line: " + ctx.getStop().getLine();
					this.errores.add(rule_5);
				}
			}
		}
		else
		{
			String rule_5 = "La tabla " + id + " no existe en la base de datos " + this.getActual().getName() + " @line: " + ctx.getStop().getLine();
			this.errores.add(rule_5);
		}
		
		
		// TODO Auto-generated method stub
		return new String();
	}
	
	
	/*****************************
	 * LIST
	 * devolvemos un array con el tipo y valor de cada valor ingresado
	 */
	@Override
	public Object visitList(sqlParser.ListContext ctx) {
		
		ArrayList<Value> values = new ArrayList();
		
		int cont = 0;
		for (int i = 0; i < ctx.getChildCount(); i++)
			if (!ctx.getChild(i).getText().equals("(") && !ctx.getChild(i).getText().equals(")") && !ctx.getChild(i).getText().equals(","))
			{
				Value valor = new Value();
				String text = ctx.literal(cont).getText();
				String tipo = (String)this.visit(ctx.getChild(i));
				cont++;
				if (tipo.equals("char"))
				{
					valor = new Value(text,tipo, text.length()-2);
				}
				else
				{
					if (tipo.equals("Error"))
					{
						String rule_5 = "La fecha " + text + " no es valida @line: " + ctx.getStop().getLine();
						this.errores.add(rule_5);
						valor = new Value(text,"date");
					}
					else
					{
						valor = new Value(text,tipo);
					}
				}
				values.add(valor);
			}
		
		// TODO Auto-generated method stub
		return values;
	}

	
	/*****************************
	 * COLUMNS
	 * devolvemos un array con los atributos/columna a 
	 * la que se desea ingresar un valor
	 * debemos revisar que las columnas existan en la tabla
	 */
	@Override
	public Object visitColumns(sqlParser.ColumnsContext ctx) {
		
		ArrayList<Atributo> columnas = new ArrayList();
		
		for (int i = 0; i < ctx.getChildCount(); i++)
			if (!ctx.getChild(i).getText().equals("(") && !ctx.getChild(i).getText().equals(")") && !ctx.getChild(i).getText().equals(","))
			{
				
				String columna = ctx.getChild(i).getText(); 
				if (this.table_use.hasAtributo(columna))
				{
					Atributo id = this.table_use.getID(columna);
					columnas.add(id);
				}
				else
				{
					String rule_5 = "La tabla " + this.table_use.getName() + " no contiene la columna " + columna + " @line: " + ctx.getStop().getLine();
					this.errores.add(rule_5);
				}
			}
		
		// TODO Auto-generated method stub
		return columnas;
	}
	

	/*************************
	 * UPDATE
	 * reviso si tiene where o no
	 * si no tiene actualizo las columnas a actualizar de todas las filas
	 * si hay actualizo solo de las filas que devuelva condition
	 */
	@Override
	public Object visitUpdate_value(sqlParser.Update_valueContext ctx) {
		
		String id = ctx.getChild(1).getText();
		int contErrores = this.errores.size();
		
		if (this.actual.existTable(id))
		{
			this.table_use = this.actual.getTable(id);
			int size = this.table_use.getData().size();
			
			if (ctx.getChildCount() == 5)
			{
				ArrayList<String> newfila = (ArrayList<String>)this.visit(ctx.getChild(3));
				
				for (int i = 0; i<size && contErrores==this.errores.size();i++)
				{
					this.table_use.getData().set(i, newfila);
				}
			}
			else
			{
				Object obj = (Object) visit(ctx.getChild(5));
				if (obj == null){
					String rule_5 = "Error en condiciones definidas @line: " + ctx.getStop().getLine();
					this.errores.add(rule_5);
					return null;
				}
				
				if (!(obj instanceof LinkedHashSet)){
					String rule_5 = "Error en condiciones definidas @line: " + ctx.getStop().getLine();
					this.errores.add(rule_5);
					return null;
				}
				
				LinkedHashSet<Integer> indices = (LinkedHashSet<Integer>)obj;
				ArrayList<Integer> index= new ArrayList(indices);
				ArrayList<String> newfila = (ArrayList<String>)this.visit(ctx.getChild(3));
				ArrayList<String> fila = new ArrayList<String>();
				ArrayList<String> fin = new ArrayList<String>();
				
				for (int j=0;j<newfila.size();j++)
					fin.add("");
				
				if (contErrores == this.errores.size())
					for (int i: index){
						fila = table_use.getData().get(i);
						for (String col : newfila)
						{
							int index2 = newfila.indexOf(col);
							if (col.equals("UPDATE"))
							{
								fin.set(index2, fila.get(index2));
							}
							else
								fin.set(index2, newfila.get(index2));
						}
						if (PrimaryKey(fin,i))
							this.table_use.getData().set(i, fin);
					}
			}
		}
		else
		{
			String rule_5 = "La tabla " + id + " no existe en la base de datos " + this.getActual().getName() + " @line: " + ctx.getStop().getLine();
			this.errores.add(rule_5);
		}
		
		// TODO Auto-generated method stub
		return super.visitUpdate_value(ctx);
	}
	
	
	/**************************
	 * Asignacion
	 * llenar fila con un valor default
	 * las filas que permanezcan con ese valor 
	 * no deben ser cambiadas
	 */
	@Override
	public Object visitAsignacion(sqlParser.AsignacionContext ctx) {
		
		ArrayList<String> newfila = new ArrayList<String>();
		
		int numCols = this.table_use.getAtributos().size();
		for (int i=0;i<numCols;i++)
			newfila.add("UPDATE");
		
		int index = 0;
		Atributo atr = new Atributo();
		for (int j=0;j<ctx.getChildCount();j++)
		{
			String text = ctx.getChild(j).getText();
			if (!text.equals("=") && !text.equals("="))
			{
				if (j==0 || j%4==0)
				{
					if (this.table_use.hasAtributo(text))
					{
						atr = this.table_use.getID(text);
						index = this.table_use.getAtributos().indexOf(atr);
					}
					else
					{
						String rule_5 = "La tabla " + this.table_use.getName() + " no contiene la columna " + text + " @line: " + ctx.getStop().getLine();
						this.errores.add(rule_5);
					}
				}
				else
				{
					String tipo = (String)this.visit(ctx.getChild(j));
					//buscamos si el tipo puede ser casteado
					if (atr.getTipo().equals(tipo))
					{
						if (tipo.equals("char"))
						{
							if (text.length()-2 <= atr.getSize())
							{
								newfila.set(index, text);
							}
							else
							{
								String rule_5 = "El tamaño de '" + text + "' es mayor al tamaño reservado para '"+ atr.getId() +" @line: " + ctx.getStop().getLine();
								this.errores.add(rule_5);
							}
						}
						else
							newfila.set(index, text);
					}
					else
					{
						if (atr.getTipo().equals("int") && tipo.equals("float"))
						{
							int k = text.indexOf('.');
							newfila.set(index, text.substring(0, k));
						}
						else
						{
							if (atr.getTipo().equals("float") && tipo.equals("int"))
							{
								newfila.set(index, text+".0");
							}
							else
							{
								if (atr.getTipo().equals("char") && tipo.equals("date"))
								{
									if (text.length()-2 == atr.getSize())
									{
										newfila.set(index, text);
									}
									else
									{
										String rule_5 = "El tamaño de '" + text + "' es mayor al tamaño reservado para '"+ atr.getId() +" @line: " + ctx.getStop().getLine();
										this.errores.add(rule_5);
									}
								}
								else
								{
									if (atr.getTipo().equals("date") && tipo.equals("char"))
									{
										if (this.visit(ctx.getChild(j)).equals("date"))
										{
											newfila.set(index, text);
										}
										else
										{
											String rule_5 = "El valor '" + text + "', no puede ser casteado a '"+ atr.getTipo() +" @line: " + ctx.getStop().getLine();
											this.errores.add(rule_5);
										}
									}
									else
									{
										String rule_5 = "El tipo: '" + tipo + "', no puede ser casteado a '"+ atr.getTipo() +" @line: " + ctx.getStop().getLine();
										this.errores.add(rule_5);
									}
								}
							}
						}
					}
				}
			}
		}
		
		// TODO Auto-generated method stub
		return newfila;
	}
	
	
	/**************************
	 * DELETE 
	 * debo revisar que si exista la tabla en la database actual
	 * si no existe condicion borro toda la tabla
	 * si existe reviso que filas cumplen con la condicion
	 */
	@Override
	public Object visitDelete_value(sqlParser.Delete_valueContext ctx) {
		String id = ctx.ID().getText();
		
		this.table_use = this.getActual().getTable(id);
		
		if (table_use == null){
			String rule_5 = "La tabla " + id + " no existe en la base de datos " + this.getActual().getName() + " @line: " + ctx.getStop().getLine();
			this.errores.add(rule_5);
			return null;
		}
		
		if (ctx.getChildCount() <= 4){
			table_use.setData(new ArrayList<ArrayList<String>>());
			return table_use;
		}
		
		Object obj = (Object) visit(ctx.getChild(4));
		if (obj == null){
			String rule_5 = "Error en condiciones definidas @line: " + ctx.getStop().getLine();
			this.errores.add(rule_5);
			return null;
		}
		
		if (!(obj instanceof LinkedHashSet)){
			String rule_5 = "Error en condiciones definidas @line: " + ctx.getStop().getLine();
			this.errores.add(rule_5);
			return null;
		}
		
		LinkedHashSet<Integer> indices = (LinkedHashSet<Integer>)obj;
		ArrayList<Integer> index= new ArrayList(indices);
		Collections.reverse(index);
		for (int i: index){
			table_use.getData().remove(i);
		}
		
		
		return (T) table_use;
	}

	
	
	/**************************
	 * Condition
	 * Revisamos cada comparacion
	 * Devolvemos un arrayList de arrraylis de string
	 * que contiene todas las filas que debemos eliminar
	 */
	@Override 
	public T visitConditionNot(sqlParser.ConditionNotContext ctx) 
	{ 
		Object obj = visit(ctx.getChild(1));
		if (obj == null){
			return null;
		}
		
		if (!(obj instanceof LinkedHashSet)){
			return null;
		}
		
		LinkedHashSet<Integer> indices = (LinkedHashSet<Integer>) obj;
		
		int size = table_use.getData().size();
		
		LinkedHashSet<Integer> nIndices = new LinkedHashSet();
		
		for (int i = 0; i < size; i++){
			if (!indices.contains(i))
				nIndices.add(i);
		}
		
		return (T)nIndices;
	}

	public T visitConditionComp (sqlParser.ConditionCompContext ctx){
		if (ctx.getChildCount() <= 1) return (T)visitChildren(ctx);
		
		Object objComp = visit(ctx.getChild(0));
		if (objComp == null) return null;
		
		if (!(objComp instanceof LinkedHashSet)) return null;
		
		LinkedHashSet<Integer> compIndex = (LinkedHashSet<Integer>) objComp;
		
		String logic = (String) visit(ctx.getChild(1));
		
		Object objCond = visit(ctx.getChild(2));
		if (objCond == null) return null;
		
		if (!(objCond instanceof LinkedHashSet)) return null;
		
		LinkedHashSet<Integer> condIndex = (LinkedHashSet<Integer>) objCond;
		LinkedHashSet<Integer> result = null;
		
		switch (logic){
			case "OR":
				
				compIndex.addAll(condIndex);
				result = new LinkedHashSet<Integer>();
				result.addAll(compIndex);
				
				break;
			case "AND":
				result = new LinkedHashSet<Integer>();
				for (int i: compIndex){
					if (condIndex.contains(i))
						result.add(i);
				}
				break;
		}
		
		
		return (T)result;
	}

	public T visitConditionCond (sqlParser.ConditionCondContext ctx){
		if (ctx.getChildCount() <= 3) return (T) visit(ctx.getChild(1));
		
		Object obj1 = visit(ctx.getChild(1));
		if (obj1 == null) return null;
		
		if (!(obj1 instanceof LinkedHashSet)) return null;
		
		LinkedHashSet<Integer> cond1Index = (LinkedHashSet<Integer>) obj1;
		
		Object obj2 = visit(ctx.getChild(4));
		if (obj2 == null) return null;
		
		if (!(obj2 instanceof LinkedHashSet)) return null;
		
		LinkedHashSet<Integer> cond2Index = (LinkedHashSet<Integer>) obj2;
		
		String logic = (String)visit(ctx.getChild(3));
		
		LinkedHashSet<Integer> result = null;
		
		switch (logic){
			case "OR":
				cond1Index.addAll(cond2Index);
				result = new LinkedHashSet<Integer>();
				result.addAll(cond1Index);
				break;
			case "AND":
				result = new LinkedHashSet<Integer>();
				for (int i: cond1Index){
					if (cond2Index.contains(i))
						result.add(i);
				}
				break;
		}
		
		
		return (T)result;
	}
	/***************************
	 * CompId
	 * Revisamos comp que puede tener
	 * ID relational ID | literal
	 */
	@Override 
	public T visitCompId(@NotNull sqlParser.CompIdContext ctx) 
	{
		
		LinkedHashSet<Integer> list = new LinkedHashSet();
		String op = ctx.getChild(1).getText(); //agarro el relational
		
		
		String id = (String) visit(ctx.getChild(0)); //agarro el primer id
		
		if (this.table_use.hasAtributo(id)) //reviso si existe en la tabla
		{
			
			if (table_use.isAmbiguous(id)){
				String error_ = "La llamada <<"+id+">> es ambigua @line: " + ctx.getStop().getLine();
				errores.add(error_);
				return null;
			}
			//tomo el atributo de la tabla y el indice de este
			
			Atributo atr = this.table_use.getID(id);
			
			Atributo id2 = new Atributo();
			int index = this.table_use.getAtributos().indexOf(atr);
			
			
			//visito el ultimo hijo 
			String tipo = (String)this.visit(ctx.getChild(2)); //si es literal, voy a recibir el tipo
			String value = ctx.getChild(2).getText();
			
			//creo una bandera para ver si voy a poder castear los tipos
			boolean flag = false;
			
			//Si es un literal
			if (tipo.equals("int") || tipo.equals("float") || tipo.equals("date") || tipo.equals("char"))
			{
				if (atr.getTipo().equals("int") && (tipo.equals("int") || tipo.equals("float")))
				{
					flag = true;
				}
				else
				{
					if (atr.getTipo().equals("float") && (tipo.equals("int") || tipo.equals("float")))
					{
						flag = true;
					}
					else
					{
						if (atr.getTipo().equals("char") && (tipo.equals("char") || tipo.equals("date")))
						{
							flag = true;
						}
						else
						{
							if (atr.getTipo().equals("date") && (tipo.equals("char") || tipo.equals("date")))
							{
								flag = true;
							}
							else
							{
								String rule_5 = "El tipo de " + atr.getId() + " no se puede comparar con un " + tipo + " @line: " + ctx.getStop().getLine();
								this.errores.add(rule_5);
							}
						}
							
					}
				}	
			}
			else
				if (tipo.equals("Error"))
				{
					// no acepto la fecha
					String rule_5 = "La fecha " + value + " no es valida @line: " + ctx.getStop().getLine();
					this.errores.add(rule_5);
				}
				else
				{
					//Si es una columna de la tabla
					String columna = (String)visit(ctx.getChild(2)); 
					if (this.table_use.hasAtributo(columna))
					{
						if (table_use.isAmbiguous(columna)){
							String error_ = "La llamada <<"+columna+">> es ambigua @line: " + ctx.getStop().getLine();
							errores.add(error_);
							return null;
						}
						id2 = this.table_use.getID(columna);
						
						value = "'";
						
						if (atr.getTipo().equals("int") && (id2.getTipo().equals("int") || id2.getTipo().equals("float")))
						{
							flag = true;
						}
						else
						{
							if (atr.getTipo().equals("float") && (id2.getTipo().equals("int") || id2.getTipo().equals("float")))
							{
								flag = true;
							}
							else
							{
								if (atr.getTipo().equals("char") && (id2.getTipo().equals("char") || id2.getTipo().equals("date")))
								{
									flag = true;
								}
								else
								{
									if (atr.getTipo().equals("date") && (id2.getTipo().equals("char") || id2.getTipo().equals("date")))
									{
										flag = true;
									}
									else
									{
										String rule_5 = "El tipo de " + atr.getId() + " no se puede comparar con un " + id2.getTipo() + " @line: " + ctx.getStop().getLine();
										this.errores.add(rule_5);
									}
								}
									
							}
						}
					}
					else
					{
						String rule_5 = "La tabla " + this.table_use.getName() + " no contiene la columna " + columna + " @line: " + ctx.getStop().getLine();
						this.errores.add(rule_5);
					}
				}
			
			if (flag)
			{
				/*
				 * CompareTo devuelve 0 si son iguales
				 * mas de 0 si el primero es mayor al segundo
				 * y menos de 0 si el primero es menor al tercero
				 */
				switch (op)
				{
					//Igual
					case "=":
						//si es un literal y de tipo int o float
						if (!value.equals("'") && (atr.getTipo().equals("int") || atr.getTipo().equals("float")))
						{
							Double valor = Double.parseDouble(value);
							int cont = 0;
							for (ArrayList<String> fila : this.table_use.getData())
							{
								Double comp = Double.parseDouble(fila.get(index));
								if (valor.compareTo(comp)==0)
									list.add(cont);
								cont++;
							}
						}
						else //si es una columna de tipo int o float
						{
							if (value.equals("'") && (atr.getTipo().equals("int") || atr.getTipo().equals("float")))
							{
								int index2 = this.table_use.getAtributos().indexOf(id2);
								int cont = 0;
								for (ArrayList<String> fila : this.table_use.getData())
								{
									Double valor = Double.parseDouble(fila.get(index2));
									Double comp = Double.parseDouble(fila.get(index));
									if (valor.compareTo(comp)==0)
										list.add(cont);
									cont++;
								}
							}
							else
							{
								//Si ambos son date y es con literal
								if (!value.equals("'") && atr.getTipo().equals("date") && tipo.equals("date"))
								{
									int cont = 0;
									for (ArrayList<String> fila : this.table_use.getData())
									{
										
										String comp = fila.get(index);
										if (compareDate(comp, value).equals("igual"))
											list.add(cont);
										cont++;
									}
								}
								else
								{
									//Si ambos son date  y es con columna
									if (value.equals("'") && atr.getTipo().equals("date") && id2.getTipo().equals("date"))
									{
										int index2 = this.table_use.getAtributos().indexOf(id2);
										int cont = 0;
										for (ArrayList<String> fila : this.table_use.getData())
										{
											
											String comp = fila.get(index);
											String valor = fila.get(index2);
											if (compareDate(comp, valor).equals("igual"))
												list.add(cont);
											cont++;
										}
									}
									else
									{
										//Si ambos son char o mezcla
										if (!value.equals("'") && (atr.getTipo().equals("char") || atr.getTipo().equals("date")))
										{
											int cont = 0;
											for (ArrayList<String> fila : this.table_use.getData())
											{
												String comp = fila.get(index);
												if (value.compareTo(comp)==0)
													list.add(cont);
												cont++;
											}
										}
										else
										{
											int index2 = this.table_use.getAtributos().indexOf(id2);
											int cont = 0;
											for (ArrayList<String> fila : this.table_use.getData())
											{
												String valor = fila.get(index2);
												String comp = fila.get(index);
												if (valor.compareTo(comp)==0)
													list.add(cont);
												cont++;
											}
										}
									}
								}
							}	
						}
						
						break;
					//Distinto
					case "<>":
						//si es un literal y de tipo int o float
						if (!value.equals("'") && (atr.getTipo().equals("int") || atr.getTipo().equals("float")))
						{
							Double valor = Double.parseDouble(value);
							int cont = 0;
							for (ArrayList<String> fila : this.table_use.getData())
							{
								Double comp = Double.parseDouble(fila.get(index));
								if (valor.compareTo(comp)!=0)
									list.add(cont);
								cont++;
							}
						}
						else //si es una columna de tipo int o float
						{
							if (value.equals("'") && (atr.getTipo().equals("int") || atr.getTipo().equals("float")))
							{
								int index2 = this.table_use.getAtributos().indexOf(id2);
								int cont = 0;
								for (ArrayList<String> fila : this.table_use.getData())
								{
									Double valor = Double.parseDouble(fila.get(index2));
									Double comp = Double.parseDouble(fila.get(index));
									if (valor.compareTo(comp)!=0)
										list.add(cont);
									cont++;
								}
							}
							else
							{	
								//Si ambos son date y es con literal
								if (!value.equals("'") && atr.getTipo().equals("date") && tipo.equals("date"))
								{
									int cont = 0;
									for (ArrayList<String> fila : this.table_use.getData())
									{
										
										String comp = fila.get(index);
										if (!compareDate(comp, value).equals("igual"))
											list.add(cont);
										cont++;
									}
								}
								else
								{
									//Si ambos son date  y es con columna
									if (value.equals("'") && atr.getTipo().equals("date") && id2.getTipo().equals("date"))
									{
										int index2 = this.table_use.getAtributos().indexOf(id2);
										int cont = 0;
										for (ArrayList<String> fila : this.table_use.getData())
										{
											
											String comp = fila.get(index);
											String valor = fila.get(index2);
											if (!compareDate(comp, valor).equals("igual"))
												list.add(cont);
											cont++;
										}
									}
									else
									{
										//Si ambos son char o mezcla
										if (!value.equals("'") && (atr.getTipo().equals("char") || atr.getTipo().equals("date")))
										{
											int cont = 0;
											for (ArrayList<String> fila : this.table_use.getData())
											{
												String comp = fila.get(index);
												if (value.compareTo(comp)!=0)
													list.add(cont);
												cont++;
											}
										}
										else
										{
											int index2 = this.table_use.getAtributos().indexOf(id2);
											int cont = 0;
											for (ArrayList<String> fila : this.table_use.getData())
											{
												String valor = fila.get(index2);
												String comp = fila.get(index);
												if (valor.compareTo(comp)!=0)
													list.add(cont);
												cont++;
											}
										}
									}
								}
							}
						}
						break;
					//Menor
					case "<":
						//si es un literal y de tipo int o float
						if (!value.equals("'") && (atr.getTipo().equals("int") || atr.getTipo().equals("float")))
						{
							Double valor = Double.parseDouble(value);
							int cont = 0;
							for (ArrayList<String> fila : this.table_use.getData())
							{
								Double comp = Double.parseDouble(fila.get(index));
								if (comp.compareTo(valor)<0)
									list.add(cont);
								cont++;
							}
						}
						else //si es una columna de tipo int o float
						{
							if (value.equals("'") && (atr.getTipo().equals("int") || atr.getTipo().equals("float")))
							{
								int index2 = this.table_use.getAtributos().indexOf(id2);
								int cont = 0;
								for (ArrayList<String> fila : this.table_use.getData())
								{
									Double valor = Double.parseDouble(fila.get(index2));
									Double comp = Double.parseDouble(fila.get(index));
									if (comp.compareTo(valor)<0)
										list.add(cont);
									cont++;
								}
							}
							else
							{
								//Si ambos son date y es con literal
								if (!value.equals("'") && atr.getTipo().equals("date") && tipo.equals("date"))
								{
									int cont = 0;
									for (ArrayList<String> fila : this.table_use.getData())
									{
										
										String comp = fila.get(index);
										if (compareDate(comp, value).equals("menor"))
											list.add(cont);
										cont++;
									}
								}
								else
								{
									//Si ambos son date  y es con columna
									if (value.equals("'") && atr.getTipo().equals("date") && id2.getTipo().equals("date"))
									{
										int index2 = this.table_use.getAtributos().indexOf(id2);
										int cont = 0;
										for (ArrayList<String> fila : this.table_use.getData())
										{
											
											String comp = fila.get(index);
											String valor = fila.get(index2);
											if (compareDate(comp, valor).equals("menor"))
												list.add(cont);
											cont++;
										}
									}
									else
									{
										//Si ambos son char o mezcla
										if (!value.equals("'") && (atr.getTipo().equals("char") || atr.getTipo().equals("date")))
										{
											int cont = 0;
											for (ArrayList<String> fila : this.table_use.getData())
											{
												String comp = fila.get(index);
												if (comp.compareTo(value)<0)
													list.add(cont);
												cont++;
											}
										}
										else
										{
											int index2 = this.table_use.getAtributos().indexOf(id2);
											int cont = 0;
											for (ArrayList<String> fila : this.table_use.getData())
											{
												String valor = fila.get(index2);
												String comp = fila.get(index);
												if (comp.compareTo(valor)<0)
													list.add(cont);
												cont++;
											}
										}
									}
								}
							}
						}
						break;
					//Mayor
					case ">":
						//si es un literal y de tipo int o float
						if (!value.equals("'") && (atr.getTipo().equals("int") || atr.getTipo().equals("float")))
						{
							Double valor = Double.parseDouble(value);
							int cont = 0;
							for (ArrayList<String> fila : this.table_use.getData())
							{
								Double comp = Double.parseDouble(fila.get(index));
								if (comp.compareTo(valor)>0)
									list.add(cont);
								cont++;
							}
						}
						else //si es una columna de tipo int o float
						{
							if (value.equals("'") && (atr.getTipo().equals("int") || atr.getTipo().equals("float")))
							{
								int index2 = this.table_use.getAtributos().indexOf(id2);
								int cont = 0;
								for (ArrayList<String> fila : this.table_use.getData())
								{
									Double valor = Double.parseDouble(fila.get(index2));
									Double comp = Double.parseDouble(fila.get(index));
									if (comp.compareTo(valor)>0)
										list.add(cont);
									cont++;
								}
							}
							else
							{
								//Si ambos son date y es con literal
								if (!value.equals("'") && atr.getTipo().equals("date") && tipo.equals("date"))
								{
									int cont = 0;
									for (ArrayList<String> fila : this.table_use.getData())
									{
										
										String comp = fila.get(index);
										if (compareDate(comp, value).equals("mayor"))
											list.add(cont);
										cont++;
									}
								}
								else
								{
									//Si ambos son date  y es con columna
									if (value.equals("'") && atr.getTipo().equals("date") && id2.getTipo().equals("date"))
									{
										int index2 = this.table_use.getAtributos().indexOf(id2);
										int cont = 0;
										for (ArrayList<String> fila : this.table_use.getData())
										{
											
											String comp = fila.get(index);
											String valor = fila.get(index2);
											if (compareDate(comp, valor).equals("mayor"))
												list.add(cont);
											cont++;
										}
									}
									else
									{
										//Si ambos son char o mezcla
										if (!value.equals("'") && (atr.getTipo().equals("char") || atr.getTipo().equals("date")))
										{
											int cont = 0;
											for (ArrayList<String> fila : this.table_use.getData())
											{
												String comp = fila.get(index);
												if (comp.compareTo(value)>0)
													list.add(cont);
												cont++;
											}
										}
										else
										{
											int index2 = this.table_use.getAtributos().indexOf(id2);
											int cont = 0;
											for (ArrayList<String> fila : this.table_use.getData())
											{
												String valor = fila.get(index2);
												String comp = fila.get(index);
												if (comp.compareTo(valor)>0)
													list.add(cont);
												cont++;
											}
										}
									}
								}
							}
						}
						break;
					//Menor Igual
					case "<=":
						//si es un literal y de tipo int o float
						if (!value.equals("'") && (atr.getTipo().equals("int") || atr.getTipo().equals("float")))
						{
							Double valor = Double.parseDouble(value);
							int cont = 0;
							for (ArrayList<String> fila : this.table_use.getData())
							{
								Double comp = Double.parseDouble(fila.get(index));
								if (comp.compareTo(valor)<0 || valor.compareTo(comp)==0)
									list.add(cont);
								cont++;
							}
						}
						else //si es una columna de tipo int o float
						{
							if (value.equals("'") && (atr.getTipo().equals("int") || atr.getTipo().equals("float")))
							{
								int index2 = this.table_use.getAtributos().indexOf(id2);
								int cont = 0;
								for (ArrayList<String> fila : this.table_use.getData())
								{
									Double valor = Double.parseDouble(fila.get(index2));
									Double comp = Double.parseDouble(fila.get(index));
									if (comp.compareTo(valor)<0 || valor.compareTo(comp)==0)
										list.add(cont);
									cont++;
								}
							}
							else
							{
								//Si ambos son date y es con literal
								if (!value.equals("'") && atr.getTipo().equals("date") && tipo.equals("date"))
								{
									int cont = 0;
									for (ArrayList<String> fila : this.table_use.getData())
									{
										
										String comp = fila.get(index);
										if (compareDate(comp, value).equals("igual") || compareDate(comp, value).equals("menor"))
											list.add(cont);
										cont++;
									}
								}
								else
								{
									//Si ambos son date  y es con columna
									if (value.equals("'") && atr.getTipo().equals("date") && id2.getTipo().equals("date"))
									{
										int index2 = this.table_use.getAtributos().indexOf(id2);
										int cont = 0;
										for (ArrayList<String> fila : this.table_use.getData())
										{
											
											String comp = fila.get(index);
											String valor = fila.get(index2);
											if (compareDate(comp, valor).equals("igual") || compareDate(comp, valor).equals("menor"))
												list.add(cont);
											cont++;
										}
									}
									else
									{
										//Si ambos son char o mezcla
										if (!value.equals("'") && (atr.getTipo().equals("char") || atr.getTipo().equals("date")))
										{
											int cont = 0;
											for (ArrayList<String> fila : this.table_use.getData())
											{
												String comp = fila.get(index);
												if (comp.compareTo(value)<0 || comp.compareTo(value)==0)
													list.add(cont);
												cont++;
											}
										}
										else
										{
											int index2 = this.table_use.getAtributos().indexOf(id2);
											int cont = 0;
											for (ArrayList<String> fila : this.table_use.getData())
											{
												String valor = fila.get(index2);
												String comp = fila.get(index);
												if (comp.compareTo(valor)<0 || comp.compareTo(valor)==0)
													list.add(cont);
												cont++;
											}
										}
									}
								}
							}
						}
						break;
					//Mayor Igual	
					case ">=":
						//si es un literal y de tipo int o float
						if (!value.equals("'") && (atr.getTipo().equals("int") || atr.getTipo().equals("float")))
						{
							Double valor = Double.parseDouble(value);
							int cont = 0;
							for (ArrayList<String> fila : this.table_use.getData())
							{
								Double comp = Double.parseDouble(fila.get(index));
								if (comp.compareTo(valor)>0 || comp.compareTo(valor)==0)
									list.add(cont);
								cont++;
							}
						}
						else //si es una columna de tipo int o float
						{
							if (value.equals("'") && (atr.getTipo().equals("int") || atr.getTipo().equals("float")))
							{
								int index2 = this.table_use.getAtributos().indexOf(id2);
								int cont = 0;
								for (ArrayList<String> fila : this.table_use.getData())
								{
									Double valor = Double.parseDouble(fila.get(index2));
									Double comp = Double.parseDouble(fila.get(index));
									if (comp.compareTo(valor)>0 || comp.compareTo(valor)==0)
										list.add(cont);
									cont++;
								}
							}
							else
							{
								//Si ambos son date y es con literal
								if (!value.equals("'") && atr.getTipo().equals("date") && tipo.equals("date"))
								{
									int cont = 0;
									for (ArrayList<String> fila : this.table_use.getData())
									{
										
										String comp = fila.get(index);
										if (compareDate(comp, value).equals("igual") || compareDate(comp, value).equals("mayor"))
											list.add(cont);
										cont++;
									}
								}
								else
								{
									//Si ambos son date  y es con columna
									if (value.equals("'") && atr.getTipo().equals("date") && id2.getTipo().equals("date"))
									{
										int index2 = this.table_use.getAtributos().indexOf(id2);
										int cont = 0;
										for (ArrayList<String> fila : this.table_use.getData())
										{
											
											String comp = fila.get(index);
											String valor = fila.get(index2);
											if (compareDate(comp, valor).equals("igual") || compareDate(comp, valor).equals("mayor"))
												list.add(cont);
											cont++;
										}
									}
									else
									{
										//Si ambos son char o mezcla
										if (!value.equals("'") && (atr.getTipo().equals("char") || atr.getTipo().equals("date")))
										{
											int cont = 0;
											for (ArrayList<String> fila : this.table_use.getData())
											{
												String comp = fila.get(index);
												if (comp.compareTo(value)>0 || comp.compareTo(value)==0)
													list.add(cont);
												cont++;
											}
										}
										else
										{
											int index2 = this.table_use.getAtributos().indexOf(id2);
											int cont = 0;
											for (ArrayList<String> fila : this.table_use.getData())
											{
												String valor = fila.get(index2);
												String comp = fila.get(index);
												if (comp.compareTo(valor)>0 || comp.compareTo(valor)==0)
													list.add(cont);
												cont++;
											}
										}
									}
								}
							}
						}
						break;
				}
			}
			//System.out.println("llego a list: "+list);
			return (T)list;
		}
		else
		{
			String rule_5 = "La tabla " + this.table_use.getName() + " no contiene la columna " + id + " @line: " + ctx.getStop().getLine();
			this.errores.add(rule_5);
		}
		System.out.println("llego a list null");
		return (T)null; 
	}
	
	
	/*********************************
	 * CompLit
	 * 
	 * Revisamos si e suna comparacion
	 * solo de literales
	 */
	@Override
	public Object visitCompLit(sqlParser.CompLitContext ctx) {
		LinkedHashSet<Integer> list = new LinkedHashSet();
		String op = ctx.getChild(1).getText(); //agarro el relational
		
		//visito el primer hijo 
		String tipo = (String)this.visit(ctx.getChild(0)); //voy a recibir el tipo
		String value = ctx.getChild(0).getText();
		
		//visito el ultimo hijo 
		String tipo2 = (String)this.visit(ctx.getChild(2)); //voy a recibir el tipo
		String value2 = (String)visit(ctx.getChild(2));
		
		boolean flag = false;
		
		
		if (flag)
		{
			switch(op)
			{
				case "=":
					if (tipo.equals("date") && tipo2.equals("date"))
					{
						int cont = 0;
						for (ArrayList<String> fila : this.table_use.getData())
						{
							if (compareDate(value,value2).equals("igual"))
								list.add(cont);
							cont++;
						}
					}
					else
					{
						if ((tipo.equals("int") || tipo.equals("float")) && (tipo2.equals("int") || tipo2.equals("float")))
						{
							int cont = 0;
							Double num = Double.parseDouble(value);
							Double num2 = Double.parseDouble(value2);
							for (ArrayList<String> fila : this.table_use.getData())
							{
								if (num.compareTo(num2)==0)
									list.add(cont);
								cont++;
							}
						}
						else
						{
							int cont = 0;
							for (ArrayList<String> fila : this.table_use.getData())
							{
								if (value.compareTo(value2)==0)
									list.add(cont);
								cont++;
							}
						}
					}
					break;
				case "<>":
					if (tipo.equals("date") && tipo2.equals("date"))
					{
						int cont = 0;
						for (ArrayList<String> fila : this.table_use.getData())
						{
							if (!compareDate(value,value2).equals("igual"))
								list.add(cont);
							cont++;
						}
					}
					else
					{
						if ((tipo.equals("int") || tipo.equals("float")) && (tipo2.equals("int") || tipo2.equals("float")))
						{
							int cont = 0;
							Double num = Double.parseDouble(value);
							Double num2 = Double.parseDouble(value2);
							for (ArrayList<String> fila : this.table_use.getData())
							{
								if (num.compareTo(num2)!=0)
									list.add(cont);
								cont++;
							}
						}
						else
						{
							int cont = 0;
							for (ArrayList<String> fila : this.table_use.getData())
							{
								if (value.compareTo(value2)!=0)
									list.add(cont);
								cont++;
							}
						}
					}
					break;
				case "<":
					if (tipo.equals("date") && tipo2.equals("date"))
					{
						int cont = 0;
						for (ArrayList<String> fila : this.table_use.getData())
						{
							if (compareDate(value,value2).equals("menor"))
								list.add(cont);
							cont++;
						}
					}
					else
					{
						if ((tipo.equals("int") || tipo.equals("float")) && (tipo2.equals("int") || tipo2.equals("float")))
						{
							int cont = 0;
							Double num = Double.parseDouble(value);
							Double num2 = Double.parseDouble(value2);
							for (ArrayList<String> fila : this.table_use.getData())
							{
								if (num.compareTo(num2)<0)
									list.add(cont);
								cont++;
							}
						}
						else
						{
							int cont = 0;
							for (ArrayList<String> fila : this.table_use.getData())
							{
								if (value.compareTo(value2)<0)
									list.add(cont);
								cont++;
							}
						}
					}
					break;
				case ">":
					if (tipo.equals("date") && tipo2.equals("date"))
					{
						int cont = 0;
						for (ArrayList<String> fila : this.table_use.getData())
						{
							if (compareDate(value,value2).equals("mayor"))
								list.add(cont);
							cont++;
						}
					}
					else
					{
						if ((tipo.equals("int") || tipo.equals("float")) && (tipo2.equals("int") || tipo2.equals("float")))
						{
							int cont = 0;
							Double num = Double.parseDouble(value);
							Double num2 = Double.parseDouble(value2);
							for (ArrayList<String> fila : this.table_use.getData())
							{
								if (num.compareTo(num2)>0)
									list.add(cont);
								cont++;
							}
						}
						else
						{
							int cont = 0;
							for (ArrayList<String> fila : this.table_use.getData())
							{
								if (value.compareTo(value2)>0)
									list.add(cont);
								cont++;
							}
						}
					}
					break;
				case "<=":
					if (tipo.equals("date") && tipo2.equals("date"))
					{
						int cont = 0;
						for (ArrayList<String> fila : this.table_use.getData())
						{
							if (compareDate(value,value2).equals("menor") || compareDate(value,value2).equals("igual"))
								list.add(cont);
							cont++;
						}
					}
					else
					{
						if ((tipo.equals("int") || tipo.equals("float")) && (tipo2.equals("int") || tipo2.equals("float")))
						{
							int cont = 0;
							Double num = Double.parseDouble(value);
							Double num2 = Double.parseDouble(value2);
							for (ArrayList<String> fila : this.table_use.getData())
							{
								if (num.compareTo(num2)<0 || num.compareTo(num2)==0)
									list.add(cont);
								cont++;
							}
						}
						else
						{
							int cont = 0;
							for (ArrayList<String> fila : this.table_use.getData())
							{
								if (value.compareTo(value2)<0 || value.compareTo(value2)==0)
									list.add(cont);
								cont++;
							}
						}
					}
					break;
				case ">=":
					if (tipo.equals("date") && tipo2.equals("date"))
					{
						int cont = 0;
						for (ArrayList<String> fila : this.table_use.getData())
						{
							if (compareDate(value,value2).equals("mayor") || compareDate(value,value2).equals("igual"))
								list.add(cont);
							cont++;
						}
					}
					else
					{
						if ((tipo.equals("int") || tipo.equals("float")) && (tipo2.equals("int") || tipo2.equals("float")))
						{
							int cont = 0;
							Double num = Double.parseDouble(value);
							Double num2 = Double.parseDouble(value2);
							for (ArrayList<String> fila : this.table_use.getData())
							{
								if (num.compareTo(num2)>0 || num.compareTo(num2)==0)
									list.add(cont);
								cont++;
							}
						}
						else
						{
							int cont = 0;
							for (ArrayList<String> fila : this.table_use.getData())
							{
								if (value.compareTo(value2)>0 || value.compareTo(value2)==0)
									list.add(cont);
								cont++;
							}
						}
					}
					break;
			}
			return list;
		}
		
		// TODO Auto-generated method stub
		return null;
	}

	
	/*********************************
	 * CompLitId
	 * Revisamso si es una comparacion
	 * de literal con id
	 */
	@Override
	public Object visitCompLitId(sqlParser.CompLitIdContext ctx) {
		
		LinkedHashSet<Integer> list = new LinkedHashSet();
		String op = ctx.getChild(1).getText(); //agarro el relational
		
		
		String id = (String)visit(ctx.getChild(2)); //agarro el primer id
		if (this.table_use.hasAtributo(id)) //reviso si existe en la tabla
		{
			if (table_use.isAmbiguous(id)){
				String error_ = "La llamada <<"+id+">> es ambigua @line: " + ctx.getStop().getLine();
				errores.add(error_);
				return null;
			}
			//tomo el atributo de la tabla y el indice de este
			Atributo atr = this.table_use.getID(id);
			int index = this.table_use.getAtributos().indexOf(atr);
			
			//visito el ultimo hijo 
			String tipo = (String)this.visit(ctx.getChild(0)); //si es literal, voy a recibir el tipo
			String value = ctx.getChild(0).getText();
			
			//creo una bandera para ver si voy a poder castear los tipos
			boolean flag = false;
			
			//Si es un literal
			if (tipo.equals("int") || tipo.equals("float") || tipo.equals("date") || tipo.equals("char"))
			{
				if (atr.getTipo().equals("int") && (tipo.equals("int") || tipo.equals("float")))
				{
					flag = true;
				}
				else
				{
					if (atr.getTipo().equals("float") && (tipo.equals("int") || tipo.equals("float")))
					{
						flag = true;
					}
					else
					{
						if (atr.getTipo().equals("char") && (tipo.equals("char") || tipo.equals("date")))
						{
							flag = true;
						}
						else
						{
							if (atr.getTipo().equals("date") && (tipo.equals("char") || tipo.equals("date")))
							{
								flag = true;
							}
							else
							{
								String rule_5 = "El tipo de " + atr.getId() + " no se puede comparar con un " + tipo + " @line: " + ctx.getStop().getLine();
								this.errores.add(rule_5);
							}
						}
							
					}
				}	
			}
			else
				if (tipo.equals("Error"))
				{
					// no acepto la fecha
					String rule_5 = "La fecha " + value + " no es valida @line: " + ctx.getStop().getLine();
					this.errores.add(rule_5);
				}
				
			
			if (flag)
			{
				/*
				 * CompareTo devuelve 0 si son iguales
				 * mas de 0 si el primero es mayor al segundo
				 * y menos de 0 si el primero es menor al tercero
				 */
				switch (op)
				{
					//Igual
					case "=":
						//si es un literal y de tipo int o float
						if (!value.equals("'") && (atr.getTipo().equals("int") || atr.getTipo().equals("float")))
						{
							Double valor = Double.parseDouble(value);
							int cont = 0;
							for (ArrayList<String> fila : this.table_use.getData())
							{
								Double comp = Double.parseDouble(fila.get(index));
								if (valor.compareTo(comp)==0)
									list.add(cont);
								cont++;
							}
						}
						else
						{
							//Si ambos son date y es con literal
							if (!value.equals("'") && atr.getTipo().equals("date") && tipo.equals("date"))
							{
								int cont = 0;
								for (ArrayList<String> fila : this.table_use.getData())
								{
									
									String comp = fila.get(index);
									if (compareDate(comp, value).equals("igual"))
										list.add(cont);
									cont++;
								}
							}
							else
							{
								//Si ambos son char o mezcla
								if (!value.equals("'") && (atr.getTipo().equals("char") || atr.getTipo().equals("date")))
								{
									int cont = 0;
									for (ArrayList<String> fila : this.table_use.getData())
									{
										String comp = fila.get(index);
										if (value.compareTo(comp)==0)
											list.add(cont);
										cont++;
									}
								}						
							}
						}
						break;
					//Distinto
					case "<>":
						//si es un literal y de tipo int o float
						if (!value.equals("'") && (atr.getTipo().equals("int") || atr.getTipo().equals("float")))
						{
							Double valor = Double.parseDouble(value);
							int cont = 0;
							for (ArrayList<String> fila : this.table_use.getData())
							{
								Double comp = Double.parseDouble(fila.get(index));
								if (valor.compareTo(comp)!=0)
									list.add(cont);
								cont++;
							}
						}					
						else
						{	
							//Si ambos son date y es con literal
							if (!value.equals("'") && atr.getTipo().equals("date") && tipo.equals("date"))
							{
								int cont = 0;
								for (ArrayList<String> fila : this.table_use.getData())
								{
									
									String comp = fila.get(index);
									if (!compareDate(comp, value).equals("igual"))
										list.add(cont);
									cont++;
								}
							}
							else
							{
								//Si ambos son char o mezcla
								if (!value.equals("'") && (atr.getTipo().equals("char") || atr.getTipo().equals("date")))
								{
									int cont = 0;
									for (ArrayList<String> fila : this.table_use.getData())
									{
										String comp = fila.get(index);
										if (value.compareTo(comp)!=0)
											list.add(cont);
										cont++;
									}
								}
							}
						}
						break;
					//Menor
					case "<":
						//si es un literal y de tipo int o float
						if (!value.equals("'") && (atr.getTipo().equals("int") || atr.getTipo().equals("float")))
						{
							Double valor = Double.parseDouble(value);
							int cont = 0;
							for (ArrayList<String> fila : this.table_use.getData())
							{
								Double comp = Double.parseDouble(fila.get(index));
								if (valor.compareTo(comp)<0)
									list.add(cont);
								cont++;
							}
						}
						else
						{
							//Si ambos son date y es con literal
							if (!value.equals("'") && atr.getTipo().equals("date") && tipo.equals("date"))
							{
								int cont = 0;
								for (ArrayList<String> fila : this.table_use.getData())
								{
									
									String comp = fila.get(index);
									if (compareDate(value, comp).equals("menor"))
										list.add(cont);
									cont++;
								}
							}
							else
							{
								//Si ambos son char o mezcla
								if (!value.equals("'") && (atr.getTipo().equals("char") || atr.getTipo().equals("date")))
								{
									int cont = 0;
									for (ArrayList<String> fila : this.table_use.getData())
									{
										String comp = fila.get(index);
										if (value.compareTo(comp)<0)
											list.add(cont);
										cont++;
									}
								}
							}
						}
						break;
					//Mayor
					case ">":
						//si es un literal y de tipo int o float
						if (!value.equals("'") && (atr.getTipo().equals("int") || atr.getTipo().equals("float")))
						{
							Double valor = Double.parseDouble(value);
							int cont = 0;
							for (ArrayList<String> fila : this.table_use.getData())
							{
								Double comp = Double.parseDouble(fila.get(index));
								if (valor.compareTo(comp)>0)
									list.add(cont);
								cont++;
							}
						}
						else
						{
							//Si ambos son date y es con literal
							if (!value.equals("'") && atr.getTipo().equals("date") && tipo.equals("date"))
							{
								int cont = 0;
								for (ArrayList<String> fila : this.table_use.getData())
								{
									
									String comp = fila.get(index);
									if (compareDate(value, comp).equals("mayor"))
										list.add(cont);
									cont++;
								}
							}
							else
							{
								//Si ambos son char o mezcla
								if (!value.equals("'") && (atr.getTipo().equals("char") || atr.getTipo().equals("date")))
								{
									int cont = 0;
									for (ArrayList<String> fila : this.table_use.getData())
									{
										String comp = fila.get(index);
										if (value.compareTo(comp)>0)
											list.add(cont);
										cont++;
									}
								}
							}
						}
						break;
					//Menor Igual
					case "<=":
						//si es un literal y de tipo int o float
						if (!value.equals("'") && (atr.getTipo().equals("int") || atr.getTipo().equals("float")))
						{
							Double valor = Double.parseDouble(value);
							int cont = 0;
							for (ArrayList<String> fila : this.table_use.getData())
							{
								Double comp = Double.parseDouble(fila.get(index));
								if (valor.compareTo(comp)<0 || valor.compareTo(comp)==0)
									list.add(cont);
								cont++;
							}
						}
						else
						{
							//Si ambos son date y es con literal
							if (!value.equals("'") && atr.getTipo().equals("date") && tipo.equals("date"))
							{
								int cont = 0;
								for (ArrayList<String> fila : this.table_use.getData())
								{
									
									String comp = fila.get(index);
									if (compareDate(value, comp).equals("igual") || compareDate(value, comp).equals("menor"))
										list.add(cont);
									cont++;
								}
							}
							else
							{
								//Si ambos son char o mezcla
								if (!value.equals("'") && (atr.getTipo().equals("char") || atr.getTipo().equals("date")))
								{
									int cont = 0;
									for (ArrayList<String> fila : this.table_use.getData())
									{
										String comp = fila.get(index);
										if (value.compareTo(comp)<0 || value.compareTo(comp)==0)
											list.add(cont);
										cont++;
									}
								}
							}
						}
						break;
					//Mayor Igual	
					case ">=":
						//si es un literal y de tipo int o float
						if (!value.equals("'") && (atr.getTipo().equals("int") || atr.getTipo().equals("float")))
						{
							Double valor = Double.parseDouble(value);
							int cont = 0;
							for (ArrayList<String> fila : this.table_use.getData())
							{
								Double comp = Double.parseDouble(fila.get(index));
								if (valor.compareTo(comp)>0 || valor.compareTo(comp)==0)
									list.add(cont);
								cont++;
							}
						}
						else
						{
							//Si ambos son date y es con literal
							if (!value.equals("'") && atr.getTipo().equals("date") && tipo.equals("date"))
							{
								int cont = 0;
								for (ArrayList<String> fila : this.table_use.getData())
								{
									
									String comp = fila.get(index);
									if (compareDate(value, comp).equals("igual") || compareDate(value, comp).equals("mayor"))
										list.add(cont);
									cont++;
								}
							}
							else
							{
								//Si ambos son char o mezcla
								if (!value.equals("'") && (atr.getTipo().equals("char") || atr.getTipo().equals("date")))
								{
									int cont = 0;
									for (ArrayList<String> fila : this.table_use.getData())
									{
										String comp = fila.get(index);
										if (value.compareTo(comp)>0 || value.compareTo(comp)==0)
											list.add(cont);
										cont++;
									}
								}
							}
						}
						break;
				}
			}
			return (T)list;
		}
		else
		{
			String rule_5 = "La tabla " + this.table_use.getName() + " no contiene la columna " + id + " @line: " + ctx.getStop().getLine();
			this.errores.add(rule_5);
		}
		
		// TODO Auto-generated method stub
		return null;
	}

	
	/****************************
	 * Recibimos un numero
	 * Si este contiene un punto
	 * quitamos todo lo que este despues del punto
	 ****************************/
	@Override 
	public T visitInt_literal(@NotNull sqlParser.Int_literalContext ctx) 
	{ 
		String num = ctx.INT().getText();
		
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
		String num = ctx.INT(0).getText();
		
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
		
		String tipo = "Error";
		
		if (1 <= mes && mes<= 12 && dia>=1)
		{
			if (bisiesto(anio))
			{
				if (mes == 2)
				{
					if (dia<=29)
					{
						tipo = "date";
					}
				}
				else
				{
					if (dia<=maxday(mes))
					{
						tipo = "date";
					}
				}
			}
			else
			{
				if (mes == 2)
				{
					if (dia<=28)
					{
						tipo = "date";
					}
				}
				else
				{
					if (dia<=maxday(mes))
					{
						tipo = "date";
					}
				}
			}
		}
		
		return (T)tipo; 
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
		
		return (T)"char";
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
	
	public String compareDate(String date1, String date2)
	{
		String valor1[] = date1.split("-");
		String valor2[] = date2.split("-");
		
		if (Integer.parseInt(valor1[0])<Integer.parseInt(valor2[0]))
		{
			return "menor";
		}
		else
		{
			if (Integer.parseInt(valor1[0])>Integer.parseInt(valor2[0]))
			{
				return "mayor";
			}
			else
			{
				if (Integer.parseInt(valor1[1])<Integer.parseInt(valor2[1]))
				{
					return "menor";
				}
				else
				{
					if (Integer.parseInt(valor1[1])>Integer.parseInt(valor2[1]))
					{
						return "mayor";
					}
					else
					{
						if (Integer.parseInt(valor1[2])<Integer.parseInt(valor2[2]))
						{
							return "menor";
						}
						else
						{
							if (Integer.parseInt(valor1[2])>Integer.parseInt(valor2[2]))
							{
								return "mayor";
							}
							else
							{
								return "igual";
							}
						}
					}
				}
			}
		}
	}
	
	public boolean checkDate(String date)
	{
		if (!date.contains("-"))
		{
			return false;
		}
		else
		{
			String fecha[] = date.split("-");
			
			int size = fecha.length;
			if (size!=3)
				return false;
			else
			{
				fecha[0].replaceAll("'", "");
				fecha[2].replaceAll("'", "");
				if(fecha[0].length() >4 && fecha[1].length() > 2 && fecha[2].length()>2)
				{
					return false;
				}
				else
				{
					//revisar que sean fechas validas
					return true;
				}
			}	
		}
	}
	public T visitShow_column_statement(sqlParser.Show_column_statementContext ctx){
		//SHOW COLUMNS FROM ID (comprobar use database, id contenido en database)
		
		if (getActual().getName().isEmpty()){
			String no_database_in_use = "No hay una Base de Datos en uso @line: " + ctx.getStop().getLine();
        	this.errores.add(no_database_in_use);
		}else{
			String ID = ctx.getChild(3).getText();
			Table tb = getActual().getTable(ID);
			if (tb == null){
				String no_database_in_use = "No hay una Tabla " +ID+" en la Base de Datos " +getActual().getName()+" @line: " + ctx.getStop().getLine();
	        	this.errores.add(no_database_in_use);
	        	//System.out.println("error de tabla");
			}else{
				return (T) tb;
			}
		}
		
		return (T)new String();
	}
	
	public T visitShow_schema_statement(sqlParser.Show_schema_statementContext ctx){
		//SHOW DATABASES
		//System.out.println("llego aqui");
		return (T) dataBases;
	}
	
	public T visitShow_table_statement(sqlParser.Show_table_statementContext ctx){
		//SHOW TABLES (comprobar use database)
		if (getActual().getName().isEmpty()){
			String no_database_in_use = "No hay una Base de Datos en uso @line: " + ctx.getStop().getLine();
        	this.errores.add(no_database_in_use);
		}else{
			
			ArrayList<Atributo> atr = new ArrayList();
			atr.add(new Atributo("Tables"));
			
			ArrayList<ArrayList<String>> values = new ArrayList();
			for (Table tb: getActual().getTables()){
				ArrayList<String> val = new ArrayList();
				val.add(tb.getName());
				values.add(val);
			}
			Table tb1 = new Table(getActual().getName());
			tb1.setAtributos(atr);
			tb1.setData(values);
			return (T) tb1;
		}
		return (T) new String();
	}

	public Object visitSelect_value (sqlParser.Select_valueContext ctx){
		
		if (actual.getName().isEmpty()){
			String no_database_in_use = "No hay una Base de Datos en uso @line: " + ctx.getStop().getLine();
        	this.errores.add(no_database_in_use);
        	return null;
		}
			
		
		ArrayList<String> tables = (ArrayList<String>)visit(ctx.localIDS());
		for (String st: tables){
			if (!actual.existTable(st)){
				String no_database_in_use = "No hay una Tabla " +st+" en la Base de Datos " +getActual().getName()+" @line: " + ctx.getStop().getLine();
	        	this.errores.add(no_database_in_use);
	        	return null;
			}
		}
		
		String dupTable = (String)checkDuplicates(tables);
		if (!dupTable.isEmpty()){
			String error_ = "La tabla <<" +dupTable+">> ha sido llamada mas de una vez @line: " + ctx.getStop().getLine();
        	this.errores.add(error_);
        	return null;
		}
		
		Table crossTable = new Table(actual.getTable(tables.get(0)));
		crossTable.setNamesByTable();
		
		int i = 0;
		for (String st: tables){
			if (i != 0){
				crossTable = crossJoin(crossTable,actual.getTable(st));
			}else{
				i++;
			}
		}
		
		if (ctx.getChildCount() <= 5){//<= 5 porque hay que tomar en cuenta ';'
			
			return getTableFromSelectedColumns(crossTable, ctx.getChild(1));
		}
		
		
		String word = ctx.getChild(4).getText();
		
		if (word.toUpperCase().equals("WHERE")){
			
			table_use = crossTable;
			
			Object result = (Object) visit(ctx.getChild(5));//visitamos condition
			
			if (result == null){
				String error_ = "Error en la definicion de condiciones @line: " + ctx.getStop().getLine();
	        	this.errores.add(error_);
				return null;
			}
			
			if (!(result instanceof LinkedHashSet)){
				String error_ = "Error en la definicion de condiciones @line: " + ctx.getStop().getLine();
	        	this.errores.add(error_);
				return null;
			}
			
			LinkedHashSet<Integer> index = (LinkedHashSet<Integer>)result;
			
			ArrayList<ArrayList<String>> data = new ArrayList();
			for (int j: index){
				data.add(table_use.getData().get(j));
			}
			
			
			table_use.setData(data);
			if (ctx.getChildCount()<=7)
				return getTableFromSelectedColumns(table_use,ctx.getChild(1));
			
			//tiene orden
			Object obj = getCompare(table_use, (sqlParser.OrderContext) ctx.order());
			if (obj == null) return null;
			
			table_use = (Table) obj;
			return getTableFromSelectedColumns(table_use,ctx.getChild(1));
			
		}else if (word.toUpperCase().equals("ORDER")){
			
			table_use = crossTable;
			
			//tiene orden
			Object obj = getCompare(table_use, (sqlParser.OrderContext) ctx.order());
			if (obj == null) return null;
			
			table_use = (Table) obj;
			return getTableFromSelectedColumns(table_use,ctx.getChild(1));
		}
		
		return null;
	}
	
	public Object getCompare(Table table, sqlParser.OrderContext ctx){
		
		try{
			Collections.sort(table.getData(), new DtComparator(){
				public int compare(ArrayList<String> tupla1, ArrayList<String> tupla2){
					
					Object obj = visitOrder(tupla1,tupla2,ctx);
					
					if (obj == null) return (Integer)null;
					
					if (obj instanceof Integer) return (Integer) obj;
					return (Integer)null;
				}
			});
			
			return table;
		}catch (Exception e){
			//e.printStackTrace();
		}
		
		return null;
				
	}
	
	public Object visitOrder(ArrayList<String> tupla1, ArrayList<String> tupla2, sqlParser.OrderContext ctx){
		if (ctx instanceof sqlParser.OrderUniContext) return visitOrderUni(tupla1, tupla2, (sqlParser.OrderUniContext)ctx);
		
		if (ctx instanceof sqlParser.OrderMultiContext) return visitOrderMulti(tupla1, tupla2, (sqlParser.OrderMultiContext)ctx);
		
		return null;
	}
	
	public Object visitOrderUni (ArrayList<String> tupla1, ArrayList<String> tupla2, sqlParser.OrderUniContext ctx){
		String id = (String) visit(ctx.getChild(0));//obtenemos id
		
		Atributo at = table_use.getID(id);//obtenemos el atributo
		if (at == null){
			String rule_5 = "La tabla " + table_use.getName() + " no contiene la columna " + id + " @line: " + ctx.getStop().getLine();
			errores.add(rule_5);
			return null;
		}
		
		if (table_use.isAmbiguous(id)){
			String error_ = "La llamada <<"+id+">> es ambigua @line: " + ctx.getStop().getLine();
			errores.add(error_);
			return null;
		}
		
		String op = "ASC";
		if (ctx.getChildCount()>1) op = ctx.getChild(1).getText().toUpperCase();
		
		String st = "";
		
		
		int index = table_use.getAtributos().indexOf(at);//obtenemos el indice en data
		String tipo = at.getTipo().toLowerCase();
		DtComparator dt = new DtComparator();
		switch (op){
			case "ASC":
				if (tipo.equals("date")){
					return dt.compareDate(tupla1.get(index),tupla2.get(index));
				}else if (tipo.equals("int") || tipo.equals("float")){
					return dt.compareNum(tupla1.get(index),tupla2.get(index));
				}else{
					return tupla1.get(index).compareTo(tupla2.get(index));
				}
				//break;
			case "DESC":
				if (tipo.equals("date")){
					return -dt.compareDate(tupla1.get(index),tupla2.get(index));
				}else if (tipo.equals("int") || tipo.equals("float")){
					return -dt.compareNum(tupla1.get(index),tupla2.get(index));
				}else{
					return -tupla1.get(index).compareTo(tupla2.get(index));
				}
				//break;
		}
		return null;
	}

	public Object visitOrderMulti (ArrayList<String> tupla1, ArrayList<String> tupla2, sqlParser.OrderMultiContext ctx){
		String id = (String) visit(ctx.getChild(0));//obtenemos id
		
		Atributo at = table_use.getID(id);//obtenemos el atributo
		if (at == null){
			String rule_5 = "La tabla " + table_use.getName() + " no contiene la columna " + id + " @line: " + ctx.getStop().getLine();
			errores.add(rule_5);
			return null;
		}
		
		if (table_use.isAmbiguous(id)){
			String error_ = "La llamada <<"+id+">> es ambigua @line: " + ctx.getStop().getLine();
			errores.add(error_);
			return null;
		}
		
		String op = "ASC";
		if (!ctx.getChild(1).getText().equals(","))
			op = ctx.getChild(1).getText().toUpperCase();
		
		String st = "";
		
		int index = table_use.getAtributos().indexOf(at);//obtenemos el indice en data
		String tipo = at.getTipo().toLowerCase();
		
		DtComparator dt = new DtComparator();
		if (tipo.equals("date")){
			if (dt.compareDate(tupla1.get(index),tupla2.get(index))==0){
				return visitOrder(tupla1,tupla2,ctx.order());
			}
		}else if (tipo.equals("int") || tipo.equals("float")){
			if (dt.compareNum(tupla1.get(index),tupla2.get(index))==0){
				return visitOrder(tupla1,tupla2,ctx.order());
			}
		}else{
			if (tupla1.get(index).compareTo(tupla2.get(index))==0){
				return visitOrder(tupla1,tupla2,ctx.order());
			}
		}
		
		
		switch (op){
			case "ASC":
				if (tipo.equals("date")){
					return dt.compareDate(tupla1.get(index),tupla2.get(index));
				}else if (tipo.equals("int") || tipo.equals("float")){
					return dt.compareNum(tupla1.get(index),tupla2.get(index));
				}else{
					return tupla1.get(index).compareTo(tupla2.get(index));
				}
				//break;
			case "DESC":
				if (tipo.equals("date")){
					return -dt.compareDate(tupla1.get(index),tupla2.get(index));
				}else if (tipo.equals("int") || tipo.equals("float")){
					return -dt.compareNum(tupla1.get(index),tupla2.get(index));
				}else{
					return -tupla1.get(index).compareTo(tupla2.get(index));
				}
				//break;
		}
		return null;
	}
	
	public Object getTableFromSelectedColumns(Table table, ParseTree pr){
		if (pr.getText().equals("*")) return table;//selecciona todas
		
		if (!(pr instanceof sqlParser.NlocalIDSContext)) return null;
		sqlParser.NlocalIDSContext ctx = (sqlParser.NlocalIDSContext) pr;
		
		ArrayList<String> columns = (ArrayList<String>) visit(ctx);
		Table ntable = new Table();
		ntable.setName(table.getName());
		
		ArrayList<ArrayList<String>> data = new ArrayList();
		for (int i = 0; i < table.getData().size(); i++){
			data.add(new ArrayList());
		}
		ntable.setData(data);
		
		for (String id : columns){
			Atributo at = table.getID(id);
			if (at == null){
				String rule_5 = "La relacion " + table.getName() + " no contiene la columna " + id + " @line: " + ctx.getStop().getLine();
				errores.add(rule_5);
				return null;
			}
			
			if (table.isAmbiguous(id)){
				String error_ = "La llamada <<"+id+">> es ambigua @line: " + ctx.getStop().getLine();
				errores.add(error_);
				return null;
			}
			
			int index = table.getAtributos().indexOf(at);
			ntable.getAtributos().add(table.getAtributos().get(index));
			ntable.getOthersIds().add(table.getOthersIds().get(index));
			
			int i = 0;
			for (ArrayList<String> tupla: ntable.getData()){
				tupla.add(table.getData().get(i).get(index));
				i++;
			}
			
		}		
		
		return ntable;
	}
	
	public Object checkDuplicates (ArrayList<String> tables){
		LinkedHashSet<String> ntables = new LinkedHashSet(tables);
		LinkedHashSet<String> dup = new LinkedHashSet();
		for (String st: ntables){
			if (dup.contains(st)){
				return st;
			}
			dup.add(st);
		}
		return "";
	}
	
	public Object visitNlocalIDS (sqlParser.NlocalIDSContext ctx){
		if (ctx.getChildCount() <= 1){
			ArrayList<String> ar = new ArrayList();
			ar.add((String)visitChildren(ctx));
			return ar;
		}
		
		ArrayList<String> ar = new ArrayList();
		ar.add((String) visit(ctx.getChild(0)));
		ar.addAll((ArrayList<String>)visit(ctx.getChild(2)));
		return ar;		
	}
	
	/**
	 * requiere un paso base
	 * a tb1 se debe llamar tb1.setNamesByTable() fuera del metodo
	 * el metodo supone que tb1 es el crossJoin de otras tablas, 
	 * por lo que solo se debe agregar tb2 al crossJoin 
	 * 
	 * @param tb1
	 * @param tb2
	 * @return
	 */
	public Table crossJoin(Table tb1, Table tb2){
		//tb1.setNameByTable(); ya estan mezclados
		tb2.setNamesByTable();
		Table nTb = new Table();
		
		nTb.setName("Select");
		
		//agregamos todos los atributos
		ArrayList<Atributo> at = new ArrayList();
		at.addAll(tb1.getAtributos());
		at.addAll(tb2.getAtributos());
		nTb.setAtributos(at);
		
		//agregamos nuevos nombres tabla.atributo
		ArrayList<String> otN = new ArrayList();
		otN.addAll(tb1.getOthersIds());
		otN.addAll(tb2.getOthersIds());
		nTb.setOthersIds(otN);
		
		//vergueo con data
		ArrayList<ArrayList<String>> data = new ArrayList();
		for (ArrayList<String> tupla1: tb1.getData()){
			for (ArrayList<String> tupla2: tb2.getData()){
				ArrayList<String> tupla = new ArrayList();
				tupla.addAll(tupla1);
				tupla.addAll(tupla2);
				data.add(tupla);
			}
		}
		nTb.setData(data);
		//System.out.println(data);
		return nTb;
	}
	
	public Object visitNID( sqlParser.NIDContext ctx){
		if (ctx.getChildCount() <= 1) return ctx.getChild(0).getText();
	
		return ctx.getChild(0).getText()+"."+ctx.getChild(2).getText();
	}
	
	public DataBase getActual() {
		return actual;
	}

	public void setActual(DataBase actual) {
		this.actual = actual;
	}
	
	public boolean PrimaryKey(ArrayList<String> fila, Integer indice)
	{
		ArrayList<Constraint> key = this.table_use.getPrimaryKeys();
		
		ArrayList<Integer> primary = new ArrayList<Integer>();
		
		if (key.size() != 0)
		{
			Constraint llave = key.get(0);
			for (String id : llave.getIDS_local())	
			{
				Atributo atr = this.table_use.getID(id);
				primary.add(this.table_use.getAtributos().indexOf(atr));
			}
			
			int i=0;
			for (ArrayList<String> newfila:this.table_use.getData())
			{
				int cont=0;
				for (int index : primary)
				{
					if (newfila.get(index).equals(fila.get(index)))
					{
						cont++;
					}
				}
				if (cont == primary.size())
				{
					if (indice!=-1)
					{
						if (indice!= i)
						{
							return false;
						}
					}
					else
						return false;
				}
				i++;
			}
		}
		
		return true;
	}
	
	
	//devuelve si la llave foreana existe en la/las otras tablas
	public boolean ForeignKey(ArrayList<String> fila, Integer indice)
	{
		ArrayList<Constraint> key = this.table_use.getForeignKey();
		
		for (Constraint llave : key)
		{
			//tengo que ir a traer la tabla a la que hacen referencia
			//recorrer la tabla y ver si el valor en la fila en el indice del id local existe en la tabla
			//aumento un contador
			//si el contador al final es igla al total de constraints devuelve true 
			int index = 0;
			for (String id : llave.getIDS_refs()) 
			{
				
			}
		}
		return true;
	}
}
