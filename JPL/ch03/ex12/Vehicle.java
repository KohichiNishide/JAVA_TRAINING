package ch03.ex12;

public class Vehicle implements Cloneable {
	private double currentSpeed;
	private double currentAngle;
	private String owner;
	
	private static int nextID; //���̏�蕨���ʔԍ�
	private int carID; 
	
    public static enum TURN_DIRECTION {
    	TURN_LEFT,
    	TURN_RIGHT
    }
	
	//-----------------------------------------------
	// �R���X�g���N�^
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
	// ���\�b�h
	//-----------------------------------------------
	public Vehicle clone() throws CloneNotSupportedException {
		return (Vehicle) super.clone();
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
	
	public String toString() {
		String str = carID + " CurrentSpeed : " + currentSpeed + " CurrentAngle : " + currentAngle + " Owner : " + owner;
		return str;
	}
	
	//-----------------------------------------------
	// set���\�b�h
	//-----------------------------------------------
	public void setCurrentAngle(double angle) {
		currentAngle = angle;
	}
	
	public void setOwner(String owr) {
		owner = owr;
	}
	
	//-----------------------------------------------
	// get���\�b�h
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
		 * ���܂Ŏg��ꂽ���ʔԍ��̍ő�l��Ԃ�
		 */
		return nextID - 1;
	}

	//-----------------------------------------------
	// main���\�b�h
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
