/**
 * 練習問題1.12：ImprovedFibonacciを修正して、printlnでStringオブジェクトを作成して配列に入れるようにする。
 */

public class ImprovedFibonacci {
	static final int MAX_INDEX = 9;
	static private String[] outputs = new String[MAX_INDEX];
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
			outputs[i-1] = i + ": " + low + mark;
			System.out.println(outputs[i-1]);
			high = high + low;
			low = high - low;		
		}
	}
}
