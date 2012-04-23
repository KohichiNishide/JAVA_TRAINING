package ex06;

public class Vehicle {
	private double currentSpeed;
	private double currentAngle;
	private String owner;
	
	private static int nextID; //次の乗り物識別番号
	private int carID; 
	
	private EnergySource energy;
	
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
	
	public Vehicle(EnergySource eng) {
		this();
		energy = eng;
	}
	
	//-----------------------------------------------
	// メソッド
	//-----------------------------------------------
	public void start() {
		if (energy.empty()) {
			System.out.println("This car can't start because the energy is empty.");
		} else {
			System.out.println("This car start to run.");
		}
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
	
	public void changeCurrentSpeed(double speed) {
		/**
		 * 現在のスピードを変更する
		 */
		currentSpeed = speed;
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
		Vehicle oldCar = new Vehicle(new GasTank(Integer.parseInt(args[0])));
		Vehicle newCar = new Vehicle(new Battery(Integer.parseInt(args[1])));
		
		oldCar.start();
		newCar.start();
	}
}
