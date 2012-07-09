package ch14.ex02;

import java.awt.PrintJob;

public class PrintServer implements Runnable {
	private final PrintQueue requests = new PrintQueue();
	private final String printThreadName = "PrintThread";
	public PrintServer() {
		new Thread(this, printThreadName).start();
	}
	
	public void print(PrintJob job) {
		requests.add(job);
	}
	
	public void run() {
		String currentThreadName = Thread.currentThread().getName();
		if (currentThreadName.equals(printThreadName)) {
			//�R���X�g���N�^�Ő������ꂽ�X���b�h�ł̂ݎ��s����B
			for(;;)
				realPrint(requests.remove());
		} else {
			// Do nothing
			System.out.println("The run method is called by unexpected thread!");
		}
	}
	
	private void realPrint(PrintJob job) {
		// ����̎��ۂ̏������s��
		System.out.println("realPrint!");
	}
	
	public static class PrintQueue {
		public void add(PrintJob job){};
		public PrintJob remove() {	
			return null;
		};
	}
	
	public static void main(String[] args) {
		PrintServer ps = new PrintServer();
		for(;;)
			ps.run(); //�Ӑ}���Ȃ��Ăяo��
	}
}
