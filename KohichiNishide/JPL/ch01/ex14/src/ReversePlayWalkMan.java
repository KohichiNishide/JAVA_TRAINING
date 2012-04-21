
public class ReversePlayWalkMan extends WalkMan{
	@Override
	public void playMusic () {
		/**
		 * ˜^‰¹‚³‚ê‚Ä‚¢‚é‹È‚ð‹t‡‚ÉÄ¶‚·‚é
		 */
		for (int i = (getMaxNumber() - 1); i >= 0; i--) {
			String music = getMusic(i);
			if (music != null) {
				System.out.println("Play : " + music);
			}
		}
	}
}
