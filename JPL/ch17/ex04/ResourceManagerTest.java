package ch17.ex04;

import static org.junit.Assert.*;

import java.lang.ref.Reference;

import org.junit.Test;

public class ResourceManagerTest {

	@Test
	public void successTest() {
		ResourceManager obj = new ResourceManager();
		useResource(obj);
		
		System.gc();
		
		//obj.shutdown();
		
	}
	
	public void useResource(ResourceManager obj) {
		Key key1 = new Key();
		Resource res = obj.getResource(key1);
		res.use(key1, null);
	}
}
