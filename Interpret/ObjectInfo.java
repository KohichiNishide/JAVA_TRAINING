import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;


public class ObjectInfo extends Observable{
	public Object obj;
	public List<Field> fields = new ArrayList<Field>();
	public List<Method> methods = new ArrayList<Method>();
	public List<String> fieldNames = new ArrayList<String>();
	public List<String> fieldTypes = new ArrayList<String>();
	public List<String> methodNames = new ArrayList<String>();
	public List<String> methodTypes = new ArrayList<String>();
	public List<String> fieldVals = new ArrayList<String>();
	Boolean isError = false;
	
	public void saveObject(Object o) {
		obj = o;
		reset();
		saveFields(getAllFieldsFromClass(o.getClass()));
		saveMethods(getAllMethodsFromClass(o.getClass()));

		isError = false;
		setChanged();
		notifyObservers();
	}
	
	public void setFieldValues(String[] vals) {
		fieldVals.clear();
		for (int i = 0; i < vals.length; i++) {			
			try {
				Field f = fields.get(i);
				f.setAccessible(true);
				System.out.println("fieldName: " + f.getName() + ", valueToInput: " + vals[i] + ", isAccessible: " + f.isAccessible());
				if (!Modifier.isStatic(f.getModifiers())) {
					// staticフィールドは変更できないためスキップ
					setFieldValue(f, vals[i]);
				}
				fieldVals.add(vals[i]);
			} catch (NullPointerException e) {
				e.printStackTrace();
				fieldVals.add("");
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
				fieldVals.add("");
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				fieldVals.add("");
			}
		}
		setChanged();
		notifyObservers();
	}
	
	private void setFieldValue(Field f, String val) throws NumberFormatException, IllegalArgumentException, IllegalAccessException {
		String typeStr = f.getType().toString();
		if (typeStr.equals("int")) {
			f.set(obj, Integer.parseInt(val));
		} else if (typeStr.equals("short")) {
			f.set(obj, Short.parseShort(val));
		} else if (typeStr.equals("long")) {
			f.set(obj, Long.parseLong(val));
		} else if (typeStr.equals("float")) {
			f.set(obj, Float.parseFloat(val));
		} else if (typeStr.equals("double")) {
			f.set(obj, Double.parseDouble(val));
		} else if (typeStr.equals("byte")) {
			f.set(obj, Byte.parseByte(val));
		} else if (typeStr.equals("boolean")) {
			f.set(obj, Boolean.valueOf(val));
		} else if (typeStr.equals("class java.lang.String")) {
			f.set(obj, val);
		} else {
			f.set(obj, (Object)val);
		}
	}
	
	public Boolean IsError() {
		return isError;
	}
	
	public void notifyError() {
		isError = true;
		setChanged();
		notifyObservers();
	}
	
	public void invokeMethod(int index) {
		Method method = methods.get(index);
		try {
			Object ret = method.invoke(obj, null);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void saveFields(List<Field> fs) {
		fields = fs;
		
		for (Field f : fields) {
			f.setAccessible(true);
			fieldNames.add(f.getName());
			fieldTypes.add(f.getGenericType().toString());
			try {
				fieldVals.add(f.get(obj).toString());
			} catch (NullPointerException e) {				
				e.printStackTrace();
				fieldVals.add("");
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
				fieldVals.add("");
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				fieldVals.add("");
			}
		}		
	}
	
	private void saveMethods(List<Method> ms) {
		methods = ms;
		
		for (Method m : methods) {
			m.setAccessible(true);
			methodNames.add(m.getName());
			methodTypes.add(m.getGenericReturnType().toString());
		}		
	}
	
	private void reset() {
		fieldNames.clear();
		fieldTypes.clear();
		fieldVals.clear();
		methodNames.clear();
		methodTypes.clear();
	}
	
	private List<Field> getAllFieldsFromClass(Class cls) {
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
	
	private List<Method> getAllMethodsFromClass(Class cls) {
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
	
	public final List<String> getFieldNames(){
	    return fieldNames;
	}
	
	public final List<String> getFieldTypes(){
	    return fieldTypes;
	}
	
	public final List<String> getFieldVals(){
	    return fieldVals;
	}
	
	public final List<String> getMethodNames(){
	    return methodNames;
	}
}
