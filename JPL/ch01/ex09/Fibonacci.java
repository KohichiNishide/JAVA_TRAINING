package ch01.ex09;
/**
 * ��K���1.9�FFibonacci�A�v���P�[�V�������C�����āA�����z��ɕۑ����āA�Ō�ɒl�̃��X�g��\������B
 */

public class Fibonacci {
	/** �l��50�����̃t�B�{�i�b�`�����\������*/
	static final int MAX_VALUE = 50;
	static final int MAX_COUNT= 9;
	static int[] values;
	
	public static void main(String[] args) {
		values = new int[MAX_COUNT];
		int low = 1;
		int high = 1;
		int count = 0;
		while (low < MAX_VALUE) {
			values[count] = low;
			high = low + high; //�V����high
			low = high - low; /*�V����low�́A�i���v-�Â�low�j
								���Ȃ킿�A�Â�high */
			count++;
		}
		for (int val: values){
				System.out.println(val);
		}
	}
}
