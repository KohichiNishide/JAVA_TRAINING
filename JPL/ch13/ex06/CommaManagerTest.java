package ch13.ex06;

import static org.junit.Assert.*;

import org.junit.Test;

public class CommaManagerTest {

	@Test
	public void test1() {
		String str = "01b23a4456ggg66";
		String actualStr = CommaManager.insertSomething(str, ',' , 3);
		String expectedStr = "0,123,445,666";
		
		assertEquals(actualStr, expectedStr);
	}
	
	@Test
	public void test2() {
		String str = "01b23a4456ggg66";
		String actualStr = CommaManager.insertSomething(str, '&' , 3);
		String expectedStr = "0&123&445&666";
		
		assertEquals(actualStr, expectedStr);
	}
	
	@Test
	public void test3() {
		String str = "01b23a4456ggg66";
		String actualStr = CommaManager.insertSomething(str, '&' , 4);
		String expectedStr = "01&2344&5666";
		
		assertEquals(actualStr, expectedStr);
	}
}
