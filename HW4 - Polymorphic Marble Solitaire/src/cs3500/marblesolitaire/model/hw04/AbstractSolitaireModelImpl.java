package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.Cell;
import cs3500.marblesolitaire.model.hw02.CellState;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * Abstract class for various versions of Marble Solitaire. Because european, english and triangle
 * marble solitaire are all very similar, everything except for constructors and any methods that
 * have specific implementations have been move from {@link cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl}
 * to this class. Any individual type of Marble solitaire extends this class. This has been done to
 * minimize repeated code.
 */
public abstract class AbstractSolitaireModelImpl implements MarbleSolitaireModel {

  protected Cell[][] board;
  protected int armThickness;
  protected int sRow;
  protected int sCol;

  /**
   * Returns this cell that exists at the given row and col.
   *
   * @param row is the specified row.
   * @param col is the specified col.
   * @return is the cell at the specified location.
   */
  public Cell getCell(int row, int col) {
    return this.board[row][col];
  }

  /**
   * Determines if the given move is valid. The first condition (111-111) checks if the given values
   * are out of bounds. The second condition (137) checks if the cell you are moving from currently
   * has a marble. The third (138) checks if the cell you are moving to is empty. The fourth (139)
   * checks if each cell you are moving over has a marble. The fifth (140-141) checks to make sure
   * each move has a distance of two and is not diagonal.
   *
   * @param fromRow is the row from which the player is moving.
   * @param fromCol the col from which the player is moving.
   * @param toRow is the row to which the player is moving.
   * @param toCol is the col to which the player is moving.
   * @param midCell is the cell between the two movement points.
   * @return boolean that says whether this is a valid move or not.
   */
  protected boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, Cell midCell) {
    return !((fromRow < 0 || fromRow >= this.board.length || fromCol < 0
        || fromCol >= this.board.length)
        || (toRow < 0 || toRow >= this.board.length || toCol < 0 || toCol >= this.board.length)
        || (this.board[fromRow][fromCol].getState() != CellState.Marble)
        || (this.board[toRow][toCol].getState() != CellState.Empty)
        || (midCell.getState() != CellState.Marble)
        || ((Math.abs(toCol - fromCol) != 2 && Math.abs(toRow - fromRow) == 0)
        || (Math.abs(toCol - fromCol) == 0 && Math.abs(toRow - fromRow) != 2))
        || (Math.abs(toCol - fromCol) != 0 && Math.abs(toRow - fromRow) != 0));
  }

  /**
   * Throws IllegalArgument exception if the move is not possible or if the start or end cells are
   * not valid.
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
      if (isValidMove(fromRow, fromCol, toRow, toCol, midCell)) {
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

  /**
   * Checks if there are any valid moves left on the board.
   *
   * @return true if you are out of moves, or false if there is at least one valid move.
   */
  protected boolean outOfMoves() {
    for (int i = 0; i < this.board.length; i++) {
      for (int j = 0; j < this.board.length; j++) {
        if ((i + 2 < this.board.length
            && this.isValidMove(i, j, i + 2, j, this.board[i + 1][j]))
            || (i - 2 >= 0
            && this.isValidMove(i, j, i - 2, j, this.board[i - 1][j]))
            || (j + 2 < this.board.length
            && this.isValidMove(i, j, i, j + 2, this.board[i][j + 1]))
            || (j - 2 >= 0
            && this.isValidMove(i, j, i, j - 2, this.board[i][j - 1]))) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public boolean isGameOver() {
    return this.getScore() <= 1 || this.outOfMoves();
  }

  @Override
  public String getGameState() {
    StringBuilder state = new StringBuilder();
    for (int i = 0; i < (this.armThickness * 3) - 2; i++) {
      for (int j = 0; j < (this.armThickness * 3) - 2; j++) {
        if (this.board[i][j].getState().equals(CellState.Empty)) {
          state.append("_");
        } else if (this.board[i][j].getState().equals(CellState.Marble)) {
          state.append("O");
        } else if (this.board[i][j].getState().equals(CellState.Inaccessible)
            && j < (this.armThickness * 2) - 2) {
          state.append(" ");
        }
        if ((j + 1 < this.board.length
            && this.board[i][j + 1].getState() != CellState.Inaccessible)
            || (j < (this.armThickness * 2) - 2
            && this.board[i][j + 1].getState().equals(CellState.Inaccessible))) {
          state.append(" ");
        }
      }
      if (i + 1 < this.board.length) {
        state.append("\n");
      }
    }
    return state.toString();
  }

  @Override
  public int getScore() {
    int score = 0;
    for (int i = 0; i < (this.armThickness * 3) - 2; i++) {
      for (int j = 0; j < (this.armThickness * 3) - 2; j++) {
        if (this.board[i][j].getState().equals(CellState.Marble)) {
          score += 1;
        }
      }
    }
    return score;
  }

  /**
   * Builds a grid in a specific shape as needed by the specific type of Marble Solitaire. The
   * possible options are a cross for english marble solitaire, an octagon for european marble
   * solitaire and a triangle for triangular marble solitaire.
   *
   * <p>Also ensures that all cells are set correctly by checking that each cell is within the grid
   * allowed by the type of marble solitaire.
   */
  protected abstract void buildGrid();
}
