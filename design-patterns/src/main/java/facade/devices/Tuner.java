package facade.devices;

public class Tuner {

    private Amplifier amplifier;

    public Tuner(Amplifier amplifier) {
        this.amplifier = amplifier;
    }

    public void on() {
        System.out.println("Tuner on...");
    }

    public void off() {
        System.out.println("Tuner off...");
    }

    public void setAm() {
        System.out.println("Tuner AM...");
    }

    public void setFm() {
        System.out.println("Tuner FM...");
    }

    public void setFrequency() {
        System.out.println("Tuner set frequency...");
    }
}
