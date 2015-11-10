package arrayToHTMLTable;

public class ArrayToHTMLTable {
	
	public Object[][] tableArray = {};
	
	public ArrayToHTMLTable(Object[][] array) {
		if(array == null)
			throw new NullPointerException();
		tableArray = array;
	}
	
	public String getHTMLTable() {
		StringBuilder htmlTable = new StringBuilder();
		htmlTable.append("<table>");
		for(Object obj : tableArray[0]) {
			htmlTable.append("<th>" + obj.toString() + "</th>");
		}
		for(int i = 1; i < tableArray.length; i++) {
			htmlTable.append("<tr>");
			for(Object obj : tableArray[i]) {
				htmlTable.append("<td>" + obj.toString() + "</td>");
			}
			htmlTable.append("</tr>");
		}
		htmlTable.append("</table>");
		return htmlTable.toString();
	}
}