package ch21.ex04;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

public class ShortStringsTest extends TestCase {
	private List<String> list = new ArrayList<String>();
	
	protected void setUp(){
		list.clear();
		list.add("abc");
		list.add("abcd");
		list.add("abcde");
		list.add("ag");
		list.add("abcdef");
		list.add("ab");
		list.add("nishide");
		list.add("a");  
	}

	@Test
	public void testNext() {
		ShortStrings ite = new ShortStrings(list.listIterator(), 4);
		assertEquals(ite.next(), "abc");
		assertEquals(ite.next(), "abcd");
		assertEquals(ite.next(), "ag");
		assertEquals(ite.next(), "ab");
		assertEquals(ite.next(), "a");
	}
	
	@Test
	public void testPrevious() {
		ShortStrings ite = new ShortStrings(list.listIterator(list.size()), 4);
		assertEquals(ite.previous(), "a");
		assertEquals(ite.previous(), "ab");
		assertEquals(ite.previous(), "ag");
		assertEquals(ite.previous(), "abcd");
		assertEquals(ite.previous(), "abc");
	}
	
	@Test
	public void testAdd() {
		ShortStrings ite = new ShortStrings(list.listIterator(), 4);
		String str = "ab";
		ite.next();
		ite.add(str);
		assertEquals(ite.next(), "ab");
	}
	
	@Test
	public void testRemove() {
		ShortStrings ite = new ShortStrings(list.listIterator(), 4);
		ite.next();
		ite.remove();
		assertEquals(ite.next(), "abcd");
	}
	
	@Test
	public void testSet() {
		ShortStrings ite = new ShortStrings(list.listIterator(), 4);
		ite.next();
		String str = "ab";
		ite.set(str);
		assertEquals(ite.next(), "ab");
	}
}
