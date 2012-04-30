package ch04.ex03;
import static org.junit.Assert.*;

import org.junit.Test;


public class LinkedListTest {

	@Test
	public void constructorTest() {
		LinkedListImp list = new LinkedListImp();
		int expectedSize = 0;
		int actualSize = list.getSize();
		assertEquals(expectedSize, actualSize);
	}	
	
	@Test
	public void cloneTest(){
		LinkedListImp list = new LinkedListImp();
		Item item1 = new Item("a");
		Item item2 = new Item("b");
		Item item3 = new Item("c");
		list.add(item1);
		list.add(item2);
		list.add(item3);
		
		try {
			LinkedListImp copyList = list.clone();
			assertNotSame(list, copyList); //�����I�u�W�F�N�g���Q�Ƃ��Ă��Ȃ����Ƃ��m�F
			for (int i = 0; i < 3; i++) {
				assertSame(list.getItem(i), copyList.getItem(i)); //�����I�u�W�F�N�g���Q�Ƃ��Ă��邱�Ƃ��m�F
			}
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
						e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void addTest() {
		LinkedListImp list = new LinkedListImp();
		Item item = new Item("a");
		
		list.add(item);
		Item expectedItem = item;
		Item actualItem = null;
		try {
			actualItem = list.getItem(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int expectedSize = 1;
		int actualSize = list.getSize();
		assertEquals(expectedSize, actualSize);
		assertEquals(expectedItem, actualItem);
	}
	
	@Test
	public void getTest() {
		LinkedListImp list = new LinkedListImp();
		Item item = new Item("a");
		list.add(item);
		
	    Object expected = "a";
		Object actual = null;
		try {
			actual = list.getValue(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(expected, actual);
	}
	
	@Test
	public void toStringTest() {
		LinkedListImp list = new LinkedListImp();
		Item item1 = new Item("a");
		Item item2 = new Item("b");
		Item item3 = new Item("c");
		list.add(item1);
		list.add(item2);
		list.add(item3);
		String actual = list.toString();
		String expected = " a b c";
		assertEquals(expected, actual);
	}
	
	@Test
	public void mainTest() {
		LinkedListImp.main(null);
	}
}
