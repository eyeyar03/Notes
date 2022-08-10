package facade.devices;

public class DvdPlayer {

    private Amplifier amplifier;

    public DvdPlayer(Amplifier amplifier) {
        this.amplifier = amplifier;
    }

    public void on() {
        System.out.println("DvdPlayer on...");
    }

    public void off() {
        System.out.println("DvdPlayer off...");
    }

    public void eject() {
        System.out.println("DvdPlayer eject...");
    }

    public void pause() {
        System.out.println("DvdPlayer pause...");
    }

    public void play(String movieTitle) {
        System.out.println("DvdPlayer playing " + movieTitle + "....");
    }

    public void setSurroundAudio() {
        System.out.println("DvdPlayer surround audio...");
    }

    public void setTwoChannelAudio() {
        System.out.println("DvdPlayer two channel audio...");
    }

    public void stop() {
        System.out.println("DvdPlayer stop...");
    }
}
