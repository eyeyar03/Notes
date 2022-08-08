package factory.abstrct.pizza;

import factory.abstrct.PizzaIngredientFactory;

public class VeggiePizza extends Pizza {

    private final PizzaIngredientFactory pizzaIngredientFactory;

    public VeggiePizza(PizzaIngredientFactory pizzaIngredientFactory) {
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + name + "...");

        dough = pizzaIngredientFactory.createDough();
        sauce = pizzaIngredientFactory.createSauce();
        cheese = pizzaIngredientFactory.createCheese();
        veggies = pizzaIngredientFactory.createVeggies();
    }
}
