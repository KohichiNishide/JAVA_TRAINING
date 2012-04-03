
public class Vehicle {
	private int currentSpeed;
	private int currentAngle;
	private String owner;
	
	private static int nextID; //次の乗り物識別番号
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
	
	public void changeCurrentSpeed(int speed) {
		/**
		 * 現在のスピードを変更する
		 */
		currentSpeed = speed;
	}
	
	public void stop() {
		/**
		 * スピードを0にする
		 */
		currentSpeed = 0;
	}
	
	//setメソッド
	public void setCurrentAngle(int angle) {
		currentAngle = angle;
	}
	
	public void setOwner(String owr) {
		owner = owr;
	}
	
	//getメソッド
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
		 * 今まで使われた識別番号の最大値を返す
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
