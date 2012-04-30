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
	/** ソートされることを確認する */
	public void test1() {
		String[] args = {"A", "C", "P", "D", "W", "L", "B"};
		OriginalList.main(args);
		System.out.flush(); //結果の出力を保証するために強制出力
		String expected = joinStrings("A", "B", "C", "D", "L", "P", "W");
		String actual = out.toString();	
		assertEquals(expected, actual);
	}

	@Test
	/** 重複要素が追加されないことを確認する */
	public void test2() {
		String[] args = {"A", "C", "A", "D", "C", "D", "D"};
		OriginalList.main(args);
		System.out.flush(); //結果の出力を保証するために強制出力
		String expected = joinStrings("A", "C", "D");
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
