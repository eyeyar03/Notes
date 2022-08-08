package factory.abstrct;

import factory.abstrct.ingredient.cheese.Cheese;
import factory.abstrct.ingredient.clams.Clams;
import factory.abstrct.ingredient.dough.Dough;
import factory.abstrct.ingredient.pepperoni.Pepperoni;
import factory.abstrct.ingredient.sauce.Sauce;
import factory.abstrct.ingredient.veggies.Veggies;

public interface PizzaIngredientFactory {
    Dough createDough();

    Sauce createSauce();

    Cheese createCheese();

    Pepperoni createPepperoni();

    Clams createClams();

    Veggies[] createVeggies();
}
