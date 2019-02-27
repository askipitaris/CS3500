package model.action;

import java.awt.Color;
import java.util.Objects;
import posn.Posn;

/**
 * Represents an action that the model will carry out.
 */
public class Action {

  private int startTime;
  private int endTime;
  private Posn toPosn;
  private Posn fromPosn;
  private double growBy;
  private Color newColor;
  private String shape;

  /**
   * Constructs an action that the model will carry out.
   *
   * @param shape is the name of the shape. Used as a key in the shapes hashmap in the abstract.
   * @param startTime is the tick where the action will start.
   * @param endTime is the tick where the action will end.
   * @param toPosn is the posn that the shape will be at when the action is over.
   * @param growBy is the multiple that the shape will grow by.
   * @param newColor is the color that the shape will be at the end of the action.
   */
  public Action(String shape, int startTime, int endTime, Posn toPosn, Posn fromPosn, double growBy,
      Color newColor) {
    if (growBy > 0 && startTime >= 0 && endTime >= 0) {
      this.shape = shape;
      this.startTime = startTime;
      this.endTime = endTime;
      this.toPosn = toPosn;
      this.fromPosn = fromPosn;
      this.growBy = growBy;
      this.newColor = newColor;
    } else {
      throw new IllegalArgumentException("Invalid arguments.");
    }
  }

  /**
   * Gets the time when this action starts.
   *
   * @return the time when this action starts
   */
  public int getStartTime() {
    return startTime;
  }

  /**
   * Gets the time when this action ends.
   *
   * @return the time when this action ends
   */
  public int getEndTime() {
    return endTime;
  }

  /**
   * Gets the location that the shape will move to during this action.
   *
   * @return the location this shape will move to
   */
  public Posn getToPosn() {
    return toPosn;
  }

  /**
   * Gets the location that the shape will move from during this action.
   *
   * @return the location this shape is at before the move.
   */
  public Posn getFromPosn() {
    return fromPosn;
  }

  /**
   * Gets the multiple that this shape will grow by. Cannot be a negative number. If it is below 1
   * the shape will shrink, if it is above 1 it will grow.
   *
   * @return the multiple that this shape will grow by
   */
  public double getGrowBy() {
    return growBy;
  }

  /**
   * Dictates what color this shape will have after the action is complete.
   *
   * @return the color that this shape will have
   */
  public Color getNewColor() {
    return newColor;
  }

  /**
   * Gets the name of the shape in this action.
   *
   * @return return the name of this shape
   */
  public String getShape() {
    return shape;
  }

  /**
   * Overrides .equals so that it checks all fields appropriately.
   *
   * @param a is the action that this will be compared to
   * @return a boolean as to whether this is the same as the given action.
   */
  @Override
  public boolean equals(Object a) {

    if (!(a instanceof Action)) {
      return false;
    }

    return this.shape.equals(((Action) a).getShape())
        && this.startTime == ((Action) a).getStartTime()
        && this.endTime == ((Action) a).getEndTime()
        && this.toPosn.equals(((Action) a).getToPosn())
        && this.fromPosn.equals(((Action) a).getFromPosn())
        && this.growBy == ((Action) a).getGrowBy()
        && this.newColor.getRGB() == ((Action) a).getNewColor().getRGB();
  }

  /**
   * Override hashCode() so that it creates an accurate hascode.
   *
   * @return the new hashCode.
   */
  @Override
  public int hashCode() {
    return Objects.hash(shape, startTime, endTime, toPosn, fromPosn, growBy, newColor);
  }
}
