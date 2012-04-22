package ex01;

public class Vehicle {
	private double currentSpeed;
	private double currentAngle;
	private String owner;
	
	private static int nextID; //���̏�蕨���ʔԍ�
	private int carID; 
	
    public static enum TURN_DIRECTION {
    	TURN_LEFT,
    	TURN_RIGHT
    }
	
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
	
	public void changeCurrentSpeed(double speed) {
		/**
		 * ���݂̃X�s�[�h��ύX����
		 */
		currentSpeed = speed;
	}
	
	public void stop() {
		/**
		 * �X�s�[�h��0�ɂ���
		 */
		currentSpeed = 0;
	}
	
	public void turn(double angle) {
		/**
		 * ��]����
		 */
		currentAngle += angle; 
	}
	
	public void turn(TURN_DIRECTION dir) {
		/**
		 * ��or�E�ɉ�]����
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
	
	//set���\�b�h
	public void setCurrentAngle(double angle) {
		currentAngle = angle;
	}
	
	public void setOwner(String owr) {
		owner = owr;
	}
	
	//get���\�b�h
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
		 * ���܂Ŏg��ꂽ���ʔԍ��̍ő�l��Ԃ�
		 */
		return nextID - 1;
	}
	
	public String toString() {
		String str = carID + " CurrentSpeed : " + currentSpeed + " CurrentAngle : " + currentAngle + " Owner : " + owner;
		return str;
	}
	
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
