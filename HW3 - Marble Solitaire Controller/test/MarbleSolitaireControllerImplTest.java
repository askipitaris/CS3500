import static org.junit.Assert.assertEquals;

import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;
import java.io.InputStreamReader;
import java.io.StringReader;
import org.junit.Test;

public class MarbleSolitaireControllerImplTest {

  @Test
  public void testConstructor() {
    Readable in = new InputStreamReader(System.in);
    MarbleSolitaireControllerImpl exController = new MarbleSolitaireControllerImpl(in, System.out);

    assertEquals(exController.getInput(), in);
    assertEquals(exController.getOutput(), System.out);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBogusConstructor() {
    new MarbleSolitaireControllerImpl(null, System.out);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBogusConstructor2() {
    new MarbleSolitaireControllerImpl(new InputStreamReader(System.in), null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBogusConstructor3() {
    new MarbleSolitaireControllerImpl(null, null);
  }

  @Test
  public void testMove() {
    MarbleSolitaireModelImpl exModel = new MarbleSolitaireModelImpl();
    Readable in = new StringReader("4 6 4 4");
    Appendable out = new StringBuilder();
    MarbleSolitaireControllerImpl exController = new MarbleSolitaireControllerImpl(in, out);

    exController.playGame(exModel);

    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O _ _ O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\nScore: 31", out.toString());
  }
  
  @Test
  public void testMoveGameOver() {
    MarbleSolitaireModelImpl exModel = new MarbleSolitaireModelImpl();

    exModel.move(3, 1, 3, 3);
    exModel.move(3, 4, 3, 2);
    exModel.move(5, 3, 3, 3);
    exModel.move(3, 2, 3, 4);
    exModel.move(4, 1, 4, 3);
    exModel.move(4, 4, 4, 2);
    exModel.move(6, 4, 4, 4);
    exModel.move(6, 2, 6, 4);
    exModel.move(4, 2, 6, 2);
    exModel.move(4, 5, 4, 3);
    exModel.move(3, 5, 3, 3);
    exModel.move(3, 3, 5, 3);
    exModel.move(1, 2, 3, 2);
    exModel.move(1, 3, 3, 3);
    exModel.move(3, 3, 3, 1);
    exModel.move(3, 0, 3, 2);
    exModel.move(2, 0, 2, 2);
    exModel.move(2, 2, 4, 2);
    exModel.move(1, 4, 3, 4);
    exModel.move(2, 6, 2, 4);
    exModel.move(2, 4, 4, 4);

    Readable in = new StringReader("5 7 3 7");
    Appendable out = new StringBuilder();
    MarbleSolitaireControllerImpl exController = new MarbleSolitaireControllerImpl(in, out);

    exController.playGame(exModel);

    assertEquals("Game over!\n"
        + "    O O O\n"
        + "    _ _ _\n"
        + "_ _ _ _ _ _ O\n"
        + "_ _ _ _ _ _ _\n"
        + "O _ O _ O _ _\n"
        + "    _ O _\n"
        + "    O _ O\nScore: 10", out.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove() {
    MarbleSolitaireModelImpl exModel = new MarbleSolitaireModelImpl();
    Readable in = new StringReader("0 7 3 7");
    Appendable out = new StringBuilder();
    MarbleSolitaireControllerImpl exController = new MarbleSolitaireControllerImpl(in, out);

    exController.playGame(exModel);
  }
}
