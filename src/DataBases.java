import java.io.Serializable;
import java.util.ArrayList;


public class DataBases implements Serializable {

	private ArrayList<DataBase> dataBases;

	public DataBases() {
		this.dataBases = new ArrayList<DataBase>();
	}

	/**
	 * @return the dataBases
	 */
	public ArrayList<DataBase> getDataBases() {
		return dataBases;
	}

	/**
	 * @param dataBases the dataBases to set
	 */
	public void setDataBases(ArrayList<DataBase> dataBases) {
		this.dataBases = dataBases;
	}
	
	public void addDataBase(DataBase b)
	{
		this.dataBases.add(b);
	}
	
}
