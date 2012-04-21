
public class WalkMan {
	private int MAX = 10;
	private String[] musicLibrary = new String[MAX];
	public void recordMusic(String music) {
		/**
		 * Žw’è‚³‚ê‚½‹È‚ð˜^‰¹‚·‚é
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
		 * ˜^‰¹‚³‚ê‚Ä‚¢‚é‹È‚ð‡”Ô‚ÉÄ¶‚·‚é
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
		 * Žw’è‚³‚ê‚½index‚Ì‹È‚ð•Ô‚·
		 */
		return musicLibrary[index];
	}
	
	public int getMaxNumber() {
		/**
		 * Walkman‚ÌÅ‘å‹È”‚ð•Ô‚·
		 */
		return MAX;
	}
}
