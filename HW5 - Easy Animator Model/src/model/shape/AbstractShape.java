package model.shape;

import java.awt.Color;
import posn.Posn;

/**
 * Abstract class for shapes. Implements {@link IShape} and is extended by all types of shapes.
 * Contains common methods for all shapes.
 */
public abstract class AbstractShape implements IShape {

  protected int height;
  protected int width;
  protected Posn posn;
  protected Color color;
  protected int appearTick;
  protected int disappearTick;
  protected boolean visible;

  /**
   * Abstract constructor.
   *
   * @param height is the height in pixels of the shape.
   * @param width is the width in pixels of the shape.
   * @param posn is the positon in cartesian coordinates of the shape.
   * @param color is the color of the shape.
   * @param appearTick is the tick this shape is meant to become visible.
   * @param disappearTick is the tick the shape is meant to become not visible.
   * @param visible is the visibility of the shape.
   */
  AbstractShape(int height, int width, Posn posn, Color color, int appearTick, int disappearTick,
      boolean visible) {
    this.height = height;
    this.width = width;
    this.posn = posn;
    this.color = color;
    this.appearTick = appearTick;
    this.disappearTick = disappearTick;
    this.visible = visible;
  }

  @Override
  public void move(Posn p) {
    this.posn.updatePos(p);
  }

  @Override
  public void changeColor(Color c) {
    this.color = new Color(c.getRGB());
  }

  @Override
  public void grow(int s) {
    this.height += (s / 2);
    this.width += (s / 2);
  }

  @Override
  public boolean getVisibility() {
    return this.visible;
  }

  @Override
  public void setVisibility() {
    this.visible = !this.visible;
  }
}
