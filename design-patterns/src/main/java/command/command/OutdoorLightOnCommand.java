package command.command;

import command.devices.OutdoorLight;

public class OutdoorLightOnCommand implements Command {

    private final OutdoorLight outdoorLight;

    public OutdoorLightOnCommand(OutdoorLight outdoorLight) {
        this.outdoorLight = outdoorLight;
    }

    @Override
    public void execute() {
        outdoorLight.on();
    }

    @Override
    public void undo() {
        outdoorLight.off();
    }
}
