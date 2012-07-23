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
	
	// 時間表時スレッドを開始する
	public void start() {
		timer = new Timer(true);
		task = new TimeTask();
		timer.schedule(task, 0, 1000);
	}
	
	// 1sec単位で登録されている全てのメッセージオブジェクトに時間が更新されたことを通知する
	private synchronized void update() {
		timeCount ++;
		System.out.println("Total time is " + timeCount + " sec");
		
		// 登録されている全てのメッセージオブジェクトに通知する
		for (Message message: messages) {
			message.notifyTime();
		}
	}
	
	// メッセージオブジェクトを登録する
	public void registerMessage(Message message) {
		messages.add(message);
	}
	
	// 時刻を取得する
	public static int getTimeCount() {
		return timeCount;
	}
	
	// タイマから起動されるタスク。
	// 時刻を保持するTimeクラスを持ち、タイマから起動されるごとに、時刻を刻むため、Timeメソッドのupdate()を呼び出す。
	class TimeTask extends TimerTask {
	    public void run() {
	        update();
	    }
	}
	
	// Mainメソッド
	public static void main(String[] args) {
		Time time = new Time();
		time.registerMessage(new Message(15));
		time.registerMessage(new Message(7));
		time.start();
	}
}
