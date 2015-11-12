package arrayToHTMLTable;

import java.io.PrintStream;
import java.util.Scanner;

public class TableMain {
	
	PrintStream ps = null;
	Scanner scanner = null;
	public String inString = null;
	
	public TableMain() {
		ps = System.out;
		scanner = new Scanner(System.in);
	}
	
	public TableMain(Scanner scanner) {
		ps = System.out;
		this.scanner = scanner;
	}
	
	public void writeLine() {
		inString = scanner.next();
		ps.print(inString);
	}
	
	public void write() {
		if(scanner != null && ps != null) {
			while(scanner.hasNextLine()) {
				ps.print(scanner.nextLine());
			}
		}
	}
}