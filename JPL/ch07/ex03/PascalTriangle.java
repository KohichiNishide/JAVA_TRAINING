package ch07.ex03;

public class PascalTriangle {
	private final int LENGTH = 12;
	private int[][] Array = new int[LENGTH][2 * LENGTH - 1]; 
	
	public PascalTriangle() {
		Array[0][(2 * LENGTH - 1) / 2] = 1; //初期値代入
		// 両端以外の任意の数は、直前の段の両側の数の和とする
		for (int i = 1; i < Array.length; i++) {		
			for (int j = 0; j < Array[i].length; j++) {
				if (j == 0) {
					Array[i][j] = Array[i-1][j+1];
				} else if (j == Array[i].length - 1) {
					Array[i][j] = Array[i-1][j-1];
				} else {
					Array[i][j] = Array[i-1][j-1] + Array[i-1][j+1];
				}
			}
		}
	}
	
	public void show() {
		for (int i = 0; i < Array.length; i++) {		
			for (int j = 0; j < Array[i].length; j++) {
				System.out.print(Array[i][j]);
				System.out.print("  "); //見やすくするためにスペース挿入
			}
			System.out.print("\n");
		}
	}
	
	public static void main(String[] args) {
		PascalTriangle tri = new PascalTriangle();
		tri.show();
	}
}
