package cs3500.marblesolitaire.controller;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import java.io.IOException;
import java.util.Scanner;

/**
 * Implementation of MarbleSolitaireController. One instance of this class in one instance of the
 * controller.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {

  private Readable input;
  private Appendable output;

  /**
   * Constructs a new controller.
   *
   * @param rd is the given input.
   * @param ap is the output resulting from the given input.
   * @throws IllegalArgumentException if rd or ap is null.
   */
  public MarbleSolitaireControllerImpl(Readable rd, Appendable ap) throws IllegalArgumentException {
    if (rd == null || ap == null) {
      throw new IllegalArgumentException("Neither argument can be null.");
    } else {
      this.input = rd;
      this.output = ap;
    }
  }

  @Override
  public void playGame(MarbleSolitaireModel model) {
    if (model == null) {
      throw new IllegalArgumentException("Model cannot be null.");
    }

    Scanner s = new Scanner(this.input);

    int fromRow = 0;
    int fromCol = 0;
    int toRow = 0;
    int toCol = 0;

    while (s.hasNext()) {
      String nextValue = s.next();

      try {
        if (Integer.parseInt(nextValue) > 0) {
          if (fromRow <= 0) {
            fromRow = Integer.parseInt(nextValue);
          } else if (fromCol <= 0) {
            fromCol = Integer.parseInt(nextValue);
          } else if (toRow <= 0) {
            toRow = Integer.parseInt(nextValue);
          } else if (toCol <= 0) {
            toCol = Integer.parseInt(nextValue);
          }
        }
      } catch (NumberFormatException nfe) {
        if (nextValue.equals("q") || nextValue.equals("Q")) {
          this.appendText("Game quit!\n"
              + "State of game when quit:\n"
              + model.getGameState() + "\n"
              + "Score: " + model.getScore());
          return;
        } else {
          this.appendText("Invalid value. Play again. \"" + nextValue + "\" is not valid.\n");
        }
      }

      if (fromRow > 0 && fromCol > 0 && toRow > 0 && toCol > 0) {
        try {
          model.move(fromRow - 1, fromCol - 1, toRow - 1, toCol - 1);
        } catch (IllegalArgumentException e) {
          this.appendText("Invalid move.\n");
        }

        fromRow = 0;
        fromCol = 0;
        toRow = 0;
        toCol = 0;
      }

      if (model.isGameOver()) {
        this.appendText("Game over!\n"
            + model.getGameState() + "\n"
            + "Score: " + model.getScore());
        return;
      }
    }

    if (!model.isGameOver()) {
      throw new IllegalStateException("Premature termination.");
    }
  }

  /**
   * Adds the given text to the output.
   *
   * @param text is the text to be appended.
   */
  private void appendText(String text) {
    try {
      this.output.append(text);
    } catch (IOException ioe) {
      throw new IllegalStateException("Unable to append text");
    }
  }

  /**
   * Returns the input field.
   */
  public Readable getInput() {
    return this.input;
  }

  /**
   * Returns the output field.
   */
  public Appendable getOutput() {
    return this.output;
  }
}