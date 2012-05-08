package ch03.ex11;

abstract class SortDouble {
	private double[] values;
	private final SortMetrics curMetrics = new SortMetrics();
	private Boolean isActive = false;
	
	/** 全ソートをするために呼び出される */
	public final SortMetrics sort(double[] data) {
		// doSort()は一度しか呼ばないように排他制御する
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
	protected final double prove(int i) {
		curMetrics.proveCnt++;
		return values[i];
	}
	
	/** 拡張したクラスが要素を比較するため */
	protected final int compare(int i, int j) {
		curMetrics.compareCnt++;
		double d1 = values[i];
		double d2 = values[j];
		if (d1 == d2)
			return 0;
		else 
			return (d1 < d2 ? -1 : 1);
	}
	
	/** 拡張したクラスが要素を交換するため */
	protected final void swap(int i, int j) {
		curMetrics.swapCnt++;
		double tmp = values[i];
		values[i] = values[j];
		values[j] = tmp;
	}
	
	/** 拡張したクラスが実装する -- ソートするのに使用される */
	protected abstract void doSort();
}
