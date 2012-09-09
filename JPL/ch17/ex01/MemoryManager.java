package ch17.ex01;

import java.util.ArrayList;
import java.util.List;

public class MemoryManager {
	public static void fullGD() {
		Runtime rt = Runtime.getRuntime();
		long isFree = rt.freeMemory();
		long wasFree;
		System.out.println("Before GC, Available memory : " + isFree + " (Bytes)");
		do {
			wasFree = isFree;
			rt.runFinalization();
			rt.gc();
			isFree = rt.freeMemory();
		} while (isFree > wasFree);
		System.out.println("After GC, Available memory : " + isFree + " (Bytes)");
	}
	
	public static void createObjects() {
		Runtime rt = Runtime.getRuntime();
		System.out.println("Before creation, Available memory : " + rt.freeMemory() + " (Bytes)");
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 1000000; i++) {
			list.add(new Integer(i));
		}
		System.out.println("After creation, Available memory : " + rt.freeMemory() + " (Bytes)");
	}
	
	public static void main(String[] args) {
		MemoryManager.createObjects();
		MemoryManager.fullGD();
	}
}
