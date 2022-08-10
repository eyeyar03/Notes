package command.command;

import command.devices.ApplianceControl;

public class ApplianceControlOffCommand implements Command {

    private final ApplianceControl applianceControl;

    public ApplianceControlOffCommand(ApplianceControl applianceControl) {
        this.applianceControl = applianceControl;
    }

    @Override
    public void execute() {
        applianceControl.off();
    }

    @Override
    public void undo() {
        applianceControl.on();
    }
}
