import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MarbleSolitaireModelImplTest {

  @Test
  public void testMove() {

  }

  @Test
  public void testIsGameOver() {

  }

  @Test
  public void testGameState() {
    assertEquals("    O O O    \n"
        + "    O O O    \n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O    \n"
        + "    O O O    ",
    new MarbleSolitaireModelImpl().getGameState());
  }

  @Test
  public void testGetScore() {

  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorTwo() {
    new MarbleSolitaireModelImpl(0,0);
    new MarbleSolitaireModelImpl(2, 2);
    new MarbleSolitaireModelImpl(6, 6);
    new MarbleSolitaireModelImpl(2, 6);
    new MarbleSolitaireModelImpl(5, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorThree() {
    new MarbleSolitaireModelImpl(-3);
    new MarbleSolitaireModelImpl(4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorFour() {
    new MarbleSolitaireModelImpl(4, 5, 5);
    new MarbleSolitaireModelImpl(5, 4, 6);
  }
}
