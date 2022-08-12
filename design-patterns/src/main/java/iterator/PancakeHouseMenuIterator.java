package iterator;

import java.util.List;

public class PancakeHouseMenuIterator<E> implements Iterator<E> {

  private final List<E> elements;

  private int position = 0;

  public PancakeHouseMenuIterator(List<E> elements) {
    this.elements = elements;
  }

  @Override
  public boolean hasNext() {
    if (position >= elements.size()) {
      return false;
    }

    return true;
  }

  @Override
  public E next() {
    E element = elements.get(position);
    position = position + 1;

    return element;
  }
}
