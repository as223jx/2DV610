package arrayToHTMLTable;

import java.io.PrintStream;

public class TableMain {
	
	PrintStream ps = null;
	
	public TableMain() {
		ps = System.out;
	}
	
	public TableMain(PrintStream ps) {
		this.ps = ps;
	}
	
	public void write() {
		ps.print("Hej");
	}
	
}