package ch22.ex04;

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
	
	@Test
	public void notifyTest1() {
		Object value1 = new Object();
		Object value2 = new Object();
		ScreenColor color1 = new ScreenColor(value1);
		ScreenColor color2 = new ScreenColor(value2);
		Attr<ScreenColor> attr1 = new Attr<ScreenColor>("Koichi1", color1);
		Attr<ScreenColor> attr2 = new Attr<ScreenColor>("Koichi2", color2);
		
		Attributed attributed = new AttributedImpl();
		attributed.add(attr1);
		attributed.add(attr2);
		
		attr1.setValue(color2);
		
		// If update is called from Koichi1, OK!
	}
	
	@Test
	public void notifyTest2() {
		Object value1 = new Object();
		Object value2 = new Object();
		ScreenColor color1 = new ScreenColor(value1);
		ScreenColor color2 = new ScreenColor(value2);
		Attr<ScreenColor> attr1 = new Attr<ScreenColor>("Koichi1", color1);
		Attr<ScreenColor> attr2 = new Attr<ScreenColor>("Koichi2", color2);
		
		Attributed attributed = new AttributedImpl();
		attributed.add(attr1);
		attributed.add(attr2);
		attributed.remove("Koichi1");
		attr1.setValue(color2);
		
		// If update isn't called from Koichi1, OK!
	}
	
	
}
