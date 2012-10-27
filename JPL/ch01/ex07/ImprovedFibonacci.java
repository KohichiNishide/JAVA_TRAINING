package ch01.ex07;
/**
 * ��K���1.7�Fi���t������悤��ImprovedFibonacci���C������
 */

public class ImprovedFibonacci {
	static final int MAX_INDEX = 9;
	/**
	 * �����v�f��'*'��t���āA�t�B�{�i�b�`�����
	 * �ŏ��̕�̗v�f��\������
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
