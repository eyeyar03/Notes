package observer.builtin;

import observer.DisplayElement;
import util.HeatIndexCalculator;

import java.util.Observable;
import java.util.Observer;

public class HeatIndexDisplay implements Observer, DisplayElement {

    private float humidity;

    private final Observable observable;

    private float temperature;


    public HeatIndexDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Heat Index is: " + HeatIndexCalculator.calculate(humidity, temperature));
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            humidity = weatherData.getHumidity();
            temperature = weatherData.getTemperature();

            display();
        }
    }
}
