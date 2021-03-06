package ch11.ex03;

import static org.junit.Assert.*;

import org.junit.Test;

public class AttrTest {

	@Test
	public void equalsColorTrueTest() {
		Object value = new Object();
		ScreenColor color = new ScreenColor(value);
		Attr<ScreenColor> attr1 = new Attr<ScreenColor>("Koichi", color);
		Attr<ScreenColor> attr2 = new Attr<ScreenColor>("Koichi", color);
		
		assertTrue(attr1.getValue().equals(attr2.getValue()));
	}
	
	
	@Test
	public void equalsColorFalseTest() {
		Object value1 = new Object();
		Object value2 = new Object();
		ScreenColor color1 = new ScreenColor(value1);
		ScreenColor color2 = new ScreenColor(value2);
		Attr<ScreenColor> attr1 = new Attr<ScreenColor>("Koichi", color1);
		Attr<ScreenColor> attr2 = new Attr<ScreenColor>("Koichi", color2);
		
		assertFalse(attr1.getValue().equals(attr2.getValue()));
	}
}
