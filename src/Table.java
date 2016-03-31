import java.io.Serializable;
import java.util.ArrayList;


/**
@author Diego Jacobs
Date: Mar 24, 2016
 */
public class Table implements Serializable {
	
	private String name;
	private ArrayList<Atributo> atributos;
	private ArrayList<Constraint> PrimaryKeys;
	private ArrayList<Constraint> ForeignKey;
	private ArrayList<Constraint> Checks;
	
	public Table()
	{
		this.name = "";
		this.atributos = new ArrayList<Atributo>();
		this.PrimaryKeys = new ArrayList<Constraint>();
		this.ForeignKey = new ArrayList<Constraint>();
		this.Checks = new ArrayList<Constraint>();
	}

	public Table(String name) {		
		this.name = name;
		this.atributos = new ArrayList<Atributo>();
		this.PrimaryKeys = new ArrayList<Constraint>();
		this.ForeignKey = new ArrayList<Constraint>();
		this.Checks = new ArrayList<Constraint>();
	}	

	public Table(String name, ArrayList<Atributo> atributos, ArrayList<Constraint> primaryKeys, ArrayList<Constraint> foreignKey, ArrayList<Constraint> checks) {
		this.name = name;
		this.atributos = atributos;
		PrimaryKeys = primaryKeys;
		ForeignKey = foreignKey;
		this.Checks = checks;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the primaryKeys
	 */
	public ArrayList<Constraint> getPrimaryKeys() {
		return PrimaryKeys;
	}

	/**
	 * @return the foreignKey
	 */
	public ArrayList<Constraint> getForeignKey() {
		return ForeignKey;
	}

	/**
	 * @return the atributos
	 */
	public ArrayList<Atributo> getAtributos() {
		return atributos;
	}

	/**
	 * @return the checks
	 */
	public ArrayList<Constraint> getChecks() {
		return Checks;
	}

	/**
	 * @param atributos the atributos to set
	 */
	public void setAtributos(ArrayList<Atributo> atributos) {
		this.atributos = atributos;
	}

	/**
	 * @param checks the checks to set
	 */
	public void setChecks(ArrayList<Constraint> checks) {
		Checks = checks;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param primaryKeys the primaryKeys to set
	 */
	public void setPrimaryKeys(ArrayList<Constraint> primaryKeys) {
		PrimaryKeys = primaryKeys;
	}

	/**
	 * @param foreignKey the foreignKey to set
	 */
	public void setForeignKey(ArrayList<Constraint> foreignKey) {
		ForeignKey = foreignKey;
	}

	public boolean hasAtributo(String id)
	{
		boolean flag = false;
		
		for (Atributo i : atributos)
			if (i.getId().equals(id))
			{
				flag = true;
				break;
			}
		
		return flag;
	}
	
	public Atributo getID(String id)
	{
		Atributo atr = null;
		
		for (Atributo i : atributos)
		{
			if (i.getId().equals(id))
			{
				atr = i;
			}
		}
		
		return atr;
	}
	
	public String toString()
	{
		String ret = "Table " + this.name + "\n";
		int cont = 0;
		ret += "\tAtributos: ";
		for (Atributo i: this.atributos)
		{
			if (cont < this.atributos.size() - 1)
				ret += i.toString() + ", ";
			else
				ret += i.toString();
			cont++;
		}
		ret += "\n";
		cont = 0;
		ret += "\tPrimary Keys: ";
		for (Constraint i: this.PrimaryKeys)
		{
			if (cont < this.PrimaryKeys.size() - 1)
				ret += i.toString() + ", ";
			else
				ret += i.toString();
			cont++;
		}
		ret += "\n";
		cont = 0;
		ret += "\tForeign Keys: ";
		for (Constraint i: this.ForeignKey)
		{
			if (cont < this.ForeignKey.size() - 1)
				ret += i.toString() + ", ";
			else
				ret += i.toString();
			cont++;
		}
		ret += "\n";
		cont = 0;
		ret += "\tCheck: ";
		for (Constraint i: this.Checks)
		{
			if (cont < this.Checks.size() - 1)
				ret += i.toString() + ", ";
			else
				ret += i.toString();
			cont++;
		}
		return ret;
	}

}
