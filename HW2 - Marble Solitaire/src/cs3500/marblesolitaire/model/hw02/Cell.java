package cs3500.marblesolitaire.model.hw02;

/**
 * Represents a Cell on the board and all operations possible for a cell.
 */
public class Cell {
  int row;
  int col;
  public CellState state;

  /**
   * Constructs a cell that stores a location in a 2D array.
   *
   * @param row is the 'y' position of the cell on a grid.
   * @param col is the 'x' positon of the cell on a grid.
   * @param state is the {@link CellState} of this Cell.
   */
  public Cell(int row, int col, CellState state) {
    this.row = row;
    this.col = col;
    this.state = state;
  }
}