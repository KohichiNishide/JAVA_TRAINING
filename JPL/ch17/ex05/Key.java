package ch17.ex05;

public class Key {
	private int val;
	public Key(int x) {
		val = x;
	}
	
	public void finalize() {
		try {
			super.finalize();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
