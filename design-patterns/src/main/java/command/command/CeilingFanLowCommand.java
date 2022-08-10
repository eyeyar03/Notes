package command.command;

import command.devices.CeilingFan;

public class CeilingFanLowCommand extends AbstractCeilingFanCommand{

    public CeilingFanLowCommand(CeilingFan ceilingFan) {
        super(ceilingFan);
    }

    @Override
    public void execute() {
        previousSpeed = ceilingFan.getSpeed();
        ceilingFan.low();
    }
}
