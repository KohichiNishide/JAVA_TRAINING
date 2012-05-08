package ch02.ex14;

public class LinkedList {
	private Item head;
	private int size;
	
	public LinkedList() {
		head = null;
		size = 0;
	}
	
	public Item getItem(int index) throws Exception {
		/**
		 * index番目のアイテムを取得する
		 */
		Item aItem = head;
		int i = 0;
		while (aItem != null) {
			if (i == index) {
				return aItem;
			}
			aItem = aItem.getNext();
			i++;
		}
		throw new Exception("The index is out of range!!");
	}
	
	public int getSize() {
		return size;
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
	
	public String toString() {
		/**
		 * 連結されている全要素をStringにする
		 */
		String str = "";
		Item aItem = head;
		Object val = null;
		while (aItem != null) {
			val = aItem.getValue();
			str += " " + val.toString();
			aItem = aItem.getNext();
		}
		return str;
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
