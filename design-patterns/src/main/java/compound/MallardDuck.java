package compound;

public class MallardDuck implements Quackable {

  private final QuackObservable quackObservable;

  public MallardDuck() {
    quackObservable = new Observable(this);
  }

  @Override
  public String quack() {
    notifyObservers();
    return "Quack!";
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
