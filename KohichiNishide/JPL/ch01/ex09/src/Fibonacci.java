/**
 * 練習問題1.9：Fibonacciアプリケーションを修正して、数列を配列に保存して、最後に値のリストを表示する。
 */

public class Fibonacci {
	/** 値が50未満のフィボナッチ数列を表示する*/
	static final int MAX_VALUE = 50;
	static final int MAX_COUNT= 9;
	static int[] values;
	
	public static void main(String[] args) {
		values = new int[MAX_COUNT];
		int low = 1;
		int high = 1;
		int count = 0;
		while (low < MAX_VALUE) {
			values[count] = low;
			high = low + high; //新しいhigh
			low = high - low; /*新しいlowは、（合計-古いlow）
								すなわち、古いhigh */
			count++;
		}
		for (int val: values){
				System.out.println(val);
		}
	}
}
