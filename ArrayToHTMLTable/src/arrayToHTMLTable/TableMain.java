package arrayToHTMLTable;

import java.io.PrintStream;
import java.util.Scanner;

public class TableMain {
	
	PrintStream ps = null;
	
	public TableMain() {
		ps = System.out;
	}
	
	public TableMain(Scanner scanner) {
		
	}
	
	public void write() {
		ps.print("Hej");
	}
	
}