
public class Vehicle {
	public int currentSpeed;
	public int currentAngle;
	public String owner;
	
	static int nextID; //éüÇÃèÊÇËï®éØï î‘çÜ
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
		carID = 0;
		carID = nextID;
		owner = owr;
	}
	
	static void main(String[] args) {
		Vehicle car = new Vehicle();
		Vehicle plane = new Vehicle();
		Vehicle bike = new Vehicle();
		
		System.out.println("ID : " + car.carID);
		System.out.println("ID : " + plane.carID);
		System.out.println("ID : " + bike.carID);
	}
}
