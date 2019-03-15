import static org.junit.Assert.assertEquals;

import model.AnimatorModel;
import model.AnimatorModelImpl;
import org.junit.Test;

/**
 * Tests for the AnimatorModel.
 */
public class TestAnimatorModel {

  @Test
  public void testGetState() {
    AnimatorModel m = new AnimatorModelImpl.Builder().setBounds(200, 70, 360, 360)
        .declareShape("R", "rectangle")
        .addKeyframe("R", 1, 200, 200, 50, 100, 255, 0, 0)
        .addMotion("R", 10, 200, 200, 50, 100, 255, 0, 0, 50
            , 300, 300, 50, 100, 255, 0, 0)
        .build();

    assertEquals("canvas 200 70 360 360\n"
        + "shape R rectangle\n"
        + "motion R 1 200 200 50 100 255 0 0  R 1 200 200 50 100 255 0 0\n"
        + "motion R 10 200 200 50 100 255 0 0  R 50 300 300 50 100 255 0 0\n", m.getState());
  }

  @Test
  public void testGetWidth() {
    AnimatorModel m = new AnimatorModelImpl.Builder().setBounds(200, 70, 360, 360)
        .declareShape("R", "rectangle")
        .addKeyframe("R", 1, 200, 200, 50, 100, 255, 0, 0)
        .addMotion("R", 10, 200, 200, 50, 100, 255, 0, 0, 50
            , 300, 300, 50, 100, 255, 0, 0)
        .build();

    assertEquals(360, m.getWidth());
  }

  @Test
  public void testGetHeight() {
    AnimatorModel m = new AnimatorModelImpl.Builder().setBounds(200, 70, 360, 360)
        .declareShape("R", "rectangle")
        .addKeyframe("R", 1, 200, 200, 50, 100, 255, 0, 0)
        .addMotion("R", 10, 200, 200, 50, 100, 255, 0, 0, 50
            , 300, 300, 50, 100, 255, 0, 0)
        .build();

    assertEquals(360, m.getHeight());
  }

  @Test
  public void testGetShapes() {
    AnimatorModel m = new AnimatorModelImpl.Builder().setBounds(200, 70, 360, 360)
        .declareShape("R", "rectangle")
        .addKeyframe("R", 1, 200, 200, 50, 100, 255, 0, 0)
        .addMotion("R", 10, 200, 200, 50, 100, 255, 0, 0, 50
            , 300, 300, 50, 100, 255, 0, 0)
        .build();

    assertEquals("rectangle", m.getShape("R"));
  }

  @Test
  public void testNumOfShapes() {
    AnimatorModel m = new AnimatorModelImpl.Builder().setBounds(200, 70, 360, 360)
        .declareShape("R", "rectangle")
        .addKeyframe("R", 1, 200, 200, 50, 100, 255, 0, 0)
        .addMotion("R", 10, 200, 200, 50, 100, 255, 0, 0, 50
            , 300, 300, 50, 100, 255, 0, 0)
        .build();

    assertEquals(1, m.numOfShapes());
  }
}