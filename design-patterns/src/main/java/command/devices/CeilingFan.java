package command.devices;

public class CeilingFan {

    public enum Speed {HIGH, MEDIUM, LOW, OFF};

    private Speed speed;

    private final String location;


    public CeilingFan(String location) {
        this.location = location;
        speed = Speed.OFF;
    }

    public void high() {
        speed = Speed.HIGH;
    }

    public void medium() {
        speed = Speed.MEDIUM;
    }

    public void low() {
        speed = Speed.LOW;
    }

    public void off() {
        speed = Speed.OFF;
    }

    public Speed getSpeed() {
        return speed;
    }
}
