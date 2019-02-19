package cs3500.marblesolitaire.model.hw02;

import cs3500.marblesolitaire.model.hw04.AbstractSolitaireModelImpl;

/**
 * Implementation of possible operations in English Marble Solitaire. One instance of the class
 * represents one instance of the game.
 *
 * <p>This version of marble solitaire has a grid in the shape of a cross, with valid movements
 * being those that jump over a marble to an empty position two points away, both vertically and
 * horizontally.
 *
 * <p>This class has been heavily modified since the previous assignment. In order to minimize
 * repeated code, most of the methods that were once in this class have been moved to {@link
 * AbstractSolitaireModelImpl}, which is now being extended by all versions of Marble Solitaire.
 *
 * <p>Extends {@link AbstractSolitaireModelImpl}.
 */
public class MarbleSolitaireModelImpl extends AbstractSolitaireModelImpl {

  /**
   * Constructor 1: Constructs a game using no arguments. Creates a game with an arm thickness of 3,
   * with the center at a default position.
   */
  public MarbleSolitaireModelImpl() {
    super.armThickness = 3;
    super.sRow = 3;
    super.sCol = 3;

    this.buildGrid();
  }

  /**
   * Constructor 2: Constructs a game with an empty space a specified row and column with an arm
   * thickness of 3.Throws IllegalArgumentException with message "Invalid empty cell position (r,c)"
   * if the specified position is not valid.
   */
  public MarbleSolitaireModelImpl(int sRow, int sCol) {
    if ((sRow < 2 && sCol < 2) || (sRow > 4 && sCol > 4)
        || (sRow < 2 && sCol > 4) || (sRow > 4 && sCol < 2)) {
      throw new IllegalArgumentException(String.format("Invalid empty cell position (%d, %d)",
          sRow, sCol));
    } else {
      super.armThickness = 3;
      super.sRow = sRow;
      super.sCol = sCol;

      this.buildGrid();
    }
  }

  /**
   * Constructor 3: Constructs a game using the specified arm thickness with an empty space at an
   * automatically determined position. Throws an IllegalArgumentException with message "Arm
   * thickness must be positive and odd."
   *
   * <p>Note: Fixed a bug present in previous versions where the empty location would not be in the
   * correct position.
   */
  public MarbleSolitaireModelImpl(int armThickness) {
    if (armThickness % 2 == 1 && armThickness > 0) {
      super.armThickness = armThickness;
      super.sRow = armThickness + ((armThickness - 3) / 2);
      super.sCol = armThickness + ((armThickness - 3) / 2);

      this.buildGrid();
    } else {
      throw new IllegalArgumentException("Arm thickness must be positive and odd.");
    }
  }

  /**
   * Constructor 4: Constructs a game using the specified arm thickness with an empty position at
   * the specified row and column. Throws an IllegalArgumentException if the position is invalid or
   * if the thickness is invalid
   */
  public MarbleSolitaireModelImpl(int armThickness, int sRow, int sCol) {
    if (armThickness % 2 == 1 && armThickness > 0) {
      super.armThickness = armThickness;
    } else {
      throw new IllegalArgumentException("Arm thickness must be positive and odd.");
    }
    if ((sRow < (armThickness - 1) && sCol < (armThickness - 1))
        || (sRow > (armThickness * 2 - 2) && sCol > (armThickness * 2 - 2))
        || (sRow < (armThickness - 1) && sCol > (armThickness * 2 - 2))
        || (sRow > (armThickness * 2 - 2) && sCol < (armThickness - 1))) {
      throw new IllegalArgumentException(String.format("Invalid empty cell position (%d, %d)",
          sRow, sCol));
    } else {
      super.sRow = sRow;
      super.sCol = sCol;
      this.buildGrid();
    }
  }

  /**
   * Builds a grid of cells in a cross shape. Makes sure that all CellState are set appropriately by
   * checking if they are within the cross shape.
   */
  @Override
  protected void buildGrid() {
    super.board = new Cell[super.armThickness * 3 - 2][super.armThickness * 3 - 2];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (super.sRow == i && super.sCol == j) {
          super.board[i][j] = new Cell(i, j, CellState.Empty);
        } else if ((i < (super.armThickness - 1) && j < (super.armThickness - 1))
            || (i > (super.armThickness * 2 - 2) && j > (super.armThickness * 2 - 2))
            || (i < (super.armThickness - 1) && j > (super.armThickness * 2 - 2))
            || (i > (super.armThickness * 2 - 2) && j < (super.armThickness - 1))) {
          super.board[i][j] = new Cell(i, j, CellState.Inaccessible);
        } else {
          super.board[i][j] = new Cell(i, j, CellState.Marble);
        }
      }
    }
  }
}
