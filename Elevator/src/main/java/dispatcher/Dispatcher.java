package dispatcher;

import Elevators.Elevator;

import java.util.Map;

/**
*
* The dispatcher is responsible for deciding which elevator
* has to serve the client in a giving floor
*
*/

public class Dispatcher implements Idispatcher{
	
	private Map<String,Elevator> elevators;
	
	/**
	 * Implementation of singleton pattern for Dispatcher class
	 */
	public static Dispatcher _instance=null;
	private Dispatcher(){}
	public static Dispatcher getInstance(){
		if(_instance==null)
			return new Dispatcher();
		return _instance;
	}
	
	/**
	 * initiate an instance of dispatcher to decide about 
	 * a list of elevators
	 */
	
	public void init(Map<String, Elevator> elevatorsMap) {
        this.elevators = elevatorsMap;
    }
	
	
	
	/**
	 * the flowing method identify which elevator will be served once a request
     * for an elevator is registered.
	 * this method select the closed elevator from a giving floor.
     * The closed elevator is the one having the minimum distance from 
     * a giving floor. This distance depends on the elevator state. 
	 * So the methods calculating this distance is implemented in 
	 * the state classes.
	 */

	public String getIdClosedFromFloor(int floor){
        int distMin = 10;
        String idClosed=null;
		for(String id : elevators.keySet())
		{	
			if (      /* elevator is not in stop state */
					elevators.get(id).getElevatorState().distanceFromFloor(floor) != -1 && 
					elevators.get(id).getElevatorState().distanceFromFloor(floor) <= distMin)
			{
			  distMin = elevators.get(id).getElevatorState().distanceFromFloor(floor);
			  idClosed = id;
			}
		}	
		return idClosed;
	}

	public Map<String, Elevator> getElevators() {
		return elevators;
	}

	public void setElevators(Map<String, Elevator> elevators) {
		this.elevators = elevators;
	}

}
