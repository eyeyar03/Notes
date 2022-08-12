package iterator.builtin;

import java.util.Iterator;

public class ImprovedDinerMenuIterator<E> implements Iterator<E> {

  private final E[] elements;

  private int position = 0;

  public ImprovedDinerMenuIterator(E[] elements) {
    this.elements = elements;
  }

  @Override
  public boolean hasNext() {
    if (position >= elements.length || elements[position] == null) {
      return false;
    }

    return true;
  }

  @Override
  public E next() {
    E element = elements[position];
    position = position + 1;

    return element;
  }

  @Override
  public void remove() {
    if (position <= 0) {
      throw new IllegalStateException(
          "You cannot remove an item until you've done at least one next()");
    }

    // shift all elements up one
    if (elements[position - 1] != null) {
      for (int i = (position - 1); i < (elements.length - 1); i++) {
        elements[i] = elements[i + 1];
      }

      elements[elements.length - 1] = null;
    }
  }
}
