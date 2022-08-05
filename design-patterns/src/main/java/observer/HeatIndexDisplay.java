package observer;

import util.HeatIndexCalculator;

public class HeatIndexDisplay implements Observer, DisplayElement {

    private float humidity;

    private Subject subject;

    private float temperature;


    public HeatIndexDisplay(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Heat Index is: " + HeatIndexCalculator.calculate(humidity, temperature));
    }

    @Override
    public void update(float humidity, float temperature, float pressure) {
        this.humidity = humidity;
        this.temperature = temperature;
        display();
    }
}
