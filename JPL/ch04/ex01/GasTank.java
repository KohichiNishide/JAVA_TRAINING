package ch04.ex01;

public class GasTank implements EnergySource{
	private double gas;
	
	public GasTank(int gas) {
		this.gas = gas;
	}
	
	public Boolean empty() {
		return (gas < 100);
	}
}
