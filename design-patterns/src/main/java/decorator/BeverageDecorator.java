package decorator;

public abstract class BeverageDecorator extends Beverage {

    protected Beverage beverage;

    @Override
    public Size getSize() {
        return beverage.getSize();
    }
}
