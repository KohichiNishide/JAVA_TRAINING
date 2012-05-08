package ch02.ex08;

public class Vehicle {
	public int currentSpeed;
	public int currentAngle;
	public String owner;
	
	static int nextID; //Ÿ‚Ìæ‚è•¨¯•Ê”Ô†
	public int carID; 
	
	static void main(String[] args) {
		Vehicle car = new Vehicle();
		Vehicle plane = new Vehicle();
		Vehicle bike = new Vehicle();
		
		System.out.println("ID : " + car.carID);
		System.out.println("ID : " + plane.carID);
		System.out.println("ID : " + bike.carID);
	}
}