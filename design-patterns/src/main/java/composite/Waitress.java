package composite;

import java.util.Iterator;

public class Waitress {

  private final MenuComponent allMenus;

  public Waitress(MenuComponent allMenus) {
    this.allMenus = allMenus;
  }

  public void printMenu() {
    allMenus.print();
  }

  public void printVegetarianMenu() {
    Iterator<MenuComponent> menuComponentIterator = allMenus.createIterator();

    System.out.println("VEGETARIAN MENU \n------------------");
    while (menuComponentIterator.hasNext()) {
      MenuComponent menuComponent = menuComponentIterator.next();

      try {
        if (menuComponent.isVegetarian()) {
          menuComponent.print();
        }

      } catch (UnsupportedOperationException e) {
        // Silently catch. isVegetarian is not supported for Menu instances.
      }
    }
  }
}
