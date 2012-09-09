package ch20.ex02;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class TranslateByteTest {

	@Test
	public void test() {
		String[] args = {"b", "B"};
		try {
			TranslateByte.main(args);
		} catch (IOException e) {
			fail();
			e.printStackTrace();
		}
	}
}
