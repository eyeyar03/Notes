package state.improved;

public class NoQuarterState implements State {

  private final ImprovedGumballMachine improvedGumballMachine;

  public NoQuarterState(ImprovedGumballMachine improvedGumballMachine) {
    this.improvedGumballMachine = improvedGumballMachine;
  }

  @Override
  public String insertQuarter() {
    improvedGumballMachine.setState(improvedGumballMachine.getHasQuarterState());

    return "You inserted a quarter.";
  }

  @Override
  public String ejectQuarter() {
    return "You haven't inserted a quarter!";
  }

  @Override
  public String turnCrank() {
    return "You turned but there's no quarter.";
  }

  @Override
  public String dispense() {
    return "You need to pay first!";
  }
}
