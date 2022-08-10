package command.devices;

public class Stereo {

    private int volume = 0;

    public void on() {
        System.out.println("Stereo is ON...");
    }

    public void off() {
        System.out.println("Stereo is OFF...");
    }

    public void setCd() {
        System.out.println("Setting Stereo  to CD...");
    }

    public void setDvd() {
        System.out.println("Setting Stereo  to DVD...");
    }

    public void setRadio() {
        System.out.println("Setting Stereo  to RADIO...");
    }

    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("Stereo volume is " + this.volume);
    }
}
