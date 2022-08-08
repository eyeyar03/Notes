package factory.abstrct;

import factory.abstrct.ingredient.cheese.Cheese;
import factory.abstrct.ingredient.cheese.MozzarellaCheese;
import factory.abstrct.ingredient.cheese.ReggianoCheese;
import factory.abstrct.ingredient.clams.Clams;
import factory.abstrct.ingredient.clams.FreshClams;
import factory.abstrct.ingredient.clams.FrozenClams;
import factory.abstrct.ingredient.dough.Dough;
import factory.abstrct.ingredient.dough.ThickCrustDough;
import factory.abstrct.ingredient.dough.ThinCrustDough;
import factory.abstrct.ingredient.pepperoni.Pepperoni;
import factory.abstrct.ingredient.pepperoni.SlicedPepperoni;
import factory.abstrct.ingredient.sauce.MarinaraSauce;
import factory.abstrct.ingredient.sauce.PlumTomatoSauce;
import factory.abstrct.ingredient.sauce.Sauce;
import factory.abstrct.ingredient.veggies.BlackOlives;
import factory.abstrct.ingredient.veggies.EggPlant;
import factory.abstrct.ingredient.veggies.Garlic;
import factory.abstrct.ingredient.veggies.Mushroom;
import factory.abstrct.ingredient.veggies.Onion;
import factory.abstrct.ingredient.veggies.RedPepper;
import factory.abstrct.ingredient.veggies.Spinach;
import factory.abstrct.ingredient.veggies.Veggies;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PizzaIngredientFactoryTest {

    @Test
    public void createIngredientsForNY() {
        PizzaIngredientFactory pizzaIngredientFactory = new NYPizzaIngredientFactory();
        Dough dough = pizzaIngredientFactory.createDough();
        Sauce sauce = pizzaIngredientFactory.createSauce();
        Cheese cheese = pizzaIngredientFactory.createCheese();
        Pepperoni pepperoni = pizzaIngredientFactory.createPepperoni();
        Clams clams = pizzaIngredientFactory.createClams();
        Veggies[] vegies = pizzaIngredientFactory.createVeggies();

        assertThat(dough).isInstanceOf(ThinCrustDough.class);
        assertThat(sauce).isInstanceOf(MarinaraSauce.class);
        assertThat(cheese).isInstanceOf(ReggianoCheese.class);
        assertThat(pepperoni).isInstanceOf(SlicedPepperoni.class);
        assertThat(clams).isInstanceOf(FreshClams.class);
        assertThat(vegies.length).isEqualTo(4);
        assertThat(vegies[0]).isInstanceOf(Garlic.class);
        assertThat(vegies[1]).isInstanceOf(Onion.class);
        assertThat(vegies[2]).isInstanceOf(Mushroom.class);
        assertThat(vegies[3]).isInstanceOf(RedPepper.class);
    }

    @Test
    public void createIngredientsForChicago() {
        PizzaIngredientFactory pizzaIngredientFactory = new ChicagoPizzaIngredientFactory();
        Dough dough = pizzaIngredientFactory.createDough();
        Sauce sauce = pizzaIngredientFactory.createSauce();
        Cheese cheese = pizzaIngredientFactory.createCheese();
        Pepperoni pepperoni = pizzaIngredientFactory.createPepperoni();
        Clams clams = pizzaIngredientFactory.createClams();
        Veggies[] vegies = pizzaIngredientFactory.createVeggies();

        assertThat(dough).isInstanceOf(ThickCrustDough.class);
        assertThat(sauce).isInstanceOf(PlumTomatoSauce.class);
        assertThat(cheese).isInstanceOf(MozzarellaCheese.class);
        assertThat(pepperoni).isInstanceOf(SlicedPepperoni.class);
        assertThat(clams).isInstanceOf(FrozenClams.class);
        assertThat(vegies.length).isEqualTo(3);
        assertThat(vegies[0]).isInstanceOf(BlackOlives.class);
        assertThat(vegies[1]).isInstanceOf(Spinach.class);
        assertThat(vegies[2]).isInstanceOf(EggPlant.class);
    }
}
