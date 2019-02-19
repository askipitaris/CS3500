import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import cs3500.marblesolitaire.model.hw02.CellState;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModelImpl;
import org.junit.Test;

public class EuropeanSolitaireModelImplTest {

  @Test
  public void testConstructorOne() {
    EuropeanSolitaireModelImpl game = new EuropeanSolitaireModelImpl();
    assertEquals(CellState.Empty, game.getCell(3, 3).getState());
  }

  @Test
  public void testConstructorTwo() {
    EuropeanSolitaireModelImpl game = new EuropeanSolitaireModelImpl(2, 2);
    assertEquals(CellState.Empty, game.getCell(2, 2).getState());
  }

  @Test
  public void testConstructorThree() {
    EuropeanSolitaireModelImpl game = new EuropeanSolitaireModelImpl(5);
    assertEquals(CellState.Marble, game.getCell(9, 9).getState());
    assertEquals(CellState.Marble, game.getCell(3, 3).getState());
    assertEquals(CellState.Marble, game.getCell(3, 9).getState());
    assertEquals(CellState.Marble, game.getCell(9, 3).getState());
  }

  @Test
  public void testConstructorFour() {
    EuropeanSolitaireModelImpl game = new EuropeanSolitaireModelImpl(5, 4, 5);
    assertEquals(CellState.Marble, game.getCell(9, 9).getState());
    assertEquals(CellState.Marble, game.getCell(3, 3).getState());
    assertEquals(CellState.Marble, game.getCell(3, 9).getState());
    assertEquals(CellState.Marble, game.getCell(9, 3).getState());
    assertEquals(CellState.Empty, game.getCell(4, 5).getState());
  }


  @Test
  public void testBuildGrid() {
    EuropeanSolitaireModelImpl game = new EuropeanSolitaireModelImpl();
    assertEquals(CellState.Empty, game.getCell(3, 3).getState());
    assertEquals(CellState.Marble, game.getCell(2, 2).getState());
    assertEquals(CellState.Marble, game.getCell(3, 1).getState());
    assertEquals(CellState.Inaccessible, game.getCell(0, 1).getState());
    assertEquals(CellState.Inaccessible, game.getCell(1, 0).getState());
    assertEquals(CellState.Inaccessible, game.getCell(5, 0).getState());
    assertEquals(CellState.Inaccessible, game.getCell(0, 5).getState());
    assertEquals(CellState.Marble, game.getCell(1, 1).getState());
    assertEquals(CellState.Marble, game.getCell(5, 1).getState());
    assertEquals(CellState.Marble, game.getCell(1, 5).getState());
    assertEquals(CellState.Marble, game.getCell(5, 5).getState());
  }

  @Test
  public void testBuildGrid2() {
    EuropeanSolitaireModelImpl game = new EuropeanSolitaireModelImpl(2, 2);
    assertEquals(CellState.Empty, game.getCell(2, 2).getState());
  }

  @Test
  public void testBuildGrid3() {
    EuropeanSolitaireModelImpl game = new EuropeanSolitaireModelImpl(5);
    assertEquals(CellState.Marble, game.getCell(9, 9).getState());
    assertEquals(CellState.Marble, game.getCell(3, 3).getState());
    assertEquals(CellState.Marble, game.getCell(3, 9).getState());
    assertEquals(CellState.Marble, game.getCell(9, 3).getState());
  }

