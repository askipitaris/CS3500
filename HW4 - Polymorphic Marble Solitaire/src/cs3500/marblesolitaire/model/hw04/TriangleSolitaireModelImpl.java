package cs3500.marblesolitaire.model.hw04;

/**
 * Implementation of possible operations in Triangular Marble Solitaire. One instance of the class
 * represents one instance of the game.
 */
public class TriangleSolitaireModelImpl extends AbstractSolitaireModelImpl {

  /**
   * Constructor 1: Constructs a game using no arguments. Creates a game with an arm thickness of 3,
   * with the center at a default position.
   */
  public TriangleSolitaireModelImpl() {

  }

  /**
   * Constructor 2: Constructs a game with an empty space a specified row and column with an arm
   * thickness of 3.Throws IllegalArgumentException with message "Invalid empty cell position (r,c)"
   * if the specified position is not valid.
   */
  public TriangleSolitaireModelImpl(int sRow, int sCol) {

  }

  /**
   * Constructor 3: Constructs a game using the specified arm thickness with an empty space at an
   * automatically determined position. Throws an IllegalArgumentException with message "Arm
   * thickness must be positive and odd."
   */
  public TriangleSolitaireModelImpl(int armThickness) {

  }

  /**
   * Constructor 4: Constructs a game using the specified arm thickness with an empty position at
   * the specified row and column. Throws an IllegalArgumentException if the position is invalid or
   * if the thickness is invalid
   */
  public TriangleSolitaireModelImpl(int armThickness, int sRow, int sCol) {

  }
}
