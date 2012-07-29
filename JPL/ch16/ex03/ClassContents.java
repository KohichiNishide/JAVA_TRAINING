package ch16.ex03;

import java.lang.reflect.Member;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassContents {
	public static void main(String[] args) {
		try {
			Class<?> c = Class.forName(args[0]);			
			System.out.println(c);			
			printMembers(c.getDeclaredFields());
			printMembers(c.getFields(), c);			
            printMembers(c.getDeclaredMethods());
            printMembers(c.getMethods(), c);
			
		} catch (ClassNotFoundException e) {
			System.out.println("unknown class: " + args[0]);
		}
	}
	
	private static void printMembers(Member[] mems) {
		for (Member m : mems) {
			if (m.getDeclaringClass() == Object.class)
				continue;
			String decl = m.toString();
			System.out.print(" ");
			System.out.println(strip(decl, "java.lang."));
		}
	}
	
	private static void printMembers(Member[] mems, Class<?> c) {
        for (Member m : mems) {
            if(m.getDeclaringClass() == Object.class)
                    continue;
            if(c.toString().equals(m.getDeclaringClass().toString()))
                    continue;

            String decl = m.toString();
            System.out.print(" ");
            System.out.println(strip(decl, "java.lang."));
        }
	}
	
	private static String strip(String str, String rem) {
        Pattern pat = Pattern.compile(rem);
        Matcher matcher = pat.matcher(str);
        return matcher.replaceAll("");
	}
}
