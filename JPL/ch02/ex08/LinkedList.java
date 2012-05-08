package ch02.ex08;

public class LinkedList {
	public Item head;
	public int size;
	
	public LinkedList() {
		head = null;
		size = 0;
	}
	
	public void add(Item item) {
		/**
		 * 指定のアイテムを最後尾に追加する
		 */
		Item aItem = head;
		if (aItem == null) {
			head = item;
			size++;
			return;
		}		
		while (aItem != null) {
			if (aItem.getNext() == null) {
				aItem.setNext(item);
				size++;
				return;
			}
			aItem = aItem.getNext();
		}
	}
	
	public Object getValue(int index) throws Exception {
		/**
		 * index番目のアイテムの要素を取得する
		 */
		Item aItem = head;
		int i = 0;
		while (aItem != null) {
			if (i == index) {
				return aItem.getValue();
			}
			aItem = aItem.getNext();
			i++;
		}
		throw new Exception("The index is out of range!!");
	}
	
	public static void main(String[] args) {
		Vehicle car = new Vehicle();
		Vehicle plane = new Vehicle();
		Vehicle bike = new Vehicle();
		Item carItem = new Item(car);
		Item planeItem = new Item(plane);
		Item bikeItem = new Item(bike);
		
		LinkedList list = new LinkedList();
		list.add(carItem);
		list.add(planeItem);
		list.add(bikeItem);
	}
}
