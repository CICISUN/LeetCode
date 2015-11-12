package Design;

import java.util.ArrayList;

public class ParkingLotSol {

	public enum VehicleSize { Motorcycle, Compact, Large };

	//Vehicle
	public abstract class Vehicle{
		protected ArrayList<ParkingSpot> parkingspots = new ArrayList<ParkingSpot>();
		protected String licensePlate;
		protected int spotsNeeded;
		protected VehicleSize size;
		public int getSpotsNeeded(){return spotsNeeded;}
		public VehicleSize getVehicleSize(){return size;}
		public void parkInSpot(ParkingSpot s) {parkingspots.add(s);} //park the vehicle
		public void cleanSpots() {} //remove slot
		public abstract boolean canFitInSpot(ParkingSpot spot); //check if slots are bigger than size
	}

	//Bus
	public class Bus extends Vehicle{
		//init
		public Bus(){
			spotsNeeded = 5;
			size=VehicleSize.Large;
		}
		@Override
		public boolean canFitInSpot(ParkingSpot spot) {
			// Checks if the spot is a Large. Doesn't check num of spots 
			return spot.spotSize.equals(size);
		}
	}

	//Car
	public class Car extends Vehicle{
		//init
		public Car(){
			spotsNeeded = 1;
			size=VehicleSize.Compact;
		}
		@Override
		public boolean canFitInSpot(ParkingSpot spot) {
			// Checks if the spot is a Large. Doesn't check num of spots 
			return spot.spotSize.equals(size);
		}
	}	

	//Motor
	public class Motor extends Vehicle{
		//init
		public Motor(){
			spotsNeeded = 1;
			size=VehicleSize.Motorcycle;
		}
		@Override
		public boolean canFitInSpot(ParkingSpot spot) {
			// Checks if the spot is a Large. Doesn't check num of spots 
			return spot.spotSize.equals(size);
		}
	}

	//parking lot
	public class ParkingLot {
		private Level[] levels;
		private final int NUM_LEVELS = 5;
		public ParkingLot() {}
		/* Park the vehicle in a spot (or multiple spots).  Return false if failed. */
		public boolean parkVehicle(Vehicle vehicle) {
			for(int i=0; i<levels.length; i++){
				if(levels[i].parkVehicle(vehicle)) return true;
			}
			return false;
		}
	}

	//level
	public class Level {
		private int floor;
		private ParkingSpot[] spots;
		private int availableSpots = 0; // number of free spots
		private static final int SPOTS_PER_ROW = 10;
		public Level(int flr, int numberSpots) {}
		public int availableSpots() { return availableSpots; }
		/* Find a place to park this vehicle. Return false if failed. */
		public boolean parkVehicle(Vehicle vehicle) {
			for(int i=0; i<spots.length; i++){
				if(spots[i].isAvailable() && spots[i].canFitVehicle(vehicle)) {spots[i].park(vehicle);return true;}
			}
			return false;}
		/* Park a vehicle starting at the spot spotNumber, and continuing until vehicle.spotsNeeded. */
		private boolean parkStartingAtSpot(int num, Vehicle v) {
			return false; }
		/* Find a spot to park this vehicle. Return index of spot, or -1  on failure. */
		private int findAvailableSpots(Vehicle vehicle) {
			return availableSpots;  }
		/* When a car was removed from the spot, increment * availableSpots */
		public void spotFreed() { availableSpots++; }
	}

	//parking spot
	public class ParkingSpot {
		private Vehicle vehicle;
		private VehicleSize spotSize;
		private int spotsize;
		private int row;
		private int spotNumber;
		private Level level;
		public ParkingSpot(Level Ivl, int r, int n, VehicleSize s) {}
		public boolean isAvailable() { return vehicle == null; }
		/* Check if the spot is big enough and is available */
		public boolean canFitVehicle(Vehicle vehicle) {
			return (vehicle.spotsNeeded <= spotsize); }
		/* Park vehicle in this spot. */
		public boolean park(Vehicle v) {
			if(this.vehicle != null){
				this.vehicle = v;
				return true;}
			else return false;}
		public int getRow() { return row; }
		public int getSpotNumber() { return spotNumber; }
		/* Remove vehicle from spot, and notify level that a new spot is available */
		public void removeVehicle() { level.spotFreed();}
	}
}
