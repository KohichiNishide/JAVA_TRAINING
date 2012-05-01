package ch06.ex04;

import static org.junit.Assert.*;

import org.junit.Test;

public class SignalColorTest {

	@Test
	public void test() {
		assertEquals(SignalColor.RED, SignalColor.RED.getColor());
		assertEquals(SignalColor.GREEN, SignalColor.GREEN.getColor());
		assertEquals(SignalColor.AMBER, SignalColor.AMBER.getColor());
	}

}
