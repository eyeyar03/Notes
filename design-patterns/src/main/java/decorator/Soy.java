package decorator;

public class Soy extends BeverageDecorator {

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    @Override
    public double cost() {
        double cost = 0.15; // Grande

        if (Size.TALL == getSize()) {
            cost = cost - 0.05;

        } else if (Size.VENTI == getSize()) {
            cost = cost + 0.05;
        }

        return cost + beverage.cost();
    }
}
