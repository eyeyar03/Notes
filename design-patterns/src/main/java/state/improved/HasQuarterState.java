package state.improved;

import java.util.Random;

public class HasQuarterState implements State {

  private final ImprovedGumballMachine improvedGumballMachine;

  private Random randomWinner = new Random(System.currentTimeMillis());

  public HasQuarterState(ImprovedGumballMachine improvedGumballMachine) {
    this.improvedGumballMachine = improvedGumballMachine;
  }

  @Override
  public String insertQuarter() {
    return "You can't insert another quarter.";
  }

  @Override
  public String ejectQuarter() {
    improvedGumballMachine.setState(improvedGumballMachine.getNoQuarterState());
    return "Quarter returned.";
  }

  @Override
  public String turnCrank() {
    String message = "You turned.. ";

    State nextState = improvedGumballMachine.getSoldState();

    int winner = randomWinner.nextInt(10);
    if ((winner == 0) && (improvedGumballMachine.getCount() > 1)) {
      nextState = improvedGumballMachine.getWinnerState();
    }

    improvedGumballMachine.setState(nextState);

    // Only call SoldState's (or WinnerState's) dispense here
    message = message + nextState.dispense();

    return message;
  }

  @Override
  public String dispense() {
    return "No gumball dispensed.";
  }
}
