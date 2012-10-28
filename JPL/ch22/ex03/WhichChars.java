package ch22.ex03;

import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class WhichChars {
	private Map<Integer, BitSet> map = new HashMap<Integer, BitSet>();
	private final static int BYTE_COUNT = 8;
	
	public WhichChars(String str) {
		this.storeBitSets();	
		for (int i = 0; i < str.length(); i++) {
			int index = str.charAt(i);
			System.out.println(index);
			BitSet set = map.get(new Integer(index/BYTE_COUNT));
			set.set(index%BYTE_COUNT);
		}
	}
	
	public String toString() {
		String desc = "[";
		for (int i = 0; i < Character.MAX_VALUE / BYTE_COUNT; i ++) {
			BitSet used = map.get(new Integer(i));
			for (int j = used.nextSetBit(0); j >= 0; j = used.nextSetBit(j+1)) {
				desc += (char) (i*BYTE_COUNT + j);
			}
		}
		return desc + "]";
	}
	
	private void storeBitSets() {
		for (int i = 0; i < Character.MAX_VALUE / BYTE_COUNT; i++) {
			map.put(new Integer(i), new BitSet(BYTE_COUNT));
		}
	}
	
	public static void main(String[] args) {
		WhichChars test1 = new WhichChars("Testing 1 2 3");
		WhichChars test2 = new WhichChars("Initialize");
		WhichChars test3 = new WhichChars("Z");
		System.out.println(test1);
		System.out.println(test2);
		System.out.println(test3);
	}
}
