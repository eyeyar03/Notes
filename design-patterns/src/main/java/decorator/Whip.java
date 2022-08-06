package decorator;

public class Whip extends BeverageDecorator {

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public double cost() {
        double cost = 0.10; // Grande

        if (Size.TALL == getSize()) {
            cost = cost - 0.05;

        } else if (Size.VENTI == getSize()) {
            cost = cost + 0.05;
        }

        return cost + beverage.cost();
    }
}
