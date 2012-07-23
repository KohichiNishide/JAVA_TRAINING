package ch14.ex06;

public class Message implements Runnable{
	private int interval = 0;
	public Message(int interval) {
		this.interval = interval;
		new Thread(this).start();
	}
	
	// メッセージをinterval間隔で表示する
	public synchronized void showMessage() throws InterruptedException{
		while (Time.getTimeCount() == 0 || Time.getTimeCount() % interval != 0) {
			wait();
		}
		System.out.println(interval + " sec is passed!");
	}
	
	public synchronized void notifyTime() {
		notifyAll();
	}

	@Override
	public void run() {
		try {
			for (;;) {
				showMessage();
				Thread.sleep(1000); //1秒間隔で時間表示
			}
		} catch (InterruptedException e) {
			System.out.println("InterruptedException!!");
			return;
		}
	}
}
