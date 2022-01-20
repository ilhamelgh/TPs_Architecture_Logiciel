package Elevators;

import dispatcher.Dispatcher;
import dispatcher.Idispatcher;
import elevatorFactory.ConcrteteElevatorFactory;
import elevatorFactory.ElevatorFactory;


import java.util.HashMap;
import java.util.Map;

/**
 * Building.
 *
 * @author Mohamed El yaakoubi
 */

public class Building {
	
	private Map<String , Elevator> elevators;
	
	private ElevatorFactory elevatorFactory = ConcrteteElevatorFactory.getInstance();
	/**
	 * the decision, about which elevator will be served, is delegated to 
	 * an instance of Dispatcher class
	 */
	private Idispatcher dispatcher=Dispatcher.getInstance();
	
	private int numberOfFloors;
	
	/**
     * @param numberOfFloors: the number of floors in the building
     * @param elevators: an array of descriptions of the elevators of the building. 
     *                   the format of a description "[elevator_id]:[elevator_current_floor]".
     */
	
	public Building(int numberOfFloors, String... elevators) {
		this.numberOfFloors = numberOfFloors;
        this.elevators = new HashMap<>();
     
        for (String elevator : elevators) {
//            String id = elevator.split(":")[0];
//            int currentFloor = Integer.valueOf(elevator.split(":")[1]);
//            Elevator e = new Elevator(numberOfFloors, id, currentFloor);
        	
        	Elevator e = elevatorFactory.createElevator(numberOfFloors, elevator);
            this.elevators.put(e.getId(), e);
        }
        dispatcher.init(this.elevators);
     }
	
	/**
	 * An elevator is requested by default from top floor.  
	 */
	
	public String requestElevator()
	{  	
		return dispatcher.getIdClosedFromFloor(numberOfFloors);
	}
	
	 /**
     * Request an elevator at floor indicate by the {@code floor} param.
     * @param floor : the floor where the request is made.
     * @return the id of the elevator that should serve the request.
     */
	
	public String requestElevator(int floor)
	{
		return dispatcher.getIdClosedFromFloor(floor);
	}
	

	/**
     * Move the elevator with the id {@code elevatorId} in the direction indicated by the {@code direction} param.
     * @param elevatorId : the id of the elevator to move.
     * @param direction : the direction can be "UP" or "DOWN".
     */

	public void move(String elevatorId,String direction){
		Elevator elevator = elevators.get(elevatorId);
		switch (direction) {
        case "UP":
            elevator.getElevatorState().up();
            break;
        case  "DOWN":
            elevator.getElevatorState().down();
            break;
        default :
            throw new IllegalArgumentException("An elevator can move only UP or Down.");
    }
}
	
	/**
     * Request the elevator with the id {@code elevatorId} to stop at 
     * the floor indicated by the {@code floor} param.
     */
		public void stopAt(String elevatorId, int floor){
			Elevator elevator = elevators.get(elevatorId);
			elevator.setCurrentFloor(floor);
			elevator.getElevatorState().stop();
		}
		
	public Map<String, Elevator> getElevators() {
		return elevators;
	}

	public void setElevators(Map<String, Elevator> elevators) {
		this.elevators = elevators;
	}
	
}
