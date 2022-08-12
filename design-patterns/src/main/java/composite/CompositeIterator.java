package composite;

import java.util.Iterator;
import java.util.Stack;

public class CompositeIterator implements Iterator<MenuComponent> {

  private Stack<Iterator<MenuComponent>> stack;

  public CompositeIterator(Iterator<MenuComponent> iterator) {
    stack = new Stack<>();
    stack.push(iterator);
  }

  @Override
  public boolean hasNext() {
    if (stack.isEmpty()) {
      return false;

    } else {
      Iterator<MenuComponent> iterator = stack.peek();
      if (!iterator.hasNext()) {
        stack.pop();
        return hasNext();

      } else {
        return true;
      }
    }
  }

  @Override
  public MenuComponent next() {
    if (hasNext()) {
      Iterator<MenuComponent> iterator = stack.peek();
      MenuComponent menuComponent = iterator.next();
      if (menuComponent instanceof Menu) {
        stack.push(menuComponent.createIterator());
      }

      return menuComponent;
    }

    return null;
  }

  @Override
  public void remove() {
    throw new UnsupportedOperationException();
  }
}
