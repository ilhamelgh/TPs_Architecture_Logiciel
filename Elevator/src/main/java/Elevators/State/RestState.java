package Elevators.State;

import Elevators.Elevator;

public class RestState extends ElevatorStat {

	public RestState(Elevator elevator) {
		super(elevator);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int distanceFromFloor(int floor){
		return Math.abs(floor - elevator.getCurrentFloor()); 
	}

	@Override
	public void down() {
		elevator.setElevatorState(new DownState(elevator));
	}

	@Override
	public void up() {
		elevator.setElevatorState(new UpState(elevator));
	}

	@Override
	public void rest() {
		throw new IllegalStateException("elevator already resting... ");
		
	}

	@Override
	public void stop() {
		elevator.setElevatorState(new StopState(elevator));
		
	}
	
}
