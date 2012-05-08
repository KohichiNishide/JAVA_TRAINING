package ch03.ex07;

public class ScreenColor {
	private Object value;
	
	public ScreenColor(Object value) {
		this.setValue(value);
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	
	public Boolean equals(ScreenColor color) {
		return (value.equals(color.getValue()));
	}

	public int hashCode() {
		return value.hashCode();
	}
}
