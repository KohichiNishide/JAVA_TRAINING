package ch01.ex01;
import static org.junit.Assert.*;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HelloWorldTest {
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
		HelloWorld.main(null);
		System.out.flush(); //���ʂ̏o�͂�ۏ؂��邽�߂ɋ����o��
		String newLine = System.getProperty("line.separator");//���ˑ��ł����s�R�[�h�̓ǂݍ���
		String expected = "Hello, world" + newLine; //System.out.println�͉�s�R�[�h�t���ŏo�͂���邽��
		String actual = out.toString();	
		assertEquals(expected, actual);
	}
}