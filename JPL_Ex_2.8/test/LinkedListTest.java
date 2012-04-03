import static org.junit.Assert.*;

import org.junit.Test;


public class LinkedListTest {

	@Test
	public void constructorTest() {
		LinkedList list = new LinkedList();
		int expectedSize = 0;
		int actualSize = list.size;
		assertEquals(expectedSize, actualSize);
	}	
	
	@Test
	public void addTest() {
		LinkedList list = new LinkedList();
		Item item = new Item("a");
		
		list.add(item);
		Item expectedItem = item;
		Item actualItem = list.head;
		int expectedSize = 1;
		int actualSize = list.size;
		assertEquals(expectedSize, actualSize);
		assertEquals(expectedItem, actualItem);
	}
	
	@Test
	public void getTest() {
		LinkedList list = new LinkedList();
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
	public void mainTest() {
		LinkedList.main(null);
	}
}
