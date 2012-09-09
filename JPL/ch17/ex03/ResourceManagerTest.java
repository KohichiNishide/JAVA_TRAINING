package ch17.ex03;

import static org.junit.Assert.*;

import org.junit.Test;

public class ResourceManagerTest {

	@Test
	public void successTest() {
		String key1 = "key1";
		ResourceManager obj = new ResourceManager();
		Resource ref = obj.getResource(key1);
		ref.use(key1, null);
	}
	
	@Test
	public void failTest() {
		String key1 = "key1";
		String key2 = "key2";
		ResourceManager obj = new ResourceManager();
		Resource ref = obj.getResource(key1);
		try {
			ref.use(key2, null);
		} catch(IllegalArgumentException ex) {
			assertEquals("wrong key", ex.getMessage());
		}
	}

}
