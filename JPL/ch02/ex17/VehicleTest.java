package ch02.ex17;
import static org.junit.Assert.*;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class VehicleTest {
	private PrintStream saved;
	private final ByteArrayOutputStream out = new ByteArrayOutputStream();
	
	/**
	 * System.out.println�̏o�͐��ByteArrayOutputStream�ɕύX����
	 */
	@Before 
	public void before() {
		saved = System.out;
		System.setOut(new PrintStream(new BufferedOutputStream(out)));
	}
	
	/**
	 * System.out.println�̏o�͐���R���\�[���ɖ߂�
	 */
	@After
	public void after() {
		System.setOut(saved);
	}
	
	@Test
	public void changeCurrentSpeedTest() {
		Vehicle vehicle = new Vehicle();
		double expected = 80;
		vehicle.changeCurrentSpeed(expected);
		double actual = vehicle.getCurrentSpeed();
		assertEquals(0, expected, actual);
	}
	
	@Test
	public void stopTest() {
		Vehicle vehicle = new Vehicle();
		double expected = 0;
		vehicle.stop();
		double actual = vehicle.getCurrentSpeed();
		assertEquals(0, expected, actual);
	}
	
	@Test
	public void turnTest() {
		Vehicle vehicle = new Vehicle();
		vehicle.turn(80);
		double expected = 90;
		double actual = vehicle.getCurrentSpeed();
		assertEquals(0, expected, actual);
	}
	
	@Test
	public void turnLeftTest() {
		Vehicle vehicle = new Vehicle();
		vehicle.turn(Vehicle.TURN_DIRECTION.TURN_LEFT);
		double expected = -80;
		double actual = vehicle.getCurrentSpeed();
		assertEquals(0, expected, actual);
	}
	
	@Test
	public void turnRightTest() {
		Vehicle vehicle = new Vehicle();
		vehicle.turn(Vehicle.TURN_DIRECTION.TURN_RIGHT);
		double expected = 100;
		double actual = vehicle.getCurrentSpeed();
		assertEquals(0, expected, actual);
	}
	
	@Test
	public void currentAngleTest() {
		Vehicle vehicle = new Vehicle();
		double expected = 80;
		vehicle.setCurrentAngle(expected);
		double actual = vehicle.getCurrentAngle();
		assertEquals(0, expected, actual);
	}
	
	@Test
	public void currentOwnerTest() {
		Vehicle vehicle = new Vehicle();
		String expected = "Tom";
		vehicle.setOwner(expected);
		String actual = vehicle.getOwner();
		assertEquals(expected, actual);
	}
	
	@Test
	public void mainTest() {
		Vehicle.main(null);
		System.out.flush(); //���ʂ̏o�͂�ۏ؂��邽�߂ɋ����o��
		String expected = joinStrings("7 CurrentSpeed : 100.0 CurrentAngle : 10.0 Owner : Tom"
				, "8 CurrentSpeed : 100.0 CurrentAngle : 10.0 Owner : Kelly"
				, "9 CurrentSpeed : 100.0 CurrentAngle : 10.0 Owner : John"
				, "maxID : 9");
		String actual = out.toString();	
		assertEquals(expected, actual);
	}

	private String joinStrings(String... strs) {
        String newLine = System.getProperty("line.separator");//���ˑ��ł�����s�R�[�h�̓ǂݍ���
        String result = "";
        for (String s : strs) {
            result += s + newLine;
        }
        return result;
    }
}
