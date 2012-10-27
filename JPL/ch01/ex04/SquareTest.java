package ch01.ex04;
import static org.junit.Assert.*;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SquareTest {
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
		Square.main(null);
		System.out.flush(); //���ʂ̏o�͂�ۏ؂��邽�߂ɋ����o��
		String expected = joinStrings("0","1","4","9","16","25","36","49","64","81","100");
		String actual = out.toString();	
		assertEquals(expected, actual);
	}
	
	private String joinStrings(String... strs) {
        String newLine = System.getProperty("line.separator");
        String result = "";
        for (String s : strs) {
            result += s + newLine;
        }
        return result;
    }
}
