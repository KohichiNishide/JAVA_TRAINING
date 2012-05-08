package ch03.ex11;

abstract class SortDouble {
	private double[] values;
	private final SortMetrics curMetrics = new SortMetrics();
	private Boolean isActive = false;
	
	/** �S�\�[�g�����邽�߂ɌĂяo����� */
	public final SortMetrics sort(double[] data) {
		// doSort()�͈�x�����Ă΂Ȃ��悤�ɔr�����䂷��
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
	
	/** �g�������N���X���v�f�̐���m�邽�� */
	protected final int getDataLength() {
		return values.length;
	}
	
	/** �g�������N���X���v�f�̐��𒲂ׂ邽��*/
	protected final double prove(int i) {
		curMetrics.proveCnt++;
		return values[i];
	}
	
	/** �g�������N���X���v�f���r���邽�� */
	protected final int compare(int i, int j) {
		curMetrics.compareCnt++;
		double d1 = values[i];
		double d2 = values[j];
		if (d1 == d2)
			return 0;
		else 
			return (d1 < d2 ? -1 : 1);
	}
	
	/** �g�������N���X���v�f���������邽�� */
	protected final void swap(int i, int j) {
		curMetrics.swapCnt++;
		double tmp = values[i];
		values[i] = values[j];
		values[j] = tmp;
	}
	
	/** �g�������N���X���������� -- �\�[�g����̂Ɏg�p����� */
	protected abstract void doSort();
}
