package command;

import command.command.Command;
import command.command.NoCommand;

public class RemoteControl {

    private Command[] onCommands;

    private Command[] offCommands;
    
    private Command undoCommand;

    public RemoteControl() {
        onCommands = new Command[7];
        offCommands = new Command[7];

        // initialize all slots to NoCommand to avoid NPE
        Command defaultCommand = new NoCommand();
        for(int i = 0; i < 7; i++) {
            setCommand(i, defaultCommand, defaultCommand);
        }

        undoCommand = defaultCommand;
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonPushed(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    public void offButtonPushed(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\n----- Remote Control -----\n");

        for (int i = 0; i < onCommands.length; i++) {
            stringBuffer.append("[slot " + i + "] " + onCommands[i].getClass().getSimpleName() + "    " + offCommands[i].getClass().getSimpleName() + " \n");

        }

        stringBuffer.append("[undo] " + undoCommand.getClass().getSimpleName());

        return stringBuffer.toString();
    }

    public void undoButtonPushed() {
        undoCommand.undo();
    }
}
