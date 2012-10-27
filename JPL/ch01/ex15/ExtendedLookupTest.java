package ch01.ex15;
import static org.junit.Assert.*;

import org.junit.Test;


public class ExtendedLookupTest {

	@Test
	public void addTest() {
		Object hoge = new Object();
		ExtendedLookup lookup = new ExtendedSimpleLookup();
		lookup.add(hoge);
		Object actual = lookup.find("Key0");
		assertEquals(hoge, actual);
	}
	
	@Test
	public void removeTest() {
		Object hoge = new Object();
		ExtendedLookup lookup = new ExtendedSimpleLookup();
		lookup.add(hoge);
		lookup.remove("Key0");
		Object actual = lookup.find("Key0");
		assertNull(actual);
	}

}
