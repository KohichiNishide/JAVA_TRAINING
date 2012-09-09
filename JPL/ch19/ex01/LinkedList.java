package ch19.ex01;

/**
 * LinkedListはリストに対して要素の追加または取得を行うメソッドを提供します。
 * @author　Koichi Nishide
 * @version 1.0
 */
public class LinkedList {
	private Item head;
	private int size;
	
	/**
	 * コンストラクタ
	 */
	public LinkedList() {
		head = null;
		size = 0;
	}
	
	/**
	 * getItemは、指定されたインデックスのアイテムを取得するメソッドです
	 * @param index　インデックス
	 * @return アイテム
	 * @throws Exception 指定したインデックスが範囲外の時に発生する例外
	 * @see Item
	 * @see Item#getNext()
	 */
	public Item getItem(int index) throws Exception {
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
	
	/**
	 * getSizeは、LinkedListのサイズを取得するメソッドです
	 * @return  サイズ
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * addは、指定したアイテムをLinkedListに追加するメソッドです
	 * @param Item　追加したいアイテム
	 * @throws Exception 指定したインデックスが範囲外の時に発生する例外
	 * @see Item
	 * @see Item#getNext()
	 * @see Item#setNext(Item)
	 */
	public void add(Item item) {
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
	
	/**
	 * getValueは、指定したインデックスに対応する要素を取得するメソッドです。
	 * @param index　インデックス
	 * @return 要素
	 * @throws Exception 指定したインデックスが範囲外の時に発生する例外
	 * @see Item
	 * @see Item#getNext()
	 * @see Item#getValue()
	 */
	public Object getValue(int index) throws Exception {
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
	
	/**
	 * toStringは、LinkedListに追加された全ての要素を文字列にして返すメソッドです。
	 * @return LinkedListに追加された全ての要素の文字列
	 * @see Item
	 * @see Item#getNext()
	 * @see Item#getValue()
	 */	
	public String toString() {
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
	
	/**
	 * メインメソッド
	 */
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
