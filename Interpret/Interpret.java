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
			// ToDo : ?���^�ɂ�����
			Class<?> clazz = Class.forName(objName);
			if (clazz != null) {
				Object obj = clazz.newInstance();
				saveObject(obj);
			}
		} catch (ClassNotFoundException e) {
			// �w�肵�����̂̃N���X�����݂��Ȃ������ꍇ
			e.printStackTrace();
			model.notifyError();
		} catch (InstantiationException e) {
			// �C���X�^���X�쐬�s�̏ꍇ
			e.printStackTrace();
			model.notifyError();
		} catch (IllegalAccessException e) {
			// �������Ȃ��Ƃ�
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
	    //View��Model��Observer�Ƃ��Ēǉ�
	}
	
	public void windowClosing(WindowEvent windowEvent){
	    model.deleteObserver((Observer)windowEvent.getSource());
	    //����View��Model��Observer����폜
	    ((Frame)windowEvent.getSource()).dispose();
	    if(model.countObservers()==0){
	    //Model�ɓo�^���Ă���View(Observer)���Ȃ��Ȃ�����v���O�����I��
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
