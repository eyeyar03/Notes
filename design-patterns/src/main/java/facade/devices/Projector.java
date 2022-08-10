package facade.devices;

public class Projector {

    private DvdPlayer dvdPlayer;

    public Projector(DvdPlayer dvdPlayer) {
        this.dvdPlayer = dvdPlayer;
    }

    public void on() {
        System.out.println("Projector on...");
    }

    public void off() {
        System.out.println("Projector off...");
    }

    public void tvMode() {
        System.out.println("Projector TV mode...");
    }

    public void wideScreenMode() {
        System.out.println("Projector widescreen mode...");
    }
}
