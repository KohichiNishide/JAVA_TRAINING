package ex04;

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
	public void mainTest() {
		String[] owners = {"Tom", "Kelly", "John"};
		PassengerVehicle.main(owners);
		System.out.flush(); //���ʂ̏o�͂�ۏ؂��邽�߂ɋ����o��
		String expected = joinStrings("0 CurrentSpeed : 100.0 CurrentAngle : 10.0 Owner : Tom Number of Seats : 2 Number of Seated people : 1"
				, "1 CurrentSpeed : 100.0 CurrentAngle : 10.0 Owner : Kelly Number of Seats : 5 Number of Seated people : 1"
				, "2 CurrentSpeed : 100.0 CurrentAngle : 10.0 Owner : John Number of Seats : 10 Number of Seated people : 1"
				, "maxID : 2");
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
