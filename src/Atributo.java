
public class Atributo {
	
	private String id;
	private String tipo;
	private int size;
	private boolean check;
	
	public Atributo()
	{
		this.id = "";
		this.tipo = "";
		this.size = -1;
		this.check = false;
	}
	
	public Atributo(String id) {		
		this.id = id;
		this.tipo = "";
		this.size = -1;
		this.check = false;
	}
	
	public Atributo(String id, String tipo) {		
		this.id = id;
		this.tipo = tipo;
		this.size = -1;
		this.check = false;
	}

	public Atributo(String id, String tipo, int size) {		
		this.id = id;
		this.tipo = tipo;
		this.size = size;
		this.check = false;
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
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @return the check
	 */
	public boolean isCheck() {
		return check;
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
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * @param check the check to set
	 */
	public void setCheck(boolean check) {
		this.check = check;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String ret = "Atributo: " + id + ", tipo: " + tipo;
		if (this.size >= 0 )
			ret = "Atributo: " + id + ", tipo: " + tipo + "[" + Integer.toString(this.size) + "]";
		return ret;
	}	
	
	
}
