package strategy.behavior.quack;

import org.junit.jupiter.api.Test;

public class QuackBehaviorTest {

    private QuackBehavior quackBehavior;

    @Test
    public void testQuack() {
        quackBehavior = new Quack();
        quackBehavior.quack();
    }

    @Test
    public void testSqueak() {
        quackBehavior = new Squeak();
        quackBehavior.quack();
    }

    @Test
    public void testMuteQuack() {
        quackBehavior = new MuteQuack();
        quackBehavior.quack();
    }
}
