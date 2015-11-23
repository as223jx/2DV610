package tests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import arrayToHTMLTable.HTMLTable;
import arrayToHTMLTable.TableMain;

public class ArrayToHTMLTests {
	private ByteArrayOutputStream os = new ByteArrayOutputStream();
	private Scanner scanner = null;
	
	@Before
	public void setStreams() {
		System.setOut(new PrintStream(os));
	}
	
	@After
	public void resetStreams() {
		System.setOut(System.out);
	}
	
	@Test
	public void createTableObject() {
		Object[][] array = {{"a", "b", "c"}, {1, 2, 3}, {4, 5, 6}};
		HTMLTable table = new HTMLTable(array);
		assertTrue(table.tableArray == array);
	}
	
	@Test (expected = NullPointerException.class)
	public void testNullArrayError() {
		Object[][] array = null;
		HTMLTable table = new HTMLTable(array);
	}

	@Test
	public void testGetHTMLTable() {
		Object[][] array = {{"a", "b"}, {1, 2}, {4, 5}};
		HTMLTable table = new HTMLTable(array);
		String htmlTable = table.getHTMLTable();
		assertEquals(htmlTable, "<table><th>a</th><th>b</th><tr><td>1</td><td>2</td></tr><tr><td>4</td><td>5</td></tr></table>");
	}

	
	@Test
	public void createTableWithTestScannerInsteadOfSystemIn() {
		scanner = new Scanner("Hej hej");
		
		TableMain main = new TableMain(scanner);
	}
	
	@Test
	public void useScannerToWriteToStream() {
		scanner = new Scanner("Hejheja");

		TableMain main = new TableMain(scanner);
		main.write();
		assertEquals(os.toString(), "Hejheja");
	}
	
	@Test
	public void getMultidimensionalArrayUsingNewLine() {
		scanner = new Scanner("Hej#där\nny#linje\ntestar#vi");
		TableMain main = new TableMain(scanner);
		String[][] inArr = {{"Hej", "där"},{"ny", "linje"},{"testar", "vi"}};
		String[][] arr = main.writeToMultidimensionalArray();
		for(int i = 0; i < inArr.length; i++) {
			for(int j = 0; j < inArr[i].length; j++) {
				assertEquals(arr[i][j], inArr[i][j]);
			}
		}
	}
	
	@Test
	public void stopReadingWhenDoubleLineBreak() {
		scanner = new Scanner("Hej#där\nny#linje\ntestar#vi\n\nbort#med#denna");
		TableMain main = new TableMain(scanner);
		String[][] inArr = {{"Hej", "där"},{"ny", "linje"},{"testar", "vi"}};
		String[][] arr = main.writeToMultidimensionalArray();
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				assertEquals(arr[i][j], inArr[i][j]);
			}
		}
	}
	
	@Test
	public void useDashToMakeEmptyCell() {
		scanner = new Scanner("Hej#på#dig\nhär#-#ska\ndet#vara#tomt!");
		TableMain main = new TableMain(scanner);
		String[][] inArr = {{"Hej", "på", "dig"},{"här", "", "ska"},{"det", "vara", "tomt!"}};
		String[][] arr = main.writeToMultidimensionalArray();
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				assertEquals(arr[i][j], inArr[i][j]);
			}
		}	
	}
	
	@Test
	public void makeSureFileIsCreated() {
		String[][] inArr = {{"Table", "head"},{"Rad", "två", "här"},{"vara", "tomt!"}};
		String path = "C:\\Users\\Alexandra\\Documents\\htmltabletest.txt";
		File f = new File(path);
		if(f.isFile()) {
			f.delete();
		}
		HTMLTable table = new HTMLTable(inArr);
		table.writeToFile(path);

		assertTrue(f.isFile());
	}
	
	@Test
	public void checkFileContents() {
		String[][] inArr = {{"Table", "head"},{"1", "2"},{"3", "4"}};
		HTMLTable table = new HTMLTable(inArr);
		String path = "C:\\Users\\Alexandra\\Documents\\htmltabletest.txt";
		table.writeToFile(path);
		
		String fileContent = "";
		try {
			Scanner sc = new Scanner(new File(path));
			while(sc.hasNext()) {
				fileContent += sc.next();
			}
			assertEquals(fileContent, "<table><th>Table</th><th>head</th><tr><td>1</td><td>2</td></tr><tr><td>3</td><td>4</td></tr></table>");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testEditCellInTable() {
		TableMain main = Mockito.mock(TableMain.class);
		int x = 2;
		int y = 1;
		String[][] inArr = {{"Table", "head"},{"1", "2"},{"3", "4"}};
		Mockito.when(main.writeToMultidimensionalArray()).thenReturn(inArr);
		HTMLTable table = new HTMLTable(main.writeToMultidimensionalArray());
		table.editCell(x, y, "new cell content");
		assertEquals(table.tableArray[x][y], "new cell content");
	}
	
	@Test
	public void testSetGetId() {
		HTMLTable table = Mockito.mock(HTMLTable.class);
		table.setId("10");
		assertEquals(table.getId(), "10");
	}
}
