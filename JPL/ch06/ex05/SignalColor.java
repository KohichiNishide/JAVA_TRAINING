package ch06.ex05;

enum SignalColor{
	RED("RED") {
		SignalColor getColor() {
			return RED;
		}
	},
	GREEN("GREEN") {
		SignalColor getColor() {
			return GREEN;
		}
	},
	AMBER("AMBER") {
		SignalColor getColor() {
			return AMBER;
		}
	};
	
	String name;
	SignalColor(String name) { this.name = name; }
	abstract SignalColor getColor();
}
