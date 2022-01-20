package Elevators.State;


import Elevators.Elevator;

public class DownState extends ElevatorStat{

	public DownState(Elevator elevator) {
		super(elevator);
	}

	@Override
	public int distanceFromFloor(int floor) {
		if(floor > elevator.getCurrentFloor())
			return floor + elevator.getNumberOfFloors() - elevator.getCurrentFloor();
		return elevator.getCurrentFloor()-floor; 
	}

	@Override
	public void down(){
		throw new IllegalStateException("elevator already going down... ");
	}

	@Override
	public void up() {
		throw new IllegalStateException("elevator is going down it can't switch direction ... ");
	}

	@Override
	public void rest() {
		elevator.setElevatorState(new RestState(elevator));	
		
	}

	@Override
	public void stop() {
		elevator.setElevatorState(new StopState(elevator));
		
	}	
}
