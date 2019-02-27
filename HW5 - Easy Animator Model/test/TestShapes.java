import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import model.shape.AbstractShape;
import model.shape.AbstractShape.ShapeType;
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
    IShape c = new Circle(10, new Posn(3, 3), Color.red, 10, 90, AbstractShape.ShapeType.Circle);

    assertFalse(c.getVisibility());
    assertEquals(Color.red, c.getColor());
  }

  @Test
  public void testEllipseConstructor() {
    IShape e = new Ellipse(10, 5, new Posn(3, 3), Color.black, 15, 20,
        AbstractShape.ShapeType.Ellipse);

    assertFalse(e.getVisibility());
  }

  @Test
  public void testRectangleConstructor() {
    IShape r = new Rectangle(10, 5, new Posn(3, 3), Color.black, 15, 20, ShapeType.Rectangle);

    assertFalse(r.getVisibility());
  }

  @Test
  public void testSquareConstructor() {
    IShape s = new Square(5, new Posn(3, 3), Color.black, 15, 20, ShapeType.Square);

    assertFalse(s.getVisibility());
  }

  @Test
  public void testMoveDiagonal() {
    IShape c = new Circle(10, new Posn(3, 4), Color.red, 10, 90, AbstractShape.ShapeType.Circle);
    Posn p = new Posn(5, 6);

    assertEquals(3, c.getPosn().getX(), 0.0001);
    assertEquals(4, c.getPosn().getY(), 0.0001);

    c.move(p);

    assertEquals(5, c.getPosn().getX(), 0.0001);
    assertEquals(6, c.getPosn().getY(), 0.0001);
  }

  @Test
  public void testMoveUp() {
    IShape c = new Circle(10, new Posn(3, 4), Color.red, 10, 90, AbstractShape.ShapeType.Circle);
    Posn p = new Posn(3, 6);

    assertEquals(3, c.getPosn().getX(), 0.0001);
    assertEquals(4, c.getPosn().getY(), 0.0001);

    c.move(p);

    assertEquals(3, c.getPosn().getX(), 0.0001);
    assertEquals(6, c.getPosn().getY(), 0.0001);
  }

  @Test
  public void testMoveDown() {
    IShape c = new Circle(10, new Posn(3, 4), Color.red, 10, 90, AbstractShape.ShapeType.Circle);
    Posn p = new Posn(3, 2);

    assertEquals(3, c.getPosn().getX(), 0.0001);
    assertEquals(4, c.getPosn().getY(), 0.0001);

    c.move(p);

    assertEquals(3, c.getPosn().getX(), 0.0001);
    assertEquals(2, c.getPosn().getY(), 0.0001);
  }

  @Test
  public void testMoveLeft() {
    IShape c = new Circle(10, new Posn(3, 4), Color.red, 10, 90, AbstractShape.ShapeType.Circle);
    Posn p = new Posn(1, 4);

    assertEquals(3, c.getPosn().getX(), 0.0001);
    assertEquals(4, c.getPosn().getY(), 0.0001);

    c.move(p);

    assertEquals(1, c.getPosn().getX(), 0.0001);
    assertEquals(4, c.getPosn().getY(), 0.0001);
  }

  @Test
  public void testMoveRight() {
    IShape c = new Circle(10, new Posn(3, 4), Color.red, 10, 90, AbstractShape.ShapeType.Circle);
    Posn p = new Posn(3, 6);

    assertEquals(3, c.getPosn().getX(), 0.0001);
    assertEquals(4, c.getPosn().getY(), 0.0001);

    c.move(p);

    assertEquals(3, c.getPosn().getX(), 0.0001);
    assertEquals(6, c.getPosn().getY(), 0.0001);
  }

  @Test
  public void testMoveStay() {
    IShape c = new Circle(10, new Posn(3, 4), Color.red, 10, 90, AbstractShape.ShapeType.Circle);
    Posn p = new Posn(3, 4);

    assertEquals(3, c.getPosn().getX(), 0.0001);
    assertEquals(4, c.getPosn().getY(), 0.0001);

    c.move(p);

    assertEquals(3, c.getPosn().getX(), 0.0001);
    assertEquals(4, c.getPosn().getY(), 0.0001);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveOutOfBouds() {
    IShape c = new Circle(10, new Posn(3, 4), Color.red, 10, 90, AbstractShape.ShapeType.Circle);
    Posn p = new Posn(-5, -6);

    assertEquals(3, c.getPosn().getX(), 0.0001);
  }

  @Test
  public void testGetPosn() {
    Posn p = new Posn(4, 3);
    IShape c = new Circle(10, p, Color.red, 10, 90, AbstractShape.ShapeType.Circle);

    assertEquals(p, c.getPosn());
  }

  @Test
  public void testGetColor() {
    IShape c = new Circle(10, new Posn(3, 3), Color.red, 10, 90, AbstractShape.ShapeType.Circle);

    assertEquals(Color.red, c.getColor());
  }

  @Test
  public void testChangeColor() {
    IShape c = new Circle(10, new Posn(3, 3), Color.red, 10, 90, AbstractShape.ShapeType.Circle);
    assertEquals(Color.red, c.getColor());
    c.changeColor(Color.yellow);
    assertEquals(Color.yellow, c.getColor());

  }

  @Test
  public void testGetVisibility() {
    IShape c = new Circle(10, new Posn(3, 3), Color.red, 10, 90, AbstractShape.ShapeType.Circle);

    assertFalse(c.getVisibility());
  }

  @Test
  public void testSetVisibility() {
    IShape c = new Circle(10, new Posn(3, 3), Color.red, 10, 90, AbstractShape.ShapeType.Circle);

    assertFalse(c.getVisibility());
    c.setVisibility();
    assertTrue(c.getVisibility());
  }

  @Test
  public void testGrowDouble() {
    IShape c = new Circle(10, new Posn(3, 3), Color.red, 10, 90, AbstractShape.ShapeType.Circle);
    assertEquals(10, c.getWidth());
    c.grow(2);
    assertEquals(20, c.getWidth());

  }

  @Test
  public void testGrowNothing() {
    IShape c = new Circle(10, new Posn(3, 3), Color.red, 10, 90, AbstractShape.ShapeType.Circle);
    assertEquals(10, c.getWidth());
    c.grow(1);
    assertEquals(10, c.getWidth());

  }

  @Test
  public void testGrowSmaller() {
    IShape c = new Circle(10, new Posn(3, 3), Color.red, 10, 90, AbstractShape.ShapeType.Circle);
    assertEquals(10, c.getWidth());
    c.grow(0.5);
    assertEquals(5, c.getWidth());

  }
}
