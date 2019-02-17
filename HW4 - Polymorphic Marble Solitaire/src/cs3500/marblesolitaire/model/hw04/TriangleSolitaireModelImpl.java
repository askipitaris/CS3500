package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.Cell;
import cs3500.marblesolitaire.model.hw02.CellState;

/**
 * Implementation of possible operations in Triangular Marble Solitaire. One instance of the class
 * represents one instance of the game.
 */
public class TriangleSolitaireModelImpl extends AbstractSolitaireModelImpl {

  /**
   * Constructor 1: Constructs a game using no arguments. Creates a game with an arm thickness of 5,
   * with the empty position at (0,0).
   */
  public TriangleSolitaireModelImpl() {
    super.armThickness = 5;
    super.sRow = 0;
    super.sCol = 0;

    this.buildGrid();
  }

  /**
   * Constructor 2: Constructs a game using the specified arm thickness with an empty space at an
   * automatically determined position. Throws an IllegalArgumentException with message "Arm
   * thickness must be positive and odd."
   */
  public TriangleSolitaireModelImpl(int armThickness) {
    if (armThickness > 0) {
      super.armThickness = armThickness;
      super.sRow = 0;
      super.sCol = 0;

      this.buildGrid();
    } else {
      throw new IllegalArgumentException("Arm thickness must be positive");
    }
  }

  /**
   * Constructor 3: Constructs a game with an empty space a specified row and column with an arm
   * thickness of 3.Throws IllegalArgumentException with message "Invalid empty cell position (r,c)"
   * if the specified position is not valid.
   */
  public TriangleSolitaireModelImpl(int sRow, int sCol) {
    if (sCol <= sRow) {
      super.sRow = sRow;
      super.sCol = sCol;
      super.armThickness = 5;

      this.buildGrid();
    } else {
      throw new IllegalArgumentException("Invalid empty cell position");
    }
  }

  /**
   * Constructor 4: Constructs a game using the specified arm thickness with an empty position at
   * the specified row and column. Throws an IllegalArgumentException if the position is invalid or
   * if the thickness is invalid
   */
  public TriangleSolitaireModelImpl(int armThickness, int sRow, int sCol) {
    if (armThickness > 0) {
      super.armThickness = armThickness;
    } else {
      throw new IllegalArgumentException("Arm thickness must be positive");
    }

    if (sCol <= sRow) {
      super.sRow = sRow;
      super.sCol = sCol;
    } else {
      throw new IllegalArgumentException("Invalid empty cell position");
    }
    this.buildGrid();
  }

  /**
   * Builds a grid in the shape of a triangle. Makes sure that all CellState are set appropriately
   * by checking where they are in the 2D array.
   *
   * <p>Determines if the cell is valid by checking if the current column <= row. For example, on
   * row 0, the only valid cell will be at (0,0). On row 1, valid cells are (1,0) and (1,1). This
   * continues for the value of armThickness.
   *
   * <p>This means that the board is stored like a right triangle, with all columns at 0 being
   * along the left side of the board.
   *
   * <p>_ <- (0,0)
   * <p>O O <- (1,1)
   * <p>O O O <- (2,2)
   * <p>O O O O <- (3,3)
   * <p>O O O O O <- (4,4)
   */
  private void buildGrid() {
    super.board = new Cell[super.armThickness][super.armThickness];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (super.sRow == i && super.sCol == j) {
          super.board[i][j] = new Cell(i, j, CellState.Empty);
        } else if (j <= i) {
          super.board[i][j] = new Cell(i, j, CellState.Marble);
        } else {
          super.board[i][j] = new Cell(i, j, CellState.Inaccessible);
        }
      }
    }
  }

  /**
   * Returns the game state for Triangle Marble Solitaire. No spaces after the last item on each
   * row. O represents a position that has a marble. _ a position that is empty and " " represents a
   * position that is invalid.
   *
   * <p>If you are on the first column of a given row, it calculates how many spaces need to be
   * added in order for the given row to be centered.
   *
   * <p>Once the necessary spaces are added, the game checks which symbol should go in the given
   * column.
   *
   * <p>At the end of the column, it then determines if a newline is needed.
   *
   * @return the state of the game as a string.
   */
  @Override
  public String getGameState() {
    StringBuilder state = new StringBuilder();
    for (int i = 0; i < super.armThickness; i++) {
      for (int j = 0; j < super.armThickness; j++) {
        if (j == 0) {
          for (int k = 1; k < super.armThickness - i; k++) {
            state.append(" ");
          }
        }
        if (super.board[i][j].getState().equals(CellState.Empty)) {
          state.append("_");
        } else if (super.board[i][j].getState().equals(CellState.Marble)) {
          state.append("O");
        }
        if (j < i) {
          state.append(" ");
        }
      }
      if (i + 1 < super.armThickness) {
        state.append("\n");
      }
    }
    return state.toString();
  }

  /**
   * This implementation differs from the one defined in {@link AbstractSolitaireModelImpl} in that
   * it allows for moves that are two rows above and below, along the four diagonal directions
   * instead of having straight, vertical movements.
   *
   * @param fromRow is the row from which the player is moving.
   * @param fromCol the col from which the player is moving.
   * @param toRow is the row to which the player is moving.
   * @param toCol is the col to which the player is moving.
   * @param midCell is the cell between the two movement points.
   * @return boolean that says whether this is a valid move or not.
   */
  @Override
  protected boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, Cell midCell) {
    return !((fromRow < 0 || fromRow >= this.board.length || fromCol < 0
        || fromCol >= this.board.length)
        || (toRow < 0 || toRow >= this.board.length || toCol < 0 || toCol >= this.board.length)
        || (this.board[fromRow][fromCol].getState() != CellState.Marble)
        || (this.board[toRow][toCol].getState() != CellState.Empty)
        || (midCell.getState() != CellState.Marble)
        || !((fromRow == toRow && Math.abs(fromCol - toCol) == 2)
        || (Math.abs(fromRow - toRow) == 2 && fromCol == toCol)
        || (fromRow - toRow == 2 && fromCol - toCol == 2)
        || (toRow - fromRow == -2 && fromCol - toCol == -2)));
  }

  /**
   * This implementation differs from the one define in {@link AbstractSolitaireModelImpl} in that
   * it allows for moves that are tow rows above and below, along the four diagonal directions.
   *
   * @param fromRow the row number of the position to be moved from (starts at 0)
   * @param fromCol the column number of the position to be moved from (starts at 0)
   * @param toRow the row number of the position to be moved to (starts at 0)
   * @param toCol the column number of the position to be moved to (starts at 0)
   * @throws IllegalArgumentException if the start cell, end cell or movement is not valid.
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    Cell midCell;
    if (fromRow >= 0 && fromRow < this.board.length && fromCol >= 0 && fromCol < this.board.length
        && toRow >= 0 && toRow < this.board.length && toCol >= 0 && toCol < this.board.length) {
      midCell = this.board[fromRow + (toRow - fromRow) / 2][fromCol + (toCol - fromCol) / 2];
      if (this.isValidMove(fromRow, fromCol, toRow, toCol, midCell)) {
        this.board[fromRow][fromCol].setState(CellState.Empty);
        midCell.setState(CellState.Empty);
        this.board[toRow][toCol].setState(CellState.Marble);
      } else {
        throw new IllegalArgumentException("Invalid movement");
      }
    } else {
      throw new IllegalArgumentException(String.format("Invalid start cell (%d, %d) "
          + "or end cell (%d, %d)", fromRow, fromCol, toRow, toCol));
    }
  }
}