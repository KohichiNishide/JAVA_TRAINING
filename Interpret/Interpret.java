import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
	
	public void createObject(String objName) {
		try {
			// ToDo : ?を型にしたい
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
	
	public void fixFields() {
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Create object") {
			createObject(objectName);
		}
	}
}
