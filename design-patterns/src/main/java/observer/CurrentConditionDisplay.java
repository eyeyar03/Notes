package observer;

public class CurrentConditionDisplay implements Observer, DisplayElement {

    private float humidity;

    private Subject subject;

    private float temperature;


    public CurrentConditionDisplay(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(float humidity, float temperature, float pressure) {
        this.humidity = humidity;
        this.temperature = temperature;
        display();
    }

    @Override
    public void display() {
        System.out.println("Current Conditions: " + temperature + "F degrees and " + humidity + "% humidity.");
    }
}
