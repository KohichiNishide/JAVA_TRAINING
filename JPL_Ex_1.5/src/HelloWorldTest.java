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
	public void test() {
		HelloWorld.main(null);
		System.out.flush(); //結果の出力を保証するために強制出力
		String newLine = System.getProperty("line.separator");//環境依存である改行コードの読み込み
		String expected = "Hello, world" + newLine; //System.out.printlnは改行コード付きで出力されるため
		String actual = out.toString();	
		assertEquals(expected, actual);
	}
}
