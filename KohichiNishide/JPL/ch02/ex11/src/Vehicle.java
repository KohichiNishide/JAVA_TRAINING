
public class Vehicle {
	public int currentSpeed;
	public int currentAngle;
	public String owner;
	
	static int nextID; //Ÿ‚Ìæ‚è•¨¯•Ê”Ô†
	public int carID; 
	
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
	
	public void setOwner(String owr) {
		owner = owr;
	}
	
	public static int getMaxID() {
		/**
		 * ¡‚Ü‚Åg‚í‚ê‚½¯•Ê”Ô†‚ÌÅ‘å’l‚ğ•Ô‚·
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