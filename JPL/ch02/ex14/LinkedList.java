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
		 * index�Ԗڂ̃A�C�e�����擾����
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
		 * �w��̃A�C�e�����Ō���ɒǉ�����
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
		 * index�Ԗڂ̃A�C�e���̗v�f���擾����
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
		 * �A������Ă���S�v�f��String�ɂ���
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
