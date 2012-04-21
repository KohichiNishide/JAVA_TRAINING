
public class ReversePlayWalkMan extends WalkMan{
	@Override
	public void playMusic () {
		/**
		 * 録音されている曲を逆順に再生する
		 */
		for (int i = (getMaxNumber() - 1); i >= 0; i--) {
			String music = getMusic(i);
			if (music != null) {
				System.out.println("Play : " + music);
			}
		}
	}
}
