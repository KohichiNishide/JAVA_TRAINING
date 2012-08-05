import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
	
	public Boolean IsError() {
		return isError;
	}
	
	public void notifyError() {
		isError = true;
		setChanged();
		notifyObservers();
	}
	
	private void saveFields(List<Field> fs) {
		fields = fs;
		
		for (Field f : fields) {
			f.setAccessible(true);
			fieldNames.add(f.getName());
			fieldTypes.add(f.getType().toString());
			try {
				fieldVals.add(f.get(obj).toString());
			} catch (NullPointerException e) {				
				e.printStackTrace();
				fieldVals.add("Null");
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
				fieldVals.add("Impossible");
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				fieldVals.add("Impossible");
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
}
