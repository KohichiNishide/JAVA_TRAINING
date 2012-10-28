package ch22.ex02;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class WhichChars {
	private Set<Character> used = new HashSet<Character>();
	
	public WhichChars(String str) {
		for (int i = 0; i < str.length(); i++) {
			used.add(str.charAt(i));
		}
	}
	
	public String toString() {
		TreeSet<Character> sortedUsed = new TreeSet<Character>(used); //元々のWhichCharsと合わせるためにソートする
		String desc = "[";
		for (Character c: sortedUsed)
			desc += c;
		return desc + "]";
	}
	
	public static void main(String[] args) {
		WhichChars test1 = new WhichChars("Testing 1 2 3");
		WhichChars test2 = new WhichChars("Initialize");
		WhichChars test3 = new WhichChars("Z");
		System.out.println(test1);
		System.out.println(test2);
		System.out.println(test3);
	}
}
