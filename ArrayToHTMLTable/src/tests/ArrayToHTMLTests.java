package tests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import arrayToHTMLTable.ArrayToHTMLTable;
import arrayToHTMLTable.TableMain;

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
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(os);
		
		TableMain main = new TableMain(out);
		main.write();
		assertEquals(os.toString(), "Hej");
		
	}
}
