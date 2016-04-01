
/**
@author Diego Jacobs
Date: Mar 31, 2016
 */
public class Value {
	private String value;
	private String tipo;
	private String size;
	
	
	
	public Value() {
		super();
		value = "";
		tipo = "";
		this.size = "";
	}

	public Value(String value, String tipo) {
		super();
		this.value = value;
		this.tipo = tipo;
		this.size = "";
	}

	public Value(String value, String tipo, String size) {
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
	
	public String getSize() {
		return size;
	}
	
	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String text = this.value + ':' + this.tipo;
		
		return text;
	}

}
