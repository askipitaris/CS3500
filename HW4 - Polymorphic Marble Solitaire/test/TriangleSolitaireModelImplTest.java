import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import cs3500.marblesolitaire.model.hw02.CellState;
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


  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorTwo() {
    new TriangleSolitaireModelImpl(1, 0);
    new TriangleSolitaireModelImpl(0, 5);
    new TriangleSolitaireModelImpl(5, 0);
    new TriangleSolitaireModelImpl(5, 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorThree() {
    new TriangleSolitaireModelImpl(-3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorFour() {
    new TriangleSolitaireModelImpl(4, 6, 6);
    new TriangleSolitaireModelImpl(5, 0, 1);
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

  @Test
  public void testHorizontalMovement() {
    TriangleSolitaireModelImpl game = new TriangleSolitaireModelImpl(4, 0);
    game.move(4, 2, 4, 0);
    assertEquals("    O\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O _ _ O O", game.getGameState());
    game.move(4, 4, 4, 2);
    assertEquals("    O\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O _ O _ _", game.getGameState());
  }

  @Test
  public void testDiagonalMovement() {
    TriangleSolitaireModelImpl game = new TriangleSolitaireModelImpl();
    game.move(2, 0, 0, 0);
    assertEquals("    O\n"
        + "   _ O\n"
        + "  _ O O\n"
        + " O O O O\n"
        + "O O O O O", game.getGameState());
    game.move(4, 2, 2, 0);
    assertEquals("    O\n"
        + "   _ O\n"
        + "  O O O\n"
        + " O _ O O\n"
        + "O O _ O O", game.getGameState());
    game.move(3, 0, 1, 0);
    assertEquals("    O\n"
        + "   O O\n"
        + "  _ O O\n"
        + " _ _ O O\n"
        + "O O _ O O", game.getGameState());
    TriangleSolitaireModelImpl game2 = new TriangleSolitaireModelImpl(2, 2);
    game2.move(0, 0, 2, 2);
    assertEquals("    _\n"
        + "   O _\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O", game2.getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidStartOrEnd() {
    TriangleSolitaireModelImpl game = new TriangleSolitaireModelImpl();
    game.move(0, 2, 0, 0);
    game.move(0, 0, 0, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove() {
    TriangleSolitaireModelImpl game = new TriangleSolitaireModelImpl();
    game.move(2, 1, 0, 0);
    game.move(3, 0, 0, 0);
    game.move(3, 3, 0, 0);
    game.move(4, 3, 4, 4);
  }

  @Test
  public void testIsGameOver() {
    TriangleSolitaireModelImpl game = new TriangleSolitaireModelImpl();
    game.move(2, 0, 0, 0);
    game.move(4, 0, 2, 0);
    game.move(4, 2, 4, 0);
    assertFalse(game.isGameOver());
    game.move(4, 4, 4, 2);
    game.move(2, 2, 4, 4);
    game.move(0, 0, 2, 2);
    assertFalse(game.isGameOver());
    game.move(2, 1, 4, 3);
    game.move(4, 3, 4, 1);
    game.move(4, 1, 2, 1);
    assertTrue(game.isGameOver());
  }
}
