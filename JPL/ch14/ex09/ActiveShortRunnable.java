package ch14.ex09;

public class ActiveShortRunnable implements Runnable{
	public void run() {
		// ’Z–½‚Æ‚·‚é‚½‚ß10‰ñ‚¾‚¯ƒ‹[ƒv‚³‚¹‚é
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}
