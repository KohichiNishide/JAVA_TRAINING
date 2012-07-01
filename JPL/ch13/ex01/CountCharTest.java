package ch13.ex01;

import static org.junit.Assert.*;
import org.junit.Test;

public class CountCharTest {

	@Test
	public void countCharTest1() {
		String str = "ababababababab";
		char character = 'a';
		
		CountChar obj = new CountChar();
		int actualCount = obj.countOfSpecifiedCharIncludedInString(str, character);
		int expectedCount = 7;
		
		assertEquals(actualCount, expectedCount);
	}
	
	@Test
	public void countCharTest2() {
		String str = "ababababababab";
		char character = 'c';
		
		CountChar obj = new CountChar();
		int actualCount = obj.countOfSpecifiedCharIncludedInString(str, character);
		int expectedCount = 0;
		
		assertEquals(actualCount, expectedCount);
	}
	
	@Test
	public void countCharTest3() {
		String str = "";
		char character = 'a';
		
		CountChar obj = new CountChar();
		int actualCount = obj.countOfSpecifiedCharIncludedInString(str, character);
		int expectedCount = 0;
		
		assertEquals(actualCount, expectedCount);
	}
}
