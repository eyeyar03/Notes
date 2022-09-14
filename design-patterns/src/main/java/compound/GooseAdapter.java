package compound;

// Applying Adapter Pattern
public class GooseAdapter implements Quackable {

  private final Goose goose;

  private final QuackObservable quackObservable;

  public GooseAdapter(Goose goose) {
    quackObservable = new Observable(this);
    this.goose = goose;
  }

  @Override
  public String quack() {
    notifyObservers();
    return goose.honk();
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
