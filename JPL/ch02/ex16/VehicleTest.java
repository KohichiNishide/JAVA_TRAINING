package ch02.ex16;
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
	 * System.out.printlnの出力先をByteArrayOutputStreamに変更する
	 */
	@Before 
	public void before() {
		saved = System.out;
		System.setOut(new PrintStream(new BufferedOutputStream(out)));
	}
	
	/**
	 * System.out.printlnの出力先をコンソールに戻す
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
		System.out.flush(); //結果の出力を保証するために強制出力
		String expected = joinStrings("3 CurrentSpeed : 100 CurrentAngle : 10 Owner : Tom"
				, "4 CurrentSpeed : 100 CurrentAngle : 10 Owner : Kelly"
				, "5 CurrentSpeed : 100 CurrentAngle : 10 Owner : John"
				, "maxID : 5");
		String actual = out.toString();	
		assertEquals(expected, actual);
	}

	private String joinStrings(String... strs) {
        String newLine = System.getProperty("line.separator");//環境依存である改行コードの読み込み
        String result = "";
        for (String s : strs) {
            result += s + newLine;
        }
        return result;
    }
}
