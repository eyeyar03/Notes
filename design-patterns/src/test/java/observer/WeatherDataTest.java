package observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;

public class WeatherDataTest {

    private WeatherData weatherData;

    private List<Observer> observersContainer;

    @BeforeEach
    public void setup() {
        observersContainer = new ArrayList<>();
        weatherData = new WeatherData(observersContainer);
        weatherData.setMeasurements(10f, 20f, 30f);
    }

    @Test
    public void testGetTemperature() {
        float temperature = weatherData.getTemperature();
        assertThat(temperature).isEqualTo(10f);
    }

    @Test
    public void testGetHumidity() {
        float humidity = weatherData.getHumidity();
        assertThat(humidity).isEqualTo(20f);
    }

    @Test
    public void testPressure() {
        float pressure = weatherData.getPressure();
        assertThat(pressure).isEqualTo(30f);
    }

    @Test
    public void testRegisterObserver() {
        assertThat(observersContainer.size()).isEqualTo(0);

        new CurrentConditionDisplay(weatherData); // the object registers itself as observer via constructor

        assertThat(observersContainer.size()).isEqualTo(1);
    }

    @Test
    public void testRemoveObserver() {
        Observer observer = new CurrentConditionDisplay(weatherData); // the object registers itself as observer via constructor

        assertThat(observersContainer.size()).isEqualTo(1);

        weatherData.removeObserver(observer);

        assertThat(observersContainer.size()).isEqualTo(0);
    }

    @Test
    public void testNotifyObservers() {
        Observer observer = Mockito.mock(CurrentConditionDisplay.class);

        weatherData.registerObserver(observer);

        weatherData.notifyObservers();

        Mockito.verify(observer, times(1)).update(10f, 20f, 30f);
    }

    @Test
    public void testMeasurementsChanged() {
        Observer observer = Mockito.mock(CurrentConditionDisplay.class);

        weatherData.registerObserver(observer);
        weatherData.setMeasurements(40f, 50f, 60f);

        Mockito.verify(observer, times(1)).update(40f, 50f, 60f);
    }
}
