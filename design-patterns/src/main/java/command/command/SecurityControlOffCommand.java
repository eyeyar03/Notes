package command.command;

import command.devices.SecurityControl;

public class SecurityControlOffCommand implements Command {

    private final SecurityControl securityControl;

    public SecurityControlOffCommand(SecurityControl securityControl) {
        this.securityControl = securityControl;
    }

    @Override
    public void execute() {
        securityControl.disarm();

    }

    @Override
    public void undo() {
        securityControl.arm();
    }
}
