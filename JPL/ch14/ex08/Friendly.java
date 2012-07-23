package ch14.ex08;

// デッドロック発生率は1/20
// yieldを挿入しても1/20
// tryToHug()を挿入すると、デッドロック発生率は0/100

public class Friendly {
	private Friendly partner;
	private String name;
	private static final Object lock = new Object();
	
	public Friendly(String name) {
		this.name = name;
	}
	
	// デッドロック回避のために、hug()を呼ぶ前にprivate static final 宣言されたロックオブジェクトを用いて同期する。
	public void tryToHug() {
		synchronized (lock) {
			this.hug();
		}
	}
	
	public synchronized void hug() {
		System.out.println(Thread.currentThread().getName() + " in " + name + ".hug() trying to invoke " + partner.name + ".hugBack()");
		partner.hugBack();
	}
	
	private synchronized void hugBack() {
		System.out.println(Thread.currentThread().getName() + " in " + name + ".hugBack()");
	}
	
	public void becomeFriend(Friendly partner) {
		this.partner = partner;
	}
	
	public static void main(String[] args) {
		final Friendly jareth = new Friendly("jareth");
		final Friendly cory = new Friendly("cory");
		
		jareth.becomeFriend(cory);
		cory.becomeFriend(jareth);
		
		new Thread(new Runnable() {
			public void run() { jareth.tryToHug();}
		}, "Thread1").start();
		
		new Thread(new Runnable() {
			public void run() { cory.tryToHug();}
		}, "Thread2").start();
	}
}
