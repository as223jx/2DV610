package arrayToHTMLTable;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class TableMain {
	
	PrintStream ps = null;
	Scanner scanner = null;
	public String inString = null;
	ArrayList<String> list = new ArrayList<String>();
	int count = 0;
	
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
	
	public String[][] writeToMultidimensionalArray() {
		String[][] multiArr = null;
		int count = 0;
		list = new ArrayList<String>();
		String str;
		while(scanner.hasNextLine()) {
			str = scanner.nextLine();
			if(str.isEmpty()) {
				break;
			}
			else {
				list.add(str);
			}
		}
		
		multiArr = new String[list.size()][];
		String[] split;
		
		for(String s : list) {
			split = s.split("#");
			
			for(int i = 0; i < split.length; i++) {
				if(split[i].equals("-")) {
					split[i] = "";
				}
			}

			multiArr[count] = split;
			count ++;
		}
		return multiArr;
	}
}