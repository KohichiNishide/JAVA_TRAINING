package ch03.ex07;

public class Attr {
	private final String name;
	private Object value = null;
	
	//-----------------------------------------
	// �R���X�g���N�^
	//-----------------------------------------
	public Attr(String name) {
		this.name = name;
	}
	
	public Attr(String name, Object value) {
		this.name = name;
		this.value = value;
	}
	
	//-----------------------------------------
	// get���\�b�h
	//-----------------------------------------
	public String getName() {
		return name;
	}
	
	public Object getValue() {
		return value;
	}
	
	//-----------------------------------------
	// set���\�b�h
	//-----------------------------------------
	public Object setValue(Object newValue) {
		Object oldVal = value;
		value = newValue;
		return oldVal;
	}
	
	//-----------------------------------------
	// ���̑����\�b�h
	//-----------------------------------------
	public String toString() {
		return name + "='" + value + ",";
	}
}
