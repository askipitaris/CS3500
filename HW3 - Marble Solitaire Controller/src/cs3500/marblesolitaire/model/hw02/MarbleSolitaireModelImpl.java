package cs3500.marblesolitaire.model.hw02;

/**
 * Implementation of possible operations in Marble Solitaire. One instance of the class represents
 * one instance of the game.
 */
public class MarbleSolitaireModelImpl implements MarbleSolitaireModel {

  private Cell[][] board;
  private int armThickness;
  private int sRow;
  private int sCol;

  /**
   * Constructor 1: Constructs a game using no arguments. Creates a game with an arm thickness of 3,
   * with the center at a default position.
   */
  public MarbleSolitaireModelImpl() {
    this.armThickness = 3;
    this.sRow = 3;
    this.sCol = 3;

    this.buildGrid();
  }

  /**
   * Constructor 2: Constructs a game with an empty space a specified row and column with an arm
   * thickness of 3.Throws IllegalArgumentExpection with message "Invalid empty cell position (r,c)"
   * if the specified position is not valid.
   */
  public MarbleSolitaireModelImpl(int sRow, int sCol) {
    if ((sRow < 2 && sCol < 2) || (sRow > 4 && sCol > 4)
        || (sRow < 2 && sCol > 4) || (sRow > 4 && sCol < 2)) {
      throw new IllegalArgumentException(String.format("Invalid empty cell position (%d, %d)",
          sRow, sCol));
    } else {
      this.armThickness = 3;
      this.sRow = sRow;
      this.sCol = sCol;

      this.buildGrid();
    }
  }

  /**
   * Constructor 3: Constructs a game using the specified arm thickness with an empty space at an
   * automatically determined position. Throws an IllegalArgumentException with message "Arm
   * thickness must be positive and odd."
   */
  public MarbleSolitaireModelImpl(int armThickness) {
    if (armThickness % 2 == 1 && armThickness > 0) {
      this.armThickness = armThickness;
      this.sRow = 3;
      this.sCol = 3;

      this.buildGrid();
    } else {
      throw new IllegalArgumentException("Arm thickness must be positive and odd.");
    }
  }

  /**
   * Constructor 4: Constructs a game using the specified arm thickness with an empty position at
   * the specified row and column. Throws an IllegalArgumentException if the positon is invalid or
   * if the thickness is invalid
   */
  public MarbleSolitaireModelImpl(int armThickness, int sRow, int sCol) {
    if (armThickness % 2 == 1 && armThickness > 0) {
      this.armThickness = armThickness;
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
      this.sRow = sRow;
      this.sCol = sCol;
      this.buildGrid();
    }
  }

  /**
   * Builds a grid of cells in a cross shape. Makes sure that all CellState are set appropriately by
   * checking where they are in the 2D array.
   */
  private void buildGrid() {
    this.board = new Cell[this.armThickness * 3 - 2][this.armThickness * 3 - 2];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (this.sRow == i && this.sCol == j) {
          this.board[i][j] = new Cell(i, j, CellState.Empty);
        } else if ((i < (this.armThickness - 1) && j < (this.armThickness - 1))
            || (i > (this.armThickness * 2 - 2) && j > (this.armThickness * 2 - 2))
            || (i < (this.armThickness - 1) && j > (this.armThickness * 2 - 2))
            || (i > (this.armThickness * 2 - 2) && j < (this.armThickness - 1))) {
          this.board[i][j] = new Cell(i, j, CellState.Inaccessible);
        } else {
          this.board[i][j] = new Cell(i, j, CellState.Marble);
        }
      }
    }
  }

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
  public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, Cell midCell) {
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
  private boolean outOfMoves() {
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
}
