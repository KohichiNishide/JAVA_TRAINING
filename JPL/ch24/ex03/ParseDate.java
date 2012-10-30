package ch24.ex03;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class ParseDate {
	public static void parse(String str) throws ParseException {
		Date date = DateFormat.getDateInstance().parse(str);
		System.out.println(date);
	}
	
	public static void main(String[] args) throws ParseException {
		ParseDate.parse("2007/01/01");
	}
}
