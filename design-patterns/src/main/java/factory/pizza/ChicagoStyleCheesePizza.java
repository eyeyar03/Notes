package factory.pizza;

public class ChicagoStyleCheesePizza extends Pizza {

    public ChicagoStyleCheesePizza() {
        name = "Chicago Style Cheese Pizza";
        dough = "Extra Thick Crust";
        sauce = "Plum Tomato";

        toppings.add("Shredded Mozzarella Cheese");
    }

    @Override
    public void cut() {
        System.out.println("Cutting " + name + " into square slices...");
    }
}
