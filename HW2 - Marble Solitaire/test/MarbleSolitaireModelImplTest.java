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
    assertEquals(CellState.Empty, game.board[3][3].state);
    assertEquals(CellState.Filled, game.board[2][2].state);
    assertEquals(CellState.Filled, game.board[3][1].state);
    assertEquals(CellState.Inaccessible, game.board[0][0].state);
    assertEquals(CellState.Inaccessible, game.board[1][1].state);
    assertEquals(CellState.Inaccessible, game.board[5][1].state);
    assertEquals(CellState.Inaccessible, game.board[1][5].state);
    assertEquals(CellState.Inaccessible, game.board[5][5].state);
  }

  @Test
  public void testBuildGrid2() {
    MarbleSolitaireModelImpl game2 = new MarbleSolitaireModelImpl(2, 2);
    assertEquals(CellState.Empty, game2.board[2][2].state);
  }

  @Test
  public void testBuildGrid3() {
    MarbleSolitaireModelImpl game3 = new MarbleSolitaireModelImpl(5, 5, 4);
    assertEquals(CellState.Empty, game3.board[5][4].state);
  }

  @Test
  public void testIsValidMove() {
    MarbleSolitaireModelImpl game4 = new MarbleSolitaireModelImpl();
    assertTrue(((MarbleSolitaireModelImpl) game4).isValidMove(
        3, 5, 3, 3, game4.board[3][4]));
    assertTrue(((MarbleSolitaireModelImpl) game4).isValidMove(
        5, 3, 3, 3, game4.board[4][3]));
  }

  @Test
  public void testInvalidMove() {
    MarbleSolitaireModelImpl game5 = new MarbleSolitaireModelImpl();
    assertFalse(game5.isValidMove(0, 2, 0, 4, game5.board[0][3]));
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
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBadMove() {
    MarbleSolitaireModelImpl game7 = new MarbleSolitaireModelImpl();
    game7.move(0, 2, 0, 4);
  }

  @Test(expected = ArrayIndexOutOfBoundsException.class)
  public void testMoveOutOfBounds() {
    MarbleSolitaireModelImpl game8 = new MarbleSolitaireModelImpl();
    game8.move(0, 2, -2, 2);
  }

  @Test
  public void testIsGameOver() {
    MarbleSolitaireModelImpl game9 = new MarbleSolitaireModelImpl();
    assertEquals(false,
        game9.isGameOver());
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
