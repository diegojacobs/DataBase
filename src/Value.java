
/**
@author Diego Jacobs
Date: Mar 31, 2016
 */
public class Value {
	private String value;
	private String tipo;
	private int size;
	
	
	
	public Value() {
		super();
		value = "";
		tipo = "";
		this.size = 0;
	}

	public Value(String value, String tipo) {
		super();
		this.value = value;
		this.tipo = tipo;
		this.size = 0;
	}

	public Value(String value, String tipo, int size) {
		super();
		this.value = value;
		this.tipo = tipo;
		this.size = size;
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
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String text = this.value + ':' + this.tipo;
		
		return text;
	}

}
