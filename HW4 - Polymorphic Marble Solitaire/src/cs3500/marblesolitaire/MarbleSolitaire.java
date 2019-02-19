package cs3500.marblesolitaire;

import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl;
import java.io.InputStreamReader;

/**
 * Main class for Marble Solitaire. Creates and runs a version of marble solitaire that is played
 * through the command line.
 */
public final class MarbleSolitaire {

  /**
   * Takes in a series of arguments that construct a game of Marble Solitaire. Arguments are
   * whitespace delimited. Valid arguments start with the type of game ("english", "european", or
   * "triangular") with optional arguments afterwards. Optional arguments are -size N or -hole N1 N2
   * and can be in any order.
   *
   * @param args are the arguments that the main methods accept.
   */
  public static void main(String[] args) {
    String type = "";
    boolean optionSize = false;
    boolean optionHole = false;
    int size = 3;
    int sRow = 3;
    int sCol = 3;

    MarbleSolitaireControllerImpl controller =
        new MarbleSolitaireControllerImpl(new InputStreamReader(System.in), System.out);

    for (int i = 0; i < args.length; i++) {
      try {
        switch (args[i]) {
          case "english":
          case "european":
          case "triangular":
            type = args[i];
            break;
          case "-size":
            size = Integer.parseInt(args[i + 1]);
            i += 1;
            optionSize = true;
            break;
          case "-hole":
            sRow = Integer.parseInt(args[i + 1]);
            sCol = Integer.parseInt(args[i + 2]);
            i += 2;
            optionHole = true;
            break;
          default:
            System.out.println(args[0] + " is not a valid marble solitaire type.");
        }
      } catch (IndexOutOfBoundsException oob) {
        System.out.println("Invalid arguments");
      }
    }

    try {
      controller.playGame(getModel(size, sRow, sCol, optionSize, optionHole, type));
    } catch (IllegalArgumentException e) {
      System.out.println("Something went wrong");
    }
  }

  /**
   * Determines which model should be used given from the command line arguments.
   *
   * @param size the given size of the board.
   * @param sRow the row of the selected empty position.
   * @param sCol the column of the selected empty position.
   * @param optionSize whether the size is different than default.
   * @param optionHole whether the empty position is different than default.
   * @param type the type of marble solitaire.
   * @return the correct model needed from the arguments.
   */
  private static MarbleSolitaireModel getModel(int size, int sRow, int sCol, boolean optionSize,
      boolean optionHole, String type) {
    if (optionSize && optionHole) {
      switch (type) {
        case "english":
          return new MarbleSolitaireModelImpl(size, sRow, sCol);
        case "european":
          return new EuropeanSolitaireModelImpl(size, sRow, sCol);
        case "triangular":
          return new TriangleSolitaireModelImpl(size, sRow, sCol);
        default:
          break;
      }
    } else if (optionSize) {
      switch (type) {
        case "english":
          return new MarbleSolitaireModelImpl(size);
        case "european":
          return new EuropeanSolitaireModelImpl(size);
        case "triangular":
          return new TriangleSolitaireModelImpl(size);
        default:
          break;
      }
    } else if (optionHole) {
      switch (type) {
        case "english":
          return new MarbleSolitaireModelImpl(sRow, sCol);
        case "european":
          return new EuropeanSolitaireModelImpl(sRow, sCol);
        case "triangular":
          return new TriangleSolitaireModelImpl(sRow, sCol);
        default:
          break;
      }
    } else {
      switch (type) {
        case "english":
          return new MarbleSolitaireModelImpl();
        case "european":
          return new EuropeanSolitaireModelImpl();
        case "triangular":
          return new TriangleSolitaireModelImpl();
        default:
          break;
      }
    }
    throw new IllegalArgumentException("Invalid arguments");
  }
}