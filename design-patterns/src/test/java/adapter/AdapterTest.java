package adapter;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AdapterTest {

    @Test
    public void testTurkeyAsDuck() {
        Duck duck = new MallardDuck();
        Turkey turkey = new WildTurkey();

        Duck turkeyAdapter = new TurkeyAdapter(turkey);

        System.out.println("The turkey says...");
        turkey.gobble();
        turkey.fly();

        System.out.println("\nThe duck says...");
        testDuck(duck);

        System.out.println("\nThe turkeyAdapter says...");
        testDuck(turkeyAdapter);
    }

    @Test
    public void testDuckAsTurkey() {
        Duck duck = new MallardDuck();
        Turkey turkey = new WildTurkey();

        Turkey duckAdapter = new DuckAdapter(duck);

        System.out.println("The turkey says...");
        turkey.gobble();
        turkey.fly();

        System.out.println("\nThe duck says...");
        testDuck(duck);

        System.out.println("\nThe duckAdapter says...");
        testTurkey(duckAdapter);
    }

    // Note that this method is able to make turkey quack and fly too by wrapping the turkey in TurkeyAdapter
    private void testDuck(Duck duck) {
        duck.quack();
        duck.fly();
    }

    // Note that this method is able to make duck gobble and fly too by wrapping the duck in DuckAdapter
    private void testTurkey(Turkey turkey) {
        turkey.gobble();
        turkey.fly();
    }

    @Test
    public void adaptEnumerationToIterator() {
        Enumeration<String> enumeration = Collections.enumeration(Lists.list("One", "Two", "Three"));
        Iterator<String> enumerationAdapter = new EnumerationAdapter<>(enumeration);

        iterate(enumerationAdapter);
    }

    @Test
    public void testRemoveOnEnumerationAdapter_throwsUnsupportedOperationException() {
        Enumeration<String> enumeration = Collections.enumeration(Lists.list("One", "Two", "Three"));
        Iterator<String> enumerationAdapter = new EnumerationAdapter<>(enumeration);

        Exception exception = assertThrows(UnsupportedOperationException.class, () -> removeItem(enumerationAdapter));

        assertThat(exception.getMessage()).isEqualTo("Enumeration is a readonly interface and doesn't support remove...");
    }

    private <T> void iterate(Iterator<T> iterator) {
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private <T> void removeItem(Iterator<T> iterator) {
        iterator.remove();
    }
}
