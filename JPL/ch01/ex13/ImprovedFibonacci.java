package ch01.ex13;
/**
 * ��K���1.13�Fprintln�̑����printf���g�p���āAImprovedFibonacci�����������B
 */

public class ImprovedFibonacci {
	static final int MAX_INDEX = 9;
	/**
	 * �����v�f��'*'��t���āA�t�B�{�i�b�`�����
	 * �ŏ��̕�̗v�f��\������
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
