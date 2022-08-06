package decorator;

public class HouseBlend extends Beverage {

    @Override
    public String getDescription() {
        return getSize().name() + " House Blend";
    }

    @Override
    public double cost() {
        double cost = 0.89; // Grande

        if (Size.TALL == getSize()) {
            cost = cost - 0.05;

        } else if (Size.VENTI == getSize()) {
            cost = cost + 0.05;
        }

        return cost;
    }
}
