package cs3500.marblesolitaire.model.hw02;

/**
 * Implementation of possible operations in Marble Solitaire. One instace of the class represents
 * one instance of the game.
 */
public class MarbleSolitaireModelImpl implements MarbleSolitaireModel {

  int armThickness;
  int sRow;
  int sCol;

  public Cell[][] board;

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
   * if the specified positon is not valid.
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
   * automatically determined positon. Throws an IllegalArgumentException with message "Arm
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
   * Builds a grid of cells in a cross shape.
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
          this.board[i][j] = new Cell(i, j, CellState.Filled);
        }
      }
    }
  }

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    // Check if from Cell is filled, if the to Cell is empty and if cell between is filled.
  }

  @Override
  public boolean isGameOver() {
    // If score <= 1 then the game is over
    return false;
  }

  @Override
  public String getGameState() {
    String state = "";
    for (int i = 0; i < (this.armThickness * 3) - 2; i++) {
      for (int j = 0; j < (this.armThickness * 3) - 2; j++) {
        if (this.board[i][j].state.equals(CellState.Empty)) {
          state += "_";
        } else if (this.board[i][j].state.equals(CellState.Filled)) {
          state += "o";
        } else if (this.board[i][j].state.equals(CellState.Inaccessible)) {
          state += " ";
        } else {
          throw new IllegalArgumentException("Invalid State");
        }
        if (j < (this.armThickness * 3) - 3) {
          state += " ";
        }
      }
      if (i < (this.armThickness * 3) - 3) {
        state += "\n";
      }
    }
    return state;
  }

  @Override
  public int getScore() {
    // Go through the array and count all Cells with a state of Filled
    return 0;
  }
}
