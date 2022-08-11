package templatemethod;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TeaWithHook extends CaffeineBeverageWithHook {

  @Override
  void brew() {
    System.out.println("Steeping the tea...");
  }

  @Override
  void addCondiments() {
    System.out.println("Adding lemon...");
  }

  @Override
  protected boolean customerWantsCondiments() {
    String answer = getUserInput();

    if (answer.toLowerCase().startsWith("y")) {
      return true;
    }

    return false;
  }

  private String getUserInput() {
    String answer = null;
    System.out.print("Would you like lemon with your tea (y/n)? ");
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    try {
      answer = in.readLine();

    } catch (Exception e) {
      System.err.println("Exception trying to read your answer...");
    }

    if (answer == null) {
      answer = "n";
    }

    return answer;
  }
}
