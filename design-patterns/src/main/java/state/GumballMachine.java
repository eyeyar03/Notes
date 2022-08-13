package state;

public class GumballMachine {

  private static final int SOLD_OUT = 0;

  private static final int NO_QUARTER = 1;

  private static final int HAS_QUARTER = 2;

  private static final int SOLD = 3;

  private int state = SOLD_OUT; // start at SOLD_OLD state

  private int count = 0; // number of gumballs in the machine

  public GumballMachine(int count) {
    this.count = count;

    if (count > 0) {
      state = NO_QUARTER;
    }
  }

  public String insertQuarter() {
    String message = null;

    if (SOLD_OUT == state) {
      message = "You cannot insert a quarter, the machine is sold out.";

    } else if (NO_QUARTER == state) {
      state = HAS_QUARTER;
      message = "You inserted a quarter.";

    } else if (HAS_QUARTER == state) {
      message = "You can't insert another quarter.";

      // This must not happen.
    } else if (SOLD == state) {
      message = "Please wait, we're already giving you a gumball.";
    }

    return message;
  }

  public String ejectQuarter() {
    String message = null;

    if (SOLD_OUT == state) {
      message = "You cannot eject a quarter, the machine is sold out.";

    } else if (NO_QUARTER == state) {
      message = "You haven't inserted a quarter!";

    } else if (HAS_QUARTER == state) {
      state = NO_QUARTER;
      message = "Quarter returned.";

      // This must not happen.
    } else if (SOLD == state) {
      message = "Sorry, you already turned the crank.";
    }

    return message;
  }

  public String turnCrank() {
    String message = null;

    if (SOLD_OUT == state) {
      message = "You turned, but there are no gumballs.";

    } else if (NO_QUARTER == state) {
      message = "You turned but there's no quarter.";

    } else if (HAS_QUARTER == state) {
      state = SOLD;
      message = "You turned.. " + dispense();

      // This must not happen.
    } else if (SOLD == state) {
      message = "Turning twice doesn't give you another gumball!";
    }

    return message;
  }

  private String dispense() {
    String message = null;

    if (count == 0) {
      message = "Oops! Out of gumball.";
      state = SOLD_OUT;

    } else {
      if (NO_QUARTER == state) {
        message = "You have to pay first.";

      } else if (SOLD_OUT == state || HAS_QUARTER == state) {
        message = "No gumball dispensed.";

      } else if (SOLD == state) {
        message = "A gumball comes rolling out the slot.";
        count -= 1;
        if (count > 0) {
          state = NO_QUARTER;
        } else {
          message += " Oops! Out of gumball.";
          state = SOLD_OUT;
        }
      }
    }

    return message;
  }

  @Override
  public String toString() {
    StringBuffer sb = new StringBuffer();
    sb.append("################################################\n");
    sb.append("Mighty Gumball, Inc.\n");
    sb.append("Java-Enabled Standing Gumball Model #2022\n");
    sb.append("Inventory: " + count + " gumballs\n");

    if (SOLD_OUT == state) {
      sb.append("Machine needs to be refilled.");

    } else if (NO_QUARTER == state) {
      sb.append("Machine is waiting for quarter.");

    } else if (HAS_QUARTER == state || SOLD == state) {
      sb.append("Machine is ready to dispense gumball.");
    }

    sb.append("\n################################################\n");

    return sb.toString();
  }
}
