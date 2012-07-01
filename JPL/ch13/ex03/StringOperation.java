package ch13.ex03;

public class StringOperation {
	public static String[] delimitedString(String from, char start, char end) {
		int startPos = -1;
		int endPos = 0;
		int index = 0;
		String[] strings = new String[10];
		
		while (from.indexOf(start, startPos+1) > -1) {
		    startPos = from.indexOf(start, startPos + 1);
			endPos = from.indexOf(end, startPos + 1);
			if (startPos == -1) {
				break;
			} else if (endPos == -1) {
				strings[index] = from.substring(startPos);
				break;
			} else if (startPos > endPos) {
				break;
			} else {
				strings[index] = from.substring(startPos, endPos + 1);
				index ++;
			}
		}
		return strings;
	}
}
