package ch09.ex04;

public class Caluculator {
	public static void main(String[] args) {
		int i = 3;
		System.out.println(3 << 2L - 1); //6(Intå^)
		System.out.println((3L << 2) - 1); //11(Intå^)
		System.out.println(10 < 12 == 6 > 17); //false
		System.out.println(10 << 12 == 6 >> 17); //false
		System.out.println(13.5e-1 % Float.POSITIVE_INFINITY); //1.35(Floatå^)
		System.out.println(Float.POSITIVE_INFINITY + Double.NEGATIVE_INFINITY); //NaN(Doubleå^)
		System.out.println(Double.POSITIVE_INFINITY - Float.NEGATIVE_INFINITY); //Inf(Doubleå^)
		System.out.println(0.0 / -0.0 == -0.0 / 0.0); //false
		System.out.println(Integer.MAX_VALUE + Integer.MIN_VALUE); //2147483647-2147483648=-1(Intå^)
		System.out.println(Long.MAX_VALUE + 5); //-9223372036854775804(Longå^)
		System.out.println((short) 5 * (byte) 10); //50(Intå^)
		System.out.println((i < 15 ? 1.72e3f : 0)); //1720.0(Intå^)
		System.out.println(i++ + i++ + --i); //3+4+4=11(Intå^)
	}
}
