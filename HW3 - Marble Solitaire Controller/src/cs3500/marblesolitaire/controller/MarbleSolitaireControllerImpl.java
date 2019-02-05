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
    }

    this.input = rd;
    this.output = ap;
  }

  @Override
  public void playGame(MarbleSolitaireModel model) {
    char exit;
    int fromRow;
    int fromCol;
    int toRow;
    int toCol;

    Scanner s = new Scanner(this.input);
    fromRow = s.nextInt();
    fromCol = s.nextInt();
    toRow = s.nextInt();
    toCol = s.nextInt();
    //exit = s.next().charAt(0);

    /*if (exit == 'q' || exit == 'Q') {
      try {
        this.output.append("Game quit!\nState of game when quit:\n");
        this.output.append(model.getGameState()).append("\n");
        this.output.append("Score: ").append(String.valueOf(model.getScore()));
      } catch (IOException e) {
        throw new IllegalStateException("Could not append game quite to output.");
      }
    } else*/ if (fromRow > 0 && fromCol > 0 && toRow > 0 && toCol > 0) {
      try {
        model.move(fromRow - 1, fromCol - 1, toRow - 1, toCol - 1);
      } catch (IllegalArgumentException e) {
        try {
          this.output.append("Invalid move. Play again. ").append(e.getMessage());
        } catch (IOException ignore) {
          throw new IllegalStateException("Could not append movement error to output.");
        }
      }

      if (model.isGameOver()) {
        try {
          this.output.append("Game over!\n");
          this.output.append(model.getGameState()).append("\n");
          this.output.append("Score: ").append(String.valueOf(model.getScore()));
        } catch (IOException e) {
          throw new IllegalStateException("Could not append game over to output.");
        }
      } else {
        try {
          this.output.append(model.getGameState()).append("\n");
          this.output.append("Score: ").append(String.valueOf(model.getScore()));
        } catch (IOException e) {
          throw new IllegalStateException("Could not append game state to output.");
        }
      }
    } else {
      throw new IllegalArgumentException("Invalid args.");
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