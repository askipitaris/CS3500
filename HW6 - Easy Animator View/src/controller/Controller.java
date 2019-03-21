package controller;

import cs3500.animator.view.IView;
import java.util.Scanner;
import model.AnimatorModel;

/**
 * Basic controller.
 */
public class Controller {

  private IView view;

  public Controller(IView v) {
    this.view = v;
    AnimatorModel model = v.getAnimatorModel();
  }

  public void runAll() {
    this.view.setCommandCallback(this::accept);
    this.view.makeVisible();
  }

  /**
   * Outputs the commands that the user specifies.
   *
   * @param command the command that the user specifies
   * @return the commands that the user specifies
   * @throws IllegalStateException if there is not a next
   */
  private String processCommand(String command) throws IllegalStateException {
    StringBuilder string = new StringBuilder();
    Scanner s = new Scanner(command);
    while (s.hasNext()) {
      String in = s.next();
    }

    return string.toString();
  }

  /**
   * Accepts a command to process.
   *
   * @param s is the command that is being accepted
   */
  private void accept(String s) {
    String status = "";

    try {
      status = processCommand(s);
    } catch (Exception e) {
      view.showErrorMessage(e.getMessage());
    }

    view.refresh();
  }
}
