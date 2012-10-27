package ch01.ex12;
/**
 * ��K���1.12�FImprovedFibonacci���C�����āAprintln��String�I�u�W�F�N�g���쐬���Ĕz��ɓ���悤�ɂ���B
 */

public class ImprovedFibonacci {
	static final int MAX_INDEX = 9;
	static private String[] outputs = new String[MAX_INDEX];
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
			outputs[i-1] = i + ": " + low + mark;
			System.out.println(outputs[i-1]);
			high = high + low;
			low = high - low;		
		}
	}
}
