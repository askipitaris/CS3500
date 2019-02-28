import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.awt.Color;
import model.action.Action;
import org.junit.Test;
import posn.Posn;

/**
 * Tests methods relating to the Action class. Most methods are retrieving fields.
 */
public class ActionTest {

  private Action a = new Action("circle", 1, 10, new Posn(0, 5), new Posn(0, 5), 1, true, true,
      Color.blue);

  @Test
  public void getStartTime() {
    assertEquals(1, a.getStartTime());
  }

  @Test
  public void getEndTime() {
    assertEquals(10, a.getEndTime());

  }

  @Test
  public void getToPosn() {
    assertEquals(0, a.getToPosn().getX(), 0.0001);
    assertEquals(5, a.getToPosn().getY(), 0.0001);
  }

  @Test
  public void getGrowBy() {
    assertEquals(1, a.getGrowBy(), 0.0001);
  }

  @Test
  public void getNewColor() {
    assertEquals(Color.blue, a.getNewColor());
  }

  @Test
  public void getShape() {
    assertEquals("circle", a.getShape());
  }

  @Test
  public void testEquality() {
    Action a1 = new Action("circle", 1, 10, new Posn(0, 5), new Posn(0, 5), 1, true, true,
        Color.blue);
    Action a2 = new Action("circle", 1, 10, new Posn(0, 5), new Posn(0, 5), 1, true, true,
        Color.blue);
    Action a3 = new Action("circle", 2, 10, new Posn(0, 5), new Posn(0, 5), 1, true, true,
        Color.blue);

    assertEquals(a1, a2);
    assertNotEquals(a1, a3);
  }

  @Test
  public void testHashCode() {
    Action a1 = new Action("circle", 1, 10, new Posn(0, 5), new Posn(0, 5), 1, true, true,
        Color.blue);
    Action a2 = new Action("circle", 1, 10, new Posn(0, 5), new Posn(0, 5), 1, true, true,
        Color.blue);
    Action a3 = new Action("circle", 2, 10, new Posn(0, 5), new Posn(0, 5), 1, true, true,
        Color.blue);

    assertEquals(a1.hashCode(), a2.hashCode());
    assertNotEquals(a1.hashCode(), a3.hashCode());
  }

  @Test
  public void testGetWidth() {
    Action a1 = new Action("circle", 1, 10, new Posn(0, 5), new Posn(0, 5), 1, true, true,
        Color.blue);
    assertTrue(a1.getWidth());
  }

  @Test
  public void testGetHeight() {
    Action a1 = new Action("circle", 1, 10, new Posn(0, 5), new Posn(0, 5), 1, true, true,
        Color.blue);
    assertTrue(a1.getHeight());
  }

}