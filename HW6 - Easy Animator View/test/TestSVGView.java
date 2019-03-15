import static org.junit.Assert.assertTrue;

import cs3500.animator.view.IView;
import cs3500.animator.view.SVGView;
import java.io.File;
import model.AnimatorModel;
import model.AnimatorModelImpl;
import org.junit.Test;

/**
 * Tests for the SVG view.
 */
public class TestSVGView {

  @Test
  public void testMakeFile() {
    AnimatorModel m = new AnimatorModelImpl.Builder().setBounds(200, 70, 360, 360)
        .declareShape("R", "rectangle")
        .addKeyframe("R", 1, 200, 200, 50, 100, 255, 0, 0)
        .addMotion("R", 10, 200, 200, 50, 100, 255, 0, 0, 50
            , 300, 300, 50, 100, 255, 0, 0)
        .build();

    IView v = new SVGView(m, "C:\\Easy Animator Output\\test.svg");

    File f = new File("C:\\Easy Animator Output\\test.svg");
    assertTrue(f.exists());
  }
}
