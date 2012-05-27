package ch10.ex05;

public class CharPrint {
	public static void print(char a, char b) {
		String result = "";
		char min, max;
		min = (a < b ? a : b);
		max = (a < b ? b : a);
		int x = 0;
		while (min + x <= max) {
			result += (char)(min + x);
			x++;
		}
		System.out.println(result);
	}
	
	public static void main(String[] args) {
		CharPrint.print('a', 'b');
		CharPrint.print('a', 'x');
		CharPrint.print('A', 'a');
		CharPrint.print('y', 'D');
		CharPrint.print('В†', 'Вс');
	}
}
