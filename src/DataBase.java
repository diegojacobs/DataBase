import java.io.Serializable;
import java.util.ArrayList;


public class DataBase implements Serializable {
	
	private String name;
	private ArrayList<Table> tables;
	private ArrayList<String[]> constraints_refs;
	
	public DataBase()
	{
		this.name = "";
		this.tables = new ArrayList<Table>();
		this.constraints_refs = new ArrayList<String[]>();
	}

	public DataBase(String name) {
		this.name = name;
		this.tables = new ArrayList<Table>();
		this.constraints_refs = new ArrayList<String[]>();
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
	public ArrayList<String[]> getConstraints_refs() {
		return constraints_refs;
	}

	/**
	 * @param constraints_refs the constraints_refs to set
	 */
	public void setConstraints_refs(ArrayList<String[]> constraints_refs) {
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
	
	public void addRef(String table_from, String key_id, String table_to)
	{
		String[] new_ref = new String[3];
		new_ref[0] = table_from;
		new_ref[1] = key_id;
		new_ref[2] = table_to;
		this.constraints_refs.add(new_ref);
	}
	
	public boolean existRef(String table_from, String key_id, String table_to)
	{
		String[] new_ref = new String[3];
		new_ref[0] = table_from;
		new_ref[1] = key_id;
		new_ref[2] = table_to;
		return this.constraints_refs.contains(new_ref);
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
