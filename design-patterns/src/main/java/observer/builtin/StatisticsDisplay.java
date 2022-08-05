package observer.builtin;

import observer.DisplayElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class StatisticsDisplay implements Observer, DisplayElement {

    private final Observable observable;

    private List<Float> temperatures;


    public StatisticsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
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
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            temperatures.add(weatherData.getTemperature());

            display();
        }
    }
}
