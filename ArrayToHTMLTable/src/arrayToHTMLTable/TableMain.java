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
	
	public String[] writeToArray() {
		count = 0;
		String str = null;
		if(scanner != null && ps != null) {
			while(scanner.hasNext()) {
				count++;
				str = scanner.next();
				list.add(str);
				ps.print(str);
			}
		}
		String[] ret = new String[list.size()];
		for(int i = 0; i < list.size(); i++) {
			ret[i] = list.get(i);
		}
		return ret;
	}
	
	public String[][] writeToMultidimensionalArray() {
		String[][] multiArr = null;
		int count = 0;
		list = new ArrayList<String>();

		while(scanner.hasNextLine()) {
			list.add(scanner.nextLine());
		}
		
		multiArr = new String[list.size()][];
		
		for(String s : list) {
			String[] split = s.split(" ");
			multiArr[count] = split;
			count ++;
		}
		return multiArr;
	}
}