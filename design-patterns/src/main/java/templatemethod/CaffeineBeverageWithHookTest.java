package templatemethod;

public class CaffeineBeverageWithHookTest {

  public static void main(String[] args) {
    CaffeineBeverageWithHook tea = new TeaWithHook();
    CaffeineBeverageWithHook coffee = new CoffeeWithHook();

    tea.prepareRecipe();
    coffee.prepareRecipe();
  }
}
