package ch14.ex05;

//////////////////////////////////////////////////////////////
//          Class for calling add() by another thread
/////////////////////////////////////////////////////////////
public class Hoge implements Runnable {
	
	public void run() {
		try {
			for (;;) {
				Totalizator.subtract(5);
				Thread.sleep(10);
			}
		} catch (InterruptedException e) {
			return;
		}
	}
}
