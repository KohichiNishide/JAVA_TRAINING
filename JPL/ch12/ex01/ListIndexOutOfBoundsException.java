package ch12.ex01;

public class ListIndexOutOfBoundsException extends Exception{
	private static final long serialVersionUID = 1L;
	private String errorMessage;
	private int index;
	
	public ListIndexOutOfBoundsException(String string, int i) {
		errorMessage = string;
		index = i;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	
	public int getIndex() {
		return index;
	}
}
