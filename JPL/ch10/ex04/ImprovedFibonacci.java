package ch10.ex04;
/**
 * 練習問題1.12：ImprovedFibonacciを修正して、printlnでStringオブジェクトを作成して配列に入れるようにする。
 */

public class ImprovedFibonacci {
	static final int MAX_INDEX = 9;
	static final int MAX_VALUE = 50;
	static private String[] outputs = new String[MAX_INDEX];
	/****************for版********************
	 * 偶数要素に'*'を付けて、フィボナッチ数列の
	 * 最初の方の要素を表示する
	 ****************************************/
	/*public static void main(String[] args) {
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
	}*/
	
	/****************while版********************
	 * While版の場合、MAX_INDEXの代わりにMAX_VALUEを使用する。
	 * 偶数要素に'*'を付けて、フィボナッチ数列の
	 * 最初の方の要素を表示する
	 ****************************************/
	/*public static void main(String[] args) {
		int low = 1;
		int high = 1;
		String mark;
		int count = 0;
		while (low < MAX_VALUE) {
			if (low % 2 == 0)
				mark = "*";
			else
				mark = "";
			outputs[count] = count + 1 + ": " + low + mark;
			System.out.println(outputs[count]);
			high = high + low;
			low = high - low;
			count++;
		}
	}*/
	
	/****************do-while版********************
	 * 最初のブール式でfalseになる可能性がないため、本ケースではdo-whileでも結果は変わらない
	 * 偶数要素に'*'を付けて、フィボナッチ数列の
	 * 最初の方の要素を表示する
	 ****************************************/
	public static void main(String[] args) {
		int low = 1;
		int high = 1;
		String mark;
		int count = 0;
		do {
			if (low % 2 == 0)
				mark = "*";
			else
				mark = "";
			outputs[count] = count + 1 + ": " + low + mark;
			System.out.println(outputs[count]);
			high = high + low;
			low = high - low;
			count++;
		} while (low < MAX_VALUE);
	}
}
