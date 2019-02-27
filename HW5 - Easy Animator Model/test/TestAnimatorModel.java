import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import model.AnimatorModel;
import model.AnimatorModelImpl;
import model.action.Action;
import model.shape.AbstractShape;
import model.shape.AbstractShape.ShapeType;
import model.shape.Circle;
import model.shape.IShape;
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

    exAnimation.addShape("c", AbstractShape.ShapeType.Circle, 10, 10, new Posn(250, 250),
        Color.red, 10, 20);

    assertEquals(1, exAnimation.numOfShapes());
  }

  @Test
  public void testAddActions() {
    AnimatorModel exAnimation = new AnimatorModelImpl();

    exAnimation.addAction("c", 11, 19, new Posn(300, 300), new Posn(300, 310),
        1, Color.red);
    assertEquals(1, exAnimation.getActions().size());

    Action a = new Action("c", 11, 19, new Posn(300, 300), new Posn(300, 310),
        1, Color.red);

    assertEquals(a, exAnimation.getActions().get(0));
    exAnimation.addAction("c", 10, 19, new Posn(300, 300), new Posn(300, 310),
        1, Color.red);
    Action a2 = new Action("c", 10, 19, new Posn(300, 300), new Posn(300, 310),
        1, Color.red);
    assertEquals(a2, exAnimation.getActions().get(1));
  }

  @Test
  public void testGetGameState() {
    AnimatorModel exAnimation = new AnimatorModelImpl();
    exAnimation.addShape("r", ShapeType.Rectangle, 5, 10, new Posn(150, 100), Color.YELLOW, 1, 5);
    exAnimation.addShape("c", AbstractShape.ShapeType.Circle, 10, 10, new Posn(250, 250),
        Color.red, 10, 20);

    exAnimation.addAction("c", 11, 19, new Posn(300, 300), new Posn(300, 310),
        1, Color.red);

    exAnimation.addAction("r", 2, 4, new Posn(200, 150), new Posn(200, 100),
        1, Color.red);

    assertEquals("shape c Circle\n"
            + "motion c 11 300.0 310.0 10 10 255 0 0    19 300.0 300.0 10 10 255 0 0\n"
            + "shape r Rectangle\n"
            + "motion r 2 200.0 100.0 10 5 255 255 0    4 200.0 150.0 10 5 255 255 0",
        exAnimation.getState());
  }

  @Test
  public void testMoveShape() {
    AnimatorModel exAnimation = new AnimatorModelImpl();
    exAnimation.addShape("c", AbstractShape.ShapeType.Circle, 10, 10, new Posn(250, 250),
        Color.red, 10, 20);

    assertEquals(250, exAnimation.getShape("c").getPosn().getX(), 0.0001);
    assertEquals(250, exAnimation.getShape("c").getPosn().getY(), 0.0001);
    IShape c = new Circle(10, new Posn(250, 250), Color.red, 10, 20, ShapeType.Circle);
    exAnimation.move(c, c.getPosn(), 10, 20, new Posn(300, 300));

    assertEquals(250, exAnimation.getShape("c").getPosn().getX(), 0.0001);
    assertEquals(250, exAnimation.getShape("c").getPosn().getY(), 0.0001);
  }

  @Test
  public void testAnimationOver() {
    AnimatorModel exAnimation = new AnimatorModelImpl();
    exAnimation.addShape("c", AbstractShape.ShapeType.Circle, 10, 10, new Posn(250, 250),
        Color.red, 10, 20);

    assertTrue(exAnimation.animationOver());

    exAnimation.addAction("c", 11, 19, new Posn(300, 300), new Posn(300, 310),
        1, Color.red);

    assertFalse(exAnimation.animationOver());
  }

  @Test
  public void testGetShape() {
    AnimatorModel exAnimation = new AnimatorModelImpl();
    exAnimation.addShape("c", AbstractShape.ShapeType.Circle, 10, 10, new Posn(250, 250),
        Color.red, 10, 20);
    Circle c = new Circle(10, new Posn(250, 250),
        Color.red, 10, 20, ShapeType.Circle);
    assertEquals(c, exAnimation.getShape("c"));
  }

  @Test
  public void testGetActions() {
    AnimatorModel exAnimation = new AnimatorModelImpl();
    exAnimation.addAction("r", 2, 4, new Posn(200, 150), new Posn(200, 100),
        1, Color.red);

    Action a = new Action("r", 2, 4, new Posn(200, 150), new Posn(200, 100),
        1, Color.red);

    assertEquals(a, exAnimation.getActions().get(0));
  }

  @Test
  public void testNumberOfShapes() {
    AnimatorModel exAnimation = new AnimatorModelImpl();
    exAnimation.addShape("c", AbstractShape.ShapeType.Circle, 10, 10, new Posn(250, 250),
        Color.red, 10, 20);
    assertEquals(1, exAnimation.numOfShapes());
  }

  @Test
  public void testRunAnimation() {
    AnimatorModel exAnimation = new AnimatorModelImpl();
    exAnimation.addShape("c", AbstractShape.ShapeType.Circle, 10, 10, new Posn(250, 250),
        Color.red, 10, 20);
    exAnimation.addAction("c", 11, 15, new Posn(300, 300), new Posn(250, 250), 0.8, Color.blue);

    assertEquals(10, exAnimation.getShape("c").getHeight());
    assertEquals(10, exAnimation.getShape("c").getWidth());
    assertEquals(250, exAnimation.getShape("c").getPosn().getX(), 0.0001);
    assertEquals(250, exAnimation.getShape("c").getPosn().getY(), 0.0001);
    assertEquals(-65536, exAnimation.getShape("c").getColor().getRGB());

    exAnimation.runAnimation();

    assertEquals(8, exAnimation.getShape("c").getHeight());
    assertEquals(8, exAnimation.getShape("c").getWidth());
    assertEquals(300, exAnimation.getShape("c").getPosn().getX(), 0.0001);
    assertEquals(300, exAnimation.getShape("c").getPosn().getY(), 0.0001);
    assertEquals(-16776961, exAnimation.getShape("c").getColor().getRGB());
  }

  @Test
  public void testRunAnimationMult() {
    AnimatorModel exAnimation = new AnimatorModelImpl();
    exAnimation.addShape("c", AbstractShape.ShapeType.Circle, 10, 10, new Posn(250, 250),
        Color.red, 10, 20);
    exAnimation.addAction("c", 11, 15, new Posn(300, 300), new Posn(250, 250), 0.8, Color.blue);

    exAnimation.addAction("c", 11, 15, new Posn(350, 300), new Posn(300, 300), 2.0, Color.blue);

    assertEquals(10, exAnimation.getShape("c").getHeight());
    assertEquals(10, exAnimation.getShape("c").getWidth());
    assertEquals(250, exAnimation.getShape("c").getPosn().getX(), 0.0001);
    assertEquals(250, exAnimation.getShape("c").getPosn().getY(), 0.0001);
    assertEquals(-65536, exAnimation.getShape("c").getColor().getRGB());

    exAnimation.runAnimation();

    assertEquals(16, exAnimation.getShape("c").getHeight());
    assertEquals(16, exAnimation.getShape("c").getWidth());
    assertEquals(350, exAnimation.getShape("c").getPosn().getX(), 0.0001);
    assertEquals(300, exAnimation.getShape("c").getPosn().getY(), 0.0001);
    assertEquals(-16776961, exAnimation.getShape("c").getColor().getRGB());

  }
}