package ch12.ex01;

public class LinkedList<E> {
	public Item<E> head;
	
	public void add(E val) {
		/**
		 * 指定の要素を最後尾に追加する
		 */
		Item<E> aItem = head;
		Item<E> item = new Item<E>(val);
		if (aItem == null) {
			head = item;
			return;
		}		
		while (aItem != null) {
			if (aItem.getNext() == null) {
				aItem.setNext(item);
				return;
			}
			aItem = aItem.getNext();
		}
	}
	
	public E getValue(int index) throws ListIndexOutOfBoundsException{
		/**
		 * index番目の要素を取得する
		 */
		Item<E> aItem = head;
		int i = 0;
		while (aItem != null) {
			if (i == index) {
				return aItem.getValue();
			}
			aItem = aItem.getNext();
			i++;
		}
		// nullを返すよりエラーの詳細を伝えることができる
		throw new ListIndexOutOfBoundsException("The index is out of range", index);
	}
	
	public E find(E val) throws ObjectNotFoundException {
		/**
		 * 指定の要素に一致する要素を取得する
		 */
		Item<E> aItem = head;
		while (aItem != null) {
			if (aItem.getValue().hashCode() == val.hashCode()) {
				return aItem.getValue();
			}
			aItem = aItem.getNext();
		}
		// nullを返すよりエラーの詳細を伝えることができる
		throw new ObjectNotFoundException("The element is not found!!", val);
	}
	
	static class Item<E> {
		private E value;
		private Item<E> next;
		
		public Item(E val) {
			value = val;
		}
		
		public E getValue() {
			return value;
		}
		
		public Item<E> getNext() {
			return next;
		}
		
		public void setNext(Item<E> nextItem) {
			next = nextItem;
		}
	}
}
