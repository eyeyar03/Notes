package factory.method;

import factory.pizza.ChicagoStyleCheesePizza;
import factory.pizza.ChicagoStyleClamPizza;
import factory.pizza.ChicagoStylePepperoniPizza;
import factory.pizza.ChicagoStyleVeggiePizza;
import factory.pizza.NYStyleCheesePizza;
import factory.pizza.NYStyleClamPizza;
import factory.pizza.NYStylePepperoniPizza;
import factory.pizza.NYStyleVeggiePizza;
import factory.pizza.Pizza;
import factory.pizza.PizzaType;

public class ChicagoPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(PizzaType pizzaType) {
        Pizza pizza = null;

        if (pizzaType.equals(PizzaType.CHEESE)) {
            pizza = new ChicagoStyleCheesePizza();

        } else if (pizzaType.equals(PizzaType.PEPPERONI)) {
            pizza = new ChicagoStylePepperoniPizza();

        } else if (pizzaType.equals(PizzaType.CLAM)) {
            pizza = new ChicagoStyleClamPizza();

        } else if (pizzaType.equals(PizzaType.VEGGIE)) {
            pizza = new ChicagoStyleVeggiePizza();
        }

        return pizza;
    }
}
