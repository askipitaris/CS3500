package posn;

import java.util.Objects;

/**
 * Represents a cartesian coordinate.
 */
public class Posn {

  private double x;
  private double y;

  /**
   * Constructs the Posn object and sets the x position to this.x and the y position to this.y.
   *
   * @param x the x position of the cartesian point
   * @param y the y position of the cartesian point
   * @throws IllegalArgumentException if the x or y value is not greater or equal 0
   */
  public Posn(double x, double y) {
    if (x >= 0 && y >= 0) {
      this.x = x;
      this.y = y;
    } else {
      throw new IllegalArgumentException("Invalid pos");
    }

  }

  /**
   * Allows other classes to view the x position.
   *
   * @return the x position of this Posn
   */
  public double getX() {
    return this.x;
  }

  /**
   * Allows other classes to view the y position.
   *
   * @return the y position of this Posn
   */
  public double getY() {
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

  /**
   * Overrides .equals so that it compares posns correctly.
   *
   * @param p is the posn that this will be compared to.
   * @return a boolean as to whether this is hte same as the given posn.
   */
  @Override
  public boolean equals(Object p) {

    if (!(p instanceof Posn)) {
      return false;
    }

    return this.getX() == ((Posn) p).getX()
        && this.getY() == ((Posn) p).getY();
  }

  /**
   * Override hashCode to ensure that things are being hashed correctly.
   *
   * @return the new hashCode
   */
  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }
}
