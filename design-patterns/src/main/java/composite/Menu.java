package composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * Menu is the node
 */
public class Menu extends MenuComponent {

  private List<MenuComponent> menuComponents;

  private final String name;

  private final String description;

  public Menu(String name, String description) {
    this.name = name;
    this.description = description;

    menuComponents = new ArrayList<>();
  }

  @Override
  public void add(MenuComponent menuComponent) {
    menuComponents.add(menuComponent);
  }

  @Override
  public void remove(MenuComponent menuComponent) {
    menuComponents.remove(menuComponent);
  }

  @Override
  public MenuComponent getChild(int i) {
    return menuComponents.get(i);
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
  public void print() {
    System.out.println(name + ", " + description);
    System.out.println("----------------------------");

    Iterator<MenuComponent> menuComponentIterator = menuComponents.iterator();
    while (menuComponentIterator.hasNext()) {
      MenuComponent menuComponent = menuComponentIterator.next();
      menuComponent.print();
    }
  }

  @Override
  public Iterator<MenuComponent> createIterator() {
    return new CompositeIterator(menuComponents.iterator());
  }
}
