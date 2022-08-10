package command.command;

import command.devices.ApplianceControl;

public class ApplianceControlOnCommand implements Command {

    private final ApplianceControl applianceControl;

    public ApplianceControlOnCommand(ApplianceControl applianceControl) {
        this.applianceControl = applianceControl;
    }

    @Override
    public void execute() {
        applianceControl.on();
    }

    @Override
    public void undo() {
        applianceControl.off();
    }
}
