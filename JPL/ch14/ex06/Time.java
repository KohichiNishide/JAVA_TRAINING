package ch14.ex06;

import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Time {
	private static int timeCount = 0;
	private Timer timer = null;
	private TimeTask task = null;
	private List<Message> messages = new LinkedList<Message>();
	
	// ���ԕ\���X���b�h���J�n����
	public void start() {
		timer = new Timer(true);
		task = new TimeTask();
		timer.schedule(task, 0, 1000);
	}
	
	// 1sec�P�ʂœo�^����Ă���S�Ẵ��b�Z�[�W�I�u�W�F�N�g�Ɏ��Ԃ��X�V���ꂽ���Ƃ�ʒm����
	private synchronized void update() {
		timeCount ++;
		System.out.println("Total time is " + timeCount + " sec");
		
		// �o�^����Ă���S�Ẵ��b�Z�[�W�I�u�W�F�N�g�ɒʒm����
		for (Message message: messages) {
			message.notifyTime();
		}
	}
	
	// ���b�Z�[�W�I�u�W�F�N�g��o�^����
	public void registerMessage(Message message) {
		messages.add(message);
	}
	
	// �������擾����
	public static int getTimeCount() {
		return timeCount;
	}
	
	// �^�C�}����N�������^�X�N�B
	// ������ێ�����Time�N���X�������A�^�C�}����N������邲�ƂɁA���������ނ��߁ATime���\�b�h��update()���Ăяo���B
	class TimeTask extends TimerTask {
	    public void run() {
	        update();
	    }
	}
	
	// Main���\�b�h
	public static void main(String[] args) {
		Time time = new Time();
		time.registerMessage(new Message(15));
		time.registerMessage(new Message(7));
		time.start();
	}
}
