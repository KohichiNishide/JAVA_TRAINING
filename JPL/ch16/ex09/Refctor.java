package ch16.ex09;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Refctor {
	private static List<Field> fields = new ArrayList();
	private static List<Method> methods = new ArrayList();
	
	public static void show(String className) {
		try {
			Class<?> clzz = Class.forName(className);
			Package pkg = clzz.getPackage();
			Class sup = clzz.getSuperclass();
			fields = getAllFieldsFromClass(clzz);
			methods = getAllMethodsFromClass(clzz);
			int mod = clzz.getModifiers();			
			
			System.out.println("package " + pkg.getName());
			String modStr = getModifier(mod);
			
			System.out.print(modStr + "class " + clzz.getSimpleName() + " ");
			if( sup != null && !sup.getSimpleName().equals("Object")) {
                System.out.println( "extends " + sup.getSimpleName());
			} else {
				System.out.println( "{");
			}
			
			for (Field f : fields) {
				String str = getModifier(f.getModifiers());
				System.out.println( str + f.getType().getSimpleName() + " " + f.getName() + ";");
			}
			
			for (Method m : methods) {
				String str = getModifier(m.getModifiers());
				String returnStr = m.getGenericReturnType().toString();
				System.out.print( str + " " + returnStr + " " + m.getName() + "( ");
				
				Type[] pTypes = m.getParameterTypes();
				for (Type t : pTypes) {
					String pStr = t.toString();
					System.out.print(" " + pStr + ",");
				}
				
				Type[] exTypes = m.getGenericExceptionTypes();
				String exStr = "";
				for (Type t : exTypes) {
					exStr += t.toString();
					exStr += ", ";
				}
				
				if (exTypes.length != 0) {
					System.out.println(" ) throws " + exStr + " { };");
				} else {
					System.out.println(" )" + "{ };");
				}
			}
			
			System.out.println("}");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static String strip(String str, String rem) {
        Pattern pat = Pattern.compile(rem);
        Matcher matcher = pat.matcher(str);
        return matcher.replaceAll("");
	}
	
	private static String getModifier(int mod) {
		String modStr = "";
		if (Modifier.isPublic(mod)) {
			modStr += "public ";
		} else if (Modifier.isProtected(mod)) {
			modStr += "protected ";
		} else if (Modifier.isPrivate(mod)) {
			modStr += "private ";
		} else {
			// never happen
		}
		
		if (Modifier.isStatic(mod)) {
			modStr += "static ";
		} else if (Modifier.isFinal(mod)) {
			modStr += "final ";
		} else if (Modifier.isStrict(mod)) {
			modStr += "strictfp ";
		}
		return modStr;
	}
	
	private static List<Field> getAllFieldsFromClass(Class cls) {
		List<Field> allFields = new ArrayList<Field>(); 
		Field[] fields = cls.getDeclaredFields();
		Field[] publicFields = cls.getFields();
		for (Field f : publicFields) {
            if(f.getDeclaringClass() == Object.class)
                    continue;
            if(cls.toString().equals(f.getDeclaringClass().toString()))
                    continue;
            allFields.add(f);
        }
		
		for (Field f : fields) {
			allFields.add(f);
		}
		return allFields;
	}
	
	private static List<Method> getAllMethodsFromClass(Class cls) {
		List<Method> allMethods = new ArrayList<Method>(); 
		Method[] methods = cls.getDeclaredMethods();
		Method[] publicMethods = cls.getMethods();
		for (Method m : publicMethods) {
            if(m.getDeclaringClass() == Object.class)
                    continue;
            if(cls.toString().equals(m.getDeclaringClass().toString()))
                    continue;
            allMethods.add(m);
        }
		
		for (Method m : methods) {
			allMethods.add(m);
		}
		return allMethods;
	}
	
	public static void main(String[] args) {
		Refctor.show("java.lang.String");
	}
}
