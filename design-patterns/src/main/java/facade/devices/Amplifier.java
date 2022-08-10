package facade.devices;

public class Amplifier {

    private Tuner tuner;

    private DvdPlayer dvdPlayer;

    private CdPlayer cdPlayer;

    public Amplifier(Tuner tuner, DvdPlayer dvdPlayer, CdPlayer cdPlayer) {
        this.tuner = tuner;
        this.dvdPlayer = dvdPlayer;
        this.cdPlayer = cdPlayer;
    }

    public void on() {
        System.out.println("Amplifier on...");
    }

    public void off() {
        System.out.println("Amplifier off...");
    }

    public void setCd() {
        System.out.println("Amplifier CD set...");
    }

    public void setDvd() {
        System.out.println("Amplifier DVD set...");
    }

    public void setStereoSound() {
        System.out.println("Amplifier Stereo Sound...");
    }

    public void setSurroundSound() {
        System.out.println("Amplifier Surround Sound...");
    }

    public void setTuner() {
        System.out.println("Amplifier tuner set...");
    }

    public void setVolume() {
        System.out.println("Amplifier volume set...");
    }
}
