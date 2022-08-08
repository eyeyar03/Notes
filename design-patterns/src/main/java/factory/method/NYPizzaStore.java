package factory.method;

import factory.pizza.NYStyleCheesePizza;
import factory.pizza.NYStyleClamPizza;
import factory.pizza.NYStylePepperoniPizza;
import factory.pizza.NYStyleVeggiePizza;
import factory.pizza.Pizza;
import factory.pizza.PizzaType;

public class NYPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(PizzaType pizzaType) {
        Pizza pizza = null;

        if (pizzaType.equals(PizzaType.CHEESE)) {
            pizza = new NYStyleCheesePizza();

        } else if (pizzaType.equals(PizzaType.PEPPERONI)) {
            pizza = new NYStylePepperoniPizza();

        } else if (pizzaType.equals(PizzaType.CLAM)) {
            pizza = new NYStyleClamPizza();

        } else if (pizzaType.equals(PizzaType.VEGGIE)) {
            pizza = new NYStyleVeggiePizza();
        }

        return pizza;
    }
}
