import static org.junit.Assert.assertEquals;

import org.junit.Test;
import posn.Posn;

/**
 * Tests for the posn class.
 */
public class TestPosn {

  @Test
  public void testBuildPosn() {
    Posn p = new Posn(3, 5);
    Posn p1 = new Posn(0, 0);

    assertEquals(3, p.getX(), 0.0001);
    assertEquals(5, p.getY(), 0.0001);

    assertEquals(0, p1.getX(), 0.0001);
    assertEquals(0, p1.getY(), 0.0001);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPosn() {
    Posn p = new Posn(-1, 5);
  }

  @Test
  public void testGetPos() {
    Posn p = new Posn(10, 11);

    assertEquals(10, p.getX(), 0.0001);
    assertEquals(11, p.getY(), 0.0001);
  }

  @Test
  public void testUpdatePosn() {
    Posn p = new Posn(3, 5);

    p.updatePos(new Posn(5, 6));

    assertEquals(5, p.getX(), 0.0001);
    assertEquals(6, p.getY(), 0.0001);
  }

}
