package strategy;

import strategy.behavior.fly.FlyWithWings;
import strategy.behavior.quack.Quack;

public class MallardDuck extends Duck {

    MallardDuck() {
        setFlyBehavior(new FlyWithWings());
        setQuackBehavior(new Quack());
    }
}
