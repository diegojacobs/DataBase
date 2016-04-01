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
import java.util.List;
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
    		guardarDBs();
        }
		return (T)"";
		//return visitChildren(ctx); 
	}	
	
	/* (non-Javadoc)
	 * @see sqlBaseVisitor#visitDrop_schema_statement(sqlParser.Drop_schema_statementContext)
	 * 
	 * FALTAN IMPLEMENTAR LAS SIGUIENTES RESTRICCIONES
	 * 
	 *  1. Si existe una referencia HACIA la tabla que se desea borrar, no se debe permitir
		la acci�n. De esta manera se garantiza la integridad referencial. El usuario del DBMS deber� primero hacer ALTER TABLE tabla
		DROP CONSTRAINT constraint, para luego poder borrar la tabla que est� siendo referenciada.
	 *	2. Verificaci�n para DROP DATABASE. Para esta instrucci�n se debe hacer una doble verificaci�n con el usuario del DBMS
		mostrando el siguiente mensaje: ��Borrar base de datos nombre_BD con N registros? (si/no)� Donde N es la sumatoria de los
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
				guardarDBs();
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
	 * FALTA VALIDAR/CAMBIAR:
	 * Si hay una Key que hace referencia se debe cambiar tambien el nombre de la referencia
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
						System.out.println("La Tabla \"" + ID + "\" se ha renombrado exitosamente a \"" + NEW_ID + "\"");
						Table new_table = this.actual.getTable(ID);
						new_table.setName(NEW_ID);
						File directory = new File(this.dataPath + "\\" + this.actual.getName() + "\\" + ID + ".bin");
						// Renombrar el directorio
						directory.renameTo(new File(this.dataPath + "\\" + this.actual.getName() + "\\" + NEW_ID + ".bin"));						
						// Guardar cambio en la DB
						guardarDBs();
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
									String local_id_not_found = "El ID \"" + i + "\" de la Primary Key \"" + pk.getId() + "\" no esta declarado en la tabla \"" + name + "\" @line: " + ctx.getStop().getLine();
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
									String local_id_not_found = "El ID \"" + j + "\" de la Foreign Key \"" + i.getId() + "\" no esta declarado en la tabla \"" + name + "\" @line: " + ctx.getStop().getLine();
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
										String ref_id_not_found = "El ID \"" + j + "\" no esta declarado en la tabla \"" + i.getId_ref() + "\" que hace referencia la Foreign Key \"" + i.getId() + "\" @line: " + ctx.getStop().getLine();
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
								String local_id_not_found = "El ID \"" + id1 + "\" del Check \"" + i.getId() + "\" no esta declarado en la tabla \"" + name + "\" @line: " + ctx.getStop().getLine();
					        	this.errores.add(local_id_not_found);
					        	errores++;
							}
							if (! attrs_names.contains(id2) )
							{
								String local_id_not_found = "El ID \"" + id2 + "\" del Check \"" + i.getId() + "\" no esta declarado en la tabla \"" + name + "\" @line: " + ctx.getStop().getLine();
					        	this.errores.add(local_id_not_found);
					        	errores++;
							} 
						}
						// Si no hay errores se guarda la tabla
						if (errores == 0)
						{			
							Table new_table = new Table(name, atrs, pks, fks, checks);
							// Agregar tabla a la DB
							this.actual.addTable(new_table);
							System.out.println("Tabla \"" + name + "\" agregada exitosamente a la Base de Datos \"" + this.actual.getName() + "\"");
							System.out.println();
							System.out.println(this.actual.toString());
							// Guardar tabla en directorio
							saveTable(this.actual.getName(), name, new_table);
							// Guardar cambio en la DB
							guardarDBs();
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
		int columnas = ctx.getChild(3).getChildCount();
		int values = ctx.getChild(5).getChildCount();
		String id = ctx.ID().getText();
		
		//debemos revisar si existe la tabla en la base de datos actual
		Table tabla = this.actual.getTable(id);
		if (tabla != null)
		{
			//comparamos numerod e columas y valores con y sin parentesis
			if ( columnas == values || (columnas+2 == values && ctx.getChild(3).getText().contains("(")) || (columnas == values+2 && ctx.getChild(5).getText().contains("(")))
			{
				ArrayList<String> cols = (ArrayList<String>)this.visit(ctx.getChild(3));
				
				ArrayList<Value> vals = (ArrayList<Value>)this.visit(ctx.getChild(5));
			}
			else
			{	
				if (columnas<values)
				{
					String rule_5 = "No se puede hacer INSERT con mayor numero de valores a insertar que columnas @line: " + ctx.getStop().getLine();
					this.errores.add(rule_5);
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
			String rule_5 = "La tabla " + id + " @line: " + ctx.getStop().getLine();
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
		
		for (int i = 0; i < ctx.getChildCount(); i++)
			if (!ctx.getChild(i).getText().equals("(") || !ctx.getChild(i).getText().equals(")"))
			{
				Value valor = new Value();
				if(ctx.getChild(i).getText().contains("'"))
				{
					
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
		
		ArrayList<String> columnas = new ArrayList();
		
		for (int i = 0; i < ctx.getChildCount(); i++)
			if (!ctx.getChild(i).getText().equals("(") || !ctx.getChild(i).getText().equals(")"))
			{
				columnas.add(ctx.getChild(i).getText());
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
				//debemos visitar cada comparaci�n
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
		 * si no solo comparar tipos y luego hacer la comparaci�n
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
	 * Debemos revisar el tama�o de este texto
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
