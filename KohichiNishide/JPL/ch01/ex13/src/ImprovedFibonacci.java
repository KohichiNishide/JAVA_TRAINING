/**
 * 練習問題1.13：printlnの代わりにprintfを使用して、ImprovedFibonacciを書き直す。
 */

public class ImprovedFibonacci {
	static final int MAX_INDEX = 9;
	/**
	 * 偶数要素に'*'を付けて、フィボナッチ数列の
	 * 最初の方の要素を表示する
	 */
	public static void main(String[] args) {
		int low = 1;
		int high = 1;
		String mark;
		
		for (int i = 1; i <= MAX_INDEX; i++) {
			if (low % 2 == 0)
				mark = "*";
			else
				mark = "";
			System.out.printf("%d: %d%s%n",i , low, mark);
			high = high + low;
			low = high - low;		
		}
	}
}
