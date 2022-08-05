package observer.builtin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Observer;

public class ObserverTest {

    private WeatherData weatherData;

    @BeforeEach
    public void setup() {
        weatherData = new WeatherData();
    }

    @Test
    public void testCurrentConditionDisplay() {
        new CurrentConditionDisplay(weatherData);

        weatherData.setMeasurements(10f, 20f, 30f);
    }

    @Test
    public void testStatisticsDisplay() {
        new StatisticsDisplay(weatherData);

        weatherData.setMeasurements(10f, 40f, 30f);
        weatherData.setMeasurements(10f, 20f, 30f);
        weatherData.setMeasurements(10f, 60f, 30f);
    }

    @Test
    public void testHeatIndexDisplay() {
        new HeatIndexDisplay(weatherData);
        weatherData.setMeasurements(10f, 40f, 30f);
    }

    @Test
    public void testAllDisplays() {
        Observer currentConditionDisplay = new CurrentConditionDisplay(weatherData);
        Observer statisticsDisplay = new StatisticsDisplay(weatherData);
        Observer heatIndexDisplay = new HeatIndexDisplay(weatherData);

        weatherData.setMeasurements(5f, 10f, 15f);

        System.out.println("---- REMOVING CurrentConditionDisplay ----");
        weatherData.deleteObserver(currentConditionDisplay);

        weatherData.setMeasurements(20f, 30f, 40f);

        System.out.println("---- REMOVING StatisticsDisplay ----");
        weatherData.deleteObserver(statisticsDisplay);

        weatherData.setMeasurements(45f, 90f, 135f);

        System.out.println("---- REMOVING HeatIndexDisplay ----");
        weatherData.deleteObserver(heatIndexDisplay);

        weatherData.setMeasurements(30f, 60f, 90f);
    }
}
