package ch02.ex03;
import static org.junit.Assert.*;

import org.junit.Test;


public class VehicleTest {

	@Test
	public void nextIDTest() {
		//Vehicle vehicle = new Vehicle();
		int expectedNextID = 100;	
		Vehicle.nextID = expectedNextID;
		
		assertEquals(expectedNextID, Vehicle.nextID); //クラス変数に代入されていることを確認。
		//assertEquals(expectedNextID, vehicle.nextID); //インスタンスでも確認。
	}
	
	@Test
	public void carIDTest() {
		Vehicle vehicle = new Vehicle();
		int expectedCarID = 100;	
		vehicle.carID = expectedCarID;
		
		assertEquals(expectedCarID, vehicle.carID);
	}

}
