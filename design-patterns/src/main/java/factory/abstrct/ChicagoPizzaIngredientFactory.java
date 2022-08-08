package factory.abstrct;

import factory.abstrct.ingredient.cheese.Cheese;
import factory.abstrct.ingredient.cheese.MozzarellaCheese;
import factory.abstrct.ingredient.clams.Clams;
import factory.abstrct.ingredient.clams.FreshClams;
import factory.abstrct.ingredient.clams.FrozenClams;
import factory.abstrct.ingredient.dough.Dough;
import factory.abstrct.ingredient.dough.ThickCrustDough;
import factory.abstrct.ingredient.pepperoni.Pepperoni;
import factory.abstrct.ingredient.pepperoni.SlicedPepperoni;
import factory.abstrct.ingredient.sauce.PlumTomatoSauce;
import factory.abstrct.ingredient.sauce.Sauce;
import factory.abstrct.ingredient.veggies.BlackOlives;
import factory.abstrct.ingredient.veggies.EggPlant;
import factory.abstrct.ingredient.veggies.Spinach;
import factory.abstrct.ingredient.veggies.Veggies;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {

    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }

    @Override
    public Cheese createCheese() {
        return new MozzarellaCheese();
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClams() {
        return new FrozenClams();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies[] veggies = {new BlackOlives(), new Spinach(), new EggPlant()};

        return veggies;
    }
}
