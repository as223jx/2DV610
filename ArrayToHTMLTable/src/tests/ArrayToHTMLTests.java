package tests;
import arrayToHTMLTable.ArrayToHTMLTable;
import arrayToHTMLTable.TableMain;
import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayToHTMLTests {
	
	@Test
	public void createTableObject() {
		Object[][] array = {{"a", "b", "c"}, {1, 2, 3}, {4, 5, 6}};
		ArrayToHTMLTable table = new ArrayToHTMLTable(array);
		assertTrue(table.tableArray == array);
	}
	
	@Test (expected = NullPointerException.class)
	public void testNullArrayError() {
		Object[][] array = null;
		ArrayToHTMLTable table = new ArrayToHTMLTable(array);
	}

	@Test
	public void testGetHTMLTable() {
		Object[][] array = {{"a", "b"}, {1, 2}, {4, 5}};
		ArrayToHTMLTable table = new ArrayToHTMLTable(array);
		String htmlTable = table.getHTMLTable();
		assertEquals(htmlTable, "<table><th>a</th><th>b</th><tr><td>1</td><td>2</td></tr><tr><td>4</td><td>5</td></tr></table>");
	}
	
	@Test
	public void writeToStream() {
		TableMain main = new TableMain();
		main.write();
	}
}
