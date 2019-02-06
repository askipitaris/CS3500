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
      char temp = s.next().charAt(0);

      if (Character.isDigit(temp) && Integer.parseInt(Character.toString(temp)) > 0) {
        if (fromRow <= 0) {
          fromRow = Integer.parseInt(Character.toString(temp));
        } else if (fromCol <= 0) {
          fromCol = Integer.parseInt(Character.toString(temp));
        } else if (toRow <= 0) {
          toRow = Integer.parseInt(Character.toString(temp));
        } else if (toCol <= 0) {
          toCol = Integer.parseInt(Character.toString(temp));
        }
      }

      if (fromRow > 0 && fromCol > 0 && toRow > 0 && toCol > 0) {
        try {
          model.move(fromRow - 1, fromCol - 1, toRow - 1, toCol - 1);
        } catch (IllegalArgumentException e) {
          try {
            this.output.append("Invalid move.\n");
          } catch (IOException ioe) {
            throw new IllegalStateException("Unable to append Invalid move");
          }
        }

        fromRow = 0;
        fromCol = 0;
        toRow = 0;
        toCol = 0;
      }

      if (temp == 'q' || temp == 'Q') {
        try {
          this.output.append("Game quit!\n").append("State of game when quit:\n");
        } catch (IOException ioe) {
          throw new IllegalStateException("Unable to append game quit");
        }

        this.appendGameState(model);
        return;
      } else if (model.isGameOver()) {
        try {
          this.output.append("Game over!\n");
        } catch (IOException ioe) {
          throw new IllegalStateException("Unable to append game over");
        }
        this.appendGameState(model);
        return;
      } else if (!Character.isDigit(temp)
          || (Character.isDigit(temp) && Integer.parseInt(Character.toString(temp)) <= 0)) {
        try {
          this.output.append("Invalid value. Play again. '").append(temp)
              .append("' is not valid.\n");
        } catch (IOException ioe) {
          throw new IllegalStateException("Unable to append Invalid value.");
        }
      }
    }

    if (!model.isGameOver()) {
      throw new IllegalStateException("Premature termination.");
    }
  }

  /**
   * Appends the current board and score to the output.
   *
   * @param model is the model currently being used.
   */
  private void appendGameState(MarbleSolitaireModel model) {
    try {
      this.output.append(model.getGameState()).append("\n").append("Score: ")
          .append(String.valueOf(model.getScore()));
    } catch (IOException ioe) {
      throw new IllegalStateException("Unable to append move.");
    }
  }

  /**
   * Returns the input option.
   */
  public Readable getInput() {
    return this.input;
  }

  /**
   * Returns the output.
   */
  public Appendable getOutput() {
    return this.output;
  }
}