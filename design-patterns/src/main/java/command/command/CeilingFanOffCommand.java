package command.command;

import command.devices.CeilingFan;

public class CeilingFanOffCommand extends AbstractCeilingFanCommand {

    public CeilingFanOffCommand(CeilingFan ceilingFan) {
        super(ceilingFan);
    }

    @Override
    public void execute() {
        previousSpeed = ceilingFan.getSpeed();
        ceilingFan.off();
    }
}
