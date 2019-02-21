package model.shape;

import java.awt.Color;
import posn.Posn;

/**
 * Represents one instance of a square. A square is a special rectangle where all side lengths are
 * the same.
 *
 * <p>Extends {@link Rectangle} and inherits fields and methods.
 */
public class Square extends Rectangle {

  /**
   * This constructor differs from {@link Rectangle} constructor in that height and width are both
   * equal to the sideLength parameter.
   *
   * @param sideLength is the side length in pixels.
   * @param posn is the position of the square's top left corner.
   * @param color is the color of the square.
   * @param appearTick is the tick when the square will appear.
   * @param disappearTick is the tick when the square will disappear.
   * @param visible is the visibility of the square.
   */
  public Square(int sideLength, Posn posn, Color color, int appearTick,
      int disappearTick, boolean visible) {
    super(sideLength, sideLength, posn, color, appearTick, disappearTick, visible);
  }


}