package strategy;

import org.junit.jupiter.api.Test;
import strategy.behavior.quack.MuteQuack;
import strategy.behavior.quack.Quack;
import strategy.behavior.quack.Squeak;

public class StrategyTest {

    private Duck duck;

    @Test
    public void testMallardDuck() {
        duck = new MallardDuck();
        duck.display();
        duck.performSwim();
        duck.performQuack();
    }

    @Test
    public void testRubberDuck() {
        duck = new RubberDuck();
        duck.display();
        duck.performSwim();
        duck.performQuack();
    }

    @Test
    public void testWoodenDuck() {
        duck = new WoodenDuck();
        duck.display();
        duck.performSwim();
        duck.performQuack();
    }

    @Test
    public void testChangeDuckBehavior() {
        duck = new MallardDuck();
        duck.performQuack();
        duck.setQuackBehavior(new Squeak());
        duck.performQuack();
        duck.setQuackBehavior(new MuteQuack());
        duck.performQuack();
        duck.setQuackBehavior(new Quack());
        duck.performQuack();
    }
}
