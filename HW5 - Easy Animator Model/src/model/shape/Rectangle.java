package model.shape;

import java.awt.Color;
import posn.Posn;

/**
 * Represents one instance of a rectangle.
 *
 * <p>Extends {@link AbstractShape} and inherits fields and methods.
 */
public class Rectangle extends AbstractShape {

  /**
   * Extends the default constructor in {@link AbstractShape}.
   *
   * @param height is the height of the rectangle in pixels.
   * @param width is the width of the rectangle in pixels.
   * @param posn is the point where the major and minor axises intersect.
   * @param color is the color of the rectangle.
   * @param appearTick is the tick when the rectangle will appear.
   * @param disappearTick is the tick when the rectangle will disappear.
   */
  public Rectangle(int height, int width, Posn posn, Color color, int appearTick,
      int disappearTick, ShapeType type) {
    super(height, width, posn, color, appearTick, disappearTick, type);
  }

}