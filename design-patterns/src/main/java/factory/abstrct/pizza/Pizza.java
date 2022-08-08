package factory.abstrct.pizza;

import factory.abstrct.PizzaIngredientFactory;
import factory.abstrct.ingredient.cheese.Cheese;
import factory.abstrct.ingredient.clams.Clams;
import factory.abstrct.ingredient.dough.Dough;
import factory.abstrct.ingredient.pepperoni.Pepperoni;
import factory.abstrct.ingredient.sauce.Sauce;
import factory.abstrct.ingredient.veggies.Veggies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Pizza {

    protected String name;

    protected Dough dough;

    protected Sauce sauce;

    protected Veggies[] veggies;

    protected Cheese cheese;

    protected Pepperoni pepperoni;

    protected Clams clams;


    public abstract void prepare();

    public void bake() {
        System.out.println("Baking " + name + " for 25 minutes at 350...");
    }

    public void cut() {
        System.out.println("Cutting " + name + " into diagonal slices...");
    }

    public void box() {
        System.out.println("Place " + name + " in official PizzaStore box...");
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name);

        List<String> ingredients = new ArrayList<>();

        if (dough != null) {
            ingredients.add(dough.getClass().getSimpleName());
        }

        if (sauce != null) {
            ingredients.add(sauce.getClass().getSimpleName());
        }

        if (cheese != null) {
            ingredients.add(cheese.getClass().getSimpleName());
        }

        if (pepperoni != null) {
            ingredients.add(pepperoni.getClass().getSimpleName());
        }

        if (clams != null) {
            ingredients.add(clams.getClass().getSimpleName());
        }

        if (veggies != null) {
            for (Veggies veg : veggies) {
                ingredients.add(veg.getClass().getSimpleName());
            }
        }

        if(!ingredients.isEmpty()) {
            sb.append(" with ");
            sb.append(ingredients.stream().collect(Collectors.joining(", ")));
        }

        return sb.toString();
    }
}
