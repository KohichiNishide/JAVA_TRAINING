package ch10.ex02;

public class Convert {
	public String convertSpecialCharacter(String str) {
		char ch[]  = str.toCharArray();
		String result = "";
        for (int i = 0; i < str.length(); i++)  {
        	switch (ch[i]) {
	        	case '\n': 
	        		result = result + "\\" + "n";
	        		break;
	        	case '\t':
	        		result = result + "\\" + "t";
	        		break;
	        	case '\b':
	        		result = result + "\\" + "b";
	        		break;
	        	case '\r':
	        		result = result + "\\" + "r";
	        		break;
	        	case '\f':
	        		result = result + "\\" + "f";
	        		break;
	        	case '\\':
	        		result = result + "\\" + "\\";
	        		break;
	        	case '\"':
	        		result = result + "\\" + "\"";
	        		break;
	        	case '\'':
	        		result = result + "\\" + "\'";
	        		break;
	        	
	        	default:
	        		result += ch[i];	
	        		break;
        	}
        }
        return result;
	}
	
	public static void main(String[] args) {
		Convert convert = new Convert();
		if (args.length != 0) System.out.println(convert.convertSpecialCharacter(args[0]));		
	}
}
