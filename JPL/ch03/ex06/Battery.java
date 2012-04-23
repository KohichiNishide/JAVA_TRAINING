package ex06;

public class Battery extends EnergySource{
	private int power;
	
	public Battery(int power) {
		this.power = power;
	}
	
	public Boolean empty() {
		return (power < 1000);
	}
}
