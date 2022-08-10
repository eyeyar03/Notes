package facade.devices;

public class CdPlayer {

    private Amplifier amplifier;

    public CdPlayer(Amplifier amplifier) {
        this.amplifier = amplifier;
    }

    public void on() {
        System.out.println("CDPlayer on...");
    }

    public void off() {
        System.out.println("CDPlayer off...");
    }

    public void eject() {
        System.out.println("CDPlayer eject...");
    }

    public void pause() {
        System.out.println("CDPlayer pause...");
    }

    public void play() {
        System.out.println("CDPlayer play...");
    }

    public void stop() {
        System.out.println("CDPlayer stop...");
    }
}