  @Test
  public void testBuildGrid4() {
    EuropeanSolitaireModelImpl game = new EuropeanSolitaireModelImpl(5, 4, 5);
    assertEquals(CellState.Marble, game.getCell(9, 9).getState());
    assertEquals(CellState.Marble, game.getCell(3, 3).getState());
    assertEquals(CellState.Marble, game.getCell(3, 9).getState());
    assertEquals(CellState.Marble, game.getCell(9, 3).getState());
    assertEquals(CellState.Empty, game.getCell(4, 5).getState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveDiffRow() {
    EuropeanSolitaireModelImpl exGame = new EuropeanSolitaireModelImpl();
    exGame.move(3, 5, 4, 3);
  }

  @Test
  public void testGameState() {
    assertEquals("    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O",
        new EuropeanSolitaireModelImpl().getGameState());
    assertEquals("    O _ O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O",
        new EuropeanSolitaireModelImpl(0, 3).getGameState());
  }

  @Test
  public void testMove() {
    EuropeanSolitaireModelImpl game = new EuropeanSolitaireModelImpl();
    game.move(3, 5, 3, 3);
    assertEquals("    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O O O O _ _ O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O",
        game.getGameState());

    game.move(3, 2, 3, 4);
    assertEquals("    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O O _ _ O _ O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O",
        game.getGameState());

    game.move(1, 3, 3, 3);
    assertEquals("    O O O\n"
            + "  O O _ O O\n"
            + "O O O _ O O O\n"
            + "O O _ O O _ O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O",
        game.getGameState());

    game.move(5, 2, 3, 2);
    assertEquals("    O O O\n"
            + "  O O _ O O\n"
            + "O O O _ O O O\n"
            + "O O O O O _ O\n"
            + "O O _ O O O O\n"
            + "  O _ O O O\n"
            + "    O O O",
        game.getGameState());

    EuropeanSolitaireModelImpl a = new EuropeanSolitaireModelImpl(5, 0, 4);
    a.move(0, 6, 0, 4);
    assertEquals("        O _ _ O O\n"
        + "      O O O O O O O\n"
        + "    O O O O O O O O O\n"
        + "  O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "  O O O O O O O O O O O\n"
        + "    O O O O O O O O O\n"
        + "      O O O O O O O\n"
        + "        O O O O O", a.getGameState());
  }

  @Test
  public void testGameOver() {
    EuropeanSolitaireModelImpl game = new EuropeanSolitaireModelImpl();
    game.move(3, 5, 3, 3);
    game.move(3, 2, 3, 4);
    game.move(1, 3, 3, 3);
    game.move(5, 2, 3, 2);
    game.move(4, 3, 2, 3);
    game.move(4, 5, 4, 3);
    game.move(4, 0, 4, 2);
    game.move(3, 2, 5, 2);
    game.move(3, 0, 3, 2);
    assertFalse(game.isGameOver());
    game.move(6, 2, 4, 2);
    game.move(5, 4, 5, 2);
    game.move(5, 1, 5, 3);
    game.move(6, 4, 6, 2);
    game.move(1, 1, 3, 1);
    game.move(4, 2, 4, 4);
    game.move(3, 2, 3, 0);
    game.move(2, 0, 4, 0);
    assertFalse(game.isGameOver());
    game.move(1, 2, 3, 2);
    game.move(2, 4, 2, 2);
    game.move(2, 2, 4, 2);
    game.move(0, 4, 2, 4);
    game.move(0, 2, 0, 4);
    game.move(3, 4, 1, 4);
    game.move(0, 4, 2, 4);
    game.move(2, 5, 2, 3);
    assertTrue(game.isGameOver());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBadMove() {
    EuropeanSolitaireModelImpl game = new EuropeanSolitaireModelImpl();
    game.move(0, 2, 0, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveOutOfBounds() {
    EuropeanSolitaireModelImpl game = new EuropeanSolitaireModelImpl();
    game.move(0, 2, -2, 2);
    game.move(15, 0, 3, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNoMarbleFrom() {
    EuropeanSolitaireModelImpl game = new EuropeanSolitaireModelImpl();
    game.move(3,3, 3, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMarbleTo() {
    EuropeanSolitaireModelImpl game = new EuropeanSolitaireModelImpl();
    game.move(0, 2, 0, 4);
  }
  @Test(expected = IllegalArgumentException.class)
  public void testNoMarbleMid() {
    EuropeanSolitaireModelImpl game = new EuropeanSolitaireModelImpl();
    game.move(3, 2,3,4);
  }

  @Test
  public void testGetScore() {
    assertEquals(36,
        new EuropeanSolitaireModelImpl().getScore());
    assertEquals(128,
        new EuropeanSolitaireModelImpl(5).getScore());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorTwo() {
    new EuropeanSolitaireModelImpl(1, 0);
    new EuropeanSolitaireModelImpl(0, 5);
    new EuropeanSolitaireModelImpl(5, 0);
    new EuropeanSolitaireModelImpl(5, 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorThree() {
    new EuropeanSolitaireModelImpl(-3);
    new EuropeanSolitaireModelImpl(4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorFour() {
    new EuropeanSolitaireModelImpl(4, 6, 6);
    new EuropeanSolitaireModelImpl(5, 0, 1);
  }
}