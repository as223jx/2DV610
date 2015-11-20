package arrayToHTMLTable;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class HTMLTable {

	public Object[][] tableArray = {};
	
	public HTMLTable(Object[][] array) {
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
	
	public void writeToFile(String path) {
		try {
			PrintWriter writer = new PrintWriter(path, "UTF-8");
			writer.print(getHTMLTable());
			writer.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
		}
	}
}