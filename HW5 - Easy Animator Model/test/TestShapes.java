import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import model.shape.Circle;
import model.shape.Ellipse;
import model.shape.IShape;
import model.shape.Rectangle;
import model.shape.Square;
import org.junit.Test;
import posn.Posn;

/**
 * Tests methods relating to shapes.
 */
public class TestShapes {

  @Test
  public void testCircleConstructor() {
    IShape c = new Circle(10, new Posn(3, 3), Color.red, 10, 90, "circle");

    assertFalse(c.getVisibility());
    assertEquals(Color.red, c.getColor());
  }

  @Test
  public void testEllipseConstructor() {
    IShape e = new Ellipse(10, 5, new Posn(3, 3), Color.black, 15, 20, "ellipse");

    assertFalse(e.getVisibility());
  }

  @Test
  public void testRectangleConstructor() {
    IShape r = new Rectangle(10, 5, new Posn(3, 3), Color.black, 15, 20, "rectangle");

    assertFalse(r.getVisibility());
  }

  @Test
  public void testSquareConstructor() {
    IShape s = new Square(5, new Posn(3, 3), Color.black, 15, 20, "square");

    assertFalse(s.getVisibility());
  }

  @Test
  public void testMove() {
    IShape c = new Circle(10, new Posn(3, 4), Color.red, 10, 90, "circle");
    Posn p = new Posn(5, 6);

    assertEquals(3, c.getPosn().getX());
    assertEquals(4, c.getPosn().getY());

    c.move(p);

    assertEquals(5, c.getPosn().getX());
    assertEquals(6, c.getPosn().getY());
  }

  @Test
  public void testGetPosn() {
    Posn p = new Posn(4, 3);
    IShape c = new Circle(10, p, Color.red, 10, 90, "circle");

    assertEquals(p, c.getPosn());
  }

  @Test
  public void testGetColor() {
    IShape c = new Circle(10, new Posn(3, 3), Color.red, 10, 90, "circle");

    assertEquals(Color.red, c.getColor());
  }

  @Test
  public void testGetVisibility() {
    IShape c = new Circle(10, new Posn(3, 3), Color.red, 10, 90, "circle");

    assertFalse(c.getVisibility());
  }

  @Test
  public void testSetVisibility() {
    IShape c = new Circle(10, new Posn(3, 3), Color.red, 10, 90, "circle");

    assertFalse(c.getVisibility());
    c.setVisibility();
    assertTrue(c.getVisibility());
  }
}
