package strategy.behavior.fly;

import org.junit.jupiter.api.Test;

public class FlyBehaviorTest {

    private FlyBehavior flyBehavior;

    @Test
    public void testFlyWithWings() {
        flyBehavior = new FlyWithWings();
        flyBehavior.fly();
    }

    @Test
    public void testFlyNoWings() {
        flyBehavior = new FlyNoWay();
        flyBehavior.fly();
    }
}
