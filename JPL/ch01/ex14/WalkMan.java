package ch01.ex14;

public class WalkMan {
	private int MAX = 10;
	private String[] musicLibrary = new String[MAX];
	public void recordMusic(String music) {
		/**
		 * �w�肳�ꂽ�Ȃ�^������
		 */
		for (int i = 0; i < MAX; i++) {
			if (musicLibrary[i] == null) {
				musicLibrary[i] = music;
				System.out.println("It is successful to record " + music);
				break;
			}
			if (i == (MAX - 1)) {
				System.out.println("It is impossible to record " + music);
			}
		}
	}
	
	public void playMusic() {
		/**
		 * �^������Ă���Ȃ����ԂɍĐ�����
		 */
		for (int i = 0; i < MAX; i++) {
			String music = musicLibrary[i];
			if (music != null) {
				System.out.println("Play : " + music);
			}
		}
	}
	
	public String getMusic(int index) {
		/**
		 * �w�肳�ꂽindex�̋Ȃ�Ԃ�
		 */
		return musicLibrary[index];
	}
	
	public int getMaxNumber() {
		/**
		 * Walkman�̍ő�Ȑ���Ԃ�
		 */
		return MAX;
	}
}
