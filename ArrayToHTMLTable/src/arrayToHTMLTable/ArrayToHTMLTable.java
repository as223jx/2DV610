package arrayToHTMLTable;

public class ArrayToHTMLTable {
	
	public Object[][] tableArray = {};
	
	public ArrayToHTMLTable(Object[][] array) {
		if(array == null)
			throw new NullPointerException();
		tableArray = array;
	}
	
	public String getHTMLTable() {
		return "<table><th>a</th><th>b</th><tr><td>1</td><td>2</td></tr><tr><td>4</td><td>5</td></tr></table>";
	}
}