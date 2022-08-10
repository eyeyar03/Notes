package command;

import command.command.ApplianceControlOffCommand;
import command.command.ApplianceControlOnCommand;
import command.command.CeilingFanHighCommand;
import command.command.CeilingFanLowCommand;
import command.command.CeilingFanMediumCommand;
import command.command.CeilingFanOffCommand;
import command.command.CeilingLightOffCommand;
import command.command.CeilingLightOnCommand;
import command.command.Command;
import command.command.FaucetControlOffCommand;
import command.command.FaucetControlOnCommand;
import command.command.GarageDoorOffCommand;
import command.command.GarageDoorOnCommand;
import command.command.MacroCommand;
import command.command.OutdoorLightOffCommand;
import command.command.OutdoorLightOnCommand;
import command.command.SecurityControlOffCommand;
import command.command.SecurityControlOnCommand;
import command.command.StereoOffCommand;
import command.command.StereoWithCDOnCommand;
import command.devices.ApplianceControl;
import command.devices.CeilingFan;
import command.devices.CeilingLight;
import command.devices.FaucetControl;
import command.devices.GarageDoor;
import command.devices.OutdoorLight;
import command.devices.SecurityControl;
import command.devices.Stereo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

public class CommandTest {

    private ApplianceControl applianceControl;

    private CeilingFan ceilingFan;

    private CeilingLight ceilingLight;

    private FaucetControl faucetControl;

    private GarageDoor garageDoor;

    private OutdoorLight outdoorLight;

    private SecurityControl securityControl;

    private Stereo stereo;


    @BeforeEach
    public void setup() {
        applianceControl = Mockito.mock(ApplianceControl.class);
        ceilingFan = Mockito.mock(CeilingFan.class);
        ceilingLight = Mockito.mock(CeilingLight.class);
        faucetControl = Mockito.mock(FaucetControl.class);
        garageDoor = Mockito.mock(GarageDoor.class);
        outdoorLight = Mockito.mock(OutdoorLight.class);
        securityControl = Mockito.mock(SecurityControl.class);
        stereo = Mockito.mock(Stereo.class);
    }

    @Test
    public void testApplianceControlOnCommand() {
        Command command = new ApplianceControlOnCommand(applianceControl);
        command.execute();

        Mockito.verify(applianceControl, Mockito.times(1)).on();
    }

    @Test
    public void testApplianceControlOffCommand() {
        Command command = new ApplianceControlOffCommand(applianceControl);
        command.execute();

        Mockito.verify(applianceControl, Mockito.times(1)).off();
    }

    @Test
    public void turnOnApplianceControlViaRemoteControl() {
        Command onCommand = new ApplianceControlOnCommand(applianceControl);
        Command offCommand = new ApplianceControlOffCommand(applianceControl);

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(0, onCommand, offCommand);

        remoteControl.onButtonPushed(0);

        Mockito.verify(applianceControl, Mockito.times(1)).on();
        Mockito.verify(applianceControl, Mockito.times(0)).off();
    }

    @Test
    public void turnOffApplianceControlViaRemoteControl() {
        Command onCommand = new ApplianceControlOnCommand(applianceControl);
        Command offCommand = new ApplianceControlOffCommand(applianceControl);

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(0, onCommand, offCommand);

        remoteControl.offButtonPushed(0);

        Mockito.verify(applianceControl, Mockito.times(0)).on();
        Mockito.verify(applianceControl, Mockito.times(1)).off();
    }

    @Test
    public void testCeilingFanLowCommand() {
        Command command = new CeilingFanLowCommand(ceilingFan);
        command.execute();

        Mockito.verify(ceilingFan, Mockito.times(1)).low();
    }

    @Test
    public void testCeilingFanMediumCommand() {
        Command command = new CeilingFanMediumCommand(ceilingFan);
        command.execute();

        Mockito.verify(ceilingFan, Mockito.times(1)).medium();
    }

    @Test
    public void testCeilingFanHighCommand() {
        Command command = new CeilingFanHighCommand(ceilingFan);
        command.execute();

        Mockito.verify(ceilingFan, Mockito.times(1)).high();
    }

    @Test
    public void testCeilingFanOffCommand() {
        Command command = new CeilingFanOffCommand(ceilingFan);
        command.execute();

        Mockito.verify(ceilingFan, Mockito.times(1)).off();
    }

