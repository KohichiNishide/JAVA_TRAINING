package ch03.ex06;
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
	public void bothStartTest() {
		String[] args = {"100", "1000"};
		Vehicle.main(args);
		System.out.flush(); //結果の出力を保証するために強制出力
		String expected = joinStrings("This car start to run."
				, "This car start to run.");
		String actual = out.toString();	
		assertEquals(expected, actual);
	}
	
	@Test
	public void oldCarStartTest() {
		String[] args = {"99", "1000"};
		Vehicle.main(args);
		System.out.flush(); //結果の出力を保証するために強制出力
		String expected = joinStrings("This car can't start because the energy is empty."
				, "This car start to run.");
		String actual = out.toString();	
		assertEquals(expected, actual);
	}
	
	@Test
	public void newCarStartTest() {
		String[] args = {"100", "999"};
		Vehicle.main(args);
		System.out.flush(); //結果の出力を保証するために強制出力
		String expected = joinStrings("This car start to run."
				, "This car can't start because the energy is empty.");
		String actual = out.toString();	
		assertEquals(expected, actual);
	}
	
	@Test
	public void bothNotStartTest() {
		String[] args = {"99", "999"};
		Vehicle.main(args);
		System.out.flush(); //結果の出力を保証するために強制出力
		String expected = joinStrings("This car can't start because the energy is empty."
				, "This car can't start because the energy is empty.");
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
