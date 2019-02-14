package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.Cell;
import cs3500.marblesolitaire.model.hw02.CellState;

/**
 * Implementation of possible operations in European Marble Solitaire. One instance of the class
 * represents one instance of the game.
 */
public class EuropeanSolitaireModelImpl extends AbstractSolitaireModelImpl {

  /**
   * Constructor 1: Constructs a game using no arguments. Creates a game with an arm thickness of 3,
   * with the center at a default position.
   */
  public EuropeanSolitaireModelImpl() {
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
  public EuropeanSolitaireModelImpl(int sRow, int sCol) {
    if (!((sRow < 2 && sCol < 2) || (sRow > 4 && sCol > 4)
        || (sRow < 2 && sCol > 4) || (sRow > 4 && sCol < 2))
        || (sRow == 1 && sCol == 1) || (sRow == 1 && sCol == 5)
        || (sRow == 5 && sCol == 1) || (sRow == 5 && sCol == 5)) {
      super.armThickness = 3;
      super.sRow = sRow;
      super.sCol = sCol;

      this.buildGrid();
    } else {
      throw new IllegalArgumentException(String.format("Invalid empty cell position (%d, %d)",
          sRow, sCol));
    }
  }

  /**
   * Constructor 3: Constructs a game using the specified arm thickness with an empty space at an
   * automatically determined position. Throws an IllegalArgumentException with message "Arm
   * thickness must be positive and odd."
   */
  public EuropeanSolitaireModelImpl(int armThickness) {
    if (armThickness % 2 == 1 && armThickness > 0) {
      super.armThickness = armThickness;
      super.sRow = armThickness;
      super.sCol = armThickness;

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
  public EuropeanSolitaireModelImpl(int armThickness, int sRow, int sCol) {
    if (armThickness % 2 == 1 && armThickness > 0) {
      super.armThickness = armThickness;
    } else {
      throw new IllegalArgumentException("Arm thickness must be positive and odd.");
    }
    if (!((sRow < (armThickness - 1) && sCol < (armThickness - 1))
        || (sRow > (armThickness * 2 - 2) && sCol > (armThickness * 2 - 2))
        || (sRow < (armThickness - 1) && sCol > (armThickness * 2 - 2))
        || (sRow > (armThickness * 2 - 2) && sCol < (armThickness - 1)))

        || (sRow == (armThickness - 2) && sCol == (armThickness - 2))
        || (sRow == (armThickness - 2) && sCol == (armThickness * 2 - 1))
        || (sRow == (armThickness * 2 - 1) && sCol == (armThickness - 2))
        || (sRow == (armThickness * 2 - 1) && sCol == (armThickness * 2 - 1))) {
      super.sRow = sRow;
      super.sCol = sCol;
      this.buildGrid();
    } else if (((sRow < (super.armThickness - 1) && sCol < (super.armThickness - 1))
        && sCol >= (super.armThickness - 1) - sRow)
        || ((sRow < (super.armThickness - 1) && sCol > (super.armThickness * 2 - 2))
        && sCol <= (super.armThickness * 3 - 2) - (super.armThickness - sRow))
        || (((sRow > (super.armThickness * 2 - 2) && sCol < (super.armThickness - 1)))
        && sCol >= (sRow - (super.armThickness * 2 - 2)))
        || ((sRow > (super.armThickness * 2 - 2) && sCol > (super.armThickness * 2 - 2))
        && sCol <= (super.armThickness * 3 - 2) - (sRow - (super.armThickness * 2 - 3)))) {
      super.sRow = sRow;
      super.sCol = sCol;
      this.buildGrid();
    } else {
      throw new IllegalArgumentException(String.format("Invalid empty cell position (%d, %d)",
          sRow, sCol));
    }
  }

  /**
   * Builds a grid of cells in an octagonal shape. Makes sure that all CellState are set
   * appropriately by checking where they are in the 2D array.
   */
  private void buildGrid() {
    super.board = new Cell[super.armThickness * 3 - 2][super.armThickness * 3 - 2];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (super.sRow == i && super.sCol == j) {
          super.board[i][j] = new Cell(i, j, CellState.Empty);
        } else if (!((i < (super.armThickness - 1) && j < (super.armThickness - 1))
            || (i > (super.armThickness * 2 - 2) && j > (super.armThickness * 2 - 2))
            || (i < (super.armThickness - 1) && j > (super.armThickness * 2 - 2))
            || (i > (super.armThickness * 2 - 2) && j < (super.armThickness - 1)))) {
          super.board[i][j] = new Cell(i, j, CellState.Marble);
        } else if (((i < (super.armThickness - 1) && j < (super.armThickness - 1))
            && j >= (super.armThickness - 1) - i)
            || ((i < (super.armThickness - 1) && j > (super.armThickness * 2 - 2))
            && j <= (super.armThickness * 3 - 2) - (super.armThickness - i))
            || (((i > (super.armThickness * 2 - 2) && j < (super.armThickness - 1)))
            && j >= (i - (super.armThickness * 2 - 2)))
            || ((i > (super.armThickness * 2 - 2) && j > (super.armThickness * 2 - 2))
            && j <= (super.armThickness * 3 - 2) - (i - (super.armThickness * 2 - 3)))) {
          super.board[i][j] = new Cell(i, j, CellState.Marble);
        } else {
          super.board[i][j] = new Cell(i, j, CellState.Inaccessible);
        }
      }
    }
  }
}