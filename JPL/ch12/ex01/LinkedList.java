package ch12.ex01;

public class LinkedList<E> {
	public Item<E> head;
	
	public void add(E val) {
		/**
		 * �w��̗v�f���Ō���ɒǉ�����
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
		 * index�Ԗڂ̗v�f���擾����
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
		// null��Ԃ����G���[�̏ڍׂ�`���邱�Ƃ��ł���
		throw new ListIndexOutOfBoundsException("The index is out of range", index);
	}
	
	public E find(E val) throws ObjectNotFoundException {
		/**
		 * �w��̗v�f�Ɉ�v����v�f���擾����
		 */
		Item<E> aItem = head;
		while (aItem != null) {
			if (aItem.getValue().hashCode() == val.hashCode()) {
				return aItem.getValue();
			}
			aItem = aItem.getNext();
		}
		// null��Ԃ����G���[�̏ڍׂ�`���邱�Ƃ��ł���
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
