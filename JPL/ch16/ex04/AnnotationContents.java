package ch16.ex04;

import java.lang.annotation.Annotation;

public class AnnotationContents {
	public static void main(String[] args) {
		try {
			Class<?> c = Class.forName(args[0]);
			printAnnotation(c);
		} catch (ClassNotFoundException e) {
			System.out.println("unknown class: " + args[0]);
		}
	}
	
	public static void printAnnotation(Class<?> c) {
		System.out.println("Class name : " + c.getName());
	    // getAnnotations
	    for(Annotation an : c.getAnnotations()){
	        System.out.println(an.toString());
	    } 
	}
}
