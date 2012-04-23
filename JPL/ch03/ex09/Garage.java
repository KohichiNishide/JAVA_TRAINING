package ex09;

public class Garage implements Cloneable{
	private static final int MAX = 10;
	private Vehicle[] vehicles = new Vehicle[MAX];
	
	public Garage clone() throws CloneNotSupportedException {
		Garage copyGarage = new Garage();
		Vehicle[] copyVehicles = copyGarage.getVehicles();
		for (int i = 0; i < MAX; i++) {
			if (vehicles[i] == null) {
				copyVehicles[i] = null;
			} else {
				copyVehicles[i] = vehicles[i].clone();
			}
		}
		return copyGarage;
	}
	
	public void add(Vehicle vehicle) throws Exception{
		if (vehicles[0] == null) {
			vehicles[0] = vehicle;
			return;
		}
		for (int i = 0; i < MAX; i++) {
			if (vehicles[i] == null) {
				vehicles[i] = vehicle;
				return;
			}
		}
		throw new Exception("This garage is full!!");
	}
	
	public Vehicle[] getVehicles() {
		return vehicles;
	}
	
	public static void main(String[] args) throws Exception {
		Garage garage1 = new Garage();
		Vehicle car1 = new Vehicle(args[0]);
		Vehicle car2 = new Vehicle(args[1]);
		Vehicle car3 = new Vehicle(args[2]);
		
		garage1.add(car1);
		garage1.add(car2);
		garage1.add(car3);
		
		Garage garage2 = garage1.clone();
		Vehicle[] copyVehicles = garage2.getVehicles();
		
		if (car1 !=  copyVehicles[0] && car1.getOwner().equals(copyVehicles[0].getOwner())) {
			System.out.println("Copy successful!");
		}
		if (car2 !=  copyVehicles[1] && car2.getOwner().equals(copyVehicles[1].getOwner())) {
			System.out.println("Copy successful!");
		}
		if (car3 !=  copyVehicles[2] && car3.getOwner().equals(copyVehicles[2].getOwner())) {
			System.out.println("Copy successful!");
		}
	}
}
