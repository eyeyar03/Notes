package factory.pizza;

public class ClamPizza extends Pizza {

    public ClamPizza() {
        name = "Clam Pizza";
        dough = "Regular Crust";
        sauce = "Marinara";

        toppings.add("Grated Reggiano Cheese");
        toppings.add("Shredded Mozzarella Cheese");
    }
}
