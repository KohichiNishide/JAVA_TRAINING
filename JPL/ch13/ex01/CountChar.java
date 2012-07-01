package ch13.ex01;

public class CountChar {
	public int countOfSpecifiedCharIncludedInString(String str, char ch) {
		int count = 0;
		int begPos = str.indexOf(ch);
		if (begPos < 0) {
		} else {
			int endPos = str.lastIndexOf(ch);
			for (int i = begPos; i <= endPos; i++) {
				if (str.charAt(i) == ch) {
					count ++;
				}
			}
		}
		return count;
	}
}
