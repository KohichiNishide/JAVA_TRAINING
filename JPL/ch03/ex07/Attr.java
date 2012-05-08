package ch03.ex07;

public class Attr {
	private final String name;
	private Object value = null;
	
	//-----------------------------------------
	// コンストラクタ
	//-----------------------------------------
	public Attr(String name) {
		this.name = name;
	}
	
	public Attr(String name, Object value) {
		this.name = name;
		this.value = value;
	}
	
	//-----------------------------------------
	// getメソッド
	//-----------------------------------------
	public String getName() {
		return name;
	}
	
	public Object getValue() {
		return value;
	}
	
	//-----------------------------------------
	// setメソッド
	//-----------------------------------------
	public Object setValue(Object newValue) {
		Object oldVal = value;
		value = newValue;
		return oldVal;
	}
	
	//-----------------------------------------
	// その他メソッド
	//-----------------------------------------
	public String toString() {
		return name + "='" + value + ",";
	}
}
