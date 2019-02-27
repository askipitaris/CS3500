package model;

import java.awt.Color;
import java.util.ArrayList;
import model.action.Action;
import model.shape.AbstractShape.ShapeType;
import model.shape.IShape;
import posn.Posn;

/**
 * Model for the Animator. One instance of AnimatorModel is one animation. Each animation has a
 * hashmap? of shapes that will be drawn, move and change color as determined by user input.
 */
public interface AnimatorModel {

  /**
   * Gets the state of the model and outputs each queued action as a sentence. If the shape
   * specified in the action does not exist, it gets skipped. If it does exist, it outputs the time
   * frame where the action will take place, then whether the position, size and color change.
   */
  String getState();

  /**
   * Gets a specific value from the hashmap of shapes. Mainly used when testing to make sure that
   * actions are executed properly.
   *
   * @param name is the name of the shape
   * @return the shape
   */
  IShape getShape(String name);

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
   * @throws IllegalArgumentException if the user doesn't provide a valid shape type
   */
  void addShape(String name, ShapeType type, int height, int width, Posn posn, Color color,
      int appearTick, int disappearTick);

  /**
   * Adds a new action to the ArrayList of actions.
   * @param shape is the name of the shape that will be added.
   * @param startTime is the tick when this action starts.
   * @param endTime is the tick when this action ends.
   * @param toPosn is the position this shape will move to.
   * @param fromPosn is the position this shape will move from.
   * @param growBy is the multiple that this shape will grow by.
   * @param newColor is the new color of the shape.
   */
  void addAction(String shape, int startTime, int endTime, Posn toPosn, Posn fromPosn,
      double growBy, Color newColor);

  /**
   * Runs all the actions in the array of actions. Essentially runs the full animation.
   */
  void runAnimation();

  /**
   * Get the size of the hashmap of shapes.
   *
   * @return the size of the hashmap as an int
   */
  int numOfShapes();

  /**
   * Returns the ArrayList of actions that have ready to execute.
   */
  ArrayList<Action> getActions();

  /**
   * Determines when the animation is over.
   *
   * @return whether or not the animation is over
   */
  boolean animationOver();

  /**
   * Moves the shape. The shape does not move all at once but executes the movement between the
   * startTick and endTick. DeltaX and DeltaY are determined by the difference between the start
   * and end divided by the number of tick the movement will occur over.
   * @param s is the shape that will move.
   * @param p is the starting posn of the shape
   * @param startTick is the tick where the movement will start
   * @param endTick is the tick where the movement will end
   * @param end is the ending posn of the shape.
   */
  void move(IShape s, Posn p, int startTick, int endTick, Posn end);
}

