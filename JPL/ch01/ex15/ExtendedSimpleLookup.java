package ch01.ex15;
/**
 * ��K���1.15:add��remove���\�b�h��錾�����C���^�[�t�F�[�X���ALookup���g�����Ē�`����
 * ���̊g�������C���^�[�t�F�[�X��V���ȃN���X�Ɏ�������B
 */

public class ExtendedSimpleLookup implements ExtendedLookup{
	private String[] names = new String[10];
	private Object[] values = new Object[10];
	
	public void add(Object value) {
		/**
		 * �l��values�ɒǉ�����
		 * ����Ɠ����ɁA"Key+index�ԍ�"�𖼑O��names�ɓo�^����B
		 */
		for (int i = 0; i < values.length; i++) {
			if (values[i] == null) {
				values[i] = value;
				names[i] = "Key" + i;
				return;
			}
		}
	}
	
	public void remove(String name) {
		/**
		 * name�Ɗ֘A�Â����ꂽ�l��values����폜����B
		 * ����Ɠ�����name��names����폜����B
		 */
		for (int i = 0; i < names.length; i++) {
			if (names[i].equals(name)) {
				values[i] = null;
				names[i] = null;
				return;
			}
		}
	}

	public Object find(String name) {
		/** name�Ɗ֘A�Â����ꂽ�l��Ԃ��B
		 * ���̂悤�Ȓl���Ȃ����null��Ԃ��B
		 */
		for (int i = 0; i < names.length; i++) {
			if (names[i] != null) {
				if (names[i].equals(name))
					return values[i];
			}
		}
		return null; //������Ȃ�����
	}
}
