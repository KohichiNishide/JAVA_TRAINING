package ch22.ex10;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import ch22.ex08.CSVManager;

public class CommentScannerTest {

	@Test
	public void test1() {
		String INPUT_FILE_PATH = "JPL/ch22/ex10/test1.txt";
		try {
			String[] expected = {"1","2","3","5","6"};
			FileReader br = new FileReader(INPUT_FILE_PATH);			
			List<String> actual = CommentScanner.read(br);
			
			for (int i = 0; i < expected.length; i++) {
				assertEquals(actual.get(i), expected[i]);
			}
		} catch (FileNotFoundException e) {
			fail();
		} catch (IOException e) {
			fail();
		}
	}

	@Test
	public void test2() {
		String INPUT_FILE_PATH = "JPL/ch22/ex10/test2.txt";
		try {
			String[] expected = {"1,2","token","token2"};
			FileReader br = new FileReader(INPUT_FILE_PATH);			
			List<String> actual = CommentScanner.read(br);
			
			for (int i = 0; i < expected.length; i++) {
				assertEquals(actual.get(i), expected[i]);
			}
		} catch (FileNotFoundException e) {
			fail();
		} catch (IOException e) {
			fail();
		}
	}
	
	@Test
	public void test3() {
		String INPUT_FILE_PATH = "JPL/ch22/ex10/test3.txt";
		try {
			String[] expected = {"token1","token2 "};
			FileReader br = new FileReader(INPUT_FILE_PATH);			
			List<String> actual = CommentScanner.read(br);
			
			for (int i = 0; i < expected.length; i++) {
				assertEquals(actual.get(i), expected[i]);
			}
		} catch (FileNotFoundException e) {
			fail();
		} catch (IOException e) {
			fail();
		}
	}
}
