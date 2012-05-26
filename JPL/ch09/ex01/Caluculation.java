package ch09.ex01;

public class Caluculation {
	public static void main(String[] args) {
		double pInfVal = Double.POSITIVE_INFINITY;
		double nInfVal = Double.NEGATIVE_INFINITY;
		
		System.out.println("‡ + ‡ = " + (pInfVal + pInfVal));
		System.out.println("‡ - ‡ = " + (pInfVal - pInfVal));
		System.out.println("‡ * ‡ = " + (pInfVal * pInfVal));
		System.out.println("‡ / ‡ = " + (pInfVal / pInfVal));
		System.out.println("‡ % ‡ = " + (pInfVal % pInfVal));

		System.out.println("‡ * -‡ = " + (pInfVal * nInfVal));
		System.out.println("‡ / -‡ = " + (pInfVal / nInfVal));
		System.out.println("‡ % -‡ = " + (pInfVal % pInfVal));
	}
}
