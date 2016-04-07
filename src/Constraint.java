import java.io.Serializable;
import java.util.ArrayList;


public class Constraint implements Serializable {
	
	private String id;
	private String tipo;
	private String exp;
	private String id_ref;
	private ArrayList<String> IDS_local;
	private ArrayList<String> IDS_refs;
	
	public Constraint()
	{
		this.id = "";
		this.tipo = "";
		this.exp = "";
		this.id_ref = "";
		this.IDS_local = new ArrayList<String>();
		this.IDS_refs = new ArrayList<String>();
	}

	public Constraint(String id) {
		this.id = id;
		this.tipo = "";
		this.exp = "";
		this.id_ref = "";
		this.IDS_local = new ArrayList<String>();
		this.IDS_refs = new ArrayList<String>();
	}
	
	public Constraint(String id, String tipo) {
		this.id = id;
		this.tipo = tipo;
		this.exp = "";
		this.id_ref = "";
		this.IDS_local = new ArrayList<String>();
		this.IDS_refs = new ArrayList<String>();
	}

	public Constraint(String id, String tipo, String exp) {
		this.id = id;
		this.tipo = tipo;
		this.exp = exp;
		this.id_ref = "";
		this.IDS_local = new ArrayList<String>();
		this.IDS_refs = new ArrayList<String>();
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @return the iDS_local
	 */
	public ArrayList<String> getIDS_local() {
		return IDS_local;
	}

	/**
	 * @return the iDS_refs
	 */
	public ArrayList<String> getIDS_refs() {
		return IDS_refs;
	}

	/**
	 * @return the exp
	 */
	public String getExp() {
		return exp;
	}

	/**
	 * @return the id_ref
	 */
	public String getId_ref() {
		return id_ref;
	}

	/**
	 * @param id_ref the id_ref to set
	 */
	public void setId_ref(String id_ref) {
		this.id_ref = id_ref;
	}

	/**
	 * @param exp the exp to set
	 */
	public void setExp(String exp) {
		this.exp = exp;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @param iDS_local the iDS_local to set
	 */
	public void setIDS_local(ArrayList<String> iDS_local) {
		IDS_local = iDS_local;
	}

	/**
	 * @param iDS_refs the iDS_refs to set
	 */
	public void setIDS_refs(ArrayList<String> iDS_refs) {
		IDS_refs = iDS_refs;
	}
	
	/**
	 * @param ID to add to the IDS_local
	 */
	public void addLocalID(String s)
	{
		this.IDS_local.add(s);
	}
	
	/**
	 * @param ID to add to the IDS_refs
	 */
	public void addRefID(String s)
	{
		this.IDS_refs.add(s);
	}
	
	public String toString()
	{
		String ret = this.tipo + " " + this.id + "(";
		switch (this.tipo)
		{
			case "Primary Key":
				int cont = 0;
				for (String i: this.IDS_local)
				{
					if (cont < this.IDS_local.size() - 1)
						ret += i + ", ";
					else
						ret += i;
					cont++;
				}
				ret += ")";
				break;
			case "Foreign Key":
				cont = 0;
				for (String i: this.IDS_local)
				{
					if (cont < this.IDS_local.size() - 1)
						ret += i + ", ";
					else
						ret += i;
					cont++;
				}
				ret += ") REFERENCES " + this.id_ref + " (";
				cont = 0;
				for (String i: this.IDS_refs)
				{
					if (cont < this.IDS_refs.size() - 1)
						ret += i + ", ";
					else
						ret += i;
					cont++;
				}
				ret += ")";
				break;
			case "Check":
				//ret += this.IDS_local.get(0) + " " + this.exp + " " + this.IDS_local.get(1) + ")";
				ret += ")";
				break;
		}
		return ret;
	}

}
