package command.command;

import command.devices.CeilingFan;

public abstract class AbstractCeilingFanCommand implements Command {

    protected final CeilingFan ceilingFan;

    protected CeilingFan.Speed previousSpeed;


    public AbstractCeilingFanCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void undo() {
        if (previousSpeed == CeilingFan.Speed.HIGH) {
            ceilingFan.high();

        } else if (previousSpeed == CeilingFan.Speed.MEDIUM) {
            ceilingFan.medium();

        } else if (previousSpeed == CeilingFan.Speed.LOW) {
            ceilingFan.low();

        } else if (previousSpeed == CeilingFan.Speed.OFF) {
            ceilingFan.off();
        }
    }
}
