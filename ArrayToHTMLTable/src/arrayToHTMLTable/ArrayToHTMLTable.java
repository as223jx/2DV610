package arrayToHTMLTable;

public class ArrayToHTMLTable {
	
	public Object[][] tableArray = {};
	
	public ArrayToHTMLTable(Object[][] array) {
		if(array == null)
			throw new NullPointerException();
		tableArray = array;
	}
	
	public String getHTMLTable() {
		return "";
	}
}