package composite;

import java.util.Iterator;

/*
 * MenuItem is the leaf
 */
public class MenuItem extends MenuComponent {

  private final String name;

  private final String description;

  private final boolean vegetarian;

  private final double price;

  public MenuItem(String name, String description, boolean vegetarian, double price) {
    this.name = name;
    this.description = description;
    this.vegetarian = vegetarian;
    this.price = price;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public boolean isVegetarian() {
    return vegetarian;
  }

  @Override
  public double getPrice() {
    return price;
  }

  @Override
  public void print() {
    StringBuilder sb = new StringBuilder();
    sb.append(name);

    if (vegetarian) {
      sb.append(" (v)");
    }

    sb.append(", " + price + "\n");
    sb.append("     -- " + description);

    System.out.println(sb);
  }

  @Override
  public Iterator<MenuComponent> createIterator() {
    return new NulllIterator();
  }
}
