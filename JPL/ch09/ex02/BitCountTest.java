package ch09.ex02;

import static org.junit.Assert.*;

import org.junit.Test;

public class BitCountTest {

	@Test
	public void test() {
		BitCount cal = new BitCount();
		for (int val = 0; val < 100000; val++) {
			int api = Integer.bitCount(val);
			int original = cal.originalCountBit(val);
			int hacker = cal.hackerCountBit(val);
			assertEquals(api, original);
			assertEquals(api, hacker);
		}
	}

}
