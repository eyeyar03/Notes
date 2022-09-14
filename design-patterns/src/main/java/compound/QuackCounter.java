package compound;

// Applying Decorator Pattern
public class QuackCounter implements Quackable {

  private final Quackable quackable;

  private static int quacks = 0;

  private final QuackObservable quackObservable;

  public QuackCounter(Quackable quackable) {
    quackObservable = new Observable(this);
    this.quackable = quackable;
  }

  @Override
  public String quack() {
    quacks++;
    return quackable.quack();
  }

  public static int getQuacks() {
    return quacks;
  }

  public static void resetQuacks() {
    quacks = 0;
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
