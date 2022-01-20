package elevatorFactory;

import Elevators.Elevator;

public abstract class ElevatorFactory {
	
	/*
	 * identifier : string that identify the elevator [elevator_id]:[elevator_current_floor]
	 */
	public abstract Elevator createElevator(int numberOfFloors,String identifier);

}
