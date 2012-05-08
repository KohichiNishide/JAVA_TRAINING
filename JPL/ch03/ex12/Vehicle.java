package ch03.ex12;

public class Vehicle implements Cloneable {
	private double currentSpeed;
	private double currentAngle;
	private String owner;
	
	private static int nextID; //次の乗り物識別番号
	private int carID; 
	
    public static enum TURN_DIRECTION {
    	TURN_LEFT,
    	TURN_RIGHT
    }
	
	//-----------------------------------------------
	// コンストラクタ
	//-----------------------------------------------
	public Vehicle() {
		currentSpeed = 0;
		currentAngle = 0;
		carID = nextID;
		nextID++;
	}
	
	public Vehicle(String owr) {
		this();
		owner = owr;
	}
	
	//-----------------------------------------------
	// メソッド
	//-----------------------------------------------
	public Vehicle clone() throws CloneNotSupportedException {
		return (Vehicle) super.clone();
	}
	
	public void changeCurrentSpeed(double speed) {
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
	
	public void turn(double angle) {
		/**
		 * 回転する
		 */
		currentAngle += angle; 
	}
	
	public void turn(TURN_DIRECTION dir) {
		/**
		 * 左or右に回転する
		 */
		switch (dir) {
		case TURN_LEFT:
			turn(-Math.PI / 2);
			break;
		case TURN_RIGHT:
			turn(Math.PI / 2);
			break;
		}
	}
	
	public String toString() {
		String str = carID + " CurrentSpeed : " + currentSpeed + " CurrentAngle : " + currentAngle + " Owner : " + owner;
		return str;
	}
	
	//-----------------------------------------------
	// setメソッド
	//-----------------------------------------------
	public void setCurrentAngle(double angle) {
		currentAngle = angle;
	}
	
	public void setOwner(String owr) {
		owner = owr;
	}
	
	//-----------------------------------------------
	// getメソッド
	//-----------------------------------------------
	public double getCurrentSpeed() {
		return currentSpeed;
	}
	
	public double getCurrentAngle() {
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

	//-----------------------------------------------
	// mainメソッド
	//-----------------------------------------------	
	static void main(String[] args) {
		Vehicle car = new Vehicle(args[0]);
		Vehicle plane = new Vehicle(args[1]);
		Vehicle bike = new Vehicle(args[2]);
		
		System.out.println(car.toString());
		System.out.println(plane.toString());
		System.out.println(bike.toString());
		System.out.println("maxID : " + Vehicle.getMaxID());
	}
}
