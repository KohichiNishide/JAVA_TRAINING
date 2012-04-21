
public class LinkedList {
	public Item head;
	
	public void add(Item item) {
		/**
		 * �w��̃A�C�e�����Ō���ɒǉ�����
		 */
		Item aItem = head;
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
		throw new Exception("index is out of range!!");
	}
}
