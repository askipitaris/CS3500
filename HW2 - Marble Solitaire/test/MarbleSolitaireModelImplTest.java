import cs3500.marblesolitaire.model.hw02.CellState;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MarbleSolitaireModelImplTest {

  @Test
  public void testBuildGrid(){
    MarbleSolitaireModel t1 = new MarbleSolitaireModelImpl();
    assertEquals(CellState.Empty,
        ((MarbleSolitaireModelImpl) t1).board[3][3].state);
    assertEquals(CellState.Filled,
        ((MarbleSolitaireModelImpl) t1).board[0][2].state);
    assertEquals(CellState.Filled,
        ((MarbleSolitaireModelImpl) t1).board[0][3].state);
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
  public void testMove() {

  }

  @Test
  public void testIsGameOver() {

  }

  @Test
  public void testGameState() {
    /*assertEquals("    O O O    \n"
        + "    O O O    \n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O    \n"
        + "    O O O    ",
    new MarbleSolitaireModelImpl().getGameState());*/
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
    //Rewrite these
    /*new MarbleSolitaireModelImpl(4, 5, 5);
    new MarbleSolitaireModelImpl(5, 5, 6);*/
  }
}
