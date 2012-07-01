package ch13.ex05;

import static org.junit.Assert.*;

import org.junit.Test;

public class CommaManagerTest {

	@Test
	public void test1() {
		String str = "0123445666";
		String actualStr = CommaManager.insertComma(str);
		String expectedStr = "0,123,445,666";
		
		assertEquals(actualStr, expectedStr);
	}
	
	@Test
	public void test2() {
		String str = "01b23a4456ggg66";
		String actualStr = CommaManager.insertComma(str);
		String expectedStr = "0,123,445,666";
		
		assertEquals(actualStr, expectedStr);
	}

	@Test
	public void test3() {
		String str = "123445666";
		String actualStr = CommaManager.insertComma(str);
		String expectedStr = "123,445,666";
		
		assertEquals(actualStr, expectedStr);
	}
}