    @Test
    public void testCeilingLightOnCommand() {
        Command command = new CeilingLightOnCommand(ceilingLight);
        command.execute();

        Mockito.verify(ceilingLight, Mockito.times(1)).on();
    }

    @Test
    public void testCeilingLightOffCommand() {
        Command command = new CeilingLightOffCommand(ceilingLight);
        command.execute();

        Mockito.verify(ceilingLight, Mockito.times(1)).off();
    }

    @Test
    public void turnOnCeilingLightViaRemoteControl() {
        Command onCommand = new CeilingLightOnCommand(ceilingLight);
        Command offCommand = new CeilingLightOffCommand(ceilingLight);

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(0, onCommand, offCommand);

        remoteControl.onButtonPushed(0);

        Mockito.verify(ceilingLight, Mockito.times(1)).on();
        Mockito.verify(ceilingLight, Mockito.times(0)).off();
    }

    @Test
    public void turnOffCeilingLightViaRemoteControl() {
        Command onCommand = new CeilingLightOnCommand(ceilingLight);
        Command offCommand = new CeilingLightOffCommand(ceilingLight);

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(0, onCommand, offCommand);

        remoteControl.offButtonPushed(0);

        Mockito.verify(ceilingLight, Mockito.times(0)).on();
        Mockito.verify(ceilingLight, Mockito.times(1)).off();
    }

    @Test
    public void testFaucetControlOnCommand() {
        Command command = new FaucetControlOnCommand(faucetControl);
        command.execute();

        Mockito.verify(faucetControl, Mockito.times(1)).openValve();
    }

    @Test
    public void testFaucetControlOffCommand() {
        Command command = new FaucetControlOffCommand(faucetControl);
        command.execute();

        Mockito.verify(faucetControl, Mockito.times(1)).closeValve();
    }

    @Test
    public void turnOnFaucetControlViaRemoteControl() {
        Command onCommand = new FaucetControlOnCommand(faucetControl);
        Command offCommand = new FaucetControlOffCommand(faucetControl);

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(0, onCommand, offCommand);

        remoteControl.onButtonPushed(0);

        Mockito.verify(faucetControl, Mockito.times(1)).openValve();
        Mockito.verify(faucetControl, Mockito.times(0)).closeValve();
    }

    @Test
    public void turnOffFaucetControlViaRemoteControl() {
        Command onCommand = new FaucetControlOnCommand(faucetControl);
        Command offCommand = new FaucetControlOffCommand(faucetControl);

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(0, onCommand, offCommand);

        remoteControl.offButtonPushed(0);

        Mockito.verify(faucetControl, Mockito.times(0)).openValve();
        Mockito.verify(faucetControl, Mockito.times(1)).closeValve();
    }

    @Test
    public void testGarageDoorOnCommand() {
        Command command = new GarageDoorOnCommand(garageDoor);
        command.execute();

        Mockito.verify(garageDoor, Mockito.times(1)).up();
    }

    @Test
    public void testGarageDoorOffCommand() {
        Command command = new GarageDoorOffCommand(garageDoor);
        command.execute();

        Mockito.verify(garageDoor, Mockito.times(1)).down();
    }

    @Test
    public void turnOnGarageDoorViaRemoteControl() {
        Command onCommand = new GarageDoorOnCommand(garageDoor);
        Command offCommand = new GarageDoorOffCommand(garageDoor);

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(0, onCommand, offCommand);

        remoteControl.onButtonPushed(0);

        Mockito.verify(garageDoor, Mockito.times(1)).up();
        Mockito.verify(garageDoor, Mockito.times(0)).down();
    }

    @Test
    public void turnOffGarageDoorViaRemoteControl() {
        Command onCommand = new GarageDoorOnCommand(garageDoor);
        Command offCommand = new GarageDoorOffCommand(garageDoor);

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(0, onCommand, offCommand);

        remoteControl.offButtonPushed(0);

        Mockito.verify(garageDoor, Mockito.times(0)).up();
        Mockito.verify(garageDoor, Mockito.times(1)).down();
    }

    @Test
    public void testOutdoorLightOnCommand() {
        Command command = new OutdoorLightOnCommand(outdoorLight);
        command.execute();

        Mockito.verify(outdoorLight, Mockito.times(1)).on();
    }

