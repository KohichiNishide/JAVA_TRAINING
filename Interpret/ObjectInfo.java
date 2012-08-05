import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;


public class ObjectInfo extends Observable{
	public Object obj;
	public List<Field> fields = new ArrayList<Field>();
	public List<String> fieldNames = new ArrayList<String>();
	Boolean isError = false;
	
	public void saveObject(Object o) {
		obj = o;
		saveFields(getAllFieldsFromClass(o.getClass()));
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
		fieldNames.clear();
		for (Field f : fields) {
			fieldNames.add(f.getName());
		}
		isError = false;
		setChanged();
		notifyObservers();
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
	
	public final List<String> getFieldNames(){
	    return fieldNames;
	}
}
