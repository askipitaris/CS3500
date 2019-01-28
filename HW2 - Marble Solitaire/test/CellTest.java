import static org.junit.Assert.assertEquals;

import cs3500.marblesolitaire.model.hw02.Cell;
import cs3500.marblesolitaire.model.hw02.CellState;
import org.junit.Test;

/**
 * Tests methods relating to Cell objects.
 */
public class CellTest {

  @Test
  public void testGetState() {
    assertEquals(CellState.Empty,
        new Cell(3, 3, CellState.Empty));
    assertEquals(CellState.Marble,
        new Cell(0, 3, CellState.Marble));
    assertEquals(CellState.Empty,
        new Cell(0, 0, CellState.Inaccessible));
  }

  @Test
  public void testSetState() {
    Cell a = new Cell(3, 3, CellState.Empty);
    a.setState(CellState.Marble);
    assertEquals(CellState.Marble, a.getState());
  }

  @Test
  public void testGetRow() {
    Cell b = new Cell(4, 4, CellState.Marble);
    assertEquals(4, b.getRow());
  }

  @Test
  public void testGetCol() {
    Cell c = new Cell(6, 3, CellState.Marble);
    assertEquals(3, c.getCol());
  }
}
