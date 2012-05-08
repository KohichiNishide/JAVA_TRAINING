package ch03.ex02;

public class Y extends X{
	protected int yMask = 0xff00;
	{
		System.out.printf("Y0, xMask:%x, yMask:%x, fullMask:%x%n", xMask, yMask, fullMask);
	}
	
	public Y() {
		System.out.printf("Y1, xMask:%x, yMask:%x, fullMask:%x%n", xMask, yMask, fullMask);
		fullMask |= yMask;
		System.out.printf("Y2, xMask:%x, yMask:%x, fullMask:%x%n", xMask, yMask, fullMask);
	}
	
	public static void main(String[] args) {
		Y y = new Y();
	}
}
