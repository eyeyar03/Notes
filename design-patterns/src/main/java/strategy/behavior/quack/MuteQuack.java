package strategy.behavior.quack;

public class MuteQuack implements QuackBehavior {

    @Override
    public void quack() {
        // do nothing - can't quack!
    }
}
