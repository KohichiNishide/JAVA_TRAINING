package ch14.ex04;

public class Totalizator {
	private static int currentVal = 0;
	public synchronized static void add(int val) {
		// static��synchronized���\�b�h�ɂ�蕡���̃X���b�h����{���\�b�h�𓯎��Ɏ��s�ł��Ȃ��悤�ɂ��Ă���
		currentVal += val;
		System.out.println("Val: " + currentVal + " Thread name: " + Thread.currentThread().getName());
	}
	
	public static void main(String[] args) {
		Runnable hoge = new Hoge();
		Runnable moge = new Moge();
		
		new Thread(hoge).start();
		new Thread(moge).start();
	}
}
