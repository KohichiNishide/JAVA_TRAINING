package ch02.ex12;

public class Vehicle {
	public int currentSpeed;
	public int currentAngle;
	public String[] owners;
	
	static int nextID; //次の乗り物識別番号
	public int carID; 
	
	public Vehicle() {
		currentSpeed = 100;
		currentAngle = 10;
		carID = nextID;
		nextID++;
	}
	
	public Vehicle(String... owrs) {
		/**
		 * オーナーが複数いる場合を考慮して、可変長の引数を使用
		 */
		this();
		owners = owrs;
	}
	
	public void setOwners(String... owrs) {
		/**
		 * オーナーが複数いる場合を考慮して、可変長の引数を使用
		 */
		owners = owrs;
	}
	
	public static int getMaxID() {
		/**
		 * 今まで使われた識別番号の最大値を返す
		 */
		return nextID - 1;
	}
	
	public String toString() {
		String str = carID + " CurrentSpeed : " + currentSpeed + " CurrentAngle : " + currentAngle;
		int i = 0;
		for (String owner: owners) {
			str += " Owner" + i + " : " + owner;
			i++;
		}
		return str;
	}
	
	static void main(String[] args) {
		Vehicle car = new Vehicle("Tom", "Ban");
		Vehicle plane = new Vehicle("Kelly");
		Vehicle bike = new Vehicle("John");
		
		System.out.println(car.toString());
		System.out.println(plane.toString());
		System.out.println(bike.toString());
		System.out.println("maxID : " + Vehicle.getMaxID());
	}
}