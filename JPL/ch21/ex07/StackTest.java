package ch21.ex07;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

public class StackTest {
	
	@Test
	public void testPush() {
		Stack stack = new Stack();
		String str1 = "apple";
		stack.push(str1);
		
		assertEquals(stack.empty(), false);
	}
	
	@Test
	public void testPeek() {
		Stack stack = new Stack();
		String str1 = "apple";
		String str2 = "orange";
		stack.push(str1);
		stack.push(str2);
		
		assertEquals(stack.peek(), str2);
		assertEquals(stack.peek(), str2);
	}
	
	@Test
	public void testPeekError() {
		Stack stack = new Stack();
		try {
			stack.peek();
			fail();
		} catch(EmptyStackException e) {
			
		}
	}
	
	@Test
	public void testPop() {
		Stack stack = new Stack();
		String str1 = "apple";
		String str2 = "orange";
		stack.push(str1);
		stack.push(str2);
		
		assertEquals(stack.pop(), str2);
		assertEquals(stack.pop(), str1);
	}
	
	@Test
	public void testPopError() {
		Stack stack = new Stack();
		try {
			stack.pop();
			fail();
		} catch(EmptyStackException e) {
			
		}
	}
	
	@Test
	public void testEmpty() {
		Stack stack = new Stack();
		assertEquals(stack.empty(), true);
	}
	
	@Test
	public void testSearch() {
		Stack stack = new Stack();
		String str1 = "apple";
		String str2 = "orange";
		stack.push(str1);
		stack.push(str2);
		
		assertEquals(stack.search(str1), 2);
	}
	
	@Test
	public void testSearchError() {
		Stack stack = new Stack();
		String str1 = "apple";
		String str2 = "orange";
		stack.push(str1);
		
		assertEquals(stack.search(str2), -1);
	}
}
