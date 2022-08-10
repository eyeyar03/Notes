package command.command;

import command.devices.Stereo;

public class StereoWithCDOnCommand implements Command {

    private final Stereo stereo;

    public StereoWithCDOnCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.on();
        stereo.setCd();
        stereo.setVolume(11);
    }

    @Override
    public void undo() {
        stereo.off();
    }
}
