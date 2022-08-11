package templatemethod;

import org.junit.jupiter.api.Test;

public class TemplateMethodTest {

  @Test
  public void createCoffee() {
    CaffeineBeverage beverage = new Coffee();

    beverage.prepareRecipe();
  }

  @Test
  public void createTea() {
    CaffeineBeverage beverage = new Tea();

    beverage.prepareRecipe();
  }

  @Test
  public void createCoffeeWithCondiments() {
    CaffeineBeverageWithHook caffeineBeverage = new CoffeeWithHook();
    caffeineBeverage.prepareRecipe();
  }

  @Test
  public void createTeaWithCondiments() {
    CaffeineBeverageWithHook caffeineBeverage = new TeaWithHook();
    caffeineBeverage.prepareRecipe();
  }
}
