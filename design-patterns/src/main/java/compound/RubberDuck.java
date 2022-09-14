package compound;

public class RubberDuck implements Quackable {

  private final QuackObservable quackObservable;

  public RubberDuck() {
    quackObservable = new Observable(this);
  }

  @Override
  public String quack() {
    notifyObservers();
    return "Squeak!";
  }

  @Override
  public void registerObserver(Observer observer) {
    quackObservable.registerObserver(observer);
  }

  @Override
  public void notifyObservers() {
    quackObservable.notifyObservers();
  }
}
