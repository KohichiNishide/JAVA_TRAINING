package ch19.ex02;

public class Item {
	private Object value;
	private Item next;
	
	public Item(Object val) {
		value = val;
	}
	
	public Object getValue() {
		return value;
	}
	
	public Item getNext() {
		return next;
	}
	
	public void setNext(Item nextItem) {
		next = nextItem;
	}
}
