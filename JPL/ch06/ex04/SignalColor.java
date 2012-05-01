package ch06.ex04;

enum SignalColor{
	RED("RED"),
	GREEN("GREEN"),
	AMBER("AMBER");
	
	String name;
	SignalColor(String name) { this.name = name; }
	
	public SignalColor getColor() {
		if (name.equals("RED")) {
			return RED;
		} else if (name.equals("GREEN")) {
			return GREEN;
		} else if (name.equals("AMBER")) {
			return AMBER;
		}
		return null;
	}
}
