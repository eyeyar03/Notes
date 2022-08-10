package command.command;

import command.devices.CeilingLight;

public class CeilingLightOnCommand implements Command {

    private final CeilingLight ceilingLight;

    public CeilingLightOnCommand(CeilingLight ceilingLight) {
        this.ceilingLight = ceilingLight;
    }

    @Override
    public void execute() {
        ceilingLight.on();
    }

    @Override
    public void undo() {
        ceilingLight.off();
    }
}
