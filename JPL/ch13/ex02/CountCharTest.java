package ch13.ex02;

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
	
	@Test
	public void countStrTest1() {
		String str = "jitensyajitensya";
		String key = "jitensya";
		
		CountChar obj = new CountChar();
		int actualCount = obj.countOfSpecifiedStringIncludedInString(str, key);
		int expectedCount = 2;
		
		assertEquals(actualCount, expectedCount);
	}
	
	@Test
	public void countStrTest2() {
		String str = "jitensyajitensya";
		String key = "ja";
		
		CountChar obj = new CountChar();
		int actualCount = obj.countOfSpecifiedStringIncludedInString(str, key);
		int expectedCount = 0;
		
		assertEquals(actualCount, expectedCount);
	}
	
	@Test
	public void countStrTest3() {
		String str = "";
		String key = "jitensya";
		
		CountChar obj = new CountChar();
		int actualCount = obj.countOfSpecifiedStringIncludedInString(str, key);
		int expectedCount = 0;
		
		assertEquals(actualCount, expectedCount);
	}
	
}
