package cs3500.marblesolitaire.model.hw02;

/**
 * Implementation of possible operations in Marble Solitaire. One instace of the class represents
 * one instance of the game.
 */
public class MarbleSolitaireModelImpl implements MarbleSolitaireModel {

  int armThickness;
  int sRow;
  int sCol;

  Cell[][] board;

  /**
   * Constructor 1: Constructs a game using no arguments. Creates a game with an arm thickness of 3,
   * with the center at a default position.
   */
  public MarbleSolitaireModelImpl() {
    this.armThickness = 3;
    this.sRow = 3;
    this.sCol = 3;

    this.board = new Cell[this.armThickness * 3][this.armThickness * 3];
  }

  /**
   * Constructor 2: Constructs a game with an empty space a specified row and column with an arm
   * thickness of 3.Throws IllegalArgumentExpection with message "Invalid empty cell position (r,c)"
   * if the specified positon is not valid.
   *
   * @param sRow
   * @param sCol
   */
  public MarbleSolitaireModelImpl(int sRow, int sCol) {
    if ((sRow < 3 && sCol < 3) || (sRow > 4 && sCol > 4)
        || (sRow < 3 && sCol > 4) || (sRow > 4 && sCol < 3)) {
      throw new IllegalArgumentException("Invalid empty cell position (r,c)");
    } else {
      this.armThickness = 3;
      this.sRow = sRow;
      this.sCol = sCol;
    }
  }

  /**
   * Constructor 3: Constructs a game using the specified arm thickness with an empty space at an
   * automatically determined positon. Throws an IllegalArgumentException with message "Arm
   * thickness must be positive and odd."
   *
   * @param armThickness
   */
  public MarbleSolitaireModelImpl(int armThickness) {
    if (armThickness % 2 == 1 && armThickness > 0) {
      this.armThickness = armThickness;
      this.sRow = 3;
      this.sCol = 3;
    } else {
      throw new IllegalArgumentException("Arm thickness must be positive and odd.");
    }
  }

  /**
   * Constructor 4: Constructs a game using the specified arm thickness with an empty position at
   * the specified row and column. Throws an IllegalArgumentException if the positon is invalid or
   * if the thickness is invalid
   *
   * @param armThickness
   * @param sRow
   * @param sCol
   */
  public MarbleSolitaireModelImpl(int armThickness, int sRow, int sCol) {
    if (armThickness % 2 == 1 && armThickness > 0) {
      this.armThickness = armThickness;
    } else {
      throw new IllegalArgumentException("Arm thickness must be positive and odd.");
    }
    if ((sRow <= armThickness && sCol < armThickness)
        || (sRow > (armThickness * 2 - 2) && sCol > (armThickness * 2 - 2))
        || (sRow < armThickness && sCol > (armThickness * 2 - 2))
        || (sRow > (armThickness * 2 - 2) && sCol < armThickness)) {
      throw new IllegalArgumentException("Invalid empty cell position (r,c)");
    } else {
      this.sRow = sRow;
      this.sCol = sCol;
    }
  }

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {

  }

  @Override
  public boolean isGameOver() {
    return false;
  }

  @Override
  public String getGameState() {
    String output = "";
    for (int i = 0; i < (this.armThickness * 3) - 2; i++) {
      for (int j = 0; j < (this.armThickness * 3) - 2; j++) {
        if (j < this.armThickness) {
          output += "  ";
        }
        else if (j == this.sCol && i == this.sRow) {
          output += "_ ";
        }
        else if (j < (this.armThickness * 2) - 2) {
          output += "O ";
        }
        else if (j < (this.armThickness * 3) - 3) {
          output += "  ";
        }
        else if (j >= (this.armThickness * 3) - 2) {
          output += "  \n";
        }
      }
    }
    return output;
  }

  @Override
  public int getScore() {
    return 0;
  }
}
