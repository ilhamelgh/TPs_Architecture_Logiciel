package Elevators.State;

import Elevators.Elevator;

public class StopState extends Elevators.State.ElevatorStat {

	public StopState(Elevator elevator) {
		super(elevator);
	}

	@Override
	public void down() {
		elevator.setElevatorState(new Elevators.State.DownState(elevator));
	}

	@Override
	public void up() {
		elevator.setElevatorState(new UpState(elevator));		
	}

	@Override
	public int distanceFromFloor(int floor) {
		return -1;
	}

	@Override
	public void rest() {
		elevator.setElevatorState(new Elevators.State.RestState(elevator));
	}

	@Override
	public void stop() {
		throw new IllegalStateException("elevator already stoping... ");		
	}

}
