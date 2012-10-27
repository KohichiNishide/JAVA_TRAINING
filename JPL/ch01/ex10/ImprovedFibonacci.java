package ch01.ex10;
/**
 * ��K���1.10�FImprovedFibonacci���C�����āA�����z��ɕۑ�������B
 * ���̂Ƃ��A����̒l�Ƃ��̒l���������������u�[���l��ێ�����N���X���쐬���āA���̃N���X�̃I�u�W�F�N�g�ւ̎Q�Ƃ�z��Ƃ��Ď��悤�ɂ���B
 */

public class ImprovedFibonacci {
	static final int MAX_INDEX = 9;
	static private Value[] values = new Value[MAX_INDEX];
	/**
	 * �����v�f��'*'��t���āA�t�B�{�i�b�`�����
	 * �ŏ��̕�̗v�f��\������
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
