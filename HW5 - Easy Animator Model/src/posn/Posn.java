package posn;

/**
 * Represents a cartesian coordinate.
 */
public class Posn {

  private int x;
  private int y;

  /**
   * Constructs the Posn object and sets the x position to this.x and the y position to this.y.
   *
   * @param x the x position of the cartesian point
   * @param y the y position of the cartesian point
   */
  Posn(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Allows other classes to view the x position.
   *
   * @return the x position of this Posn
   */
  private int getX() {
    return this.x;
  }

  /**
   * Allows other classes to view the y position.
   *
   * @return the y position of this Posn
   */
  private int getY() {
    return this.y;
  }

  /**
   * Update this position.
   *
   * @param p is the new position.
   */
  public void updatePos(Posn p) {
    this.x = p.getX();
    this.y = p.getY();
  }
}