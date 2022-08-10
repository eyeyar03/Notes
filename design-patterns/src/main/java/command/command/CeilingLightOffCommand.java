package command.command;

import command.devices.CeilingLight;

public class CeilingLightOffCommand implements Command {

    private final CeilingLight ceilingLight;

    public CeilingLightOffCommand(CeilingLight ceilingLight) {
        this.ceilingLight = ceilingLight;
    }

    @Override
    public void execute() {
        ceilingLight.off();
    }

    @Override
    public void undo() {
        ceilingLight.on();
    }
}
