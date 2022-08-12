package iterator;

import java.util.ArrayList;
import java.util.List;

public class PancakeHouseMenu {

  // Notice that PancakeHouseMenu is using Arraylist to store MenuItem
  private List<MenuItem> menuItems;

  public PancakeHouseMenu() {
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

  /*
   * Notice the both DinerMenu and PancakeHouseMenu has getMenuItems, but the return types are different.
   * Also notice that this method is not declared anymore in PancakeHouseMenuWithIterator.
   */
  public List<MenuItem> getMenuItems() {
    return menuItems;
  }
}
