package invoker;

import command.TurnOffComm;
import command.TurnOnComm;
import appareils.Device;

import java.util.HashMap;

public class RemoteControl {

    private int nbrSlot;

    private String report="";

    private HashMap<Integer, Device> slots = new HashMap<>();

    public RemoteControl(int nbrSlot) {
        this.nbrSlot = nbrSlot;
    }

    public String getReport() {
        return this.report;
    }

    public void init(Device... devices) {
        int id = 0;
        for (Device device : devices) {
            slots.put(id, device);
            id++;
        }
    }

    public void onButtonPressed(int id) {
        TurnOnComm turnOn = new TurnOnComm(slots.get(id));
        this.report += turnOn.execute() + "-";
    }

    public void offButtonPressed(int id) {
        TurnOffComm turnOff = new TurnOffComm(slots.get(id));
        this.report += turnOff.execute() + "-";
    }
}
