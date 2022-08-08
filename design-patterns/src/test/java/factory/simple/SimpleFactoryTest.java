package factory.simple;

import factory.pizza.CheesePizza;
import factory.pizza.ClamPizza;
import factory.pizza.PepperoniPizza;
import factory.pizza.Pizza;
import factory.pizza.PizzaType;
import factory.pizza.VeggiePizza;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleFactoryTest {

    @Test
    public void orderCheesePizza() {
        PizzaStore pizzaStore = new PizzaStore(new SimplePizzaFactory());
        Pizza pizza = pizzaStore.orderPizza(PizzaType.CHEESE);
        assertThat(pizza).isInstanceOf(CheesePizza.class);
    }

    @Test
    public void orderPepperoniPizza() {
        PizzaStore pizzaStore = new PizzaStore(new SimplePizzaFactory());
        Pizza pizza = pizzaStore.orderPizza(PizzaType.PEPPERONI);
        assertThat(pizza).isInstanceOf(PepperoniPizza.class);
    }

    @Test
    public void orderClamPizza() {
        PizzaStore pizzaStore = new PizzaStore(new SimplePizzaFactory());
        Pizza pizza = pizzaStore.orderPizza(PizzaType.CLAM);
        assertThat(pizza).isInstanceOf(ClamPizza.class);
    }

    @Test
    public void orderVeggiePizza() {
        PizzaStore pizzaStore = new PizzaStore(new SimplePizzaFactory());
        Pizza pizza = pizzaStore.orderPizza(PizzaType.VEGGIE);
        assertThat(pizza).isInstanceOf(VeggiePizza.class);
    }
}
