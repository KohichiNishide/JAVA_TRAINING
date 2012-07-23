package ch14.ex08;

// �f�b�h���b�N��������1/20
// yield��}�����Ă�1/20
// tryToHug()��}������ƁA�f�b�h���b�N��������0/100

public class Friendly {
	private Friendly partner;
	private String name;
	private static final Object lock = new Object();
	
	public Friendly(String name) {
		this.name = name;
	}
	
	// �f�b�h���b�N����̂��߂ɁAhug()���ĂԑO��private static final �錾���ꂽ���b�N�I�u�W�F�N�g��p���ē�������B
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
