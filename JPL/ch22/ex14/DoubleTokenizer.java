package ch22.ex14;

import java.util.StringTokenizer;

public class DoubleTokenizer {
	public static double splitDouble(String str) {
		StringTokenizer tokens = new StringTokenizer(str, " ");
		String s;
		double total = 0;
		while (tokens.hasMoreTokens()) {
			s = tokens.nextToken();
			System.out.println(s);
			double d = Double.parseDouble(s.replaceAll("[^0-9|.]",""));
			System.out.println(d);
			total += d;
		}
		return total;
	}
}
