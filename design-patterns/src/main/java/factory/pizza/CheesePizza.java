package factory.pizza;

public class CheesePizza extends Pizza {

    public CheesePizza() {
        name = "Cheese Pizza";
        dough = "Regular Crust";
        sauce = "Marinara";

        toppings.add("Grated Reggiano Cheese");
        toppings.add("Shredded Mozzarella Cheese");
    }
}
