package ch04.ex03;

public interface LinkedList {
	Item getItem(int index) throws Exception;
	int getSize();
	void add(Item item);
	Object getValue(int index) throws Exception;
	String toString();
}
