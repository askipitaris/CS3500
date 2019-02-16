import static org.junit.Assert.assertEquals;

import cs3500.marblesolitaire.model.hw02.CellState;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl;
import org.junit.Test;

public class TriangleSolitaireModelImplTest {
  @Test
  public void testConstructorOne() {
    TriangleSolitaireModelImpl game = new TriangleSolitaireModelImpl();
    assertEquals(CellState.Empty, game.getCell(0, 0).getState());
    assertEquals(CellState.Inaccessible, game.getCell(0, 1).getState());
    assertEquals(CellState.Marble, game.getCell(1, 0).getState());
    assertEquals(CellState.Marble, game.getCell(1, 1).getState());
    assertEquals(CellState.Marble, game.getCell(4, 4).getState());
  }

  @Test
  public void testConstructorTwo() {
    TriangleSolitaireModelImpl game = new TriangleSolitaireModelImpl(6);
    assertEquals(CellState.Empty, game.getCell(0, 0).getState());
    assertEquals(CellState.Inaccessible, game.getCell(0, 1).getState());
    assertEquals(CellState.Inaccessible, game.getCell(1, 2).getState());
    assertEquals(CellState.Inaccessible, game.getCell(1, 5).getState());
    assertEquals(CellState.Marble, game.getCell(1, 0).getState());
    assertEquals(CellState.Marble, game.getCell(1, 1).getState());
    assertEquals(CellState.Marble, game.getCell(4, 4).getState());
    assertEquals(CellState.Marble, game.getCell(5, 5).getState());
  }

  @Test
  public void testConstructorThree() {
    TriangleSolitaireModelImpl game = new TriangleSolitaireModelImpl(2, 2);
    assertEquals(CellState.Empty, game.getCell(2, 2).getState());
    assertEquals(CellState.Marble, game.getCell(0, 0).getState());
    assertEquals(CellState.Inaccessible, game.getCell(0, 1).getState());
    assertEquals(CellState.Marble, game.getCell(1, 0).getState());
    assertEquals(CellState.Marble, game.getCell(1, 1).getState());
    assertEquals(CellState.Marble, game.getCell(4, 4).getState());
  }

  @Test
  public void testConstructorFour() {
    TriangleSolitaireModelImpl game = new TriangleSolitaireModelImpl(6, 2, 2);
    assertEquals(CellState.Empty, game.getCell(2, 2).getState());
    assertEquals(CellState.Inaccessible, game.getCell(0, 1).getState());
    assertEquals(CellState.Inaccessible, game.getCell(1, 2).getState());
    assertEquals(CellState.Inaccessible, game.getCell(1, 5).getState());
    assertEquals(CellState.Marble, game.getCell(1, 0).getState());
    assertEquals(CellState.Marble, game.getCell(1, 1).getState());
    assertEquals(CellState.Marble, game.getCell(4, 4).getState());
    assertEquals(CellState.Marble, game.getCell(5, 5).getState());
  }

  @Test
  public void testGameState() {
    assertEquals(
        "    _\n"
            + "   O O\n"
            + "  O O O\n"
            + " O O O O\n"
            + "O O O O O",
        new TriangleSolitaireModelImpl().getGameState());
    assertEquals("    O\n"
            + "   O O\n"
            + "  O O _\n"
            + " O O O O\n"
            + "O O O O O",
        new TriangleSolitaireModelImpl(2, 2).getGameState());
    assertEquals(
        "      _\n"
            + "     O O\n"
            + "    O O O\n"
            + "   O O O O\n"
            + "  O O O O O\n"
            + " O O O O O O\n"
            + "O O O O O O O",
        new TriangleSolitaireModelImpl(7).getGameState());
  }
}
