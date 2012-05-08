package ch03.ex07;

import static org.junit.Assert.*;

import org.junit.Test;

public class ColorAttrTest {

	@Test
	public void equalsColorTrueTest() {
		Object value = new Object();
		ScreenColor color = new ScreenColor(value);
		ColorAttr attr1 = new ColorAttr("Koichi", color);
		ColorAttr attr2 = new ColorAttr("Koichi", color);
		
		assertTrue(attr1.equals(attr2));
	}
	
	@Test
	public void equalsValueTrueTest() {
		Object value = new Object();
		ColorAttr attr1 = new ColorAttr("Koichi", value);
		ColorAttr attr2 = new ColorAttr("Koichi", value);
		
		assertTrue(attr1.equals(attr2));
	}
	
	@Test
	public void hashColorTrueTest() {
		Object value = new Object();
		ScreenColor color = new ScreenColor(value);
		ColorAttr attr1 = new ColorAttr("Koichi", color);
		ColorAttr attr2 = new ColorAttr("Koichi", color);
		
		assertEquals(attr1.hashCode(), attr2.hashCode());
		System.out.println(attr1.hashCode() + ", " + attr2.hashCode());
	}
	
	@Test
	public void hashValueTrueTest() {
		Object value = new Object();
		ColorAttr attr1 = new ColorAttr("Koichi", value);
		ColorAttr attr2 = new ColorAttr("Koichi", value);
		
		assertEquals(attr1.hashCode(), attr2.hashCode());
		System.out.println(attr1.hashCode() + ", " + attr2.hashCode());
	}
	
	@Test
	public void equalsColorFalseTest() {
		Object value1 = new Object();
		Object value2 = new Object();
		ScreenColor color1 = new ScreenColor(value1);
		ScreenColor color2 = new ScreenColor(value2);
		ColorAttr attr1 = new ColorAttr("Koichi", color1);
		ColorAttr attr2 = new ColorAttr("Koichi", color2);
		
		assertFalse(attr1.equals(attr2));
	}
	@Test
	public void equalsValueFalseTest() {
		Object value1 = new Object();
		Object value2 = new Object();
		ColorAttr attr1 = new ColorAttr("Koichi", value1);
		ColorAttr attr2 = new ColorAttr("Koichi", value2);
		
		assertFalse(attr1.equals(attr2));
	}
	
	@Test
	public void hashColorFalseTest() {
		Object value1 = new Object();
		Object value2 = new Object();
		ScreenColor color1 = new ScreenColor(value1);
		ScreenColor color2 = new ScreenColor(value2);
		ColorAttr attr1 = new ColorAttr("Koichi", color1);
		ColorAttr attr2 = new ColorAttr("Koichi", color2);
		
		assertNotSame(attr1.hashCode(), attr2.hashCode());
		System.out.println(attr1.hashCode() + ", " + attr2.hashCode());
	}
	
	@Test
	public void hashValueFalseTest() {
		Object value1 = new Object();
		Object value2 = new Object();
		ColorAttr attr1 = new ColorAttr("Koichi", value1);
		ColorAttr attr2 = new ColorAttr("Koichi", value2);
		
		assertNotSame(attr1.hashCode(), attr2.hashCode());
		System.out.println(attr1.hashCode() + ", " + attr2.hashCode());
	}
}
