package ch13.ex06;

public class CommaManager {
	public static String insertComma(String str) {
		if (str == null) return null;
		
		int commaIndex = 0;
		StringBuilder result = new StringBuilder();
		// 文字列から10進数を取り出す
		for (int i = str.length() -1; i >= 0; i--) {
			char a = str.charAt(i);
			if (Character.isDigit(a)) {
				commaIndex ++;
				if (i != 0 && commaIndex%3 == 0) { //コンマが最初に付かないように"i != 0"の条件を追加
					result.append(a).append(',');
				} else {
					result.append(a);
				}
			}
		}
		return result.reverse().toString();
	}
	
	public static String insertSomething(String str, char breakChar, int interval) {
		if (str == null) return null;
		
		int commaIndex = 0;
		StringBuilder result = new StringBuilder();
		// 文字列から10進数を取り出す
		for (int i = str.length() -1; i >= 0; i--) {
			char a = str.charAt(i);
			if (Character.isDigit(a)) {
				commaIndex ++;
				if (i != 0 && commaIndex%interval == 0) { //コンマが最初に付かないように"i != 0"の条件を追加
					result.append(a).append(breakChar);
				} else {
					result.append(a);
				}
			}
		}
		return result.reverse().toString();
	}
}
