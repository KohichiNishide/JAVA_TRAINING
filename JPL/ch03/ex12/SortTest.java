package ex12;

import org.junit.Test;

public class SortTest {

	@Test
	public void sortTest() {
		Vehicle car = new Vehicle("Tomm");
		Vehicle bike = new Vehicle("Johnnnnnnnnnnnnnn");
		Vehicle plane = new Vehicle("Kelllly");
		Vehicle ship = new Vehicle("Ken");
		Vehicle[] testData = {
							car, bike, plane, ship
						};
		
		SortHarness bsort = new SimpleSortDouble();
		SortMetrics metrics = bsort.sort(testData);
		System.out.println("Metrics: " + metrics);
		for (int i = 0; i < testData.length; i++)
			System.out.println("\t" + testData[i]);
	}
	
	@Test
	public void sortIncludingSameObjTest() {
		Vehicle car = new Vehicle("Tomm");
		Vehicle bike = new Vehicle("Johnnnnnnnnnnnnnn");
		Vehicle plane = new Vehicle("Kelllly");
		Vehicle ship = new Vehicle("Tomm");
		Vehicle[] testData = {
							car, bike, plane, ship
						};
		
		SortHarness bsort = new SimpleSortDouble();
		SortMetrics metrics = bsort.sort(testData);
		System.out.println("Metrics: " + metrics);
		for (int i = 0; i < testData.length; i++)
			System.out.println("\t" + testData[i]);
	}
}
