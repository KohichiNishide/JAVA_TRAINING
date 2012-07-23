package ch14.ex04;

public class Totalizator {
	private static int currentVal = 0;
	public synchronized static void add(int val) {
		// staticのsynchronizedメソッドにより複数のスレッドから本メソッドを同時に実行できないようにしている
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
