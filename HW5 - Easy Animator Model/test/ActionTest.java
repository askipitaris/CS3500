import static org.junit.Assert.assertEquals;

import java.awt.Color;
import model.action.Action;
import org.junit.Test;
import posn.Posn;

/**
 * Tests methods relating to the Action class. Most methods are retrieving fields.
 */
public class ActionTest {

  private Action a = new Action("circle", 1, 10, new Posn(0, 5), new Posn(0, 5), 1, Color.blue);

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
    assertEquals(0, a.getToPosn().getX());
    assertEquals(5, a.getToPosn().getY());
  }

  @Test
  public void getGrowBy() {
    assertEquals(1, a.getGrowBy());
  }

  @Test
  public void getNewColor() {
    assertEquals(Color.blue, a.getNewColor());
  }

  @Test
  public void getShape() {
    assertEquals("circle", a.getShape());
  }
}