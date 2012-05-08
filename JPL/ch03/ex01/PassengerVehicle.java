package ch03.ex01;

public class PassengerVehicle extends Vehicle{
	private int nSeats; //Ô‚ª‚Á‚Ä‚¢‚éÀÈ”
	private int nSeatedPeople; //Œ»İÀ‚Á‚Ä‚¢‚él”
	
	public PassengerVehicle(String owner, int nSeats) {
		super(owner);
		this.nSeats = nSeats;
	}
	
	public String toString() {
		String str = super.toString() + " Number of Seats : " + nSeats + " Number of Seated people : " + nSeatedPeople;
		return str;
	}
	
	//------------------------------------
	// GetŠÖ”
	//------------------------------------
	public int getNoOfSeats() {
		return nSeats;
	}
	
	public int getNoOfSeatedPeople() {
		return nSeatedPeople;
	}
	
	//------------------------------------
	// SetŠÖ”
	//------------------------------------	
	public void setNoOfSeatedPeople(int nSeatedPeople) {
		this.nSeatedPeople = nSeatedPeople;
	}
	
	/*
	 * MainŠÖ”
	 */
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
