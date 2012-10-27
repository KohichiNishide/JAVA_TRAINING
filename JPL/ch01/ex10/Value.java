package ch01.ex10;

public class Value {
	private int val;
	
	public Value (int val) {
		this.val = val;
	}
	
	/**
	 * val���������ǂ����𔻒f����
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
