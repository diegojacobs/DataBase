import java.io.Serializable;
import java.util.ArrayList;


public class DataBase implements Serializable {
	
	private String name;
	private ArrayList<Table> tables;
	private ArrayList<String> constraints_refs;
	
	public DataBase()
	{
		this.name = "";
		this.tables = new ArrayList<Table>();
		this.constraints_refs = new ArrayList<String>();
	}

	public DataBase(String name) {
		this.name = name;
		this.tables = new ArrayList<Table>();
		this.constraints_refs = new ArrayList<String>();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the tables
	 */
	public ArrayList<Table> getTables() {
		return tables;
	}
	
	/**
	 * @return the constraints_refs
	 */
	public ArrayList<String> getConstraints_refs() {
		return constraints_refs;
	}

	/**
	 * @param constraints_refs the constraints_refs to set
	 */
	public void setConstraints_refs(ArrayList<String> constraints_refs) {
		this.constraints_refs = constraints_refs;
	}

	/**
	 * @param tables the tables to set
	 */
	public void setTables(ArrayList<Table> tables) {
		this.tables = tables;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public void addRef(String table_to)
	{		
		if (! this.constraints_refs.contains(table_to))
			this.constraints_refs.add(table_to);
	}
	
	public boolean existRef(String table_to)
	{
		boolean res = false; 
		
		for (String i: this.constraints_refs)
			if (i.equals(table_to))
			{
				res = true;
				break;
			}
		return res;
	}
	
	public void renameRef(String old_name, String new_name)
	{
		int index = this.constraints_refs.indexOf(old_name);
		this.constraints_refs.remove(index);
		this.constraints_refs.add(new_name);
	}
	
	public void deleteRef(String name)
	{
		int index = this.constraints_refs.indexOf(name);
		if (index != -1)
			this.constraints_refs.remove(index);
	}
	
	public void addTable(Table t)
	{
		this.tables.add(t);
	}
	
	public boolean existTable(String name)
	{
		boolean res = false;
		for (Table i: this.tables)
			if (i.getName().equals(name))
			{
				res = true;
				break;
			}
		return res;
	}
	
	public Table getTable(String name)
	{
		Table res = new Table();
		res = null;
		for (Table i: this.tables)
			if (i.getName().equals(name))
			{
				res = i;
				break;
			}
		return res;
	}
	
	public void deleteTable(String name)
	{
		int index = -1;
		int cont = 0;
		for (Table i: this.tables)
		{
			if (i.getName().equals(name))
			{
				index = cont;
				break;
			}
			cont++;
		}
		if (index != -1)
			this.tables.remove(index);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String ret = "DB " + this.name + "\n";
		for (Table i: this.tables)
			ret += "\t" + i.toString() + "\n\n";
		return ret;
	}
	
}
