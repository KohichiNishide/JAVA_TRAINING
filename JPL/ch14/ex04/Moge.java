package ch14.ex04;

//////////////////////////////////////////////////////////////
//         Class for calling add() by another thread
/////////////////////////////////////////////////////////////
public class Moge implements Runnable {
	
	public void run() {
		try {
			for (;;) {
				Totalizator.add(8);
				Thread.sleep(10);
			}
		} catch (InterruptedException e) {
			return;
		}
	}
}
