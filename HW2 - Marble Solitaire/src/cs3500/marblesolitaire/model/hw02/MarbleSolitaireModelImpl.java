package cs3500.marblesolitaire.model.hw02;

/**
 * Implementation of possible operations in Marble Solitaire. One instace of the class represents
 * one instance of the game.
 */
public class MarbleSolitaireModelImpl implements MarbleSolitaireModel {

  public Cell[][] board;
  int armThickness;
  int sRow;
  int sCol;

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
      throw new IllegalArgumentException("Invalid empty cell position (r,c)");
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
      throw new IllegalArgumentException("Invalid empty cell position (r,c)");
    } else {
      this.sRow = sRow;
      this.sCol = sCol;
      this.buildGrid();
    }
  }

  /**
   * Builds a grid of cells in a cross shape. Makes sure that all CellState are set appropriatly by
   * checking where they are in the 2D array.
   */
  public void buildGrid() {
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
   * Determines if the given move is valid.
   *
   * @param fromRow is the row from which the player is moving.
   * @param fromCol the col from which the player is moving.
   * @param toRow is the row to which the player is moving.
   * @param toCol is the col to which the player is moving.
   * @param midCell is the cell between the two movement points.
   * @return boolean that says whether this is a valid move or not.
   */
  public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, Cell midCell)
      throws IllegalArgumentException {
    if (this.board[fromRow][fromCol].state != CellState.Marble) {
      throw new IllegalArgumentException("The cell you are moving from must have a marble");
    } else if (this.board[toRow][toCol].state != CellState.Empty) {
      throw new IllegalArgumentException("This cell you are moving to must be empty");
    } else if (midCell.state != CellState.Marble) {
      throw new IllegalArgumentException("The cell between your movement points must "
          + "have a marble");
    } else if ((Math.abs(toCol - fromCol) != 2 && Math.abs(toRow - fromRow) == 0)
        || (Math.abs(toCol - fromCol) == 0 && Math.abs(toRow - fromRow) != 2) ) {
      throw new IllegalArgumentException("The distance between cells must be 2 and must "
          + "be horizontal or vertical");
    } else {
      return true;
    }
  }

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    Cell midCell = this.board[fromRow + (toRow - fromRow) / 2][fromCol + (toCol - fromCol) / 2];
    if (isValidMove(fromRow, fromCol, toRow, toCol, midCell)) {
      this.board[fromRow][fromCol].state = CellState.Empty;
      midCell.state = CellState.Empty;
      this.board[toRow][toCol].state = CellState.Marble;
    }
  }

  @Override
  public boolean isGameOver() {
    return this.getScore() <= 1;
  }

  @Override
  public String getGameState() {
    String state = "";
    for (int i = 0; i < (this.armThickness * 3) - 2; i++) {
      for (int j = 0; j < (this.armThickness * 3) - 2; j++) {
        if (this.board[i][j].state.equals(CellState.Empty)) {
          state += "_";
        } else if (this.board[i][j].state.equals(CellState.Marble)) {
          state += "O";
        } else if (this.board[i][j].state.equals(CellState.Inaccessible)
            && j < (this.armThickness * 2) - 2) {
          state += " ";
        }
        if (j + 1 < this.board.length && this.board[i][j + 1].state != CellState.Inaccessible) {
          state += " ";
        } else if (j < (this.armThickness * 2) - 2
            && this.board[i][j + 1].state.equals(CellState.Inaccessible)) {
          state += " ";
        }
      }
      if (i + 1 < this.board.length) {
        state += "\n";
      }
    }
    return state;
  }

  @Override
  public int getScore() {
    int score = 0;
    for (int i = 0; i < (this.armThickness * 3) - 2; i++) {
      for (int j = 0; j < (this.armThickness * 3) - 2; j++) {
        if (this.board[i][j].state.equals(CellState.Marble)) {
          score += 1;
        }
      }
    }
    return score;
  }
}