    @Test
    public void testOutdoorLightOffCommand() {
        Command command = new OutdoorLightOffCommand(outdoorLight);
        command.execute();

        Mockito.verify(outdoorLight, Mockito.times(1)).off();
    }

    @Test
    public void turnOnOutdoorLightViaRemoteControl() {
        Command onCommand = new OutdoorLightOnCommand(outdoorLight);
        Command offCommand = new OutdoorLightOffCommand(outdoorLight);

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(0, onCommand, offCommand);

        remoteControl.onButtonPushed(0);

        Mockito.verify(outdoorLight, Mockito.times(1)).on();
        Mockito.verify(outdoorLight, Mockito.times(0)).off();
    }

    @Test
    public void turnOffOutdoorLightViaRemoteControl() {
        Command onCommand = new OutdoorLightOnCommand(outdoorLight);
        Command offCommand = new OutdoorLightOffCommand(outdoorLight);

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(0, onCommand, offCommand);

        remoteControl.offButtonPushed(0);

        Mockito.verify(outdoorLight, Mockito.times(0)).on();
        Mockito.verify(outdoorLight, Mockito.times(1)).off();
    }

    @Test
    public void testSecurityControlOnCommand() {
        Command command = new SecurityControlOnCommand(securityControl);
        command.execute();

        Mockito.verify(securityControl, Mockito.times(1)).arm();
    }

    @Test
    public void testSecurityControlOffCommand() {
        Command command = new SecurityControlOffCommand(securityControl);
        command.execute();

        Mockito.verify(securityControl, Mockito.times(1)).disarm();
    }

    @Test
    public void turnOnSecurityControlViaRemoteControl() {
        Command onCommand = new SecurityControlOnCommand(securityControl);
        Command offCommand = new SecurityControlOffCommand(securityControl);

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(0, onCommand, offCommand);

        remoteControl.onButtonPushed(0);

        Mockito.verify(securityControl, Mockito.times(1)).arm();
        Mockito.verify(securityControl, Mockito.times(0)).disarm();
    }

    @Test
    public void turnOffSecurityControlViaRemoteControl() {
        Command onCommand = new SecurityControlOnCommand(securityControl);
        Command offCommand = new SecurityControlOffCommand(securityControl);

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(0, onCommand, offCommand);

        remoteControl.offButtonPushed(0);

        Mockito.verify(securityControl, Mockito.times(0)).arm();
        Mockito.verify(securityControl, Mockito.times(1)).disarm();
    }

    @Test
    public void testStereoWithCDOnCommand() {
        Command command = new StereoWithCDOnCommand(stereo);
        command.execute();

        Mockito.verify(stereo, Mockito.times(1)).on();
        Mockito.verify(stereo, Mockito.times(1)).setCd();
        Mockito.verify(stereo, Mockito.times(1)).setVolume(11);
    }

    @Test
    public void testStereoOffCommand() {
        Command command = new StereoOffCommand(stereo);
        command.execute();

        Mockito.verify(stereo, Mockito.times(1)).off();
    }

    @Test
    public void turnOnStereoWithCDViaRemoteControl() {
        Command onCommand = new StereoWithCDOnCommand(stereo);
        Command offCommand = new StereoOffCommand(stereo);

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(0, onCommand, offCommand);

        remoteControl.onButtonPushed(0);

        Mockito.verify(stereo, Mockito.times(1)).on();
        Mockito.verify(stereo, Mockito.times(1)).setCd();
        Mockito.verify(stereo, Mockito.times(1)).setVolume(11);
        Mockito.verify(stereo, Mockito.times(0)).off();
    }

    @Test
    public void turnOffStereoWithCDViaRemoteControl() {
        Command onCommand = new StereoWithCDOnCommand(stereo);
        Command offCommand = new StereoOffCommand(stereo);

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(0, onCommand, offCommand);

        remoteControl.offButtonPushed(0);

        Mockito.verify(stereo, Mockito.times(0)).on();
        Mockito.verify(stereo, Mockito.times(0)).setCd();
        Mockito.verify(stereo, Mockito.times(0)).setVolume(11);
        Mockito.verify(stereo, Mockito.times(1)).off();
    }

