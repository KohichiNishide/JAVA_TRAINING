package ch14.ex03;

//////////////////////////////////////////////////////////////
//         Class for calling add() by another thread
/////////////////////////////////////////////////////////////
public class Moge implements Runnable {
	private Totalizator obj;
	Moge(Totalizator obj) {
		this.obj = obj;
	}
	
	
	public void run() {
		try {
			for (;;) {
				obj.add(8);
				Thread.sleep(10);
			}
		} catch (InterruptedException e) {
			return;
		}
	}
}
