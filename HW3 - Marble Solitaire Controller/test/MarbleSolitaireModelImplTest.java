import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import cs3500.marblesolitaire.model.hw02.CellState;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;
import org.junit.Test;

public class MarbleSolitaireModelImplTest {

  @Test
  public void testBuildGrid() {
    MarbleSolitaireModelImpl game = new MarbleSolitaireModelImpl();
    assertEquals(CellState.Empty, game.getCell(3, 3).getState());
    assertEquals(CellState.Marble, game.getCell(2, 2).getState());
    assertEquals(CellState.Marble, game.getCell(3, 1).getState());
    assertEquals(CellState.Inaccessible, game.getCell(0, 0).getState());
    assertEquals(CellState.Inaccessible, game.getCell(1, 1).getState());
    assertEquals(CellState.Inaccessible, game.getCell(5, 1).getState());
    assertEquals(CellState.Inaccessible, game.getCell(1, 5).getState());
    assertEquals(CellState.Inaccessible, game.getCell(5, 5).getState());
  }

  @Test
  public void testBuildGrid2() {
    MarbleSolitaireModelImpl game2 = new MarbleSolitaireModelImpl(2, 2);
    assertEquals(CellState.Empty, game2.getCell(2, 2).getState());
  }

  @Test
  public void testBuildGrid3() {
    MarbleSolitaireModelImpl game3 = new MarbleSolitaireModelImpl(5, 5, 4);
    assertEquals(CellState.Empty, game3.getCell(5, 4).getState());
  }

  @Test
  public void testIsValidMove() {
    MarbleSolitaireModelImpl game4 = new MarbleSolitaireModelImpl();
    assertTrue(game4.isValidMove(
        3, 5, 3, 3, game4.getCell(3, 4)));
    assertTrue(game4.isValidMove(
        5, 3, 3, 3, game4.getCell(4, 3)));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOutOfBoundsMove() {
    MarbleSolitaireModelImpl game4 = new MarbleSolitaireModelImpl();
    game4.move(-1, 3, 1, 3);
  }

  @Test
  public void testInvalidMove() {
    MarbleSolitaireModelImpl game5 = new MarbleSolitaireModelImpl();
    assertFalse(game5.isValidMove(0, 2, 0, 4, game5.getCell(0, 3)));
  }

  @Test
  public void testMove() {
    MarbleSolitaireModelImpl game6 = new MarbleSolitaireModelImpl();
    game6.move(3, 5, 3, 3);
    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O _ _ O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O",
        game6.getGameState());

    game6.move(3,2, 3, 4);
    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O _ _ O _ O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O",
        game6.getGameState());

    game6.move(1,3, 3, 3);
    assertEquals("    O O O\n"
            + "    O _ O\n"
            + "O O O _ O O O\n"
            + "O O _ O O _ O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O",
        game6.getGameState());

    game6.move(5,2, 3, 2);
    assertEquals("    O O O\n"
            + "    O _ O\n"
            + "O O O _ O O O\n"
            + "O O O O O _ O\n"
            + "O O _ O O O O\n"
            + "    _ O O\n"
            + "    O O O",
        game6.getGameState());

    MarbleSolitaireModelImpl a = new MarbleSolitaireModelImpl(5, 0, 4);
    a.move(0, 6, 0, 4);
    assertEquals("        O _ _ O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O", a.getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBadMove() {
    MarbleSolitaireModelImpl game7 = new MarbleSolitaireModelImpl();
    game7.move(0, 2, 0, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveOutOfBounds() {
    MarbleSolitaireModelImpl game8 = new MarbleSolitaireModelImpl();
    game8.move(0, 2, -2, 2);
    game8.move(15, 0, 3, 5);
  }

  @Test
  public void testIsGameOver() {
    MarbleSolitaireModelImpl game9 = new MarbleSolitaireModelImpl();
    assertFalse(game9.isGameOver());
    game9.move(3, 1, 3, 3);
    game9.move(3, 4, 3, 2);
    game9.move(5, 3, 3, 3);
    game9.move(3, 2, 3, 4);
    game9.move(4, 1, 4, 3);
    game9.move(4, 4, 4, 2);
    game9.move(6, 4, 4, 4);
    game9.move(6, 2, 6, 4);
    assertFalse(game9.isGameOver());
    game9.move(4, 2, 6, 2);
    game9.move(4, 5, 4, 3);
    game9.move(3, 5, 3, 3);
    game9.move(3, 3, 5, 3);
    game9.move(1, 2, 3, 2);
    game9.move(1, 3, 3, 3);
    game9.move(3, 3, 3, 1);
    assertFalse(game9.isGameOver());
    game9.move(3, 0, 3, 2);
    game9.move(2, 0, 2, 2);
    game9.move(2, 2, 4, 2);
    game9.move(1, 4, 3, 4);
    game9.move(2, 6, 2, 4);
    game9.move(2, 4, 4, 4);
    game9.move(4, 6, 2, 6);
    assertTrue(game9.isGameOver());
    System.out.print(game9.getGameState());
  }

  @Test
  public void testGameState() {
    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O",
        new MarbleSolitaireModelImpl().getGameState());
    assertEquals("    O _ O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O",
        new MarbleSolitaireModelImpl(0, 3).getGameState());
  }

  @Test
  public void testGetScore() {
    assertEquals(32,
        new MarbleSolitaireModelImpl().getScore());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorTwo() {
    new MarbleSolitaireModelImpl(1, 1);
    new MarbleSolitaireModelImpl(1, 5);
    new MarbleSolitaireModelImpl(5, 1);
    new MarbleSolitaireModelImpl(5, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorThree() {
    new MarbleSolitaireModelImpl(-3);
    new MarbleSolitaireModelImpl(4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorFour() {
    new MarbleSolitaireModelImpl(4, 6, 6);
    new MarbleSolitaireModelImpl(5, 0, 1);
  }
}
