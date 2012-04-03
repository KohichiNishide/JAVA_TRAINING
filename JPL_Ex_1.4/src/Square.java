/**
 * 練習問題1.4：平方表を作成するプログラム
 */

public class Square {
	/** 値が1～10までの整数値の平方を表示する*/
	public static void main(String[] args) {
		int[] iArray = {0,1,2,3,4,5,6,7,8,9,10};
		int squareVal = 0;
		for (int i: iArray) {
			squareVal = i * i;
			System.out.println(squareVal);
		}
	}
}
