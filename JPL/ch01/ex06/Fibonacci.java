package ch01.ex06;
/**
 * ��K���1.6�FFibonacci�v���O�����̃^�C�g���ɑ΂��Ė��O�t������萔���g�p����
 */

public class Fibonacci {
	/** �l��50�����̃t�B�{�i�b�`�����\������*/
	static final String TITLE = "The Fibonacci program";
	static final int MAX = 50;
	public static void main(String[] args) {
		System.out.println(TITLE);
		int low = 1;
		int high = 1;
		System.out.println(low);
		while (high < MAX) {
			System.out.println(high);
			high = low + high; //�V����high
			low = high - low; /*�V����low�́A�i���v-�Â�low�j
								���Ȃ킿�A�Â�high */
		}
	}
}
