package command;

import appareils.Device;

public class TurnOnComm implements Command {

    private Device device;

    public TurnOnComm(Device device) {
        this.device = device;
    }

    @Override
    public String execute() {
        return device.turnOn();
    }

    @Override
    public String undo() {
        return device.turnOff();
    }
}
