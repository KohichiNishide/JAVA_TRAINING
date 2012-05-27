package ch10.ex01;

public class Convert {
	public String convertSpecialCharacter(String str) {
		char ch[]  = str.toCharArray();
		String result = "";
        for (int i = 0; i < str.length(); i++)  {
        	if (ch[i] == '\n') {
        		result = result + "\\" + "n";
        	} else if (ch[i] == '\t') {
        		result = result + "\\" + "t";
        	} else if (ch[i] == '\b') {
        		result = result + "\\" + "b";
        	} else if (ch[i] == '\r') {
        		result = result + "\\" + "r";
        	} else if (ch[i] == '\f') {
        		result = result + "\\" + "f";
        	} else if (ch[i] == '\\') {
        		result = result + "\\" + "\\";
        	} else if (ch[i] == '\"') {
        		result = result + "\\" + "\"";
        	} else if (ch[i] == '\'') {
        		result = result + "\\" + "\'";
        	} else {
        		result += ch[i];
        	}
        }
		return result;
	}
	
	public static void main(String[] args) {
		Convert convert = new Convert();
		if (args.length != 0) System.out.println(convert.convertSpecialCharacter(args[0]));		
	}
}
