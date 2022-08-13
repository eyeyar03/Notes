package state;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StateTest {

  @Test
  public void insertQuarter_soldOut() {
    GumballMachine gumballMachine = new GumballMachine(0);
    String message = gumballMachine.insertQuarter();

    assertThat(message).isEqualTo("You cannot insert a quarter, the machine is sold out.");
  }

  @Test
  public void insertQuarter_noQuarter() {
    GumballMachine gumballMachine = new GumballMachine(2);
    String message = gumballMachine.insertQuarter();

    assertThat(message).isEqualTo("You inserted a quarter.");
  }

  @Test
  public void insertQuarter_hasQuarter() {
    GumballMachine gumballMachine = new GumballMachine(2);

    String message = gumballMachine.insertQuarter();
    assertThat(message).isEqualTo("You inserted a quarter.");

    message = gumballMachine.insertQuarter();
    assertThat(message).isEqualTo("You can't insert another quarter.");
  }

  @Test
  public void ejectQuarter_soldOut() {
    GumballMachine gumballMachine = new GumballMachine(0);
    String message = gumballMachine.ejectQuarter();

    assertThat(message).isEqualTo("You cannot eject a quarter, the machine is sold out.");
  }

  @Test
  public void ejectQuarter_noQuarter() {
    GumballMachine gumballMachine = new GumballMachine(2);
    String message = gumballMachine.ejectQuarter();

    assertThat(message).isEqualTo("You haven't inserted a quarter!");
  }

  @Test
  public void ejectQuarter_hasQuarter() {
    GumballMachine gumballMachine = new GumballMachine(2);
    gumballMachine.insertQuarter();
    String message = gumballMachine.ejectQuarter();

    assertThat(message).isEqualTo("Quarter returned.");
  }

  @Test
  public void turnCrank_soldOut() {
    GumballMachine gumballMachine = new GumballMachine(0);
    String message = gumballMachine.turnCrank();

    assertThat(message).isEqualTo("You turned, but there are no gumballs.");
  }

  @Test
  public void turnCrank_noQuarter() {
    GumballMachine gumballMachine = new GumballMachine(2);
    String message = gumballMachine.turnCrank();

    assertThat(message).isEqualTo("You turned but there's no quarter.");
  }

  @Test
  public void turnCrank_hasQuarter() {
    GumballMachine gumballMachine = new GumballMachine(2);
    gumballMachine.insertQuarter();
    String message = gumballMachine.turnCrank();

    assertThat(message).isEqualTo("You turned.. A gumball comes rolling out the slot.");
  }

  @Test
  public void turnCrank_twice() {
    GumballMachine gumballMachine = new GumballMachine(2);
    gumballMachine.insertQuarter();

    String message = gumballMachine.turnCrank();
    assertThat(message).isEqualTo("You turned.. A gumball comes rolling out the slot.");

    message = gumballMachine.turnCrank();
    assertThat(message).isEqualTo("You turned but there's no quarter.");
  }

  @Test
  public void testGumballMachine() {
    GumballMachine gumballMachine = new GumballMachine(5);
    System.out.println(gumballMachine);

    String message = gumballMachine.insertQuarter();
    assertThat(message).isEqualTo("You inserted a quarter.");

    message = gumballMachine.turnCrank();
    assertThat(message).isEqualTo("You turned.. A gumball comes rolling out the slot.");

    System.out.println(gumballMachine);

    message = gumballMachine.insertQuarter();
    assertThat(message).isEqualTo("You inserted a quarter.");

    message = gumballMachine.ejectQuarter();
    assertThat(message).isEqualTo("Quarter returned.");

    message = gumballMachine.turnCrank();
    assertThat(message).isEqualTo("You turned but there's no quarter.");

    System.out.println(gumballMachine);

    message = gumballMachine.insertQuarter();
    assertThat(message).isEqualTo("You inserted a quarter.");

    message = gumballMachine.turnCrank();
    assertThat(message).isEqualTo("You turned.. A gumball comes rolling out the slot.");

    message = gumballMachine.insertQuarter();
    assertThat(message).isEqualTo("You inserted a quarter.");

    message = gumballMachine.turnCrank();
    assertThat(message).isEqualTo("You turned.. A gumball comes rolling out the slot.");

    message = gumballMachine.ejectQuarter();
    assertThat(message).isEqualTo("You haven't inserted a quarter!");

    System.out.println(gumballMachine);

    message = gumballMachine.insertQuarter();
    assertThat(message).isEqualTo("You inserted a quarter.");

    message = gumballMachine.insertQuarter();
    assertThat(message).isEqualTo("You can't insert another quarter.");

    message = gumballMachine.turnCrank();
    assertThat(message).isEqualTo("You turned.. A gumball comes rolling out the slot.");

    message = gumballMachine.insertQuarter();
    assertThat(message).isEqualTo("You inserted a quarter.");

    message = gumballMachine.turnCrank();
    assertThat(message)
        .isEqualTo("You turned.. A gumball comes rolling out the slot. Oops! Out of gumball.");

    message = gumballMachine.insertQuarter();
    assertThat(message).isEqualTo("You cannot insert a quarter, the machine is sold out.");

    message = gumballMachine.turnCrank();
    assertThat(message).isEqualTo("You turned, but there are no gumballs.");

    System.out.println(gumballMachine);
  }
}
