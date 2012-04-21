import static org.junit.Assert.*;

import org.junit.Test;


public class LinkedListTest {

	@Test
	public void addTest() {
		LinkedList list = new LinkedList();
		Item item = new Item("a");
		
		list.add(item);
		Item expected = item;
		Item actual = list.head;
		assertEquals(expected, actual);
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
}
