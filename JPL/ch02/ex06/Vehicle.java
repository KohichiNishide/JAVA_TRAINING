package ch02.ex06;

public class Vehicle {
	public int currentSpeed;
	public int currentAngle;
	public String owner;
	
	static int nextID; //次の乗り物識別番号
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