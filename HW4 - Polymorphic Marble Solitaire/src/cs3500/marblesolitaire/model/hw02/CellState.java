package cs3500.marblesolitaire.model.hw02;

/**
 * Represents the state of a cell. Can be Empty, signifying the lack of a marble at this location;
 * Marble, signifying the existence of a marble at this location; or Inaccessible, signifying that
 * this cell should be inaccessible.
 */
public enum CellState {
  Empty, Marble, Inaccessible
}
