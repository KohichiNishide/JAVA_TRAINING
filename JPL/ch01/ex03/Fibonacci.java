package ch01.ex03;
/**
 * ��K���1.3�FFibonacci�v���O�����̏o�̓��X�g�Ƀ^�C�g����ǉ�����B
 */

public class Fibonacci {
	/** �l��50�����̃t�B�{�i�b�`�����\������*/
	public static void main(String[] args) {
		System.out.println("The Fibonacci program");
		int low = 1;
		int high = 1;
		System.out.println(low);
		while (high < 50) {
			System.out.println(high);
			high = low + high; //�V����high
			low = high - low; /*�V����low�́A�i���v-�Â�low�j
								���Ȃ킿�A�Â�high */
		}
	}
}
