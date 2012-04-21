/**
 * 練習問題1.10：ImprovedFibonacciを修正して、数列を配列に保存させる。
 * そのとき、数列の値とその値が偶数かを示すブール値を保持するクラスを作成して、そのクラスのオブジェクトへの参照を配列として持つようにする。
 */

public class ImprovedFibonacci {
	static final int MAX_INDEX = 9;
	static private Value[] values = new Value[MAX_INDEX];
	/**
	 * 偶数要素に'*'を付けて、フィボナッチ数列の
	 * 最初の方の要素を表示する
	 */
	public static void main(String[] args) {
		int low = 1;
		int high = 1;
		String mark;
			
		for (int i = 1; i <= MAX_INDEX; i++) {
			values[i-1] = new Value(low);
			if (values[i-1].isEven())
				mark = "*";
			else
				mark = "";
			System.out.println(i + ": " + low + mark);
			high = high + low;
			low = high - low;		
		}
	}
}
