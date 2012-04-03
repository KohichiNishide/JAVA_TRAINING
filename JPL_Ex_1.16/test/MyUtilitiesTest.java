import static org.junit.Assert.*;

import org.junit.Test;


public class MyUtilitiesTest {

	@Test
	public void getDataSetTest() {
		String str = "/Users/knishide/Documents/workspace/JPL_Ex_1.16/test/test";
		MyUtilities utilities = new MyUtilities();
		double[] expected = {116, 101, 115, 116}; //test
		double[] actual = new double[4];
		try {
			actual = utilities.getDataSet(str);
		} catch (BadDataSetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double actualVal;
		double expectedVal;
		for (int i = 0; i < 4; i++) {
			actualVal = actual[i];
			expectedVal = expected[i];
			assertEquals(0, actualVal, expectedVal);
		}
	}
	
	@Test
	public void getBadDataSetTest() {
		String str = "/Users/knishide/Documents/workspace/JPL_Ex_1.16/test/";
		MyUtilities utilities = new MyUtilities();
		try {
			utilities.getDataSet(str);
		} catch (BadDataSetException e) {
			String expected = "/Users/knishide/Documents/workspace/JPL_Ex_1.16/test/.txt";
			assertEquals(e.getFileName(), expected);
		}
	}

}
