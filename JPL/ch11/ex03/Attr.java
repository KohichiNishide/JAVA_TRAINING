package ch11.ex03;

public class Attr<E> {
	private final String name;
	private E value;
	
	//-----------------------------------------
	// コンストラクタ
	//-----------------------------------------
	public Attr(String name) {
		this.name = name;
	}
	
	public Attr(String name, E value) {
		this.name = name;
		this.value = value;
	}
	
	//-----------------------------------------
	// getメソッド
	//-----------------------------------------
	public String getName() {
		return name;
	}
	
	public E getValue() {
		return value;
	}
	
	//-----------------------------------------
	// setメソッド
	//-----------------------------------------
	public E setValue(E newValue) {
		E oldVal = value;
		value = newValue;
		return oldVal;
	}
	
	//-----------------------------------------
	// その他メソッド
	//-----------------------------------------
	public String toString() {
		return (String) (name + "='" + value + ",");
	}
}
