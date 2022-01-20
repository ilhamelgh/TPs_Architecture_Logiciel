package Elevators.State;

import Elevators.Elevator;

public abstract class ElevatorStat {
	
	protected Elevator elevator;
	
	public ElevatorStat(Elevator elevator) {
		super();
		this.elevator = elevator;
	}

	/**
	 * four states are identified : down, up, stop, rest
	 */
	
	public abstract void down();
	public abstract void up();
	public abstract void rest();
	public abstract void stop();
	/**
	 * the flowing method calculate the distance form a giving floor, 
	 * the parameter of this method is the floor where an
	 * elevator is requested from. This distance depends on the state 
	 * of elevator
	 */
	public abstract int distanceFromFloor(int floor);

}
