import static org.junit.Assert.*;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ReversePlayWalkManTest {
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
	public void recordAndPlayTest() {
		WalkMan walkMan = new ReversePlayWalkMan();
		walkMan.recordMusic("music");
		walkMan.playMusic();
		
		System.out.flush(); //結果の出力を保証するために強制出力		
		String expected = joinStrings("It is successful to record music", "Play : music");
		String actual = out.toString();	
		assertEquals(expected, actual);
	}
	@Test
	public void recordMoreThan10MusicsTest() {
		WalkMan walkMan = new ReversePlayWalkMan();
		for (int i = 0; i <= 10; i++ ) {
			walkMan.recordMusic("music" + i);
		}
		walkMan.playMusic();
		
		System.out.flush(); //結果の出力を保証するために強制出力		
		String expected = joinStrings("It is successful to record music0", "It is successful to record music1", "It is successful to record music2", "It is successful to record music3", "It is successful to record music4",
				"It is successful to record music5", "It is successful to record music6", "It is successful to record music7", "It is successful to record music8", "It is successful to record music9", 
				"It is impossible to record music10", "Play : music9", "Play : music8", "Play : music7", "Play : music6", "Play : music5", "Play : music4", "Play : music3", "Play : music2", "Play : music1", "Play : music0");
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