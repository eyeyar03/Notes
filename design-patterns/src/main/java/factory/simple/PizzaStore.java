package factory.simple;

import factory.pizza.Pizza;
import factory.pizza.PizzaType;

public class PizzaStore {

    private SimplePizzaFactory simplePizzaFactory;

    public PizzaStore(SimplePizzaFactory simplePizzaFactory) {
        this.simplePizzaFactory = simplePizzaFactory;
    }

    public Pizza orderPizza(PizzaType pizzaType) {
        Pizza pizza = simplePizzaFactory.createPizza(pizzaType);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
