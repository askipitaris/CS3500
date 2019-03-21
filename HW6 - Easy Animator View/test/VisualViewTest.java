import cs3500.animator.view.VisualView;
import model.AnimatorModel;
import model.AnimatorModelImpl;
import org.junit.Test;

/**
 * Tests that visual view works properly.
 */
public class VisualViewTest {


  @Test (expected = IllegalArgumentException.class)
  public void testConstructorBadModel() {
    AnimatorModel m = null;

    new VisualView(m, 10);

  }

  @Test (expected = IllegalArgumentException.class)
  public void testConstructorBadSpeed() {
    AnimatorModel m = new AnimatorModelImpl.Builder().setBounds(200, 70, 360, 360)
        .declareShape("R", "ellipse")
        .addKeyframe("R", 1, 200, 200, 50, 100, 255, 0, 0)
        .addMotion("R", 10, 200, 200, 50, 100, 255, 0, 0, 50,
            300, 300, 50, 100, 255, 0, 0)
        .build();

    new VisualView(m, -10);

  }




}