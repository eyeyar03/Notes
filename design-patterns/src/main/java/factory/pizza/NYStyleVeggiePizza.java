package factory.pizza;

public class NYStyleVeggiePizza extends Pizza {

    public NYStyleVeggiePizza() {
        name = "NY Style Veggie Pizza";
        dough = "Thin Crust";
        sauce = "Marinara";

        toppings.add("Grated Reggiano Cheese");
    }
}
