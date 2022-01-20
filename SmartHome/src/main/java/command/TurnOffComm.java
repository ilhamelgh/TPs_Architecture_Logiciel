package command;

import appareils.Device;

public class TurnOffComm implements Command {

    private Device device;

    public TurnOffComm(Device device) {
        this.device = device;
    }

    @Override
    public String execute() {
        return device.turnOff();
    }

    @Override
    public String undo() {
        return device.turnOn();
    }
}
