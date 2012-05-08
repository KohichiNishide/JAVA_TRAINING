package ch03.ex08;

import static org.junit.Assert.assertEquals;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PassengerVehicleTest {
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
	public void cloneVehicleTest() throws CloneNotSupportedException {
		Vehicle car1 = new Vehicle("Tom");
		Vehicle car2 = car1.clone();
		
		assertEquals(car1.getOwner(), car2.getOwner());
		assertEquals(0, car1.getCurrentAngle(), car2.getCurrentAngle());
		assertEquals(0, car1.getCurrentSpeed(), car2.getCurrentSpeed());
	}
	
	@Test
	public void clonePassengerVehicleTest() throws CloneNotSupportedException {
		PassengerVehicle car1 = new PassengerVehicle("Tom", 5);
		PassengerVehicle car2 = car1.clone();
		
		assertEquals(car1.getOwner(), car2.getOwner());
		assertEquals(0, car1.getCurrentAngle(), car2.getCurrentAngle());
		assertEquals(0, car1.getCurrentSpeed(), car2.getCurrentSpeed());
		assertEquals(0, car1.getNoOfSeatedPeople(), car2.getNoOfSeatedPeople());
		assertEquals(0, car1.getNoOfSeats(), car2.getNoOfSeats());
	}
	
	@Test
	public void mainTest() {
		String[] owners = {"Tom", "Kelly", "John"};
		PassengerVehicle.main(owners);
		System.out.flush(); //結果の出力を保証するために強制出力
		String expected = joinStrings("2 CurrentSpeed : 0.0 CurrentAngle : 0.0 Owner : Tom Number of Seats : 2 Number of Seated people : 1"
				, "3 CurrentSpeed : 0.0 CurrentAngle : 0.0 Owner : Kelly Number of Seats : 5 Number of Seated people : 1"
				, "4 CurrentSpeed : 0.0 CurrentAngle : 0.0 Owner : John Number of Seats : 10 Number of Seated people : 1"
				, "maxID : 4");
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
