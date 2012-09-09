package ch20.ex06;

public class Attr<E> {
	private final String name;
	private E value;
	

	public Attr(String name) {
		this.name = name;
	}
	
	public Attr(String name, E value) {
		this.name = name;
		this.value = value;
	}
	

	public String getName() {
		return name;
	}
	
	public E getValue() {
		return value;
	}
	

	public E setValue(E newValue) {
		E oldVal = value;
		value = newValue;
		return oldVal;
	}
	

	public String toString() {
		return (String) (name + "='" + value + ",");
	}
}
