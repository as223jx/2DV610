package tests;
import arrayToHTMLTable.ArrayToHTMLTable;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayToHTMLTests {

	@Test
	public void createTableObject() {
		ArrayToHTMLTable table = new ArrayToHTMLTable();
		assertFalse(table.tableArray, null);
	}

}
