package model.shape;

import java.awt.Color;
import posn.Posn;

/**
 * This interface represents the possible operations on a shape. One object of this interface
 * represents one shape.
 */
public interface IShape {

  /**
   * Moves a shape to a new location represented by cartesian coordinates.
   *
   * @param newLoc is the new location in cartesian coordinates that this shape will move to.
   */
  void move(Posn newLoc);

  /**
   * Changes the color of this shape. Color can be one of the built in values or a custom color.
   *
   * @param newColor is the new color of this shape.
   */
  void changeColor(Color newColor);

  /**
   * Grows this shape. This shape will grow by the given value. Negative values cause it to shrink.
   *
   * @param by is the amount by which this shape will grow.
   */
  void grow(int by);
}