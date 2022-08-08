package factory.abstrct;

import factory.abstrct.pizza.Pizza;
import factory.pizza.PizzaType;

public abstract class PizzaStore {

    protected abstract Pizza createPizza(PizzaType pizzaType);

    public final Pizza orderPizza(PizzaType pizzaType) {
       Pizza pizza = createPizza(pizzaType);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

       return pizza;
    }
}
