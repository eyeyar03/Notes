package state.improved;

public class SoldState implements State {

  private final ImprovedGumballMachine improvedGumballMachine;

  public SoldState(ImprovedGumballMachine improvedGumballMachine) {
    this.improvedGumballMachine = improvedGumballMachine;
  }

  @Override
  public String insertQuarter() {
    return "Please wait, we're already giving you a gumball.";
  }

  @Override
  public String ejectQuarter() {
    return "Sorry, you already turned the crank.";
  }

  @Override
  public String turnCrank() {
    return "Turning twice doesn't give you another gumball!";
  }

  @Override
  public String dispense() {

    String message;

    if (improvedGumballMachine.getCount() < 1) {
      message = "Oops! Out of gumballs.";
      improvedGumballMachine.setState(improvedGumballMachine.getSoldOutState());

    } else {
      message = improvedGumballMachine.releaseBall();

      if (improvedGumballMachine.getCount() > 0) {
        improvedGumballMachine.setState(improvedGumballMachine.getNoQuarterState());

      } else {
        message = message + " Oops! Out of gumballs.";
        improvedGumballMachine.setState(improvedGumballMachine.getSoldOutState());
      }
    }

    return message;
  }
}
