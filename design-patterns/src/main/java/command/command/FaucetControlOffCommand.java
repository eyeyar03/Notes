package command.command;

import command.devices.FaucetControl;

public class FaucetControlOffCommand implements Command {

    private final FaucetControl faucetControl;

    public FaucetControlOffCommand(FaucetControl faucetControl) {
        this.faucetControl = faucetControl;
    }

    @Override
    public void execute() {
        faucetControl.closeValve();
    }

    @Override
    public void undo() {
        faucetControl.openValve();
    }
}
