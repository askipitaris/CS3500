import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import cs3500.animator.util.AnimationReader;
import cs3500.animator.view.IView;
import cs3500.animator.view.TextualView;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import model.AnimatorModel;
import model.AnimatorModelImpl;
import org.junit.Test;

/**
 * Tests for the textual view.
 */
public class TextualViewTest {

  @Test
  public void testMakeFile() {
    AnimatorModel m = new AnimatorModelImpl.Builder().setBounds(200, 70, 360, 360)
        .declareShape("R", "rectangle")
        .addKeyframe("R", 1, 200, 200, 50, 100, 255, 0, 0)
        .addMotion("R", 10, 200, 200, 50, 100, 255, 0, 0, 50
            , 300, 300, 50, 100, 255, 0, 0)
        .build();

    IView v = new TextualView(m, "C:\\Easy Animator Output\\test.txt");

    File f = new File("C:\\Easy Animator Output\\test.txt");
    assertTrue(f.exists());
  }

  @Test
  public void testTextFromFile() {
    Readable in = null;

    try {
      in = new FileReader("C:\\Users\\alex\\IdeaProjects\\CS3500\\"
              + "HW6 - Easy Animator View\\resources\\toh-3.txt");
    } catch (IOException ioe) {
      System.out.println("asd");
    }

    AnimatorModel m = AnimationReader.parseFile(in, new AnimatorModelImpl.Builder());

    IView v = new TextualView(m, "C:\\Easy Animator Output\\test.txt");

    File f = new File("C:\\Easy Animator Output\\test.txt");
    assertTrue(f.exists());
  }

  @Test
  public void testPrintToConsole() {
    AnimatorModel m = new AnimatorModelImpl.Builder().setBounds(200, 70, 360, 360)
        .declareShape("R", "rectangle")
        .addKeyframe("R", 1, 200, 200, 50, 100, 255, 0, 0)
        .addMotion("R", 10, 200, 200, 50, 100, 255, 0, 0, 50
            , 300, 300, 50, 100, 255, 0, 0)
        .build();

    IView v = new TextualView(m, "System.out");

    assertEquals("canvas 200 70 360 360\n"
        + "shape R rectangle\n"
        + "motion R 1 200 200 50 100 255 0 0  R 1 200 200 50 100 255 0 0\n"
        + "motion R 10 200 200 50 100 255 0 0  R 50 300 300 50 100 255 0 0\n", m.getState());
  }

}
