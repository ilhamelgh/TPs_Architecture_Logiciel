package dispatcher;

import Elevators.Elevator;

import java.util.Map;

public interface Idispatcher {
	
	public String getIdClosedFromFloor(int floor);
	public void init(Map<String, Elevator> elevatorsMap);

}
