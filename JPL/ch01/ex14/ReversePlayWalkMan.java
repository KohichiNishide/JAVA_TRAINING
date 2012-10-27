package ch01.ex14;

public class ReversePlayWalkMan extends WalkMan{
	@Override
	public void playMusic () {
		/**
		 * �^������Ă���Ȃ��t���ɍĐ�����
		 */
		for (int i = (getMaxNumber() - 1); i >= 0; i--) {
			String music = getMusic(i);
			if (music != null) {
				System.out.println("Play : " + music);
			}
		}
	}
}
