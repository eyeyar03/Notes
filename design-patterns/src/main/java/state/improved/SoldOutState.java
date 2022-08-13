package state.improved;

public class SoldOutState implements State {

  private final ImprovedGumballMachine improvedGumballMachine;

  public SoldOutState(ImprovedGumballMachine improvedGumballMachine) {
    this.improvedGumballMachine = improvedGumballMachine;
  }

  @Override
  public String insertQuarter() {
    return "You cannot insert a quarter, the machine is sold out.";
  }

  @Override
  public String ejectQuarter() {
    return "You cannot eject a quarter, the machine is sold out.";
  }

  @Override
  public String turnCrank() {
    return "You turned, but there are no gumballs.";
  }

  @Override
  public String dispense() {
    return "You cannot dispense a gumball, the machine is sold out.";
  }
}
