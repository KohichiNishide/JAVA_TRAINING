package ch14.ex06;

public class Message implements Runnable{
	private int interval = 0;
	public Message(int interval) {
		this.interval = interval;
		new Thread(this).start();
	}
	
	// ���b�Z�[�W��interval�Ԋu�ŕ\������
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
				Thread.sleep(1000); //1�b�Ԋu�Ŏ��ԕ\��
			}
		} catch (InterruptedException e) {
			System.out.println("InterruptedException!!");
			return;
		}
	}
}
