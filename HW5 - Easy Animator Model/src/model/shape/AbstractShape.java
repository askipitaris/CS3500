package model.shape;

import java.awt.Color;
import java.util.Objects;
import posn.Posn;

/**
 * Abstract class for shapes. Implements {@link IShape} and is extended by all types of shapes.
 * Contains common methods for all shapes.
 */
public abstract class AbstractShape implements IShape {

  protected Posn posn;
  protected Color color;
  private int height;
  private int width;
  private int appearTick;
  private int disappearTick;
  private boolean visible;
  private ShapeType type;

  /**
   * Abstract constructor.
   *
   * @param height is the height in pixels of the shape.
   * @param width is the width in pixels of the shape.
   * @param posn is the positon in cartesian coordinates of the shape.
   * @param color is the color of the shape.
   * @param appearTick is the tick this shape is meant to become visible.
   * @param disappearTick is the tick the shape is meant to become not visible.
   * @param type the type of the shape
   */
  AbstractShape(int height, int width, Posn posn, Color color, int appearTick, int disappearTick,
      ShapeType type) {
    this.height = height;
    this.width = width;
    this.posn = posn;
    this.color = color;
    this.appearTick = appearTick;
    this.disappearTick = disappearTick;
    this.visible = false;
    this.type = type;
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
  public void grow(double s) {
    double dH = this.height * s;
    double dW = this.width * s;
    this.height = (int) dH;
    this.width = (int) dW;
  }

  @Override
  public Posn getPosn() {
    return this.posn;
  }

  @Override
  public Color getColor() {
    return this.color;
  }

  @Override
  public boolean getVisibility() {
    return this.visible;
  }

  @Override
  public void setVisibility() {
    this.visible = !this.visible;
  }

  @Override
  public int getHeight() {
    return this.height;
  }

  @Override
  public int getWidth() {
    return this.width;
  }

  @Override
  public ShapeType getType() {
    return this.type;
  }

  @Override
  public void updateHeightAndWidth(double g) {
    double nH = this.height * g;
    double nW = this.width * g;

    this.height = (int) nH;
    this.width = (int) nW;
  }

  @Override
  public int getAppearTick() {
    return this.appearTick;
  }

  @Override
  public int getDisappearTick() {
    return this.disappearTick;
  }

  /**
   * Override .equals to ensure that shapes are being correctly compared.
   *
   * @param s is the shape that this will be compared to.
   * @return a boolean which says if this is the same as the given shape.
   */
  @Override
  public boolean equals(Object s) {

    if (!(s instanceof IShape)) {
      return false;
    }

    return this.getPosn().equals(((IShape) s).getPosn())
        && this.getColor().equals(((IShape) s).getColor())
        && this.getHeight() == ((IShape) s).getHeight()
        && this.getWidth() == ((IShape) s).getWidth()
        && this.getAppearTick() == ((IShape) s).getAppearTick()
        && this.getDisappearTick() == ((IShape) s).getDisappearTick()
        && this.getVisibility() == ((IShape) s).getVisibility()
        && this.getType().equals(((IShape) s).getType());
  }

  /**
   * Override hashCode to ensure that things are being hashed correctly.
   *
   * @return the new hashCode
   */
  @Override
  public int hashCode() {
    return Objects.hash(posn, color, height, width, appearTick, disappearTick, visible, type);
  }

  /**
   * This enum represents all possible shapes. Used when methods need to know what type of shape
   * they are working with.
   */
  public enum ShapeType {
    Circle, Ellipse, Square, Rectangle
  }
}
