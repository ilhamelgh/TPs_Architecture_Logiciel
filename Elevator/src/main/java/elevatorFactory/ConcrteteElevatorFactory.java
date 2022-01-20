package elevatorFactory;

import Elevators.Elevator;

public class ConcrteteElevatorFactory extends ElevatorFactory{
	
	
	public static ConcrteteElevatorFactory _instance=null;
	private ConcrteteElevatorFactory(){}
	public static ConcrteteElevatorFactory getInstance(){
		if(_instance==null)
			return new ConcrteteElevatorFactory();
		return _instance;
	}
	
	
	@Override
	public Elevator createElevator(int numberOfFloors,String identifier) {
		
		String id = identifier.split(":")[0];
        int currentFloor = Integer.valueOf(identifier.split(":")[1]);
        return  new Elevator(numberOfFloors, id, currentFloor);

	}

}
