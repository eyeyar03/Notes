package factory.abstrct;

import factory.abstrct.pizza.CheesePizza;
import factory.abstrct.pizza.ClamPizza;
import factory.abstrct.pizza.PepperoniPizza;
import factory.abstrct.pizza.Pizza;
import factory.abstrct.pizza.VeggiePizza;
import factory.pizza.PizzaType;

public class NYPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(PizzaType pizzaType) {
       Pizza pizza = null;

       PizzaIngredientFactory pizzaIngredientFactory = new NYPizzaIngredientFactory();

       if (pizzaType.equals(PizzaType.CHEESE)) {
           pizza = new CheesePizza(pizzaIngredientFactory);
           pizza.setName("New York Style Cheese Pizza");

       } else if (pizzaType.equals(PizzaType.CLAM)) {
           pizza = new ClamPizza(pizzaIngredientFactory);
           pizza.setName("New York Style Clam Pizza");

       } else if (pizzaType.equals(PizzaType.PEPPERONI)) {
           pizza = new PepperoniPizza(pizzaIngredientFactory);
           pizza.setName("New York Style Pepperoni Pizza");

       } else if (pizzaType.equals(PizzaType.VEGGIE)) {
           pizza = new VeggiePizza(pizzaIngredientFactory);
           pizza.setName("New York Style Veggie Pizza");
       }

       return pizza;
    }
}
