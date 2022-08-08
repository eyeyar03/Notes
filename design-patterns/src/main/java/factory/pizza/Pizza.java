package factory.pizza;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {

    protected String name;

    protected String dough;

    protected String sauce;

    protected List<String> toppings = new ArrayList<>();


    public void prepare() {
        System.out.println("Preparing " + name + "...");
        System.out.println("Tossing " + dough + " dough...");
        System.out.println("Adding " + sauce + " sauce...");
        System.out.println("Tossing toppings:");
        toppings.forEach(s -> System.out.println("   " + s));
    }

    public void bake() {
        System.out.println("Baking " + name + " for 25 minutes at 350...");
    }

    public void cut() {
        System.out.println("Cutting " + name + " into diagonal slices...");
    }

    public void box() {
        System.out.println("Place " + getClass().getSimpleName() + " in official PizzaStore box...");
    }
}
