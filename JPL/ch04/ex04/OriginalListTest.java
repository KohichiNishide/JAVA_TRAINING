package ch04.ex04;

import static org.junit.Assert.*;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OriginalListTest {
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
	/** �\�[�g����邱�Ƃ��m�F���� */
	public void test1() {
		String[] args = {"A", "C", "P", "D", "W", "L", "B"};
		OriginalList.main(args);
		System.out.flush(); //���ʂ̏o�͂�ۏ؂��邽�߂ɋ����o��
		String expected = joinStrings("A", "B", "C", "D", "L", "P", "W");
		String actual = out.toString();	
		assertEquals(expected, actual);
	}

	@Test
	/** �d���v�f���ǉ�����Ȃ����Ƃ��m�F���� */
	public void test2() {
		String[] args = {"A", "C", "A", "D", "C", "D", "D"};
		OriginalList.main(args);
		System.out.flush(); //���ʂ̏o�͂�ۏ؂��邽�߂ɋ����o��
		String expected = joinStrings("A", "C", "D");
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
