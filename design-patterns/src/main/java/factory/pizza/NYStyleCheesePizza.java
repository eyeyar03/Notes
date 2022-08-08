package factory.pizza;

public class NYStyleCheesePizza extends Pizza {

    public NYStyleCheesePizza() {
        name = "NY Style Cheese Pizza";
        dough = "Thin Crust";
        sauce = "Marinara";

        toppings.add("Grated Reggiano Cheese");
    }
}
