import java.io.Serializable;
import java.util.ArrayList;


public class DataBase implements Serializable {
	
	private String name;
	private ArrayList<Table> tables;
	
	public DataBase()
	{
		this.name = "";
		this.tables = new ArrayList<Table>();
	}

	public DataBase(String name) {
		this.name = name;
		this.tables = new ArrayList<Table>();
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String ret = this.name + "\n";
		for (Table i: this.tables)
			ret += "\t" + i.toString() + "\n";
		return ret;
	}
	
}
