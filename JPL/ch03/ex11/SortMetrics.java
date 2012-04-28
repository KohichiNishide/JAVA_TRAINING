package ex11;

final class SortMetrics implements Cloneable{
	public long proveCnt, //単純なデータの値調査
				compareCnt, //２つの要素の比較
				swapCnt; //２つの要素の交換
	public void init() {
		proveCnt = swapCnt = compareCnt = 0;
	}
	
	public String toString() {
		return proveCnt + " probes " +
			   compareCnt + " compares " +
			   swapCnt + " swaps";
 	}
	
	/** このクラスは、cloneをサポートしている */
	public SortMetrics clone() {
		try {
			// デフォルトの仕組みで十分
			return (SortMetrics) super.clone();
		} catch (CloneNotSupportedException e) {
			// 起こりえない。このクラスとObjectは複製できる
			throw new InternalError(e.toString());
		}
	}
}
