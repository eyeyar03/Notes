package factory.abstrct;

import factory.abstrct.ingredient.cheese.Cheese;
import factory.abstrct.ingredient.cheese.ReggianoCheese;
import factory.abstrct.ingredient.clams.Clams;
import factory.abstrct.ingredient.clams.FreshClams;
import factory.abstrct.ingredient.dough.Dough;
import factory.abstrct.ingredient.dough.ThinCrustDough;
import factory.abstrct.ingredient.pepperoni.Pepperoni;
import factory.abstrct.ingredient.pepperoni.SlicedPepperoni;
import factory.abstrct.ingredient.sauce.MarinaraSauce;
import factory.abstrct.ingredient.sauce.Sauce;
import factory.abstrct.ingredient.veggies.Garlic;
import factory.abstrct.ingredient.veggies.Mushroom;
import factory.abstrct.ingredient.veggies.Onion;
import factory.abstrct.ingredient.veggies.RedPepper;
import factory.abstrct.ingredient.veggies.Veggies;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {

    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClams() {
        return new FreshClams();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies[] veggies = {new Garlic(), new Onion(), new Mushroom(), new RedPepper()};
        return veggies;
    }
}
