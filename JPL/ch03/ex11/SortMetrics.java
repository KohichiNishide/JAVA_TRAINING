package ex11;

final class SortMetrics implements Cloneable{
	public long proveCnt, //�P���ȃf�[�^�̒l����
				compareCnt, //�Q�̗v�f�̔�r
				swapCnt; //�Q�̗v�f�̌���
	public void init() {
		proveCnt = swapCnt = compareCnt = 0;
	}
	
	public String toString() {
		return proveCnt + " probes " +
			   compareCnt + " compares " +
			   swapCnt + " swaps";
 	}
	
	/** ���̃N���X�́Aclone���T�|�[�g���Ă��� */
	public SortMetrics clone() {
		try {
			// �f�t�H���g�̎d�g�݂ŏ\��
			return (SortMetrics) super.clone();
		} catch (CloneNotSupportedException e) {
			// �N���肦�Ȃ��B���̃N���X��Object�͕����ł���
			throw new InternalError(e.toString());
		}
	}
}
