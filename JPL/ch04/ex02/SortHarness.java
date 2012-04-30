package ch04.ex02;

abstract class SortHarness implements Sort{
	private Object[] values;
	private final SortMetrics curMetrics = new SortMetrics();
	private Boolean isActive = false;
	
	/** 全ソートをするために呼び出される */
	public final SortMetrics sort(Object[] data) {
		// doSort()内でsort()を呼ばれると無限ループに入ってしまうので、doSort()は一度しか呼ばないように排他制御する
		if (!isActive) {
			isActive = true;
			values = data;
			curMetrics.init();
			doSort();
		}
		return getMetrics();
	}
	
	public final SortMetrics getMetrics() {
		return curMetrics.clone();
	}
	
	/** 拡張したクラスが要素の数を知るため */
	protected final int getDataLength() {
		return values.length;
	}
	
	/** 拡張したクラスが要素の数を調べるため*/
	protected final Object prove(int i) {
		curMetrics.proveCnt++;
		return values[i];
	}
	
	/** 拡張したクラスが要素を比較するため*/
	protected final int compare(int i, int j) {
		// Stringの長さで比較
		curMetrics.compareCnt++;
		int d1 = values[i].toString().length();
		int d2 = values[j].toString().length();
		if (d1 == d2)
			return 0;
		else 
			return (d1 < d2 ? -1 : 1);
	}
	
	/** 拡張したクラスが要素を交換するため */
	protected final void swap(int i, int j) {
		curMetrics.swapCnt++;
		Object obj = values[i];
		values[i] = values[j];
		values[j] = obj;
	}
}
