package ch01.ex07;
import static org.junit.Assert.*;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ImprovedFibonacciTest {
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
	public void test() {
		ImprovedFibonacci.main(null);
		System.out.flush(); //���ʂ̏o�͂�ۏ؂��邽�߂ɋ����o��		
		String evenMark = "*";
		String expected = joinStrings("9: 34" + evenMark, "8: 21", "7: 13", "6: 8" + evenMark, "5: 5", "4: 3", "3: 2" + evenMark, "2: 1", "1: 1");
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
