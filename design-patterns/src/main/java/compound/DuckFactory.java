package compound;

// Applying Abstract Factory Pattern
public class DuckFactory extends AbstractDuckFactory {

  @Override
  public Quackable createMallardDuck() {
    return new MallardDuck();
  }

  @Override
  public Quackable createRedHeadDuck() {
    return new RedHeadDuck();
  }

  @Override
  public Quackable createDuckCall() {
    return new DuckCall();
  }

  @Override
  public Quackable createRubberDuck() {
    return new RubberDuck();
  }
}
