package ch10.ex04;
/**
 * ���K���1.12�FImprovedFibonacci���C�����āAprintln��String�I�u�W�F�N�g���쐬���Ĕz��ɓ����悤�ɂ���B
 */

public class ImprovedFibonacci {
	static final int MAX_INDEX = 9;
	static final int MAX_VALUE = 50;
	static private String[] outputs = new String[MAX_INDEX];
	/****************for��********************
	 * �����v�f��'*'��t���āA�t�B�{�i�b�`�����
	 * �ŏ��̕��̗v�f��\������
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
	
	/****************while��********************
	 * While�ł̏ꍇ�AMAX_INDEX�̑����MAX_VALUE���g�p����B
	 * �����v�f��'*'��t���āA�t�B�{�i�b�`�����
	 * �ŏ��̕��̗v�f��\������
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
	
	/****************do-while��********************
	 * �ŏ��̃u�[������false�ɂȂ�\�����Ȃ����߁A�{�P�[�X�ł�do-while�ł����ʂ͕ς��Ȃ�
	 * �����v�f��'*'��t���āA�t�B�{�i�b�`�����
	 * �ŏ��̕��̗v�f��\������
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
