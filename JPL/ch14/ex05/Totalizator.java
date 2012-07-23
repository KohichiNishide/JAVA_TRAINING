package ch14.ex05;

import ch14.ex04.Hoge;
import ch14.ex04.Moge;

public class Totalizator {
	private static int currentVal = 0;
	public static void add(int val) {
		// synchronized文によりClassオブジェクトのロックを獲得し、同期を実現
		synchronized (Totalizator.class) {
			currentVal += val;
			System.out.println("Val: " + currentVal + " Thread name: " + Thread.currentThread().getName());
		}
	}
	
	public static void subtract(int val) {
		// synchronized文によりClassオブジェクトのロックを獲得し、同期を実現
		synchronized (Totalizator.class) {
			currentVal -= val;
			System.out.println("Val: " + currentVal + " Thread name: " + Thread.currentThread().getName());
		}	
	}
	
	public static void main(String[] args) {
		Runnable hoge = new Hoge();
		Runnable moge = new Moge();
		
		new Thread(hoge).start();
		new Thread(moge).start();
	}
}
