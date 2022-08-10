package command.command;

import command.devices.CeilingFan;

public class CeilingFanMediumCommand extends AbstractCeilingFanCommand {

    public CeilingFanMediumCommand(CeilingFan ceilingFan) {
        super(ceilingFan);
    }

    @Override
    public void execute() {
        previousSpeed = ceilingFan.getSpeed();
        ceilingFan.medium();
    }
}
