package factory.simple;

import factory.pizza.CheesePizza;
import factory.pizza.ClamPizza;
import factory.pizza.PepperoniPizza;
import factory.pizza.Pizza;
import factory.pizza.PizzaType;
import factory.pizza.VeggiePizza;

public class SimplePizzaFactory {

    public Pizza createPizza(PizzaType pizzaType) {
        Pizza pizza = null;

        if (pizzaType.equals(PizzaType.CHEESE)) {
            pizza = new CheesePizza();

        } else if (pizzaType.equals(PizzaType.PEPPERONI)) {
            pizza = new PepperoniPizza();

        } else if (pizzaType.equals(PizzaType.CLAM)) {
            pizza = new ClamPizza();

        } else if (pizzaType.equals(PizzaType.VEGGIE)) {
            pizza = new VeggiePizza();
        }

        return pizza;
    }
}
