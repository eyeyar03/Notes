package decorator;

public class DarkRoast extends Beverage {

    @Override
    public String getDescription() {
        return getSize().name() + " Dark Roast";
    }

    @Override
    public double cost() {
        double cost = 0.99; // Grande

        if (Size.TALL == getSize()) {
            cost = cost - 0.05;

        } else if (Size.VENTI == getSize()) {
            cost = cost + 0.05;
        }

        return cost;
    }
}
