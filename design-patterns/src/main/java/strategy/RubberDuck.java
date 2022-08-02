package strategy;

import strategy.behavior.fly.FlyNoWay;
import strategy.behavior.quack.Squeak;

public class RubberDuck extends Duck {

    RubberDuck() {
        setFlyBehavior(new FlyNoWay());
        setQuackBehavior(new Squeak());
    }

}
