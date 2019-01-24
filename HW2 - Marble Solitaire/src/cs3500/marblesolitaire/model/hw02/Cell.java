package cs3500.marblesolitaire.model.hw02;

/**
 * Represents a Cell on the board and all operations possible for a cell.
 */
public class Cell {
  int row;
  int col;
  public CellState state;

  /**
   * Constructs a cell.
   *
   * @param row       ... The x position of this Cell.
   * @param col       ... The y position of this Cell.
   * @param state     ... The {@link CellState} of this Cell.
   */
  public Cell(int row, int col, CellState state) {
    this.row = row;
    this.col = col;
    this.state = state;
  }
}