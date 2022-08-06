package decorator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DecoratorTest {

    @Test
    public void testEspresso() {
        Beverage beverage = new Espresso();
        assertThat(beverage.getDescription() + " $" + beverage.cost()).isEqualTo("GRANDE Espresso $1.99");
    }

    @Test
    public void testDarkRoastWithDoubleMochaAndWhip() {
        Beverage beverage = new DarkRoast();
        beverage = new Mocha(beverage);
        beverage = new Mocha(beverage);
        beverage = new Whip(beverage);

        assertThat(beverage.getDescription() + " $" + beverage.cost()).isEqualTo("GRANDE Dark Roast, Mocha, Mocha, Whip $1.49");
    }

    @Test
    public void testHouseBlendWithSoyMochaAndWhip() {
        Beverage beverage = new HouseBlend();
        beverage = new Soy(beverage);
        beverage = new Mocha(beverage);
        beverage = new Whip(beverage);

        assertThat(beverage.getDescription() + " $" + beverage.cost()).isEqualTo("GRANDE House Blend, Soy, Mocha, Whip $1.34");
    }

    @Test
    public void testVentiDarkRoastWithMochaAndWhip() {
        Beverage beverage = new DarkRoast();
        beverage.setSize(Beverage.Size.VENTI);
        beverage = new Mocha(beverage);
        beverage = new Whip(beverage);

        assertThat(beverage.getDescription() + " $" + beverage.cost()).isEqualTo("VENTI Dark Roast, Mocha, Whip $1.44");
    }
}
