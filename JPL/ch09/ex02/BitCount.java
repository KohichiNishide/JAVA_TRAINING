package ch09.ex02;

public class BitCount {
	public int originalCountBit(int val) {
		int bit = 0;
		for( bit = 0; 0 != val; val = (val >> 1) )
		{
			if ( 0 != (val & 0x01) )
			{
				++bit;
			}
			//System.out.println(val);
		}
		return bit;
	}
	
	// from Hacker's Delight 
	public int hackerCountBit(int val) {
		val = ((val&0xaaaaaaaa) >> 1) + (val&0x55555555); 
	    val = ((val&0xcccccccc) >> 2) + (val&0x33333333); 
	    val = ((val&0xf0f0f0f0) >> 4) + (val&0x0f0f0f0f); 
	    val = ((val&0xff00ff00) >> 8) + (val&0x00ff00ff); 
	    val = ((val&0xffff0000) >> 16) + (val&0x0000ffff); 
	    return val;
	}
	
	public static void main(String[] args) {
		BitCount cal = new BitCount();
		int val = 250000000;
		System.out.println("original: " + cal.originalCountBit(val));
		System.out.println("public: " + cal.hackerCountBit(val));
		System.out.println("api: " + Integer.bitCount(val));
	}
}
