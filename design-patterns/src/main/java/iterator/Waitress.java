package iterator;

import java.util.List;

public class Waitress {

  private final PancakeHouseMenu pancakeHouseMenu;

  private final DinerMenu dinerMenu;

  public Waitress(PancakeHouseMenu pancakeHouseMenu, DinerMenu dinerMenu) {
    this.pancakeHouseMenu = pancakeHouseMenu;
    this.dinerMenu = dinerMenu;
  }

  /*
   * Note the need to use 2 loops...
   */
  public void printMenu() {
    List<MenuItem> pancakeHouseMenuItems = pancakeHouseMenu.getMenuItems();
    MenuItem[] dinerMenuItems = dinerMenu.getMenuItems();

    for (int i = 0; i < pancakeHouseMenuItems.size(); i++) {
      MenuItem menuItem = pancakeHouseMenuItems.get(i);
      printMenuItem(menuItem);
    }

    for (int i = 0; i < dinerMenuItems.length; i++) {
      MenuItem menuItem = dinerMenuItems[i];
      printMenuItem(menuItem);
    }
  }

  private void printMenuItem(MenuItem menuItem) {
    System.out.println(
        menuItem.getName() + " - " + menuItem.getPrice() + " (" + menuItem.getDescription() + ")");
  }
}
