package observer;

import java.util.List;

public class WeatherData implements Subject {

    private List<Observer> observersContainer;

    private float humidity;

    private float pressure;

    private float temperature;


    public WeatherData(List<Observer> observersContainer) {
        this.observersContainer = observersContainer;
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

    @Override
    public void registerObserver(Observer observer) {
        observersContainer.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observersContainer.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observersContainer.stream().forEach(o -> o.update(humidity, temperature, pressure));
    }

    public void measurementsChanged() {
        notifyObservers();
    }
}
