package ch10.ex02;

import static org.junit.Assert.*;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConvertTest {
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
		String[] args = {"\n\t\b\r\f\\\'\""};
		Convert.main(args);
		System.out.flush(); //���ʂ̏o�͂�ۏ؂��邽�߂ɋ����o��		
		String expected = "\\" + "n" + "\\" + "t" + "\\" + "b" +"\\" + "r" + "\\" + "f" + "\\" + "\\" + "\\" + "\'" + "\\" + "\"" + "\n";
		String actual = out.toString();	
		assertEquals(expected, actual);
	}
}
