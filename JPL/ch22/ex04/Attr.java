package ch22.ex04;

import java.util.Observable;

public class Attr<E> extends Observable{
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
		
		// Valueに変化があったことを通知
		setChanged();
		notifyObservers(name);
		return oldVal;
	}
	
	public String toString() {
		return (String) (name + "='" + value + ",");
	}
}
