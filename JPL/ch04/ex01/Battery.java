package ch04.ex01;

public class Battery implements EnergySource{
	private int power;
	
	public Battery(int power) {
		this.power = power;
	}
	
	public Boolean empty() {
		return (power < 1000);
	}
}
