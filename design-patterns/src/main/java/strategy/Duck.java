package strategy;

import strategy.behavior.fly.FlyBehavior;
import strategy.behavior.quack.QuackBehavior;

public abstract class Duck {

    private FlyBehavior flyBehavior;

    private QuackBehavior quackBehavior;

    public void display() {
        System.out.println(String.format("I am a %s.", this.getClass().getSimpleName()));
    }

    public void performSwim() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
