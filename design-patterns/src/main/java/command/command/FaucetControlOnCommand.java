package command.command;

import command.devices.FaucetControl;

public class FaucetControlOnCommand implements Command {

    private final FaucetControl faucetControl;

    public FaucetControlOnCommand(FaucetControl faucetControl) {
        this.faucetControl = faucetControl;
    }

    @Override
    public void execute() {
        faucetControl.openValve();
    }

    @Override
    public void undo() {
        faucetControl.closeValve();
    }
}
