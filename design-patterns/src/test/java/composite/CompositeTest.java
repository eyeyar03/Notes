package composite;

import org.junit.jupiter.api.Test;

public class CompositeTest {

  @Test
  public void printPancakeHouseMenu() {
    MenuComponent pancakeHouseMenu = new Menu("PANCAKE HOUSE MENU", "Breakfast");
    pancakeHouseMenu.add(
        new MenuItem(
            "K&B's Pancake Breakfast", "Pancakes with scrambled eggs, and toast", true, 2.99));
    pancakeHouseMenu.add(
        new MenuItem(
            "Regular Pancake Breakfast", "Pancakes with fried eggs, sausage", false, 2.99));
    pancakeHouseMenu.add(
        new MenuItem("Blueberry Pancake", "Pancakes made with fresh blueberries", true, 3.49));
    pancakeHouseMenu.add(
        new MenuItem(
            "Waffles", "Waffles, with your choice of blueberries or strawberries", true, 3.59));

    Waitress waitress = new Waitress(pancakeHouseMenu);

    waitress.printMenu();
  }

  @Test
  public void printDinerMenu() {
    MenuComponent dinerMenu = new Menu("DINER MENU", "Lunch");
    dinerMenu.add(
        new MenuItem(
            "Vegetarian BLT", "(Fakin') Bacon with lettuce & tomato on whole wheat", true, 2.99));
    dinerMenu.add(new MenuItem("BLT", "Bacon with lettuce & tomato on whole wheat", false, 2.99));
    dinerMenu.add(
        new MenuItem(
            "Soup of the day", "Soup of the day, with a side of potato salad", false, 3.29));
    dinerMenu.add(
        new MenuItem(
            "Hotdog", "A hotdog, with saurkraut, relish, onions, topped with cheese", false, 3.05));
    dinerMenu.add(new MenuItem("Adobo", "Pork filipino dish with asian rice", false, 3.99));
    dinerMenu.add(
        new MenuItem(
            "Hotdog", "A hotdog, with saurkraut, relish, onions, topped with cheese", false, 3.05));

    MenuComponent dessertMenu = new Menu("DESSERT MENU", "Dessert of course!");
    dessertMenu.add(
        new MenuItem(
            "Apple Pie",
            "Apple pie with a flakey crust, topped with vanilla ice cream",
            true,
            1.59));
    dessertMenu.add(new MenuItem("Halo-halo Special", "A filipino dessert", true, 3.49));
    dessertMenu.add(
        new MenuItem(
            "Cheesecake", "Creamy New York cheesecake, with a chocolate graham crush", true, 1.99));
    dessertMenu.add(new MenuItem("Sorbet", "A scoop of raspberry and a scoop of lime", true, 1.89));

    // add dessert menu (submenu) to diner menu
    dinerMenu.add(dessertMenu);

    Waitress waitress = new Waitress(dinerMenu);

    waitress.printMenu();
  }

  @Test
  public void printAllMenu() {
    Waitress waitress = new Waitress(buildAllMenus());

    waitress.printMenu();
  }

  /*
   * This test demonstrates using both Iterator and Composite patterns.
   */
  @Test
  public void printVegetarianMenu() {
    Waitress waitress = new Waitress(buildAllMenus());

    waitress.printVegetarianMenu();
  }

  private MenuComponent buildAllMenus() {
    // Pancake House Menu
    MenuComponent pancakeHouseMenu = new Menu("PANCAKE HOUSE MENU", "Breakfast");
    pancakeHouseMenu.add(
        new MenuItem(
            "K&B's Pancake Breakfast", "Pancakes with scrambled eggs, and toast", true, 2.99));
    pancakeHouseMenu.add(
        new MenuItem(
            "Regular Pancake Breakfast", "Pancakes with fried eggs, sausage", false, 2.99));
    pancakeHouseMenu.add(
        new MenuItem("Blueberry Pancake", "Pancakes made with fresh blueberries", true, 3.49));
    pancakeHouseMenu.add(
        new MenuItem(
            "Waffles", "Waffles, with your choice of blueberries or strawberries", true, 3.59));

    // Diner Menu
    MenuComponent dinerMenu = new Menu("DINER MENU", "Lunch");
    dinerMenu.add(
        new MenuItem(
            "Vegetarian BLT", "(Fakin') Bacon with lettuce & tomato on whole wheat", true, 2.99));
    dinerMenu.add(new MenuItem("BLT", "Bacon with lettuce & tomato on whole wheat", false, 2.99));
    dinerMenu.add(
        new MenuItem(
            "Soup of the day", "Soup of the day, with a side of potato salad", false, 3.29));
    dinerMenu.add(
        new MenuItem(
            "Hotdog", "A hotdog, with saurkraut, relish, onions, topped with cheese", false, 3.05));
    dinerMenu.add(new MenuItem("Adobo", "Pork filipino dish with asian rice", false, 3.99));
    dinerMenu.add(
        new MenuItem(
            "Hotdog", "A hotdog, with saurkraut, relish, onions, topped with cheese", false, 3.05));

    MenuComponent dessertMenu = new Menu("DESSERT MENU", "Dessert of course!");
    dessertMenu.add(
        new MenuItem(
            "Apple Pie",
            "Apple pie with a flakey crust, topped with vanilla ice cream",
            true,
            1.59));
    dessertMenu.add(new MenuItem("Halo-halo Special", "A filipino dessert", true, 3.49));
    dessertMenu.add(
        new MenuItem(
            "Cheesecake", "Creamy New York cheesecake, with a chocolate graham crush", true, 1.99));
    dessertMenu.add(new MenuItem("Sorbet", "A scoop of raspberry and a scoop of lime", true, 1.89));

    // Add Dessert Menu (submenu) to Diner Menu
    dinerMenu.add(dessertMenu);

    // Cafe Menu
    MenuComponent cafeMenu = new Menu("CAFE MENU", "Dinner");
    cafeMenu.add(
        new MenuItem(
            "Veggie Burger and Air Fries",
            "Veggie burger on a whole wheat bun, lettuce, tomato, and fries",
            true,
            3.99));
    cafeMenu.add(
        new MenuItem(
            "Soup of the day", "A cup of the soup of the day, with a side salad", false, 3.69));
    cafeMenu.add(
        new MenuItem(
            "Burrito", "A large burrito, with whole pinto beans, salsa, guacamole", true, 4.29));

    MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");
    allMenus.add(pancakeHouseMenu);
    allMenus.add(dinerMenu);
    allMenus.add(cafeMenu);

    return allMenus;
  }
}
