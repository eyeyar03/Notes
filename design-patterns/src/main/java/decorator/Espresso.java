package decorator;

public class Espresso extends Beverage {

    @Override
    public String getDescription() {
        return getSize().name() + " Espresso";
    }

    @Override
    public double cost() {
        double cost = 1.99; // Grande

        if (Size.TALL == getSize()) {
            cost = cost - 0.05;

        } else if (Size.VENTI == getSize()) {
            cost = cost + 0.05;
        }

        return cost;
    }
}
