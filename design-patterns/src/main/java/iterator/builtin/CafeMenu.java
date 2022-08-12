package iterator.builtin;

import iterator.MenuItem;

import java.util.Hashtable;
import java.util.Iterator;

public class CafeMenu implements ImprovedMenu<MenuItem> {

  private Hashtable<String, MenuItem> menuItems;

  public CafeMenu() {
    menuItems = new Hashtable<>();

    addItem(
        "Veggie Burger and Air Fries",
        "Veggie burger on a whole wheat bun, lettuce, tomato, and fries",
        true,
        3.99);
    addItem("Soup of the day", "A cup of the soup of the day, with a side salad", false, 3.69);
    addItem("Burrito", "A large burrito, with whole pinto beans, salsa, guacamole", true, 4.29);
  }

  private void addItem(String name, String description, boolean vegetarian, double price) {
    MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
    menuItems.put(menuItem.getName(), menuItem);
  }

  @Override
  public Iterator<MenuItem> createIterator() {
    // Hashtable has values() method to get the collection then it's iterator
    return menuItems.values().iterator();
  }
}
