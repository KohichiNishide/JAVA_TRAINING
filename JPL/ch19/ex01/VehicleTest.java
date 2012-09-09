package ch19.ex01;
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
	public void currentSpeedTest() {
		Vehicle vehicle = new Vehicle();
		int expected = 80;
		vehicle.setCurrentSpeed(expected);
		int actual = vehicle.getCurrentSpeed();
		assertEquals(expected, actual);
	}
	
	@Test
	public void currentAngleTest() {
		Vehicle vehicle = new Vehicle();
		int expected = 80;
		vehicle.setCurrentAngle(expected);
		int actual = vehicle.getCurrentAngle();
		assertEquals(expected, actual);
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
		String expected = joinStrings("3 CurrentSpeed : 100 CurrentAngle : 10 Owner : Tom"
				, "4 CurrentSpeed : 100 CurrentAngle : 10 Owner : Kelly"
				, "5 CurrentSpeed : 100 CurrentAngle : 10 Owner : John"
				, "maxID : 5");
		String actual = out.toString();	
		assertEquals(expected, actual);
	}

	private String joinStrings(String... strs) {
        String newLine = System.getProperty("line.separator");//���ˑ��ł����s�R�[�h�̓ǂݍ���
        String result = "";
        for (String s : strs) {
            result += s + newLine;
        }
        return result;
    }
}
