package ch11.ex03;

public class Attr<E> {
	private final String name;
	private E value;
	
	//-----------------------------------------
	// �R���X�g���N�^
	//-----------------------------------------
	public Attr(String name) {
		this.name = name;
	}
	
	public Attr(String name, E value) {
		this.name = name;
		this.value = value;
	}
	
	//-----------------------------------------
	// get���\�b�h
	//-----------------------------------------
	public String getName() {
		return name;
	}
	
	public E getValue() {
		return value;
	}
	
	//-----------------------------------------
	// set���\�b�h
	//-----------------------------------------
	public E setValue(E newValue) {
		E oldVal = value;
		value = newValue;
		return oldVal;
	}
	
	//-----------------------------------------
	// ���̑����\�b�h
	//-----------------------------------------
	public String toString() {
		return (String) (name + "='" + value + ",");
	}
}
