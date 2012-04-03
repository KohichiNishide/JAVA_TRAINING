/**
 * 練習問題1.6：Fibonacciプログラムのタイトルに対して名前付文字列定数を使用する
 */

public class Fibonacci {
	/** 値が50未満のフィボナッチ数列を表示する*/
	static final String TITLE = "The Fibonacci program";
	static final int MAX = 50;
	public static void main(String[] args) {
		System.out.println(TITLE);
		int low = 1;
		int high = 1;
		System.out.println(low);
		while (high < MAX) {
			System.out.println(high);
			high = low + high; //新しいhigh
			low = high - low; /*新しいlowは、（合計-古いlow）
								すなわち、古いhigh */
		}
	}
}
