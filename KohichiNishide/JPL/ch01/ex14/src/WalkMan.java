
public class WalkMan {
	private int MAX = 10;
	private String[] musicLibrary = new String[MAX];
	public void recordMusic(String music) {
		/**
		 * 指定された曲を録音する
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
		 * 録音されている曲を順番に再生する
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
		 * 指定されたindexの曲を返す
		 */
		return musicLibrary[index];
	}
	
	public int getMaxNumber() {
		/**
		 * Walkmanの最大曲数を返す
		 */
		return MAX;
	}
}
