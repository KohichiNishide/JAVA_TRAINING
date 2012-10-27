package ch01.ex04;
/**
 * ��K���1.4�F����\���쐬����v���O����
 */

public class Square {
	/** �l��1�`10�܂ł̐����l�̕����\������*/
	public static void main(String[] args) {
		int[] iArray = {0,1,2,3,4,5,6,7,8,9,10};
		int squareVal = 0;
		for (int i: iArray) {
			squareVal = i * i;
			System.out.println(squareVal);
		}
	}
}
