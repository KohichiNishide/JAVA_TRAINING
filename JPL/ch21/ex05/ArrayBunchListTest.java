package ch21.ex05;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import junit.framework.TestCase;

import org.junit.Test;

public class ArrayBunchListTest extends TestCase  {
	private ListIterator<String> iterator;

	protected void setUp(){
		String[][] arrays = { {"Japan", "Jamaica"}, 
                {"UnitedStates", "Uzbekistan"},
                {"Chile", "China", "Canada"} };
		ArrayBunchList<String> list = new ArrayBunchList<String>(arrays);
	    iterator = list.listIterator();
	}
	
	@Test
	public void testNext() {
		assertEquals(iterator.next(), "Japan");
		assertEquals(iterator.next(), "Jamaica");
		assertEquals(iterator.next(), "UnitedStates");
	}
	
	@Test
	public void testPrevious() {
		iterator.next();
		assertEquals("Jamaica", iterator.previous());
		iterator.next();
		iterator.next();
		assertEquals("UnitedStates", iterator.previous());
	}

}
