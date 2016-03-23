import java.util.ArrayList;


public class Constraint {
	
	private String id;
	private String tipo;
	private String exp;
	ArrayList<String> IDS_local;
	ArrayList<String> IDS_refs;
	
	public Constraint()
	{
		this.id = "";
		this.tipo = "";
		this.exp = "";
		this.IDS_local = new ArrayList<String>();
		this.IDS_refs = new ArrayList<String>();
	}

	public Constraint(String id) {
		this.id = id;
		this.tipo = "";
		this.exp = "";
		this.IDS_local = new ArrayList<String>();
		this.IDS_refs = new ArrayList<String>();
	}

	public Constraint(String id, String tipo) {
		this.id = id;
		this.tipo = tipo;
		this.exp = "";
		this.IDS_local = new ArrayList<String>();
		this.IDS_refs = new ArrayList<String>();
	}

	public Constraint(String id, String tipo, String exp) {
		this.id = id;
		this.tipo = tipo;
		this.exp = exp;
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

}
