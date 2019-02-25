package model.shape;

import java.awt.Color;
import posn.Posn;

/**
 * Represents one instance of a circle. A circle is a special ellipse where the foci are the same
 * point and the minor axis the same size as the major axis.
 *
 * <p>Extends {@link Ellipse} and inherits fields and methods.
 */
public class Circle extends Ellipse {

  /**
   * This constructor differs from {@link Ellipse} constructor in that height and width are both
   * equal to the diameter parameter.
   *
   * @param diameter is the diamter of the circle.
   * @param posn is the center of the circle.
   * @param color is the color of the circle.
   * @param appearTick is the tick when the circle will appear.
   * @param disappearTick is the tick when the circle will disappear.
   */
  public Circle(int diameter, Posn posn, Color color, int appearTick, int disappearTick) {
    super(diameter, diameter, posn, color, appearTick, disappearTick);
  }
}
