
public class Value {
	private int val;
	
	public Value (int val) {
		this.val = val;
	}
	
	/**
	 * valが偶数かどうかを判断する
	 */
	public Boolean isEven() {
		if (val % 2 == 0)
			return true;
		else
			return false;
	}
	
	public int getVal () {
		return val;
	}
}
