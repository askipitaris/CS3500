package controller;

import cs3500.animator.view.IView;
import java.util.Scanner;
import model.AnimatorModel;

/**
 * Basic controller.
 */
public class Controller {

  private AnimatorModel model;
  private IView view;


  public Controller(AnimatorModel model, IView v, int tween) {
    this.view = v;
    this.model = model;
  }

  public void go() {
    this.view.setCommandCallback(this::accept);
    this.view.makeVisible();
  }

  private String processCommand(String command) throws IllegalStateException {
    StringBuilder string = new StringBuilder();
    Scanner s = new Scanner(command);
    while (s.hasNext()) {
      String in = s.next();
    }

    return null;
  }

  private void accept(String s) {
    String command = s;
    String status = "";

    try {
      status = processCommand(command);
    } catch (Exception e) {
      view.showErrorMessage(e.getMessage());
    }

    view.refresh();
  }
}