    @Test
    public void testInitialStateOfRemoteControl() {
        StringBuilder expectation = new StringBuilder();
        expectation.append("\n----- Remote Control -----\n");
        expectation.append("[slot 0] NoCommand    NoCommand \n");
        expectation.append("[slot 1] NoCommand    NoCommand \n");
        expectation.append("[slot 2] NoCommand    NoCommand \n");
        expectation.append("[slot 3] NoCommand    NoCommand \n");
        expectation.append("[slot 4] NoCommand    NoCommand \n");
        expectation.append("[slot 5] NoCommand    NoCommand \n");
        expectation.append("[slot 6] NoCommand    NoCommand \n");
        expectation.append("[undo] NoCommand");

        RemoteControl remoteControl = new RemoteControl();

        assertThat(remoteControl.toString()).isEqualTo(expectation.toString());
    }

    @Test
    public void loadRemoteControlSlots() {
        StringBuilder expectation = new StringBuilder();
        expectation.append("\n----- Remote Control -----\n");
        expectation.append("[slot 0] ApplianceControlOnCommand    ApplianceControlOffCommand \n");
        expectation.append("[slot 1] CeilingLightOnCommand    CeilingLightOffCommand \n");
        expectation.append("[slot 2] FaucetControlOnCommand    FaucetControlOffCommand \n");
        expectation.append("[slot 3] GarageDoorOnCommand    GarageDoorOffCommand \n");
        expectation.append("[slot 4] OutdoorLightOnCommand    OutdoorLightOffCommand \n");
        expectation.append("[slot 5] SecurityControlOnCommand    SecurityControlOffCommand \n");
        expectation.append("[slot 6] StereoWithCDOnCommand    StereoOffCommand \n");
        expectation.append("[undo] NoCommand");

        RemoteControl remoteControl = getRemoteControlWithLoadedSlots();

        assertThat(remoteControl.toString()).isEqualTo(expectation.toString());
    }

