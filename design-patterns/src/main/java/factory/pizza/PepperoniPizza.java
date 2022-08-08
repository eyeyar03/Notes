package factory.pizza;

public class PepperoniPizza extends Pizza {

    public PepperoniPizza() {
        name = "Pepperoni Pizza";
        dough = "Regular Crust";
        sauce = "Marinara";

        toppings.add("Grated Reggiano Cheese");
        toppings.add("Shredded Mozzarella Cheese");
    }
}
