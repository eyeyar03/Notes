package observer;

import java.util.ArrayList;
import java.util.List;

public class StatisticsDisplay implements Observer, DisplayElement {

    private Subject subject;

    private List<Float> temperatures;

    public StatisticsDisplay(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);

        temperatures = new ArrayList<>();
    }

    @Override
    public void display() {
        System.out.println("Ave/Max/Min Temperatures: " + getAve() + "/" + getMax() + "/" + getMin());
    }

    private float getMin() {
        return temperatures.stream().min(Float::compare).get();
    }

    private float getMax() {
        return temperatures.stream().max(Float::compare).get();
    }

    private float getAve() {
        return temperatures.stream().reduce(0f, (f1, f2) -> Float.sum(f1, f2)) / temperatures.size();
    }

    @Override
    public void update(float humidity, float temperature, float pressure) {
        temperatures.add(temperature);

        display();
    }
}
