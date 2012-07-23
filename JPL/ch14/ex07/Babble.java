package ch14.ex07;

public class Babble extends Thread{
	static boolean doYield; //���̃X���b�h�Ɏ��s������̂��H
	static int howOften; //�\�������
	private String word; //���̃X���b�h�̒P��
	
	Babble(String whatToSay) {
		word = whatToSay;
	}
	
	public void run() {
		for (int i = 0; i < howOften; i++) {
			System.out.println(word);
			if (doYield)
				Thread.yield(); //���̃X���b�h�𑖂点��
		}
	}
	
	public static void main(String[] args) {
		doYield = new Boolean(args[0]).booleanValue();
		howOften = Integer.parseInt(args[1]);
		
		//�e�P��ɑ΂��ăX���b�h�𐶐�
		for (int i = 2; i < args.length; i++)
			new Babble(args[i]).start();
	}
}
