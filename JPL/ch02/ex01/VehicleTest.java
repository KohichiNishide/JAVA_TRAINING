package ch02.ex01;
import static org.junit.Assert.*;

import org.junit.Test;


public class VehicleTest {

	@Test
	public void test() {
		Vehicle vehicle = new Vehicle();
		int expectedSpeed = 100;
		int expectedAngle = 60;
		String expectedOwner = "Max";
		
		vehicle.currentSpeed = expectedSpeed;
		vehicle.currentAngle = expectedAngle;
		vehicle.owner = expectedOwner;
		
		assertEquals(expectedSpeed, vehicle.currentSpeed);
		assertEquals(expectedAngle, vehicle.currentAngle);
		assertEquals(expectedOwner, vehicle.owner);
	}

}
