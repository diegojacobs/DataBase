import java.util.ArrayList;


/**
@author Diego Jacobs
Date: Mar 24, 2016
 */
public class Table {
	private String name;
	private ArrayList<Atributo> IDS;
	private ArrayList<Constraint> keys;
	
	public Table()
	{
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Atributo> getIDS() {
		return IDS;
	}

	public void setIDS(ArrayList<Atributo> iDS) {
		IDS = iDS;
	}
	
	public void setID(Atributo ID) {
		IDS.add(ID);
	}

	public ArrayList<Constraint> getKeys() {
		return keys;
	}

	public void setKeys(ArrayList<Constraint> keys) {
		this.keys = keys;
	}
	
	public boolean hasID(String id)
	{
		boolean flag = false;
		
		for (Atributo i : IDS)
		{
			if (i.getId().equals(id))
			{
				flag = true;
			}
		}
		
		return flag;
	}
	
	public Atributo getID(String id)
	{
		Atributo atr = null;
		
		for (Atributo i : IDS)
		{
			if (i.getId().equals(id))
			{
				atr = i;
			}
		}
		
		return atr;
	}

}
