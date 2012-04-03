/**
 * 練習問題1.7：iが逆順するようにImprovedFibonacciを修正する
 */

public class ImprovedFibonacci {
	static final int MAX_INDEX = 9;
	/**
	 * 偶数要素に'*'を付けて、フィボナッチ数列の
	 * 最初の方の要素を表示する
	 */
	public static void main(String[] args) {
		int low = 21;
		int high = 34;
		String mark;
		
		for (int i = MAX_INDEX; i >= 1; i--) {
			if (high % 2 == 0)
				mark = "*";
			else
				mark = "";
			System.out.println(i + ": " + high + mark);
			low = high -low;
			high = high - low;
		}
	}
}
