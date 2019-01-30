package cs3500.marblesolitaire.model.hw02;

/**
 * Represents a Cell on the board and all operations possible for a cell. A Cell has a row, col and
 * state.
 */
public class Cell {
  private int row;
  private int col;
  private CellState state;

  /**
   * Constructs a cell.
   *
   * @param row is the x position of this Cell.
   * @param col is the y position of this Cell.
   * @param state is the {@link CellState} of this Cell.
   */
  public Cell(int row, int col, CellState state) {
    this.row = row;
    this.col = col;
    this.state = state;
  }

  /**
   * Returns the {@link CellState} of the state of this cell.
   */
  public CellState getState() {
    return this.state;
  }

  /**
   * Changes the {@link CellState} of this Cell.
   *
   * @param newState is the new state of this Cell.
   */
  public void setState(CellState newState) {
    this.state = newState;
  }

  /**
   * Returns the row of this Cell.
   */
  public int getRow() {
    return this.row;
  }

  /**
   * Returns the col of this Cell.
   */
  public int getCol() {
    return this.col;
  }
}