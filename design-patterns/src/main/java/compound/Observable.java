package compound;

import java.util.ArrayList;
import java.util.List;

// Applying Observer Pattern
public class Observable implements QuackObservable {

  private List<Observer> observers = new ArrayList<>();

  private final QuackObservable quackObservable;

  public Observable(QuackObservable quackObservable) {
    this.quackObservable = quackObservable;
  }

  @Override
  public void registerObserver(Observer observer) {
    observers.add(observer);
  }

  @Override
  public void notifyObservers() {
    observers.forEach(o -> o.update(quackObservable));
  }
}
