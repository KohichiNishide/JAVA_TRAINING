package ch12.ex01;

public class ObjectNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	private String errorMessage;
	private Object value;
	
	public ObjectNotFoundException(String string, Object val) {
		errorMessage = string;
		value = val;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	
	public Object getValue() {
		return value;
	}
}
