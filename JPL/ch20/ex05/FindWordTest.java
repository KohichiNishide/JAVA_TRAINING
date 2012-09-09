package ch20.ex05;

import java.io.IOException;

import org.junit.Test;

public class FindWordTest {

	@Test
	public void test() throws IOException {
		String[] args = {"nishide", "/Users/knishide/Desktop/findWord.txt"};
		FindWord.main(args);
	}

}
