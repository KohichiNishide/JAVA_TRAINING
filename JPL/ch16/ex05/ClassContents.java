package ch16.ex05;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
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
			String decl = m.toString() + getAnnotationInfo(m);
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
	
	// 指定されたメンバーのアノテーション情報を含む文字列を返す
	private static String getAnnotationInfo(Member m) {
		String result = " Annotation: ";
		Annotation[] ans = ((AnnotatedElement) m).getAnnotations();
		
		if (ans.length == 0)
			// アノテーションがない場合
			return "";
		
		for (Annotation an : ans) {
			result += an.toString();
			result += ", ";
		}
		return result;
	}
}
