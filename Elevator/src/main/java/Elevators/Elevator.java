package Elevators;


import Elevators.State.ElevatorStat;
import Elevators.State.RestState;

public class Elevator {
	
	private int numberOfFloors = 0;
    private ElevatorStat elevatorState;
    private String id;
    private int currentFloor;
    
	public Elevator(int numberOfFloors, String id, int currentFloor) {
		
		this.elevatorState = new RestState(this);
		this.numberOfFloors = numberOfFloors;
		this.id = id;
		this.currentFloor = currentFloor;
	
	}

	public int  distanceFromFloor(int floor){
		return elevatorState.distanceFromFloor(floor);
	}

	public int getNumberOfFloors() {
		return numberOfFloors;
	}

	public void setNumberOfFloors(int numberOfFloors) {
		this.numberOfFloors = numberOfFloors;
	}

	public ElevatorStat getElevatorState() {
		return elevatorState;
	}

	public void setElevatorState(ElevatorStat elevatorState) {
		this.elevatorState = elevatorState;
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}

	public String getId() {
		return id;
	}
	
	
    
}
