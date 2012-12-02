package ch22.ex05;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DiceManager {
	private static Map<Integer, Double> theoreticalMaps = new HashMap<Integer, Double>();
	private static Map<Integer, Double> actualMaps = new HashMap<Integer, Double>();
	private static int TRIAL_TIMES = 1000000;
	
	public static void storeTheoretical() {
		theoreticalMaps.put(2, (double)1/36);
		theoreticalMaps.put(3, (double)2/36);
		theoreticalMaps.put(4, (double)3/36);
		theoreticalMaps.put(5, (double)4/36);
		theoreticalMaps.put(6, (double)5/36);
		theoreticalMaps.put(7, (double)6/36);
		theoreticalMaps.put(8, (double)5/36);
		theoreticalMaps.put(9, (double)4/36);
		theoreticalMaps.put(10, (double)3/36);
		theoreticalMaps.put(11, (double)2/36);
		theoreticalMaps.put(12, (double)1/36);
	}
	
	public static void storeActual() {
        //Random rnd = new Random();
        int totalDiceVal = 0;
        for (int i = 0; i < TRIAL_TIMES; i++) {
        	Random rnd = new Random(i); // 毎回シードを変更する方が理論に近い値が算出される
	        int firstDiceVal = rnd.nextInt(6) + 1;
	        int secondDiceVal = rnd.nextInt(6) + 1;
	        //System.out.println("first Dice: "+ firstDiceVal + ", second Dice: " + secondDiceVal);
	        totalDiceVal = firstDiceVal + secondDiceVal;
	        setActualMap(totalDiceVal);
        }
	}
	
	private static void setActualMap(int val) {
		Double f = actualMaps.remove(val);
		if (f == null)
			f = (double) 0;
		f += (double)1 / (double)TRIAL_TIMES;
		actualMaps.put(val, f);
	}
	
	public static void main(String[] args) {
		DiceManager.storeTheoretical();
		DiceManager.storeActual();
		double theoretical = 0;
		double actual = 0;
		for (int i = 2; i <= 12; i++) {
			theoretical = theoreticalMaps.get(i);
			actual = actualMaps.get(i);
			System.out.println(i + ": " + "T: " + theoretical + ", A: " + actual);
		}
	}
}
