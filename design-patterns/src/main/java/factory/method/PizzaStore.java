package factory.method;

import factory.pizza.Pizza;
import factory.pizza.PizzaType;

public abstract class PizzaStore {

    protected abstract Pizza createPizza(PizzaType pizzaType);

    // final so that franchise stores will not change (i.e. override) the pizza preparations.
    public final Pizza orderPizza(PizzaType pizzaType) {
        Pizza pizza = createPizza(pizzaType);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
