package strategy;

import strategy.behavior.fly.FlyNoWay;
import strategy.behavior.quack.MuteQuack;

public class WoodenDuck extends Duck {

    WoodenDuck() {
        setFlyBehavior(new FlyNoWay());
        setQuackBehavior(new MuteQuack());
    }
}
