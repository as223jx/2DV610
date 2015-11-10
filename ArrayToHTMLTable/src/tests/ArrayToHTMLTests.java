package tests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import arrayToHTMLTable.ArrayToHTMLTable;
import arrayToHTMLTable.TableMain;

public class ArrayToHTMLTests {
	private ByteArrayOutputStream os = new ByteArrayOutputStream();
	
	@Before
	public void setStreams() {
		System.setOut(new PrintStream(os));
	}
	
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
		assertEquals(os.toString(), "Hej");
	}
	
	@Test
	public void createTableWithTestScannerInsteadOfSystemIn() {
		Scanner scanner = new Scanner("Hej hej");
		
		TableMain main = new TableMain(scanner);
	}
}
