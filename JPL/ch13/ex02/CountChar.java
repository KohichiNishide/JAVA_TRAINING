package ch13.ex02;

public class CountChar {
	/*
	 * �����񒆂ɁA�w��̕������o������񐔂𐔂���
	 */
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
	
	/*
	 * �����񒆂ɁA�w��̕����񂪏o������񐔂𐔂���
	 */
	public int countOfSpecifiedStringIncludedInString(String str, String key) {
		int count = 0;
		int begPos = str.indexOf(key);
		int keySize = key.length();
		
		if (begPos != -1) {
			int endPos = str.lastIndexOf(key);
			for (int i = begPos; i <= endPos; i++) {
				for (int j = 0; j < keySize; j++) {
					if (str.charAt(i) != key.charAt(j)) {
						break;
					}
					count ++;
				}
			}
		}
		return count;
	}
}
