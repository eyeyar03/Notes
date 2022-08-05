package observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ObserverTest {

    private WeatherData weatherData;

    @BeforeEach
    public void setup() {
        weatherData = new WeatherData(new ArrayList<>());
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
        weatherData.removeObserver(currentConditionDisplay);

        weatherData.setMeasurements(20f, 30f, 40f);

        System.out.println("---- REMOVING StatisticsDisplay ----");
        weatherData.removeObserver(statisticsDisplay);

        weatherData.setMeasurements(45f, 90f, 135f);

        System.out.println("---- REMOVING HeatIndexDisplay ----");
        weatherData.removeObserver(heatIndexDisplay);

        weatherData.setMeasurements(30f, 60f, 90f);
    }
}
