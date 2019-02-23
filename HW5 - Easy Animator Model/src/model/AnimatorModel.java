package model;

import java.awt.Color;
import posn.Posn;

/**
 * Model for the Animator. One instance of AnimatorModel is one animation. Each animation has a
 * hashmap? of shapes that will be drawn, move and change color as determined by user input.
 */
public interface AnimatorModel {

  /**
   * Moves the shape to the new position.
   *
   * @param shape the shape that will be moved
   * @param p the new position that the shape will move to
   */
  void moveShape(String shape, Posn p);

  /**
   * Changes the color of the shape.
   *
   * @param shape the shape that will change color
   * @param c the new color that the shape will turn to
   */
  void changeColor(String shape, Color c);

  /**
   * The new size that the shape will be.
   *
   * @param shape the shape that will change size
   * @param s the amount that the shape will change by
   */
  void grow(String shape, int s);

  /**
   * Changes the visibility of the shape.
   *
   * @param shape the shape that will change visibility
   */
  void changeVisibility(String shape);

  /**
   * Determines when the animation is over.
   *
   * @return whether or not the animation is over
   */
  boolean animationOver();

  /**
   * Adds a shape with given properties to the hashmap.
   *
   * @param name name of the shape
   * @param type type of the shape
   * @param height height of the shape
   * @param width width of the shape
   * @param posn position of the shape
   * @param color color of the shape
   * @param appearTick time that shape appears in animation
   * @param disappearTick time that shape disappears in animation
   * @param visible determines if the shape is visible on the screen
   * @throws IllegalArgumentException if the user doesn't provide a valid shape type
   */
  void add(String name, String type, int height, int width, Posn posn, Color color,
      int appearTick, int disappearTick, boolean visible);

}
