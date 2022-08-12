package iterator;

public class DinerMenuIterator<E> implements Iterator<E> {

  private final E[] elements;

  private int position = 0;

  public DinerMenuIterator(E[] e) {
    this.elements = e;
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
}
