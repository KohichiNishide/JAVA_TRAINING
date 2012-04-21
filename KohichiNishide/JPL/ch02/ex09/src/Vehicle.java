
public class Vehicle {
	public int currentSpeed;
	public int currentAngle;
	public String owner;
	
	static int nextID; //���̏�蕨���ʔԍ�
	public int carID; 
	
	public Vehicle() {
		currentSpeed = 100;
		currentAngle = 10;
		owner = "Max";
		carID = nextID;
		nextID++;
	}
	
	public Vehicle(String owr) {
		currentSpeed = 100;
		currentAngle = 10;
		carID = nextID;
		nextID++;
		owner = owr;
	}
	
	public static int getMaxID() {
		/**
		 * ���܂Ŏg��ꂽ���ʔԍ��̍ő�l��Ԃ�
		 */
		return nextID - 1;
	}
	
	static void main(String[] args) {
		Vehicle car = new Vehicle();
		Vehicle plane = new Vehicle();
		Vehicle bike = new Vehicle();
		
		System.out.println("ID : " + car.carID);
		System.out.println("ID : " + plane.carID);
		System.out.println("ID : " + bike.carID);
		System.out.println("maxID : " + Vehicle.getMaxID());
	}
}
