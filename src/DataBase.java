import java.io.Serializable;


public class DataBase implements Serializable {
	
	private String name;
	
	public DataBase()
	{
		this.name = "";
	}

	public DataBase(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.name;
	}
	
}
