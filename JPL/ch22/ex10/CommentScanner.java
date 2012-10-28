package ch22.ex10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommentScanner {
	public static List<String> read(Readable source) {
		Scanner in = new Scanner(source);
		
		List<String> vals = new ArrayList<String>();
		in.useDelimiter("#.*|\n");
		String token;
		
		while(in.hasNext()) {
			token = in.next();
			while (token.matches(" *"))
				token = in.next();
			System.out.println(token);
			vals.add(token);
		}
		return vals;
	}
}
