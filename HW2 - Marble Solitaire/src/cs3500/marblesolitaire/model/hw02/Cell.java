package cs3500.marblesolitaire.model.hw02;

/**
 * Represents a Cell on the board and all operations possible for a cell.
 */
public class Cell {
  int x;
  int y;
  CellState state;

  /**
   * Constructs a cell.
   *
   * @param x       ... The x position of this Cell.
   * @param y       ... The y position of this Cell.
   * @param state   ... The {@link CellState} of this Cell.
   */
  public Cell(int x, int y, CellState state) {
    this.x = x;
    this.y = y;
    this.state = state;
  }
}