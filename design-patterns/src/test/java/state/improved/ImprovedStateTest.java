package state.improved;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ImprovedStateTest {

  @Test
  public void insertQuarter_soldOut() {
    ImprovedGumballMachine improvedGumballMachine = new ImprovedGumballMachine(0);
    String message = improvedGumballMachine.insertQuarter();

    assertThat(message).isEqualTo("You cannot insert a quarter, the machine is sold out.");
  }

  @Test
  public void insertQuarter_noQuarter() {
    ImprovedGumballMachine improvedGumballMachine = new ImprovedGumballMachine(2);
    String message = improvedGumballMachine.insertQuarter();

    assertThat(message).isEqualTo("You inserted a quarter.");
  }

  @Test
  public void insertQuarter_hasQuarter() {
    ImprovedGumballMachine improvedGumballMachine = new ImprovedGumballMachine(2);

    String message = improvedGumballMachine.insertQuarter();
    assertThat(message).isEqualTo("You inserted a quarter.");

    message = improvedGumballMachine.insertQuarter();
    assertThat(message).isEqualTo("You can't insert another quarter.");
  }

  @Test
  public void ejectQuarter_soldOut() {
    ImprovedGumballMachine improvedGumballMachine = new ImprovedGumballMachine(0);
    String message = improvedGumballMachine.ejectQuarter();

    assertThat(message).isEqualTo("You cannot eject a quarter, the machine is sold out.");
  }

  @Test
  public void ejectQuarter_noQuarter() {
    ImprovedGumballMachine improvedGumballMachine = new ImprovedGumballMachine(2);
    String message = improvedGumballMachine.ejectQuarter();

    assertThat(message).isEqualTo("You haven't inserted a quarter!");
  }

  @Test
  public void ejectQuarter_hasQuarter() {
    ImprovedGumballMachine improvedGumballMachine = new ImprovedGumballMachine(2);
    improvedGumballMachine.insertQuarter();
    String message = improvedGumballMachine.ejectQuarter();

    assertThat(message).isEqualTo("Quarter returned.");
  }

  @Test
  public void turnCrank_soldOut() {
    ImprovedGumballMachine improvedGumballMachine = new ImprovedGumballMachine(0);
    String message = improvedGumballMachine.turnCrank();

    assertThat(message).isEqualTo("You turned, but there are no gumballs.");
  }

  @Test
  public void turnCrank_noQuarter() {
    ImprovedGumballMachine improvedGumballMachine = new ImprovedGumballMachine(2);
    String message = improvedGumballMachine.turnCrank();

    assertThat(message).isEqualTo("You turned but there's no quarter.");
  }

  @Test
  public void turnCrank_hasQuarter() {
    ImprovedGumballMachine improvedGumballMachine = new ImprovedGumballMachine(2);
    improvedGumballMachine.insertQuarter();
    String message = improvedGumballMachine.turnCrank();

    assertThat(message).isEqualTo("You turned.. A gumball comes rolling out the slot.");
  }

  @Test
  public void turnCrank_twice() {
    ImprovedGumballMachine improvedGumballMachine = new ImprovedGumballMachine(2);
    improvedGumballMachine.insertQuarter();

    String message = improvedGumballMachine.turnCrank();
    assertThat(message).isEqualTo("You turned.. A gumball comes rolling out the slot.");

    message = improvedGumballMachine.turnCrank();
    assertThat(message).isEqualTo("You turned but there's no quarter.");
  }

  /*
   * Note that this test will fail sometimes because of random winner (See HasQuarterState's turnCrank method)
   */
  @Test
  public void testGumballMachine() {
    ImprovedGumballMachine improvedGumballMachine = new ImprovedGumballMachine(5);
    System.out.println(improvedGumballMachine);

    String message = improvedGumballMachine.insertQuarter();
    assertThat(message).isEqualTo("You inserted a quarter.");

    message = improvedGumballMachine.turnCrank();
    assertThat(message).isEqualTo("You turned.. A gumball comes rolling out the slot.");

    System.out.println(improvedGumballMachine);

    message = improvedGumballMachine.insertQuarter();
    assertThat(message).isEqualTo("You inserted a quarter.");

    message = improvedGumballMachine.ejectQuarter();
    assertThat(message).isEqualTo("Quarter returned.");

    message = improvedGumballMachine.turnCrank();
    assertThat(message).isEqualTo("You turned but there's no quarter.");

    System.out.println(improvedGumballMachine);

    message = improvedGumballMachine.insertQuarter();
    assertThat(message).isEqualTo("You inserted a quarter.");

    message = improvedGumballMachine.turnCrank();
    assertThat(message).isEqualTo("You turned.. A gumball comes rolling out the slot.");

    message = improvedGumballMachine.insertQuarter();
    assertThat(message).isEqualTo("You inserted a quarter.");

    message = improvedGumballMachine.turnCrank();
    assertThat(message).isEqualTo("You turned.. A gumball comes rolling out the slot.");

    message = improvedGumballMachine.ejectQuarter();
    assertThat(message).isEqualTo("You haven't inserted a quarter!");

    System.out.println(improvedGumballMachine);

    message = improvedGumballMachine.insertQuarter();
    assertThat(message).isEqualTo("You inserted a quarter.");

    message = improvedGumballMachine.insertQuarter();
    assertThat(message).isEqualTo("You can't insert another quarter.");

    message = improvedGumballMachine.turnCrank();
    assertThat(message).isEqualTo("You turned.. A gumball comes rolling out the slot.");

    message = improvedGumballMachine.insertQuarter();
    assertThat(message).isEqualTo("You inserted a quarter.");

    message = improvedGumballMachine.turnCrank();
    assertThat(message)
        .isEqualTo("You turned.. A gumball comes rolling out the slot. Oops! Out of gumballs.");

    message = improvedGumballMachine.insertQuarter();
    assertThat(message).isEqualTo("You cannot insert a quarter, the machine is sold out.");

    message = improvedGumballMachine.turnCrank();
    assertThat(message).isEqualTo("You turned, but there are no gumballs.");

    System.out.println(improvedGumballMachine);
  }

  @Test
  public void testRefill() {
    ImprovedGumballMachine improvedGumballMachine = new ImprovedGumballMachine(0);
    System.out.println(improvedGumballMachine);

    String message = improvedGumballMachine.insertQuarter();
    assertThat(message).isEqualTo("You cannot insert a quarter, the machine is sold out.");

    message = improvedGumballMachine.ejectQuarter();
    assertThat(message).isEqualTo("You cannot eject a quarter, the machine is sold out.");

    message = improvedGumballMachine.turnCrank();
    assertThat(message).isEqualTo("You turned, but there are no gumballs.");

    improvedGumballMachine.refill(5);

    System.out.println(improvedGumballMachine);

    message = improvedGumballMachine.insertQuarter();
    assertThat(message).isEqualTo("You inserted a quarter.");

    message = improvedGumballMachine.ejectQuarter();
    assertThat(message).isEqualTo("Quarter returned.");

    message = improvedGumballMachine.insertQuarter();
    assertThat(message).isEqualTo("You inserted a quarter.");

    message = improvedGumballMachine.turnCrank();
    System.out.println(message);

    System.out.println(improvedGumballMachine);
  }

  @Test
  public void test() {
final String[] TODO_WHAT = new String[]{"suck his thumb", "tie his shoe", "climb a tree", "shut the door", "check the skies", "pick up sticks", "eat a lemon", "he is feeling great", "check the time", "say \"THE END!\""};
StringBuilder lyricsBuilder = new StringBuilder();
for (int i = 1; i < 11; i++) {
for (int j = 0; j < 3; j++) {
lyricsBuilder.append(String.format("The ants go marching %d by %d", i, i));
if (j < 2) {
lyricsBuilder.append("\nHurrah! hurrah!\n");
} else {
lyricsBuilder.append("\nThe little ones stops");
}
}
if (i == 8 ){
lyricsBuilder.append(", ");
} else {
lyricsBuilder.append(" to ");
}
lyricsBuilder.append(TODO_WHAT[i - 1]);
lyricsBuilder.append("\nAnd they all go marching down to the ground");
lyricsBuilder.append("\nTo get out of the rain");
lyricsBuilder.append("\nBoom! Boom! Boom! Boom!");
}

System.out.println(lyricsBuilder);
  }
}
