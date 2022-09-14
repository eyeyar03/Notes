package compound;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

public class CompoundPatternTest {

  @BeforeEach
  public void setup() {
    QuackCounter.resetQuacks(); // needed only for testing
  }

  @Test
  public void testQuacks() {
    Quackable mallardDuck = new MallardDuck();
    Quackable redHeadDuck = new RedHeadDuck();
    Quackable duckCall = new DuckCall();
    Quackable rubberDuck = new RubberDuck();

    quack(mallardDuck, "Quack!");
    quack(redHeadDuck, "Quack!");
    quack(duckCall, "Kwak!");
    quack(rubberDuck, "Squeak!");
  }

  @Test
  public void testQuackForGoose_applyingAdapterPattern() {
    Quackable gooseAdapter = new GooseAdapter(new Goose());

    quack(gooseAdapter, "Honk!");
  }

  @Test
  public void countQuacks_applyingDecoratorPattern() {
    Quackable mallardDuck = new QuackCounter(new MallardDuck());
    Quackable redHeadDuck = new QuackCounter(new RedHeadDuck());
    Quackable duckCall = new QuackCounter(new DuckCall());
    Quackable rubberDuck = new QuackCounter(new RubberDuck());
    Quackable gooseAdapter = new GooseAdapter(new Goose());

    assertThat(QuackCounter.getQuacks()).isEqualTo(0);

    quack(mallardDuck, "Quack!");
    quack(redHeadDuck, "Quack!");
    quack(duckCall, "Kwak!");
    quack(rubberDuck, "Squeak!");
    quack(gooseAdapter, "Honk!"); // not a quack, should not be counted

    assertThat(QuackCounter.getQuacks()).isEqualTo(4);
  }

  @Test
  public void testQuacks_applyingAbstractFactoryPattern() {
    testDucksUsingAbstractFactory(new DuckFactory());

    assertThat(QuackCounter.getQuacks()).isEqualTo(0); // Because we're not using QuackCounter decorator
  }

  @Test
  public void countQuacks_applyingDecoratorAndAbstractFactoryPatterns() {
    testDucksUsingAbstractFactory(new CountingDuckFactory());

    assertThat(QuackCounter.getQuacks()).isEqualTo(4);
  }

  @Test
  public void testQuacks_applyingCompositePattern() {
    Flock flockOfDucks = new Flock();

    AbstractDuckFactory abstractDuckFactory = new CountingDuckFactory();

    Quackable redHeadDuck = abstractDuckFactory.createRedHeadDuck();
    Quackable duckCall = abstractDuckFactory.createDuckCall();
    Quackable rubberDuck = abstractDuckFactory.createRubberDuck();
    Quackable gooseAdapter = new GooseAdapter(new Goose());

    flockOfDucks.add(redHeadDuck);
    flockOfDucks.add(duckCall);
    flockOfDucks.add(rubberDuck);
    flockOfDucks.add(gooseAdapter);

    Flock flockOfMallardDucks = new Flock();
    Quackable mallardDuck1 = abstractDuckFactory.createMallardDuck();
    Quackable mallardDuck2 = abstractDuckFactory.createMallardDuck();
    Quackable mallardDuck3 = abstractDuckFactory.createMallardDuck();
    Quackable mallardDuck4 = abstractDuckFactory.createMallardDuck();

    flockOfMallardDucks.add(mallardDuck1);
    flockOfMallardDucks.add(mallardDuck2);
    flockOfMallardDucks.add(mallardDuck3);
    flockOfMallardDucks.add(mallardDuck4);

    quack(flockOfDucks, "Quack!, Kwak!, Squeak!, Honk!");
    quack(flockOfMallardDucks, "Quack!, Quack!, Quack!, Quack!");

    assertThat(QuackCounter.getQuacks()).isEqualTo(7);
  }

  private void quack(Quackable quackable, String expected) {
    assertThat(quackable.quack()).isEqualTo(expected);
  }

  private void testDucksUsingAbstractFactory(AbstractDuckFactory abstractDuckFactory) {
    Quackable mallardDuck = abstractDuckFactory.createMallardDuck();
    Quackable redHeadDuck = abstractDuckFactory.createRedHeadDuck();
    Quackable duckCall = abstractDuckFactory.createDuckCall();
    Quackable rubberDuck = abstractDuckFactory.createRubberDuck();
    Quackable gooseAdapter = new GooseAdapter(new Goose());

    quack(mallardDuck, "Quack!");
    quack(redHeadDuck, "Quack!");
    quack(duckCall, "Kwak!");
    quack(rubberDuck, "Squeak!");
    quack(gooseAdapter, "Honk!");
  }

  @Test
  public void shouldUpdateQuackologist_applyingObserverPattern(){
    Quackologist quackologist = Mockito.mock(Quackologist.class);
    AbstractDuckFactory abstractDuckFactory = new DuckFactory();
    Quackable mallardDuck = abstractDuckFactory.createMallardDuck();
    mallardDuck.registerObserver(quackologist);

    quack(mallardDuck, "Quack!");

   Mockito.verify(quackologist, Mockito.times(1)).update(mallardDuck);

    Quackable redHeadDuck1 = abstractDuckFactory.createRedHeadDuck();
    Quackable redHeadDuck2 = abstractDuckFactory.createRedHeadDuck();
    Quackable redHeadDuck3 = abstractDuckFactory.createRedHeadDuck();
    Quackable redHeadDuck4 = abstractDuckFactory.createRedHeadDuck();

    Flock redHeadDuckFlock = new Flock();
    redHeadDuckFlock.add(redHeadDuck1);
    redHeadDuckFlock.add(redHeadDuck2);
    redHeadDuckFlock.add(redHeadDuck3);
    redHeadDuckFlock.add(redHeadDuck4);

    redHeadDuckFlock.registerObserver(quackologist);

    quack(redHeadDuckFlock, "Quack!, Quack!, Quack!, Quack!");

    Mockito.verify(quackologist, Mockito.times(1)).update(redHeadDuck1);
    Mockito.verify(quackologist, Mockito.times(1)).update(redHeadDuck2);
    Mockito.verify(quackologist, Mockito.times(1)).update(redHeadDuck3);
    Mockito.verify(quackologist, Mockito.times(1)).update(redHeadDuck4);
  }
}
