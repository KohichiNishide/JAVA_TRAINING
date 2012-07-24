package ch14.ex09;

public class ActiveShortRunnable implements Runnable{
	public void run() {
		// 短命とするため10回だけループさせる
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}
