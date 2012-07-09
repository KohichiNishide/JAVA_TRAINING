package ch14.ex03;

//////////////////////////////////////////////////////////////
//          Class for calling add() by another thread
/////////////////////////////////////////////////////////////
public class Hoge implements Runnable {
	private Totalizator obj;
	Hoge(Totalizator obj) {
		this.obj = obj;
	}
	
	
	public void run() {
		try {
			for (;;) {
				obj.add(5);
				Thread.sleep(10);
			}
		} catch (InterruptedException e) {
			return;
		}
	}
}
