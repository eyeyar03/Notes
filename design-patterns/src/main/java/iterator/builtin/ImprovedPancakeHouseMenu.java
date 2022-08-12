package iterator.builtin;

import iterator.MenuItem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ImprovedPancakeHouseMenu implements ImprovedMenu<MenuItem> {

  private List<MenuItem> menuItems;

  public ImprovedPancakeHouseMenu() {
    menuItems = new ArrayList<>();

    addItem("K&B's Pancake Breakfast", "Pancakes with scrambled eggs, and toast", true, 2.99);
    addItem("Regular Pancake Breakfast", "Pancakes with fried eggs, sausage", false, 2.99);
    addItem("Blueberry Pancake", "Pancakes made with fresh blueberries", true, 3.49);
    addItem("Waffles", "Waffles, with your choice of blueberries or strawberries", true, 3.59);
  }

  private void addItem(String name, String description, boolean vegetarian, double price) {
    MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
    menuItems.add(menuItem);
  }

  @Override
  public Iterator<MenuItem> createIterator() {
    // no need to create iterator for List.. the Java API already provides one.
    return menuItems.iterator();
  }
}
