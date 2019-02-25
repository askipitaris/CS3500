package model.shape;

import java.awt.Color;
import posn.Posn;

/**
 * Represents one instance of an Ellipse.
 *
 * <p>Extends {@link AbstractShape} and inherits fields and methods.
 */
public class Ellipse extends AbstractShape {

  /**
   * Extends the default constructor in {@link AbstractShape}.
   *
   * @param height is the height of the ellipse in pixels.
   * @param width is the width of the ellipse in pixels.
   * @param posn is the point where the major and minor axises intersect.
   * @param color is the color of the ellipse.
   * @param appearTick is the tick when the ellipse will appear.
   * @param disappearTick is the tick when the ellipse will disappear.
   */
  public Ellipse(int height, int width, Posn posn, Color color, int appearTick, int disappearTick) {
    super(height, width, posn, color, appearTick, disappearTick);
  }
}
