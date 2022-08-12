package iterator;

public class DinerMenu {

  private static final int MAX_ITEMS = 6;

  private int numberOfItems = 0;

  // Notice that DinerMenu is using Array to store MenuItem
  private MenuItem[] menuItems;

  public DinerMenu() {
    menuItems = new MenuItem[MAX_ITEMS];

    addItem("Vegetarian BLT", "(Fakin') Bacon with lettuce & tomato on whole wheat", true, 2.99);
    addItem("BLT", "Bacon with lettuce & tomato on whole wheat", false, 2.99);
    addItem("Soup of the day", "Soup of the day, with a side of potato salad", false, 3.29);
    addItem("Hotdog", "A hotdog, with saurkraut, relish, onions, topped with cheese", false, 3.05);
    addItem("Adobo", "Pork filipino dish with asian rice", false, 3.99);
    addItem("Toron", "Fried banana with ice cream on top", true, 2.05);
  }

  private void addItem(String name, String description, boolean vegetarian, double price) {
    MenuItem menuItem = new MenuItem(name, description, vegetarian, price);

    if (numberOfItems >= MAX_ITEMS) {
      System.err.println("Sorry, menu is full! Can't add item to menu.");

    } else {
      menuItems[numberOfItems] = menuItem;
      numberOfItems = numberOfItems + 1;
    }
  }

  /*
   * Notice the both DinerMenu and PancakeHouseMenu has getMenuItems, but the return types are different.
   * Also notice that this method is not declared anymore in DinerMenuWithIterator
   */
  public MenuItem[] getMenuItems() {
    return menuItems;
  }
}
