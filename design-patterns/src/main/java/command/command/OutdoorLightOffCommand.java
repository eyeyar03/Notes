package command.command;

import command.devices.OutdoorLight;

public class OutdoorLightOffCommand implements Command {

    private final OutdoorLight outdoorLight;

    public OutdoorLightOffCommand(OutdoorLight outdoorLight) {
        this.outdoorLight = outdoorLight;
    }

    @Override
    public void execute() {
        outdoorLight.off();
    }

    @Override
    public void undo() {
        outdoorLight.on();
    }
}
