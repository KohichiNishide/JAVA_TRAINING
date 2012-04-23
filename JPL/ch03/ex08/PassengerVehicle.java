package ex08;

public class PassengerVehicle extends Vehicle implements Cloneable{
	private int nSeats; //車が持っている座席数
	private int nSeatedPeople; //現在座っている人数
	
	public String toString() {
		String str = super.toString() + " Number of Seats : " + nSeats + " Number of Seated people : " + nSeatedPeople;
		return str;
	}
	
	public PassengerVehicle clone() throws CloneNotSupportedException {
		return (PassengerVehicle) super.clone();
	}
	
	//-----------------------------------------------
	// コンストラクタ
	//-----------------------------------------------
	public PassengerVehicle(String owner, int nSeats) {
		super(owner);
		this.nSeats = nSeats;
	}
	
	//------------------------------------
	// Get関数
	//------------------------------------
	public int getNoOfSeats() {
		return nSeats;
	}
	
	public int getNoOfSeatedPeople() {
		return nSeatedPeople;
	}
	
	//------------------------------------
	// Set関数
	//------------------------------------	
	public void setNoOfSeatedPeople(int nSeatedPeople) {
		this.nSeatedPeople = nSeatedPeople;
	}
	
	//------------------------------------
	// Main関数
	//------------------------------------	
	static void main(String[] args) {
		PassengerVehicle smallCar = new PassengerVehicle(args[0], 2);
		PassengerVehicle normalCar = new PassengerVehicle(args[1], 5);
		PassengerVehicle bigCar = new PassengerVehicle(args[2], 10);
		
		smallCar.setNoOfSeatedPeople(1);
		normalCar.setNoOfSeatedPeople(1);
		bigCar.setNoOfSeatedPeople(1);
		
		System.out.println(smallCar.toString());
		System.out.println(normalCar.toString());
		System.out.println(bigCar.toString());
		System.out.println("maxID : " + Vehicle.getMaxID());
	}
}