    @Test
    public void testRemoteControlWithLoadedSlots_applianceControl_on() {
        RemoteControl remoteControl = getRemoteControlWithLoadedSlots();

        remoteControl.onButtonPushed(0);

        verify(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    }

    @Test
    public void testRemoteControlWithLoadedSlots_applianceControl_off() {
        RemoteControl remoteControl = getRemoteControlWithLoadedSlots();

        remoteControl.offButtonPushed(0);

        verify(0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    }

    @Test
    public void testRemoteControlWithLoadedSlots_ceilingLight_on() {
        RemoteControl remoteControl = getRemoteControlWithLoadedSlots();

        remoteControl.onButtonPushed(1);

        verify(0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    }

    @Test
    public void testRemoteControlWithLoadedSlots_ceilingLight_off() {
        RemoteControl remoteControl = getRemoteControlWithLoadedSlots();

        remoteControl.offButtonPushed(1);

        verify(0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    }

    @Test
    public void testRemoteControlWithLoadedSlots_faucetControl_on() {
        RemoteControl remoteControl = getRemoteControlWithLoadedSlots();

        remoteControl.onButtonPushed(2);

        verify(0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    }

    @Test
    public void testRemoteControlWithLoadedSlots_faucetControl_off() {
        RemoteControl remoteControl = getRemoteControlWithLoadedSlots();

        remoteControl.offButtonPushed(2);

        verify(0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    }

    @Test
    public void testRemoteControlWithLoadedSlots_garageDoor_on() {
        RemoteControl remoteControl = getRemoteControlWithLoadedSlots();

        remoteControl.onButtonPushed(3);

        verify(0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    }

    @Test
    public void testRemoteControlWithLoadedSlots_garageDoor_off() {
        RemoteControl remoteControl = getRemoteControlWithLoadedSlots();

        remoteControl.offButtonPushed(3);

        verify(0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0);
    }

    @Test
    public void testRemoteControlWithLoadedSlots_outdoorLight_on() {
        RemoteControl remoteControl = getRemoteControlWithLoadedSlots();

        remoteControl.onButtonPushed(4);

        verify(0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);
    }

    @Test
    public void testRemoteControlWithLoadedSlots_outdoorLight_off() {
        RemoteControl remoteControl = getRemoteControlWithLoadedSlots();

        remoteControl.offButtonPushed(4);

        verify(0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0);
    }

    @Test
    public void testRemoteControlWithLoadedSlots_securityControl_on() {
        RemoteControl remoteControl = getRemoteControlWithLoadedSlots();

        remoteControl.onButtonPushed(5);

        verify(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0);
    }

    @Test
    public void testRemoteControlWithLoadedSlots_securityControl_off() {
        RemoteControl remoteControl = getRemoteControlWithLoadedSlots();

        remoteControl.offButtonPushed(5);

        verify(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0);
    }

    @Test
    public void testRemoteControlWithLoadedSlots_sterioWithCD_on() {
        RemoteControl remoteControl = getRemoteControlWithLoadedSlots();

        remoteControl.onButtonPushed(6);

        verify(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0);
    }

    @Test
    public void testRemoteControlWithLoadedSlots_sterio_off() {
        RemoteControl remoteControl = getRemoteControlWithLoadedSlots();

        remoteControl.offButtonPushed(6);

        verify(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);
    }

    @Test
    public void testUndo() {
        CeilingFan ceilingFan = new CeilingFan("Bedroom");
        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(0, new CeilingFanLowCommand(ceilingFan), new CeilingFanOffCommand(ceilingFan));
        remoteControl.setCommand(1, new CeilingFanMediumCommand(ceilingFan), new CeilingFanOffCommand(ceilingFan));
        remoteControl.setCommand(2, new CeilingFanHighCommand(ceilingFan), new CeilingFanOffCommand(ceilingFan));

        StringBuilder expectation = new StringBuilder();
        expectation.append("\n----- Remote Control -----\n");
        expectation.append("[slot 0] CeilingFanLowCommand    CeilingFanOffCommand \n");
        expectation.append("[slot 1] CeilingFanMediumCommand    CeilingFanOffCommand \n");
        expectation.append("[slot 2] CeilingFanHighCommand    CeilingFanOffCommand \n");
        expectation.append("[slot 3] NoCommand    NoCommand \n");
        expectation.append("[slot 4] NoCommand    NoCommand \n");
        expectation.append("[slot 5] NoCommand    NoCommand \n");
        expectation.append("[slot 6] NoCommand    NoCommand \n");
        expectation.append("[undo] NoCommand");

        assertThat(ceilingFan.getSpeed()).isEqualTo(CeilingFan.Speed.OFF);
        assertThat(remoteControl.toString()).isEqualTo(expectation.toString());

        remoteControl.onButtonPushed(1);
        assertThat(ceilingFan.getSpeed()).isEqualTo(CeilingFan.Speed.MEDIUM);

        remoteControl.onButtonPushed(2);
        assertThat(ceilingFan.getSpeed()).isEqualTo(CeilingFan.Speed.HIGH);

        remoteControl.undoButtonPushed();

        expectation = new StringBuilder();
        expectation.append("\n----- Remote Control -----\n");
        expectation.append("[slot 0] CeilingFanLowCommand    CeilingFanOffCommand \n");
        expectation.append("[slot 1] CeilingFanMediumCommand    CeilingFanOffCommand \n");
        expectation.append("[slot 2] CeilingFanHighCommand    CeilingFanOffCommand \n");
        expectation.append("[slot 3] NoCommand    NoCommand \n");
        expectation.append("[slot 4] NoCommand    NoCommand \n");
        expectation.append("[slot 5] NoCommand    NoCommand \n");
        expectation.append("[slot 6] NoCommand    NoCommand \n");
        expectation.append("[undo] CeilingFanHighCommand");

        assertThat(ceilingFan.getSpeed()).isEqualTo(CeilingFan.Speed.MEDIUM);
        assertThat(remoteControl.toString()).isEqualTo(expectation.toString());

        remoteControl.offButtonPushed(0);
        assertThat(ceilingFan.getSpeed()).isEqualTo(CeilingFan.Speed.OFF);

        remoteControl.onButtonPushed(0);
        assertThat(ceilingFan.getSpeed()).isEqualTo(CeilingFan.Speed.LOW);

        remoteControl.undoButtonPushed();

        expectation = new StringBuilder();
        expectation.append("\n----- Remote Control -----\n");
        expectation.append("[slot 0] CeilingFanLowCommand    CeilingFanOffCommand \n");
        expectation.append("[slot 1] CeilingFanMediumCommand    CeilingFanOffCommand \n");
        expectation.append("[slot 2] CeilingFanHighCommand    CeilingFanOffCommand \n");
        expectation.append("[slot 3] NoCommand    NoCommand \n");
        expectation.append("[slot 4] NoCommand    NoCommand \n");
        expectation.append("[slot 5] NoCommand    NoCommand \n");
        expectation.append("[slot 6] NoCommand    NoCommand \n");
        expectation.append("[undo] CeilingFanLowCommand");

        assertThat(ceilingFan.getSpeed()).isEqualTo(CeilingFan.Speed.OFF);
        assertThat(remoteControl.toString()).isEqualTo(expectation.toString());
    }

    @Test
    public void testMacroCommand_on() {
        Command ceilingFanHighCommand = new CeilingFanHighCommand(ceilingFan);
        Command ceilingLightOnCommand = new CeilingLightOnCommand(ceilingLight);
        Command securityControlOnCommand = new SecurityControlOnCommand(securityControl);
        Command stereoWithCDOnCommand = new StereoWithCDOnCommand(stereo);

        Command ceilingFanOffCommand = new CeilingFanOffCommand(ceilingFan);
        Command ceilingLightOffCommand = new CeilingLightOffCommand(ceilingLight);
        Command securityControlOffCommand = new SecurityControlOffCommand(securityControl);
        Command stereoOffCommand = new StereoOffCommand(stereo);

        Command partyOnMacroCommand = new MacroCommand(ceilingFanHighCommand, ceilingLightOnCommand, securityControlOnCommand, stereoWithCDOnCommand);
        Command partyOffMacroCommand = new MacroCommand(ceilingFanOffCommand, ceilingLightOffCommand, securityControlOffCommand, stereoOffCommand);

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(0, partyOnMacroCommand, partyOffMacroCommand);

        remoteControl.onButtonPushed(0);

        Mockito.verify(ceilingFan, Mockito.times(1)).high();
        Mockito.verify(ceilingLight, Mockito.times(1)).on();
        Mockito.verify(securityControl, Mockito.times(1)).arm();
        Mockito.verify(stereo, Mockito.times(1)).on();
        Mockito.verify(stereo, Mockito.times(1)).setCd();
        Mockito.verify(stereo, Mockito.times(1)).setVolume(11);

        Mockito.verify(ceilingFan, Mockito.times(0)).off();
        Mockito.verify(ceilingLight, Mockito.times(0)).off();
        Mockito.verify(securityControl, Mockito.times(0)).disarm();
        Mockito.verify(stereo, Mockito.times(0)).off();
    }

    @Test
    public void testMacroCommand_off() {
        Command ceilingFanHighCommand = new CeilingFanHighCommand(ceilingFan);
        Command ceilingLightOnCommand = new CeilingLightOnCommand(ceilingLight);
        Command securityControlOnCommand = new SecurityControlOnCommand(securityControl);
        Command stereoWithCDOnCommand = new StereoWithCDOnCommand(stereo);

        Command ceilingFanOffCommand = new CeilingFanOffCommand(ceilingFan);
        Command ceilingLightOffCommand = new CeilingLightOffCommand(ceilingLight);
        Command securityControlOffCommand = new SecurityControlOffCommand(securityControl);
        Command stereoOffCommand = new StereoOffCommand(stereo);

        Command partyOnMacroCommand = new MacroCommand(ceilingFanHighCommand, ceilingLightOnCommand, securityControlOnCommand, stereoWithCDOnCommand);
        Command partyOffMacroCommand = new MacroCommand(ceilingFanOffCommand, ceilingLightOffCommand, securityControlOffCommand, stereoOffCommand);

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(0, partyOnMacroCommand, partyOffMacroCommand);

        remoteControl.offButtonPushed(0);

        Mockito.verify(ceilingFan, Mockito.times(0)).high();
        Mockito.verify(ceilingLight, Mockito.times(0)).on();
        Mockito.verify(securityControl, Mockito.times(0)).arm();
        Mockito.verify(stereo, Mockito.times(0)).on();
        Mockito.verify(stereo, Mockito.times(0)).setCd();
        Mockito.verify(stereo, Mockito.times(0)).setVolume(11);

        Mockito.verify(ceilingFan, Mockito.times(1)).off();
        Mockito.verify(ceilingLight, Mockito.times(1)).off();
        Mockito.verify(securityControl, Mockito.times(1)).disarm();
        Mockito.verify(stereo, Mockito.times(1)).off();
    }

    @Test
    public void testMacroCommand_undo() {
        CeilingFan ceilingFan = new CeilingFan("Living Room");
        Command ceilingFanHighCommand = new CeilingFanHighCommand(ceilingFan);
        Command ceilingLightOnCommand = new CeilingLightOnCommand(ceilingLight);
        Command securityControlOnCommand = new SecurityControlOnCommand(securityControl);
        Command stereoWithCDOnCommand = new StereoWithCDOnCommand(stereo);

        Command ceilingFanOffCommand = new CeilingFanOffCommand(ceilingFan);
        Command ceilingLightOffCommand = new CeilingLightOffCommand(ceilingLight);
        Command securityControlOffCommand = new SecurityControlOffCommand(securityControl);
        Command stereoOffCommand = new StereoOffCommand(stereo);

        Command partyOnMacroCommand = new MacroCommand(ceilingFanHighCommand, ceilingLightOnCommand, securityControlOnCommand, stereoWithCDOnCommand);
        Command partyOffMacroCommand = new MacroCommand(ceilingFanOffCommand, ceilingLightOffCommand, securityControlOffCommand, stereoOffCommand);

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(0, partyOnMacroCommand, partyOffMacroCommand);

        remoteControl.onButtonPushed(0);

        assertThat(ceilingFan.getSpeed()).isEqualTo(CeilingFan.Speed.HIGH);
        Mockito.verify(ceilingLight, Mockito.times(1)).on();
        Mockito.verify(securityControl, Mockito.times(1)).arm();
        Mockito.verify(stereo, Mockito.times(1)).on();
        Mockito.verify(stereo, Mockito.times(1)).setCd();
        Mockito.verify(stereo, Mockito.times(1)).setVolume(11);

        Mockito.verify(ceilingLight, Mockito.times(0)).off();
        Mockito.verify(securityControl, Mockito.times(0)).disarm();
        Mockito.verify(stereo, Mockito.times(0)).off();

        remoteControl.undoButtonPushed();
        assertThat(ceilingFan.getSpeed()).isEqualTo(CeilingFan.Speed.OFF);
        Mockito.verify(ceilingLight, Mockito.times(1)).off();
        Mockito.verify(securityControl, Mockito.times(1)).disarm();
        Mockito.verify(stereo, Mockito.times(1)).off();
    }

    private void verify(int... times) {
        Mockito.verify(applianceControl, Mockito.times(times[0])).on();
        Mockito.verify(applianceControl, Mockito.times(times[1])).off();
        Mockito.verify(ceilingLight, Mockito.times(times[2])).on();
        Mockito.verify(ceilingLight, Mockito.times(times[3])).off();
        Mockito.verify(faucetControl, Mockito.times(times[4])).openValve();
        Mockito.verify(faucetControl, Mockito.times(times[5])).closeValve();
        Mockito.verify(garageDoor, Mockito.times(times[6])).up();
        Mockito.verify(garageDoor, Mockito.times(times[7])).down();
        Mockito.verify(outdoorLight, Mockito.times(times[8])).on();
        Mockito.verify(outdoorLight, Mockito.times(times[9])).off();
        Mockito.verify(securityControl, Mockito.times(times[10])).arm();
        Mockito.verify(securityControl, Mockito.times(times[11])).disarm();
        Mockito.verify(stereo, Mockito.times(times[12])).on();
        Mockito.verify(stereo, Mockito.times(times[13])).setCd();
        Mockito.verify(stereo, Mockito.times(times[14])).setVolume(11);
        Mockito.verify(stereo, Mockito.times(times[15])).off();
    }

    private RemoteControl getRemoteControlWithLoadedSlots() {
        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(0, new ApplianceControlOnCommand(applianceControl), new ApplianceControlOffCommand(applianceControl));
        remoteControl.setCommand(1, new CeilingLightOnCommand(ceilingLight), new CeilingLightOffCommand(ceilingLight));
        remoteControl.setCommand(2, new FaucetControlOnCommand(faucetControl), new FaucetControlOffCommand(faucetControl));
        remoteControl.setCommand(3, new GarageDoorOnCommand(garageDoor), new GarageDoorOffCommand(garageDoor));
        remoteControl.setCommand(4, new OutdoorLightOnCommand(outdoorLight), new OutdoorLightOffCommand(outdoorLight));
        remoteControl.setCommand(5, new SecurityControlOnCommand(securityControl), new SecurityControlOffCommand(securityControl));
        remoteControl.setCommand(6, new StereoWithCDOnCommand(stereo), new StereoOffCommand(stereo));

        return remoteControl;
    }
}
