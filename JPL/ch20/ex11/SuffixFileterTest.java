package ch20.ex11;

import org.junit.Test;

public class SuffixFileterTest {

	@Test
	public void test() {
		String dirPath = "/Users/knishide/Desktop/TestSuffix";
		String suffix = "nishide";
		String[] args = {dirPath, suffix};
		SuffixFilter.main(args);
	}

}
