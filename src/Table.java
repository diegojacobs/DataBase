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
	private ArrayList<ArrayList<String>> data;
	private ArrayList<String> othersIds;
	
	public Table()
	{
		this.name = "";
		this.atributos = new ArrayList<Atributo>();
		this.PrimaryKeys = new ArrayList<Constraint>();
		this.ForeignKey = new ArrayList<Constraint>();
		this.Checks = new ArrayList<Constraint>();
		this.data = new ArrayList<ArrayList<String>>();
		this.setOthersIds(new ArrayList<String>()); 
	}

	public Table(String name) {		
		this.name = name;
		this.atributos = new ArrayList<Atributo>();
		this.PrimaryKeys = new ArrayList<Constraint>();
		this.ForeignKey = new ArrayList<Constraint>();
		this.Checks = new ArrayList<Constraint>();
		this.data = new ArrayList<ArrayList<String>>();
		this.setOthersIds(new ArrayList<String>());
	}	

	public Table(String name, ArrayList<Atributo> atributos, ArrayList<Constraint> primaryKeys, ArrayList<Constraint> foreignKey, ArrayList<Constraint> checks) {
		this.name = name;
		this.atributos = atributos;
		PrimaryKeys = primaryKeys;
		ForeignKey = foreignKey;
		this.Checks = checks;
		this.data = new ArrayList<ArrayList<String>>();
		this.setOthersIds(new ArrayList<String>());
		for (Atributo atr : this.atributos)
		{
			String col = name+"."+atr.getId();
			this.getOthersIds().add(col);
		}
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
	 * @return the name of the atributos
	 */
	public ArrayList<String> getAtributosNames() {
		ArrayList<String> ret = new ArrayList<String>();
		for (Atributo i: this.atributos)
			ret.add(i.getId());
		
		for (String name : this.getOthersIds())
			ret.add(name);
		return ret;
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
	
	public void renameRefIdFK(String oldName, String new_name)
	{
		for (Constraint i: this.ForeignKey)
			if (i.getId_ref().equals(oldName))
				i.setId_ref(new_name);
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
		
		if (!flag)
			for (String name : this.getOthersIds())
				if (id.equals(name))
				{
					flag=true;
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
		
		if (atr.equals(null))
		{
			for (String name : this.getOthersIds())
			{
				if (name.equals(id))
				{
					int index = this.getOthersIds().indexOf(name);
					atr = this.atributos.get(index);
				}
			}
		}
		
		return atr;
	}
	
	public Constraint getConstraint(String id)
	{
		Constraint res = new Constraint();
		int cont = 0;
		
		for (Constraint i: this.PrimaryKeys)
			if (i.getId().equals(id))
			{
				res = i;
				cont++;
				break;
			}
		
		if (cont == 0)
		{
			for (Constraint i: this.ForeignKey)
				if (i.getId().equals(id))
				{
					res = i;
					cont++;
					break;
				}
			
			if (cont == 0)
			{
				for (Constraint i: this.Checks)
					if (i.getId().equals(id))
					{
						res = i;
						cont++;
						break;
					}				
			}
		}	
		
		return res;
	}
	
	/*
	 * Return false si ya existe un atributo con el mismo nombre 
	 */
	public boolean canAddAtributo(Atributo a)
	{		
		int cont = 0;
		
		for(Atributo i: this.atributos)
			if (i.getId().equals(a.getId()))
			{
				cont++;
				break;
			}
		
		return (cont == 0);
	}
	
	public void addAtributo(Atributo a)
	{
		this.atributos.add(a);
		for (ArrayList<String> tupla: data){
			if (tupla.size()==atributos.size()-1){
				tupla.add("null");
			}
		}
	}
	
	public void deleteAtributo(String id)
	{
		int index = -1;
		int cont = 0;
		
		for (Atributo i: this.atributos)
		{
			if (i.getId().equals(id))
			{
				index = cont;
				break;
			}
			cont++;
		}
		
		if (index != -1)
			for (ArrayList<String> tupla: data){
				if (tupla.size()>index){
					tupla.remove(index);
				}
			}
			this.atributos.remove(index);
	}
	
	public void deleteConstraint(Constraint c)
	{
		switch (c.getTipo())
		{
			case "Primary Key":
				this.PrimaryKeys.remove(0);
				break;
			case "Foreign Key":
				int index = -1;
				int cont = 0;
				for (Constraint i: this.ForeignKey)
				{
					if (i.getId().equals(c.getId()))
					{
						index = cont;
						break;
					}
					cont++;
				}
				if (index != -1)
					this.ForeignKey.remove(index);
						
				break;
			case "Check":
				index = -1;
				cont = 0;
				for (Constraint i: this.Checks)
				{
					if (i.getId().equals(c.getId()))
					{
						index = cont;
						break;
					}
					cont++;
				}
				if (index != -1)
					this.ForeignKey.remove(index);
						
				break;
		}
	}
	
	/*
	 * Return false si ya existe una constraint con el mismo nombre 
	 */
	public boolean canAddConstraint(Constraint c)
	{
		int cont = 0;
		
		for (Constraint i: this.PrimaryKeys)
			if (i.getId().equals(c.getId()))
			{
				cont++;
				break;
			}
		
		if (cont == 0)
		{
			for (Constraint i: this.ForeignKey)
				if (i.getId().equals(c.getId()))
				{
					cont++;
					break;
				}
			
			if (cont == 0)
			{
				for (Constraint i: this.Checks)
					if (i.getId().equals(c.getId()))
					{
						cont++;
						break;
					}				
			}
		}	
		
		return (cont == 0);
	}
	
	public void addConstraint(Constraint c)
	{
		switch (c.getTipo())
		{
			case "Primary Key":
				this.PrimaryKeys.add(c);
				break;
			case "Foreign Key":
				this.ForeignKey.add(c);
				break;
			case "Check":
				this.Checks.add(c);
				break;
		}
	}
	
	/*
	 * Return true if exist the Constraint
	 */
	public boolean existeConstraint(String c)
	{
		int cont = 0;
		
		for (Constraint i: this.PrimaryKeys)
			if (i.getId().equals(c))
			{
				cont++;
				break;
			}
		
		if (cont == 0)
		{
			for (Constraint i: this.ForeignKey)
				if (i.getId().equals(c))
				{
					cont++;
					break;
				}
			
			if (cont == 0)
			{
				for (Constraint i: this.Checks)
					if (i.getId().equals(c))
					{
						cont++;
						break;
					}				
			}
		}	
		
		return (cont > 0);
	}
	
	public void addData(ArrayList<String> data){
		this.data.add(data);
	}
	
	public ArrayList<ArrayList<String>> getData() {
		return data;
	}

	public void setData(ArrayList<ArrayList<String>> data) {
		this.data = data;
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
	
	public boolean isAmbiguous(String id){
		int contador = 0;
		for (String st: getOthersIds()){
			if (st.equals(id))
				contador ++;
		}
		if (contador>0) return true;
		
		for (Atributo at: atributos){
			if (at.getId().equals(id))
				contador ++;
		}
		
		if (contador > 0) return true;
		
		return false;
		
	}
	
	/**
	 * agrega a othersIds los nombres de tal forma que sea:
	 * nombreTabla.nombreAtributo al momento de hacer el select
	 */
	public void setNamesByTable(){
		ArrayList<String> st = new ArrayList();
		for (Atributo at: atributos)
			st.add(getName()+"."+at.getId());
		this.setOthersIds(st);
	}

	public ArrayList<String> getOthersIds() {
		return othersIds;
	}

	public void setOthersIds(ArrayList<String> othersIds) {
		this.othersIds = othersIds;
	}

}
