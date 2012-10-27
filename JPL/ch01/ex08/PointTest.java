package ch01.ex08;
import static org.junit.Assert.*;

import org.junit.Test;


public class PointTest {

	@Test
	public void test() {
		Point pointA = new Point(100.0, 100.0);
		Point pointB = new Point(200.0, 300.0);
		
		pointA.setCordinateData(pointB);
		double actualX = pointA.x;
		double actualY = pointA.y;
		double expectedX = 200.0;
		double expectedY = 300.0;
		
		assertEquals(expectedX, actualX, 0.0);
		assertEquals(expectedY, actualY, 0.0);
	}

}
