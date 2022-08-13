package state.improved;

public class ImprovedGumballMachine {

  private final State soldOutState;

  private final State noQuarterState;

  private final State hasQuarterState;

  private final State soldState;

  private final State winnerState;

  private State state;

  private int count = 0;

  public ImprovedGumballMachine(int count) {
    this.soldOutState = new SoldOutState(this);
    this.noQuarterState = new NoQuarterState(this);
    this.hasQuarterState = new HasQuarterState(this);
    this.soldState = new SoldState(this);
    this.winnerState = new WinnerState(this);
    this.count = count;

    if (this.count > 0) {
      state = noQuarterState;

    } else {
      state = soldOutState;
    }
  }

  public String insertQuarter() {
    return state.insertQuarter();
  }

  public String ejectQuarter() {
    return state.ejectQuarter();
  }

  public String turnCrank() {
    return state.turnCrank();
  }

  public String releaseBall() {
    String message = "A gumball comes rolling out the slot.";
    count = count - 1;

    return message;
  }

  public int getCount() {
    return count;
  }

  public void refill(int count) {
    this.count = this.count + count;

    if (this.count > 0) {
      state = noQuarterState;
    } else {
      state = soldOutState;
    }
  }

  public void setState(State state) {
    this.state = state;
  }

  public State getSoldOutState() {
    return soldOutState;
  }

  public State getNoQuarterState() {
    return noQuarterState;
  }

  public State getHasQuarterState() {
    return hasQuarterState;
  }

  public State getSoldState() {
    return soldState;
  }

  public State getWinnerState() {
    return winnerState;
  }

  @Override
  public String toString() {
    StringBuffer sb = new StringBuffer();
    sb.append("################################################\n");
    sb.append("Mighty Gumball, Inc.\n");
    sb.append("Java-Enabled Standing Gumball (Improved) Model #2022\n");
    sb.append("Inventory: " + count + " gumballs\n");

    if (soldOutState == state) {
      sb.append("Machine needs to be refilled.");

    } else if (noQuarterState == state) {
      sb.append("Machine is waiting for quarter.");

    } else if (hasQuarterState == state || soldState == state) {
      sb.append("Machine is ready to dispense gumball.");
    }

    sb.append("\n################################################\n");

    return sb.toString();
  }
}
