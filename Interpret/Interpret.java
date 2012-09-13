import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Observer;


public class Interpret extends WindowAdapter implements ActionListener{
	private ObjectInfo model;
	private String objectName = "";
	//--------------------------------------------------------------------
	//							Public methods
	//--------------------------------------------------------------------
	public Interpret(ObjectInfo model) {
		this.model = model;
	}
	
	public void setObjectName(String name) {
		objectName = name;
	}
	
	public void setFieldVal(int index, String val) {
		model.setFieldVal(index, val);
	}
	
	public void setSelectedField(int index) {
		model.setSelectedField(index);
	}
	
	public void setSelectedMethod(int index) {
		model.setSelectedMethod(index);
	}
	
	public void setSelectedConstructor(int index) {
		model.setSelectedConstructor(index);
	}
	
	public void readSelectedElement(int index) {
		model.readSelectedElement(index);
	}
	
	public void createObject(String objName) {
		try {
			Class<?> clazz = Class.forName(objName);
			if (clazz != null) {
				Object obj = clazz.newInstance();
				saveObject(obj);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			model.notifyError(e.toString());
		} catch (InstantiationException e) {
			e.printStackTrace();
			model.notifyError(e.toString());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			model.notifyError(e.toString());
		}
	}
	
	public void setStringField(Object o, String name, String nv)
		throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		Field field = o.getClass().getField(name);
		field.set(o, nv);
	}
	
	public void setFieldValues(String[] vals) {
		model.setFieldValues(vals);
	}
	
	public void callMethod(String[] args) {
		model.invokeMethod(args);
	}
	
	public void callConstructor(String[] args) {
		model.invokeConstructor(args);
	}
	
	public void createArray(String type, String size) {
		model.createArray(type, size);
	}
	
	public void setElement(int index) {
		model.setElement(index);
	}
	
	public void getStockObject(String name) {
		model.getStockObject(name);
	}
	
	public void windowOpened(WindowEvent windowEvent){
	    model.addObserver((Observer)windowEvent.getSource());
	}
	
	public void windowClosing(WindowEvent windowEvent){
	    model.deleteObserver((Observer)windowEvent.getSource());
	    ((Frame)windowEvent.getSource()).dispose();
	    if(model.countObservers()==0){
	    System.exit(0);
	  }
	}
	
	public void removeAllStockObjects() {
		model.removeAllStockObjects();
	}
	//--------------------------------------------------------------------
	//							Private methods
	//--------------------------------------------------------------------
	private void saveObject(Object obj) {
		model.saveObject(obj);
	}
	
	private void showConstructor(String objName) {
		try {
			Class<?> clazz = Class.forName(objName);
			if (clazz != null) {
				Constructor[] cons = clazz.getConstructors();
				model.saveConstructors(cons);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Create object") {
			createObject(objectName);
		} else if (e.getActionCommand() == "Show constructor") {
			showConstructor(objectName);
		}
	}
}
