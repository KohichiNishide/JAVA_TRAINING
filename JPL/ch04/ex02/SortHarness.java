package ch04.ex02;

abstract class SortHarness implements Sort{
	private Object[] values;
	private final SortMetrics curMetrics = new SortMetrics();
	private Boolean isActive = false;
	
	/** �S�\�[�g�����邽�߂ɌĂяo����� */
	public final SortMetrics sort(Object[] data) {
		// doSort()����sort()���Ă΂��Ɩ������[�v�ɓ����Ă��܂��̂ŁAdoSort()�͈�x�����Ă΂Ȃ��悤�ɔr�����䂷��
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
	protected final Object prove(int i) {
		curMetrics.proveCnt++;
		return values[i];
	}
	
	/** �g�������N���X���v�f���r���邽��*/
	protected final int compare(int i, int j) {
		// String�̒����Ŕ�r
		curMetrics.compareCnt++;
		int d1 = values[i].toString().length();
		int d2 = values[j].toString().length();
		if (d1 == d2)
			return 0;
		else 
			return (d1 < d2 ? -1 : 1);
	}
	
	/** �g�������N���X���v�f���������邽�� */
	protected final void swap(int i, int j) {
		curMetrics.swapCnt++;
		Object obj = values[i];
		values[i] = values[j];
		values[j] = obj;
	}
}
