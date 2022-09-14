package compound;

public class DuckCall implements Quackable {

  private final QuackObservable quackObservable;

  public DuckCall() {
    quackObservable = new Observable(this);
  }

  @Override
  public String quack() {
    notifyObservers();
    return "Kwak!";
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
