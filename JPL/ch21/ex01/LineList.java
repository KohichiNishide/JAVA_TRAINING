package ch21.ex01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LineList {
	private static List<String> strList = new ArrayList<String>();
	
	private static void storeList(String fileName) throws IOException {
		strList.clear();
		
		BufferedReader br = new BufferedReader(new FileReader(fileName));
        LineReader lr = new LineReader(br);
        String str;
        while((str = lr.readLine()).length() != 0) {
        	System.out.println(str);
        	addSorting(str);
        }
	}
	
	private static void addSorting(String str) {
		ListIterator<String> ite = strList.listIterator();
		
		while(ite.hasNext()) {
			String nextStr = ite.next();
			if (str.compareTo(nextStr) > 0) {
				break;
			}
		}
		if (ite.hasPrevious()) ite.previous();
		ite.add(str);
	}
	
	public static void main(String[] args) throws IOException {
		final String INPUT_FILE_PATH = "JPL/ch21/ex01/input.txt";
		storeList(INPUT_FILE_PATH);
		
		Iterator<String> ite = strList.iterator();
		System.out.println("***** PRINT *****");
		while (ite.hasNext()) {
			System.out.println(ite.next());
		}
	}
}
