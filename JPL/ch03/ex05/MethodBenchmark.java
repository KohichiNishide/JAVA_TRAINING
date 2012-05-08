package ch03.ex05;

public class MethodBenchmark extends Benchmark{
	private int loopCount;
	void benchmark() {
		for (int i = 0; i <= loopCount; i++) {
		}
	}
	
	public void setLoopCount(int count) {
		loopCount = count;
	}
	
	public static void main(String[] args) {
		MethodBenchmark benchmark = new MethodBenchmark();
		int count = Integer.parseInt(args[0]);
		benchmark.setLoopCount(Integer.parseInt(args[1]));
		
		long time = benchmark.repeat(count);
		System.out.println(count + " method in " + time + " nanoseconds");
	}
}
