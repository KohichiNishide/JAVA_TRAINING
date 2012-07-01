package ch13.ex03;

import static org.junit.Assert.*;
import org.junit.Test;

public class StringOperationTest {

	@Test
	public void test1() {
		String str = "jitensyajitensya";
		char start = 'j';
		char end = 'a';
		
		String[] actualStrings = StringOperation.delimitedString(str, start, end);
		String[] expectedStrings = {"jitensya", "jitensya"};
		
		for (int i = 0; i < expectedStrings.length; i++) {
			String actualStr = actualStrings[i];
			String expectedStr = expectedStrings[i];
			assertEquals(actualStr, expectedStr);
		}
	}
	
	@Test
	public void test2() {
		String str = "jitensyajitensya";
		char start = 'j';
		char end = 'j';
		
		String[] actualStrings = StringOperation.delimitedString(str, start, end);
		String[] expectedStrings = {"jitensyaj"};
		
		for (int i = 0; i < expectedStrings.length; i++) {
			String actualStr = actualStrings[i];
			String expectedStr = expectedStrings[i];
			assertEquals(actualStr, expectedStr);
		}
	}
	
	@Test
	public void test3() {
		String str = "jitensyajitensya";
		char start = 'j';
		char end = 'g';
		
		String[] actualStrings = StringOperation.delimitedString(str, start, end);
		String[] expectedStrings = {"jitensyajitensya"};
		
		for (int i = 0; i < expectedStrings.length; i++) {
			String actualStr = actualStrings[i];
			String expectedStr = expectedStrings[i];
			assertEquals(actualStr, expectedStr);
		}
	}
	
	@Test
	public void test4() {
		String str = "jitensyajitensya";
		char start = 'g';
		char end = 'g';
		
		String[] actualStrings = StringOperation.delimitedString(str, start, end);
		String[] expectedStrings = {null};
		
		for (int i = 0; i < expectedStrings.length; i++) {
			String actualStr = actualStrings[i];
			String expectedStr = expectedStrings[i];
			assertEquals(actualStr, expectedStr);
		}
	}

}
