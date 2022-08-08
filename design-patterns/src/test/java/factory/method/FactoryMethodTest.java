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
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FactoryMethodTest {

    @Test
    public void orderNYStyleCheesePizza() {
        PizzaStore pizzaStore = new NYPizzaStore();
        Pizza pizza = pizzaStore.orderPizza(PizzaType.CHEESE);
        assertThat(pizza).isInstanceOf(NYStyleCheesePizza.class);
    }

    @Test
    public void orderNYStylePepperoniPizza() {
        PizzaStore pizzaStore = new NYPizzaStore();
        Pizza pizza = pizzaStore.orderPizza(PizzaType.PEPPERONI);
        assertThat(pizza).isInstanceOf(NYStylePepperoniPizza.class);
    }

    @Test
    public void orderNYStyleClamPizza() {
        PizzaStore pizzaStore = new NYPizzaStore();
        Pizza pizza = pizzaStore.orderPizza(PizzaType.CLAM);
        assertThat(pizza).isInstanceOf(NYStyleClamPizza.class);
    }

    @Test
    public void orderNYStyleVeggiePizza() {
        PizzaStore pizzaStore = new NYPizzaStore();
        Pizza pizza = pizzaStore.orderPizza(PizzaType.VEGGIE);
        assertThat(pizza).isInstanceOf(NYStyleVeggiePizza.class);
    }

    @Test
    public void orderChicagoStyleCheesePizza() {
        PizzaStore pizzaStore = new ChicagoPizzaStore();
        Pizza pizza = pizzaStore.orderPizza(PizzaType.CHEESE);
        assertThat(pizza).isInstanceOf(ChicagoStyleCheesePizza.class);
    }

    @Test
    public void orderChicagoStylePepperoniPizza() {
        PizzaStore pizzaStore = new ChicagoPizzaStore();
        Pizza pizza = pizzaStore.orderPizza(PizzaType.PEPPERONI);
        assertThat(pizza).isInstanceOf(ChicagoStylePepperoniPizza.class);
    }

    @Test
    public void orderChicagoStyleClamPizza() {
        PizzaStore pizzaStore = new ChicagoPizzaStore();
        Pizza pizza = pizzaStore.orderPizza(PizzaType.CLAM);
        assertThat(pizza).isInstanceOf(ChicagoStyleClamPizza.class);
    }

    @Test
    public void orderChicagoStyleVeggiePizza() {
        PizzaStore pizzaStore = new ChicagoPizzaStore();
        Pizza pizza = pizzaStore.orderPizza(PizzaType.VEGGIE);
        assertThat(pizza).isInstanceOf(ChicagoStyleVeggiePizza.class);
    }
}
