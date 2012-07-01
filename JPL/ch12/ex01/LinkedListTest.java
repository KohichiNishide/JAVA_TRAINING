package ch12.ex01;
import static org.junit.Assert.*;

import org.junit.Test;


public class LinkedListTest {

	@Test
	public void addTest() {
		LinkedList<String> list = new LinkedList<String>();
		
		list.add("a");
		String expected = "a";
		String actual = list.head.getValue();
		assertEquals(expected, actual);
	}
	
	@Test
	public void getTest() {
		LinkedList<String> list = new LinkedList<String>();
		
		list.add("a");
		
	    String expected = "a";
		String actual = null;
		try {
			actual = list.getValue(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(expected, actual);
	}
}
