package command.command;

import command.devices.SecurityControl;

public class SecurityControlOnCommand implements Command {

    private final SecurityControl securityControl;


    public SecurityControlOnCommand(SecurityControl securityControl) {
        this.securityControl = securityControl;
    }

    @Override
    public void execute() {
        securityControl.arm();
    }

    @Override
    public void undo() {
        securityControl.disarm();
    }
}
