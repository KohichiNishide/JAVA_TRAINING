package ch19.ex02;

public class Vehicle {
	private int currentSpeed;
	private int currentAngle;
	private String owner;
	
	private static int nextID; //���̏�蕨���ʔԍ�
	private int carID; 
	
	public Vehicle() {
		currentSpeed = 100;
		currentAngle = 10;
		carID = nextID;
		nextID++;
	}
	
	public Vehicle(String owr) {
		this();
		owner = owr;
	}
	//set���\�b�h
	public void setCurrentSpeed(int speed) {
		currentSpeed = speed;
	}
	
	public void setCurrentAngle(int angle) {
		currentAngle = angle;
	}
	
	public void setOwner(String owr) {
		owner = owr;
	}
	
	//get���\�b�h
	public int getCurrentSpeed() {
		return currentSpeed;
	}
	
	public int getCurrentAngle() {
		return currentAngle;
	}
	
	public String getOwner() {
		return owner;
	}
	
	public static int getMaxID() {
		/**
		 * ���܂Ŏg��ꂽ���ʔԍ��̍ő�l��Ԃ�
		 */
		return nextID - 1;
	}
	
	public String toString() {
		String str = carID + " CurrentSpeed : " + currentSpeed + " CurrentAngle : " + currentAngle + " Owner : " + owner;
		return str;
	}
	
	static void main(String[] args) {
		Vehicle car = new Vehicle("Tom");
		Vehicle plane = new Vehicle("Kelly");
		Vehicle bike = new Vehicle("John");
		
		System.out.println(car.toString());
		System.out.println(plane.toString());
		System.out.println(bike.toString());
		System.out.println("maxID : " + Vehicle.getMaxID());
	}
}
