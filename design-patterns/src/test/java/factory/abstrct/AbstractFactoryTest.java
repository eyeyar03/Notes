package factory.abstrct;

import factory.abstrct.pizza.CheesePizza;
import factory.abstrct.pizza.ClamPizza;
import factory.abstrct.pizza.PepperoniPizza;
import factory.abstrct.pizza.Pizza;
import factory.abstrct.pizza.VeggiePizza;
import factory.pizza.PizzaType;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AbstractFactoryTest {

    @Test
    public void orderNYStyleCheesePizza() {
        PizzaStore pizzaStore = new NYPizzaStore();
        Pizza pizza = pizzaStore.orderPizza(PizzaType.CHEESE);
        assertThat(pizza).isInstanceOf(CheesePizza.class);
        assertThat(pizza.toString()).isEqualTo("New York Style Cheese Pizza with ThinCrustDough, MarinaraSauce, ReggianoCheese");
    }

    @Test
    public void orderNYStyleClamPizza() {
        PizzaStore pizzaStore = new NYPizzaStore();
        Pizza pizza = pizzaStore.orderPizza(PizzaType.CLAM);
        assertThat(pizza).isInstanceOf(ClamPizza.class);
        assertThat(pizza.toString()).isEqualTo("New York Style Clam Pizza with ThinCrustDough, MarinaraSauce, ReggianoCheese, FreshClams");
    }

    @Test
    public void orderNYStylePepperoniPizza() {
        PizzaStore pizzaStore = new NYPizzaStore();
        Pizza pizza = pizzaStore.orderPizza(PizzaType.PEPPERONI);
        assertThat(pizza).isInstanceOf(PepperoniPizza.class);
        assertThat(pizza.toString()).isEqualTo("New York Style Pepperoni Pizza with ThinCrustDough, MarinaraSauce, ReggianoCheese, SlicedPepperoni");
    }

    @Test
    public void orderNYStyleVeggiePizza() {
        PizzaStore pizzaStore = new NYPizzaStore();
        Pizza pizza = pizzaStore.orderPizza(PizzaType.VEGGIE);
        assertThat(pizza).isInstanceOf(VeggiePizza.class);
        assertThat(pizza.toString()).isEqualTo("New York Style Veggie Pizza with ThinCrustDough, MarinaraSauce, ReggianoCheese, Garlic, Onion, Mushroom, RedPepper");
    }

    @Test
    public void orderChicagoStyleCheesePizza() {
        PizzaStore pizzaStore = new ChicagoPizzaStore();
        Pizza pizza = pizzaStore.orderPizza(PizzaType.CHEESE);
        assertThat(pizza).isInstanceOf(CheesePizza.class);
        assertThat(pizza.toString()).isEqualTo("Chicago Style Cheese Pizza with ThickCrustDough, PlumTomatoSauce, MozzarellaCheese");
    }

    @Test
    public void orderChicagoStyleClamPizza() {
        PizzaStore pizzaStore = new ChicagoPizzaStore();
        Pizza pizza = pizzaStore.orderPizza(PizzaType.CLAM);
        assertThat(pizza).isInstanceOf(ClamPizza.class);
        assertThat(pizza.toString()).isEqualTo("Chicago Style Clam Pizza with ThickCrustDough, PlumTomatoSauce, MozzarellaCheese, FrozenClams");
    }

    @Test
    public void orderChicagoStylePepperoniPizza() {
        PizzaStore pizzaStore = new ChicagoPizzaStore();
        Pizza pizza = pizzaStore.orderPizza(PizzaType.PEPPERONI);
        assertThat(pizza).isInstanceOf(PepperoniPizza.class);
        assertThat(pizza.toString()).isEqualTo("Chicago Style Pepperoni Pizza with ThickCrustDough, PlumTomatoSauce, MozzarellaCheese, SlicedPepperoni");
    }

    @Test
    public void orderChicagoStyleVeggiePizza() {
        PizzaStore pizzaStore = new ChicagoPizzaStore();
        Pizza pizza = pizzaStore.orderPizza(PizzaType.VEGGIE);
        assertThat(pizza).isInstanceOf(VeggiePizza.class);
        assertThat(pizza.toString()).isEqualTo("Chicago Style Veggie Pizza with ThickCrustDough, PlumTomatoSauce, MozzarellaCheese, BlackOlives, Spinach, EggPlant");
    }
}
