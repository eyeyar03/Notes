package iterator;

import iterator.builtin.CafeMenu;
import iterator.builtin.ImprovedDinerMenu;
import iterator.builtin.ImprovedMenu;
import iterator.builtin.ImprovedPancakeHouseMenu;
import iterator.builtin.ImprovedWaitress;
import org.junit.jupiter.api.Test;

public class IteratorTest {

  @Test
  public void printMenuWithoutIterator() {
    PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
    DinerMenu dinerMenu = new DinerMenu();
    Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu);

    waitress.printMenu();
  }

  @Test
  public void printMenuWithIterator() {
    PancakeHouseMenuWithIterator pancakeHouseMenuWithIterator = new PancakeHouseMenuWithIterator();
    DinerMenuWithIterator dinerMenuWithIterator = new DinerMenuWithIterator();
    WaitressUsingIterator waitressUsingIterator =
        new WaitressUsingIterator(pancakeHouseMenuWithIterator, dinerMenuWithIterator);

    waitressUsingIterator.printMenu();
  }

  @Test
  public void printMenuUsingBuiltInIterator() {
    ImprovedMenu<MenuItem> improvedPancakeHouseMenu = new ImprovedPancakeHouseMenu();
    ImprovedMenu<MenuItem> improvedDinerMenu = new ImprovedDinerMenu();
    ImprovedMenu<MenuItem> cafeMenu = new CafeMenu();

    ImprovedWaitress improvedWaitress =
        new ImprovedWaitress(improvedPancakeHouseMenu, improvedDinerMenu, cafeMenu);

    improvedWaitress.printMenu();
  }
}
