package factory.pizza;

public class VeggiePizza extends Pizza {

    public VeggiePizza() {
        name = "Veggie Pizza";
        dough = "Regular Crust";
        sauce = "Marinara";

        toppings.add("Grated Reggiano Cheese");
        toppings.add("Shredded Mozzarella Cheese");
    }
}
