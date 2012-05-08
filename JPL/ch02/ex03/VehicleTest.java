package ch02.ex03;
import static org.junit.Assert.*;

import org.junit.Test;


public class VehicleTest {

	@Test
	public void nextIDTest() {
		//Vehicle vehicle = new Vehicle();
		int expectedNextID = 100;	
		Vehicle.nextID = expectedNextID;
		
		assertEquals(expectedNextID, Vehicle.nextID); //�N���X�ϐ��ɑ������Ă��邱�Ƃ��m�F�B
		//assertEquals(expectedNextID, vehicle.nextID); //�C���X�^���X�ł��m�F�B
	}
	
	@Test
	public void carIDTest() {
		Vehicle vehicle = new Vehicle();
		int expectedCarID = 100;	
		vehicle.carID = expectedCarID;
		
		assertEquals(expectedCarID, vehicle.carID);
	}

}
