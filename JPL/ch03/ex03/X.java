package ch03.ex03;

public class X {
	protected int xMask = 0x00ff;
	protected int fullMask;
	
	{
		System.out.printf("X0, xMask:%x, fullMask:%x%n", xMask, fullMask);
	}
	
	public X() {
		System.out.printf("X1, xMask:%x, fullMask:%x%n", xMask, fullMask);
		fullMask = xMask;
		System.out.printf("X2, xMask:%x, fullMask:%x%n", xMask, fullMask);
	}
	
	// �I�[�o�[���C�h�ł��Ȃ��悤�ɕύX
	public final int mask(int orig) {
		return (orig & fullMask);
	}
}
