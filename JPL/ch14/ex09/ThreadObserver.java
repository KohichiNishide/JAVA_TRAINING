package ch14.ex09;

public class ThreadObserver{
	public void ShowThread(final ThreadGroup group) {
		new Thread(new Runnable() {
			public void run() {
				for (;;) { 
					Show(group);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						return;
					}
				}
			} 
		}, "Thread").start();
	}

	private void Show(ThreadGroup group) {
		Thread[] list = new Thread[group.activeCount()];
		int threadCount = group.enumerate(list, true);
		
		System.out.println("----------Start-----------");
		for (Thread thread: list) {
			System.out.println("Thread name: " + thread.getName());
		}
		System.out.println("-----------End-----------");
	}
	
	public static void main(String[] args) {
		ThreadObserver obj = new ThreadObserver();
		ThreadGroup group1 = new ThreadGroup("Group1");
		Thread th1 = new Thread(group1, new ActiveShortRunnable(), "Thread1");
		Thread th2 = new Thread(group1, new ActiveShortRunnable(), "Thread2");
		Thread th3 = new Thread(group1, new ActiveShortRunnable(), "Thread3");
		th1.start();
		th2.start();
		th3.start();
		
		// �w��̃X���b�h�O���[�v�ɏ�������X���b�h�̖��O��1�b�Ԋu�ŕ\������
		obj.ShowThread(group1);
		
		// �e�X�g�Ƃ��āA3�b��ɐV�����X���b�h�𑖂点��
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Thread th4 = new Thread(group1, new ActiveShortRunnable(), "Thread4");
		th4.start();
	}
}
