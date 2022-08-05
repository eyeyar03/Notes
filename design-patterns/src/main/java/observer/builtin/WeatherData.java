package observer.builtin;

import java.util.Observable;

public class WeatherData extends Observable {

    private float humidity;

    private float pressure;

    private float temperature;


    public WeatherData() {
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setMeasurements(float humidity, float temperature, float pressure) {
        this.humidity = humidity;
        this.pressure = pressure;
        this.temperature = temperature;

        measurementsChanged();
    }

    public void measurementsChanged() {
        setChanged(); // Observers will not be notified if this is not called even if notifyObservers() is called.
        notifyObservers(); // PULL model
    }
}
