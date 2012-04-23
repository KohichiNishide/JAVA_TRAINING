package ex05;

import org.junit.Test;

public class BenchmarkTest {

	@Test
	public void test() {
		String[] args = {"500", "10000"};
		MethodBenchmark.main(args);
	}
}
