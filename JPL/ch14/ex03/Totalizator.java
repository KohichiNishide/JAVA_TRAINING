package ch14.ex03;

public class Totalizator {
	private int currentVal = 0;
	public synchronized void add(int val) {
		currentVal += val;
		System.out.println("Val: " + currentVal + " Thread name: " + Thread.currentThread().getName());
	}
	
	public static void main(String[] args) {
		Totalizator obj = new Totalizator();
		Runnable hoge = new Hoge(obj);
		Runnable moge = new Moge(obj);
		
		new Thread(hoge).start();
		new Thread(moge).start();
	}
}
