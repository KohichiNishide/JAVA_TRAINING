/**
 * 練習問題1.3：Fibonacciプログラムの出力リストにタイトルを追加する。
 */

public class Fibonacci {
	/** 値が50未満のフィボナッチ数列を表示する*/
	public static void main(String[] args) {
		System.out.println("The Fibonacci program");
		int low = 1;
		int high = 1;
		System.out.println(low);
		while (high < 50) {
			System.out.println(high);
			high = low + high; //新しいhigh
			low = high - low; /*新しいlowは、（合計-古いlow）
								すなわち、古いhigh */
		}
	}
}
