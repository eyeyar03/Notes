package iterator.builtin;

import iterator.MenuItem;

import java.util.Iterator;

public class ImprovedWaitress {

  private final ImprovedMenu<MenuItem> pancakeHouseMenu;

  private final ImprovedMenu<MenuItem> dinerMenu;

  private final ImprovedMenu<MenuItem> cafeMenu;

  public ImprovedWaitress(
      ImprovedMenu<MenuItem> pancakeHouseMenu,
      ImprovedMenu<MenuItem> dinerMenu,
      ImprovedMenu<MenuItem> cafeMenu) {
    this.pancakeHouseMenu = pancakeHouseMenu;
    this.dinerMenu = dinerMenu;
    this.cafeMenu = cafeMenu;
  }

  public void printMenu() {
    Iterator<MenuItem> pancakeHouseMenuIterator = pancakeHouseMenu.createIterator();
    Iterator<MenuItem> dinerMenuIterator = dinerMenu.createIterator();
    Iterator<MenuItem> cafeMenuIterator = cafeMenu.createIterator();

    System.out.println("MENU\n----\nBREAKFAST");
    printMenu(pancakeHouseMenuIterator);

    System.out.println("\nLUNCH");
    printMenu(dinerMenuIterator);

    System.out.println("\nDinner");
    printMenu(cafeMenuIterator);
  }

  private void printMenu(Iterator<MenuItem> menuItemIterator) {
    while (menuItemIterator.hasNext()) {
      MenuItem menuItem = menuItemIterator.next();
      printMenuItem(menuItem);
    }
  }

  private void printMenuItem(MenuItem menuItem) {
    System.out.println(
        menuItem.getName() + " - " + menuItem.getPrice() + " (" + menuItem.getDescription() + ")");
  }
}
