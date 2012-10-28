package ch22.ex14;

import static org.junit.Assert.*;

import org.junit.Test;

public class DoubleTokenizerTest {

	@Test
	public void test1() {
		String str = "210.66666 89.44 90.322423";
		double actual = DoubleTokenizer.splitDouble(str);
		double expected = 210.66666 + 89.44 + 90.322423;
		assertEquals(actual, expected, 0);
	}
	
	@Test
	public void test2() {
		String str = "aaaa210.66666 ll89.44g 90.322423";
		double actual = DoubleTokenizer.splitDouble(str);
		double expected = 210.66666 + 89.44 + 90.322423;
		assertEquals(actual, expected, 0);
	}
	
	@Test
	public void test3() {
		String str = "aaaa210.66666 ll89.44g 90.322423  ";
		double actual = DoubleTokenizer.splitDouble(str);
		double expected = 210.66666 + 89.44 + 90.322423;
		assertEquals(actual, expected, 0);
	}

}
