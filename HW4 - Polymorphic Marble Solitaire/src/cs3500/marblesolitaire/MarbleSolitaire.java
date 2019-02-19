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
   * The method iterates through every argument and determines which type of constructor needs to be
   * given to the controller. The arguments can be given in any order and are whitespace delimited,
   * meaning "english -size 5 -hole 5 6" is equally valid as "-hole 5 6 english -size 5".
   *
   * @param args are the arguments given the program.
   */
  public static void main(String[] args) {
    String type = "";
    boolean optionalSize = false;
    boolean optionalHole = false;
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
            optionalSize = true;
            break;
          case "-hole":
            sRow = Integer.parseInt(args[i + 1]);
            sCol = Integer.parseInt(args[i + 2]);
            i += 2;
            optionalHole = true;
            break;
          default:
            break;
        }
      } catch (IndexOutOfBoundsException oob) {
        System.out.println("Invalid arguments");
      }
    }

    try {
      controller.playGame(getModel(size, sRow, sCol, optionalSize, optionalHole, type));
    } catch (IllegalArgumentException e) {
      System.out.println("Something went wrong");
    }
  }

  /**
   * Determines which model should be used given from the command line arguments.
   *
   * <p>Each if statement checks which optional arguments were given in the initial command in
   * order to determine which version of the constructors to use. Within each if statement
   * is a switch  statement that determines which version of marble solitaire is supposed to be
   * created.
   *
   * <p>Because when the user specifies the location for the empty position, they that start at 1
   * instead of at 0 (for instance a location that would be 3,3 in the model is input as 4,4),
   * the inputted rows and columns are subtracted by one when given to the model.
   *
   * @param size the given size of the board.
   * @param sRow the row of the selected empty position.
   * @param sCol the column of the selected empty position.
   * @param optionalSize whether the size is different than the default.
   * @param optionalHole whether the empty position is different than the default.
   * @param type the type of marble solitaire.
   * @return the correct model needed from the arguments.
   */
  private static MarbleSolitaireModel getModel(int size, int sRow, int sCol, boolean optionalSize,
      boolean optionalHole, String type) throws IllegalArgumentException {
    if (optionalSize && optionalHole) {
      switch (type) {
        case "english":
          return new MarbleSolitaireModelImpl(size, sRow - 1, sCol - 1);
        case "european":
          return new EuropeanSolitaireModelImpl(size, sRow - 1, sCol - 1);
        case "triangular":
          return new TriangleSolitaireModelImpl(size, sRow - 1, sCol - 1);
        default:
          break;
      }
    } else if (optionalSize) {
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
    } else if (optionalHole) {
      switch (type) {
        case "english":
          return new MarbleSolitaireModelImpl(sRow - 1, sCol - 1);
        case "european":
          return new EuropeanSolitaireModelImpl(sRow - 1, sCol - 1);
        case "triangular":
          return new TriangleSolitaireModelImpl(sRow - 1, sCol - 1);
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