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
	
	public void setSelectedMethod(int index) {
		model.setSelectedMethod(index);
	}
	
	public void setSelectedConstructor(int index) {
		model.setSelectedConstructor(index);
	}
	
	public void createObject(String objName) {
		try {
			Class<?> clazz = Class.forName(objName);
			if (clazz != null) {
				Object obj = clazz.newInstance();
				saveObject(obj);
			}
		} catch (ClassNotFoundException e) {
			// 指定した名称のクラスが存在しなかった場合
			e.printStackTrace();
			model.notifyError();
		} catch (InstantiationException e) {
			// インスタンス作成不可の場合
			e.printStackTrace();
			model.notifyError();
		} catch (IllegalAccessException e) {
			// 権限がないとき
			e.printStackTrace();
			model.notifyError();
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
	
	public void windowOpened(WindowEvent windowEvent){
	    model.addObserver((Observer)windowEvent.getSource());
	    //ViewをModelのObserverとして追加
	}
	
	public void windowClosing(WindowEvent windowEvent){
	    model.deleteObserver((Observer)windowEvent.getSource());
	    //閉じるViewをModelのObserverから削除
	    ((Frame)windowEvent.getSource()).dispose();
	    if(model.countObservers()==0){
	    //Modelに登録していたView(Observer)がなくなったらプログラム終了
	    System.exit(0);
	  }
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
			if (clazz != null ) {
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
