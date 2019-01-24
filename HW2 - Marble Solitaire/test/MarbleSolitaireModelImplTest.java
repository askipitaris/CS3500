import static org.junit.Assert.assertEquals;

import cs3500.marblesolitaire.model.hw02.CellState;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;
import org.junit.Test;

public class MarbleSolitaireModelImplTest {

  @Test
  public void testBuildGrid() {
    MarbleSolitaireModel t1 = new MarbleSolitaireModelImpl();
    assertEquals(CellState.Empty,
        ((MarbleSolitaireModelImpl) t1).board[3][3].state);
    assertEquals(CellState.Filled,
        ((MarbleSolitaireModelImpl) t1).board[2][2].state);
    assertEquals(CellState.Filled,
        ((MarbleSolitaireModelImpl) t1).board[3][1].state);
    assertEquals(CellState.Inaccessible,
        ((MarbleSolitaireModelImpl) t1).board[0][0].state);
    assertEquals(CellState.Inaccessible,
        ((MarbleSolitaireModelImpl) t1).board[1][1].state);
    assertEquals(CellState.Inaccessible,
        ((MarbleSolitaireModelImpl) t1).board[5][1].state);
    assertEquals(CellState.Inaccessible,
        ((MarbleSolitaireModelImpl) t1).board[1][5].state);
    assertEquals(CellState.Inaccessible,
        ((MarbleSolitaireModelImpl) t1).board[5][5].state);
  }

  @Test
  public void testBuildGrid2() {
    MarbleSolitaireModel t2 = new MarbleSolitaireModelImpl(2, 2);
    assertEquals(CellState.Empty,
        ((MarbleSolitaireModelImpl) t2).board[2][2].state);
  }

  @Test
  public void testBuildGrid3() {
    MarbleSolitaireModel t3 = new MarbleSolitaireModelImpl(5, 5, 4);
    assertEquals(CellState.Empty,
        ((MarbleSolitaireModelImpl) t3).board[5][4].state);
  }

  @Test
  public void testMove() {

  }

  @Test
  public void testIsGameOver() {

  }

  @Test
  public void testGameState() {
    assertEquals("    o o o    \n"
            + "    o o o    \n"
            + "o o o o o o o\n"
            + "o o o _ o o o\n"
            + "o o o o o o o\n"
            + "    o o o    \n"
            + "    o o o    ",
        new MarbleSolitaireModelImpl().getGameState());
    assertEquals("    o _ o    \n"
            + "    o o o    \n"
            + "o o o o o o o\n"
            + "o o o o o o o\n"
            + "o o o o o o o\n"
            + "    o o o    \n"
            + "    o o o    ",
        new MarbleSolitaireModelImpl(0, 3).getGameState());
  }

  @Test
  public void testGetScore() {

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
