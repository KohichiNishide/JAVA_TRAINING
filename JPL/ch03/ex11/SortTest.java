package ch03.ex11;

import org.junit.Test;

public class SortTest {

	@Test
	public void test() {
		double[] testData = {
							0.3, 1.3e-2, 7.9, 3.17
						};
		
		SortDouble bsort = new SimpleSortDouble();
		SortMetrics metrics = bsort.sort(testData);
		System.out.println("Metrics: " + metrics);
		for (int i = 0; i < testData.length; i++)
			System.out.println("\t" + testData[i]);
	}

}
