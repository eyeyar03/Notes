package compound;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Applying Composite Pattern
public class Flock implements Quackable {

  private List<Quackable> quackables = new ArrayList<>();

  public void add(Quackable quackable) {
    quackables.add(quackable);
  }

  @Override
  public String quack() {
    return quackables.stream().map(Quackable::quack).collect(Collectors.joining(", "));
  }

  @Override
  public void registerObserver(Observer observer) {
    quackables.forEach(q -> q.registerObserver(observer));
  }

  @Override
  public void notifyObservers() {
    quackables.forEach(Quackable::notifyObservers);
  }
}
