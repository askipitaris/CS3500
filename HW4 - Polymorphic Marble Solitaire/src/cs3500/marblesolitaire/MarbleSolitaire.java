package cs3500.marblesolitaire;

import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl;
import java.io.InputStreamReader;

/**
 * Main method for Marble Solitaire. Used to run the game.
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
    int size = 0;
    int sRow = 0;
    int sCol = 0;
    MarbleSolitaireControllerImpl controller =
        new MarbleSolitaireControllerImpl(new InputStreamReader(System.in), System.out);

    if (args[0].equals("english") || args[0].equals("european")) {
      type = args[0];
      size = 3;
      sRow = 3;
      sCol = 3;
    } else if (args[0].equals("triangular")) {
      type = args[0];
      size = 5;
      sRow = 0;
      sCol = 0;
    }

    if (args.length >= 2 && args[1].equals("-size")) {
      size = Integer.parseInt(args[2]);
      sRow = Integer.parseInt(args[2]) - 1;
      sCol = Integer.parseInt(args[2]) - 1;
    } else if (args.length >= 2 && args[1].equals("-hole")) {
      sRow = Integer.parseInt(args[2]) - 1;
      sCol = Integer.parseInt(args[3]) - 1;
    }

    if (args.length >= 5 && args[3].equals("-hole")) {
      sRow = Integer.parseInt(args[4]) - 1;
      sCol = Integer.parseInt(args[5]) - 1;
    } else if (args.length >= 5 && args[4].equals("-size")) {
      size = Integer.parseInt(args[5]);
    }

    try {
      switch (type) {
        case "english":
          controller.playGame(new MarbleSolitaireModelImpl(size, sRow, sCol));
          break;
        case "european":
          controller.playGame(new EuropeanSolitaireModelImpl(size, sRow, sCol));
          break;
        case "triangular":
          controller.playGame(new TriangleSolitaireModelImpl(size, sRow, sCol));
          break;
        default:
          break;
      }
    } catch (IllegalArgumentException e) {
      System.out.println("Something failed");
      e.printStackTrace();
    }
  }
}