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
				this.actual = i;
				break;
			}
		if (find == false)
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
				if (this.actual.getName().equals(ID))
					this.actual.setName(NEW_ID);
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
			if (this.actual.getName().isEmpty())
			{
				String no_database_in_use = "No hay una Base de Datos en uso @line: " + ctx.getStop().getLine();
	        	this.errores.add(no_database_in_use);
			}
			else
			{
				// Verificar que la tabla con ID exista
				if (this.actual.existTable(ID))
				{
					// Verificar que no exista una tabla ya creada con ID == NEW_ID
					if (! this.actual.existTable(NEW_ID))
					{						
						//System.out.println("Before rename");
						//System.out.println(this.actual);
						// Renombrar referencias
						if (this.actual.existRef(ID))
						{
							for (Table i: this.actual.getTables())
								i.renameRefIdFK(ID, NEW_ID);
						}
						this.actual.renameRef(ID, NEW_ID);
						System.out.println("La Tabla \"" + ID + "\" se ha renombrado exitosamente a \"" + NEW_ID + "\"");
						Table new_table = this.actual.getTable(ID);
						new_table.setName(NEW_ID);
						File directory = new File(this.dataPath + "\\" + this.actual.getName() + "\\" + ID + ".bin");
						// Renombrar el directorio
						directory.renameTo(new File(this.dataPath + "\\" + this.actual.getName() + "\\" + NEW_ID + ".bin"));						
						// Guardar cambio en la DB
						//guardarDBs();
						//System.out.println("After rename");
						//System.out.println(this.actual);
					}
					else
					{
						String table_already_exist = "Ya existe una tabla con el mismo nombre en la Base de Datos \"" + this.actual.getName() + "\" @line: " + ctx.getStop().getLine();
			        	this.errores.add(table_already_exist);
					}
				}
				else
				{
					String table_not_found = "La Tabla \"" + ID + "\" no existe en la Base de Datos \"" + this.actual.getName() + "\" @line: " + ctx.getStop().getLine();
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
		if (this.actual.getName().isEmpty())
		{
			String no_database_in_use = "No hay una Base de Datos en uso @line: " + ctx.getStop().getLine();
        	this.errores.add(no_database_in_use);
        	errores++;
		}
		else
		{		
			// No se puede repetir nombre en las tablas
			if (! this.actual.existTable(name))
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
							if (! this.actual.existTable(i.getId_ref()))
							{
								String table_not_found = "La tabla \"" + i.getId_ref() + "\" que hace referencia la Foreign Key \"" + i.getId() + "\" no esta declarada en la Base de Datos \"" + this.actual.getName() + "\" @line: " + ctx.getStop().getLine();
					        	this.errores.add(table_not_found);
					        	errores++;
							}
							else
							{
								Table table_ref = this.actual.getTable(i.getId_ref());
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
								this.actual.addRef(i.getId_ref());
							// Agregar tabla a la DB
							this.actual.addTable(new_table);
							System.out.println("Tabla \"" + name + "\" agregada exitosamente a la Base de Datos \"" + this.actual.getName() + "\"");
							System.out.println();
							System.out.println(this.actual.toString());
							// Guardar tabla en directorio
							saveTable(this.actual.getName(), name, new_table);
							// Guardar cambio en la DB
							//guardarDBs();
						}
					}
				}
			}
			else
			{				
				String table_already_exist = "Ya existe una tabla con el mismo nombre en la Base de Datos \"" + this.actual.getName() + "\" @line: " + ctx.getStop().getLine();
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
		if (this.actual.getName().isEmpty())
		{
			String no_database_in_use = "No hay una Base de Datos en uso @line: " + ctx.getStop().getLine();
        	this.errores.add(no_database_in_use);
		}
		else
		{
			// Verificar que exista la tabla
			if (this.actual.existTable(ID_Table))
			{
				Table toAlter = this.actual.getTable(ID_Table);
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
							if (! this.actual.existTable(con.getId_ref()))
							{
								String table_not_found = "La tabla \"" + con.getId_ref() + "\" que hace referencia la Foreign Key \"" + con.getId() + "\" no esta declarada en la Base de Datos \"" + this.actual.getName() + "\" @line: " + ctx.getStop().getLine();
					        	this.errores.add(table_not_found);
					        	errores++;
							}
							else
							{
								Table table_ref = this.actual.getTable(con.getId_ref());
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
							this.actual.addRef(con.getId_ref());
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
				String table_not_found = "La Tabla \"" + ID_Table + "\" no existe en la Base de Datos \"" + this.actual.getName() + "\" @line: " + ctx.getStop().getLine();
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
		if (this.actual.getName().isEmpty())
		{
			String no_database_in_use = "No hay una Base de Datos en uso @line: " + ctx.getStop().getLine();
        	this.errores.add(no_database_in_use);
		}
		else
		{
			// Verificar que exista la tabla
			if (this.actual.existTable(ID_Table))
			{
				Table toAlter = this.actual.getTable(ID_Table);
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
							if (! this.actual.existTable(con.getId_ref()))
							{
								String table_not_found = "La tabla \"" + con.getId_ref() + "\" que hace referencia la Foreign Key \"" + con.getId() + "\" no esta declarada en la Base de Datos \"" + this.actual.getName() + "\" @line: " + ctx.getStop().getLine();
					        	this.errores.add(table_not_found);
					        	errores++;
							}
							else
							{
								Table table_ref = this.actual.getTable(con.getId_ref());
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
							this.actual.addRef(con.getId_ref());
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
				String table_not_found = "La Tabla \"" + ID_Table + "\" no existe en la Base de Datos \"" + this.actual.getName() + "\" @line: " + ctx.getStop().getLine();
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
		if (this.actual.getName().isEmpty())
		{
			String no_database_in_use = "No hay una Base de Datos en uso @line: " + ctx.getStop().getLine();
        	this.errores.add(no_database_in_use);
		}
		else
		{
			// Verificar que exista la tabla
			if (this.actual.existTable(ID_Table))
			{
				Table toAlter = this.actual.getTable(ID_Table);
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
					if (this.actual.existRef(ID_Table))
					{
						for (Table i: this.actual.getTables())
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
				String table_not_found = "La Tabla \"" + ID_Table + "\" no existe en la Base de Datos \"" + this.actual.getName() + "\" @line: " + ctx.getStop().getLine();
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
		if (this.actual.getName().isEmpty())
		{
			String no_database_in_use = "No hay una Base de Datos en uso @line: " + ctx.getStop().getLine();
        	this.errores.add(no_database_in_use);
		}
		else
		{
			// Verificar que exista la tabla
			if (this.actual.existTable(ID_Table))
			{
				Table toAlter = this.actual.getTable(ID_Table);
				// Verificar que exista la Constraint
				if (toAlter.existeConstraint(ID_Constraint))
				{
					// Verificar si hay que borrarlo de constraints_refs
					Constraint to_drop = toAlter.getConstraint(ID_Constraint);
					if (to_drop.getTipo().equals("Foreign Key"))
					{
						int cont = 0;
						for (Table i: this.actual.getTables())
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
							this.actual.deleteRef(to_drop.getId_ref());
								
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
				String table_not_found = "La Tabla \"" + ID_Table + "\" no existe en la Base de Datos \"" + this.actual.getName() + "\" @line: " + ctx.getStop().getLine();
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
				if (this.actual.getName().isEmpty())
				{
					String no_database_in_use = "No hay una Base de Datos en uso @line: " + ctx.getStop().getLine();
		        	this.errores.add(no_database_in_use);
				}
				else
				{
					// Verificar que exista la tabla
					if (this.actual.existTable(ID_Table))
					{
						Table toAlter = this.actual.getTable(ID_Table);
						// Verificar si tiene referencias en fks
						if (this.actual.existRef(ID_Table))
						{
							for (Table i: this.actual.getTables())
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
					    		File file = new File(this.dataPath+this.actual.getName()+"\\"+ID_Table+".bin");					    		
					    		
					    		if(file.delete())
					    		{
					    			// Eliminar tabla del objeto					
									this.actual.deleteTable(ID_Table);
					    			System.out.println("La Tabla \"" + ID_Table + "\" se ha eliminado exitosamente de la Base de Datos \"" + this.actual.getName() + "\"");
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
						String table_not_found = "La Tabla \"" + ID_Table + "\" no existe en la Base de Datos \"" + this.actual.getName() + "\" @line: " + ctx.getStop().getLine();
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
		//debemos revisar si existe la tabla en la base de datos actual
		table_use = this.actual.getTable(id);
		
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
								if (atr.getSize()>=valor.getSize())
								{
									//agrego el valor a la fila en el index del atributo
									int index = this.table_use.getAtributos().indexOf(atr);
									fila.add(index, valor.getValue());
								}
								else
								{
									//error tamaño del valor mayor
									String rule_5 = "El tamaño del valor que se desea ingresar es mayor al tamaño reservado en la base de datos @line: " + ctx.getStop().getLine();
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
										if (atr.getSize() >= valor.getValue().length())
										{
											//agrego el valor a la fila en el index del atributo
											int index = this.table_use.getAtributos().indexOf(atr);
											fila.set(index, valor.getValue());
										}
									}
							}
						}
						//cont++;
					}
					
					//Agrego la fila solo si el numero de errores sigue siendo el mismo
					if (contErrores == this.errores.size())
					{
						this.table_use.addData(fila);
						this.inserted_rows++;
					}
				}
			}
			else
			{	
				String rule_5 = "No se puede hacer INSERT con mayor numero de columnas  que valores a insertar @line: " + ctx.getStop().getLine();
				this.errores.add(rule_5);
			}
		}
		else
		{
			String rule_5 = "La tabla " + id + " no existe en la base de datos " + this.actual.getName() + " @line: " + ctx.getStop().getLine();
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

	
	/**************************
	 * Condition
	 * Revisamos cada comparacion
	 * Si al final la expresion es true devolvemos true
	 * si no false
	 */
	@Override 
	public T visitCondition(@NotNull sqlParser.ConditionContext ctx) 
	{ 
		int cant = ctx.getChildCount();
		
		switch (cant)
		{
			case 1:
				  return (T)ctx.comp();
			case 2:
				if (ctx.comp().toString().equals("true"))
					return (T)"false";
				else
					return (T)"true";
			default:
				//debemos visitar cada comparación
					return (T)"true";
		}
	}
	
	
	/***************************
	 * Comp
	 * Revisamos comp que puede tener
	 * ID relational ID | literal
	 */
	@Override 
	public T visitComp(@NotNull sqlParser.CompContext ctx) 
	{
		String ID1 = ctx.getChild(0).getText();
		String comp = ctx.getChild(2).getText(); //si es literal, voy a recibir el tipo
		
		
		/* Debemos de alguna forma revisar que el ID1 pertenece 
		 * a la tabla que estamos trabajando
		 * si el hijo 2 es ID debemos verificar qeut ambien pertenezca
		 * a la tabla
		 * si no solo comparar tipos y luego hacer la comparación
		*/
		
		return (T)"true"; 
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
	
	public T visitShow_column_statement(sqlParser.Show_column_statementContext ctx){
		//SHOW COLUMNS FROM ID (comprobar use database, id contenido en database)
		String dbsPath = dataPath+"/dbs.bin";//path... /data/
		if (actual.getName().isEmpty()){
			String no_database_in_use = "No hay una Base de Datos en uso @line: " + ctx.getStop().getLine();
        	this.errores.add(no_database_in_use);
		}else{
			String ID = ctx.getChild(3).getText();
			Table tb = actual.getTable(ID);
			if (tb == null){
				String no_database_in_use = "No hay una Tabla " +ID+" en la Base de Datos " +actual.getName()+" @line: " + ctx.getStop().getLine();
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
		return (T) new String();
	}
	
}
