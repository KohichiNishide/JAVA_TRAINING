package ch22.ex06;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class Gaussian {
	private static final int TRIAL_TIMES = 1000;
	private static Map<String, Integer> map = new TreeMap<String, Integer>();

	public static void createGraph() {		
		double d = 0;
		Integer count = 0;
		for (int i = 0; i < TRIAL_TIMES; i++) {
			Random random = new Random(i);
			d = random.nextGaussian();
			String key = String.format("%.1f", d);
			count = map.get(key);
			if (count == null)
				count = 0;
			map.put(key, ++count);
		}

		Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            System.out.print(key);
            for(int i = 0; i < map.get(key); i++){
				System.out.print("*");
			}
			System.out.println("");
        }
	}

	public static void main(String[] args) {
		Gaussian.createGraph();
	}
}
