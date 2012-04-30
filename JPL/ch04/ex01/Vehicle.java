package ch04.ex01;

public class Vehicle {
	private double currentSpeed;
	private double currentAngle;
	private String owner;
	
	private static int nextID; //���̏�蕨���ʔԍ�
	private int carID; 
	
	private EnergySource energy;
	
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
	
	public Vehicle(EnergySource eng) {
		this();
		energy = eng;
	}
	
	//-----------------------------------------------
	// ���\�b�h
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
	
	public void changeCurrentSpeed(double speed) {
		/**
		 * ���݂̃X�s�[�h��ύX����
		 */
		currentSpeed = speed;
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
		Vehicle oldCar = new Vehicle(new GasTank(Integer.parseInt(args[0])));
		Vehicle newCar = new Vehicle(new Battery(Integer.parseInt(args[1])));
		
		oldCar.start();
		newCar.start();
	}
}
