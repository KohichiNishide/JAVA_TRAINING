package ch02.ex12;
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
		Vehicle.nextID = 0;
	}
	
	@Test
	public void mainTest() {
		Vehicle.main(null);
		System.out.flush(); //���ʂ̏o�͂�ۏ؂��邽�߂ɋ����o��
		String expected = joinStrings("0 CurrentSpeed : 100 CurrentAngle : 10 Owner0 : Tom Owner1 : Ban"
				, "1 CurrentSpeed : 100 CurrentAngle : 10 Owner0 : Kelly"
				, "2 CurrentSpeed : 100 CurrentAngle : 10 Owner0 : John"
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
