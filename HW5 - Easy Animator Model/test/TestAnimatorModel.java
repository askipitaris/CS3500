import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import model.AnimatorModel;
import model.AnimatorModelImpl;
import model.action.Action;
import org.junit.Test;
import posn.Posn;

/**
 * Tests for the AnimatorModel.
 */
public class TestAnimatorModel {

  @Test
  public void testAdd() {
    AnimatorModel exAnimation = new AnimatorModelImpl();
    assertEquals(0, exAnimation.numOfShapes());

    exAnimation.add("c", "circle", 10, 10, new Posn(250, 250),
        Color.red, 10, 20);

    assertEquals(1, exAnimation.numOfShapes());
  }

  @Test
  public void testAddActions() {
    AnimatorModel exAnimation = new AnimatorModelImpl();
    Action exAction = new Action("c", 11, 19, new Posn(300, 300), new Posn(300, 310),
        1, Color.red);

    exAnimation.addActions(exAction);
    assertEquals(1, exAnimation.getActions().size());

  }

  @Test
  public void testGetGameState() {
    AnimatorModel exAnimation = new AnimatorModelImpl();
    exAnimation.add("c", "circle", 10, 10, new Posn(250, 250),
        Color.red, 10, 20);
    Action exAction = new Action("c", 11, 19, new Posn(300, 300), new Posn(300, 310),
        1, Color.red);

    exAnimation.addActions(exAction);

    assertEquals("shape c circle\n"
        + "motion c 11 300 310 10 10 255 0 0    19 300 300 10 10 255 0 0", exAnimation.getState());
  }

  @Test
  public void testMoveShape() {
    AnimatorModel exAnimation = new AnimatorModelImpl();
    exAnimation.add("c", "circle", 10, 10, new Posn(250, 250),
        Color.red, 10, 20);

    assertEquals(250, exAnimation.getShape("c").getPosn().getX());
    assertEquals(250, exAnimation.getShape("c").getPosn().getY());

    exAnimation.moveShape("c", new Posn(300, 300));

    assertEquals(300, exAnimation.getShape("c").getPosn().getX());
    assertEquals(300, exAnimation.getShape("c").getPosn().getY());
  }

  @Test
  public void testChangeColor() {
    AnimatorModel exAnimation = new AnimatorModelImpl();
    exAnimation.add("c", "circle", 10, 10, new Posn(250, 250),
        Color.red, 10, 20);

    assertEquals(Color.red, exAnimation.getShape("c").getColor());

    exAnimation.changeColor("c", Color.black);

    assertEquals(Color.black, exAnimation.getShape("c").getColor());
  }

  @Test
  public void testGrow() {
    AnimatorModel exAnimation = new AnimatorModelImpl();
    exAnimation.add("c", "circle", 10, 10, new Posn(250, 250),
        Color.red, 10, 20);

    assertEquals(10, exAnimation.getShape("c").getHeight());
    assertEquals(10, exAnimation.getShape("c").getWidth());

    exAnimation.grow("c", 1.5);

    assertEquals(15, exAnimation.getShape("c").getHeight());
    assertEquals(15, exAnimation.getShape("c").getWidth());
  }

  @Test
  public void testChangeVisibility() {
    AnimatorModel exAnimation = new AnimatorModelImpl();
    exAnimation.add("c", "circle", 10, 10, new Posn(250, 250),
        Color.red, 10, 20);

    assertFalse(exAnimation.getShape("c").getVisibility());

    exAnimation.changeVisibility("c");

    assertTrue(exAnimation.getShape("c").getVisibility());
  }

  @Test
  public void testAnimationOver() {
    AnimatorModel exAnimation = new AnimatorModelImpl();
    Action exAction = new Action("c", 11, 19, new Posn(300, 300), new Posn(300, 310),
        1, Color.red);
    exAnimation.add("c", "circle", 10, 10, new Posn(250, 250),
        Color.red, 10, 20);

    assertTrue(exAnimation.animationOver());

    exAnimation.addActions(exAction);

    assertFalse(exAnimation.animationOver());
  }
}