
/**
@author Diego Jacobs
Date: Apr 2, 2016
 */
public class Comp {
	private Atributo id;
	private String op;
	private String value;
	private String tipo;
	private boolean withCol;
	private Atributo Col;
	
	
	
	public Comp() {
		id = new Atributo();
		op = new String();
		value = new String();
		tipo = new String();
		withCol = false;
		Col = null;
	}

	
	
	public Comp(Atributo id, String op, String value, String tipo) {
		this.id = id;
		this.op = op;
		this.value = value;
		this.tipo = tipo;
		this.withCol = false;
		this.Col = null;
	}

	

	public Comp(Atributo id, String op, Atributo col) {
		this.id = id;
		this.op = op;
		this.Col = col;
		this.withCol = true;
		this.value = null;
		this.tipo = null;
	}



	public Atributo getId() {
		return id;
	}
	
	public void setId(Atributo id) {
		this.id = id;
	}
	
	public String getOp() {
		return op;
	}
	
	public void setOp(String op) {
		this.op = op;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isWithCol() {
		return withCol;
	}
	
	public void setWithCol(boolean withCol) {
		this.withCol = withCol;
	}
	
	public Atributo getCol() {
		return Col;
	}
	
	public void setCol(Atributo col) {
		Col = col;
	}
}
