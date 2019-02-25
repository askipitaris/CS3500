package model;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import model.shape.Circle;
import model.shape.IShape;
import model.shape.Rectangle;
import posn.Posn;

/**
 * Abstract class for AnimatorModel interface. Any types of Animations extend this class. Has
 * default methods for Animations. Implements {@link AnimatorModel}
 */
abstract class AbstractAnimatorModel implements AnimatorModel {

  protected int winWidth;
  protected int winHeight;
  protected Color winColor;
  protected Map<String, IShape> shapes = new HashMap<String, IShape>();

  protected int tick = 0;

  @Override
  public void add(String name, String type, int height, int width, Posn posn, Color color,
      int appearTick, int disappearTick, boolean visible) {
    switch (type) {
      case "circle":
        IShape circle = new Circle(width, posn, color, appearTick, disappearTick);
        shapes.put(name, circle);
        break;
      case "square":
        IShape square = new Rectangle(height, width, posn, color, appearTick, disappearTick);
        shapes.put(name, square);
        break;
      case "rectangle":
        IShape rectangle = new Rectangle(height, width, posn, color, appearTick, disappearTick);
        shapes.put(name, rectangle);
        break;
      case "ellipse":
        IShape ellipse = new Rectangle(height, width, posn, color, appearTick, disappearTick);
        shapes.put(name, ellipse);
        break;
      default:
        throw new IllegalArgumentException("Must enter a valid type for a shape");
    }
  }

  @Override
  public void moveShape(String shape, Posn p) {
    shapes.get(shape).move(p);
  }

  @Override
  public void changeColor(String shape, Color c) {
    shapes.get(shape).changeColor(c);
  }

  @Override
  public void grow(String shape, int s) {
    shapes.get(shape).grow(s);
  }

  @Override
  public void changeVisibility(String shape) {
    shapes.get(shape).setVisibility();
  }

  @Override
  public boolean animationOver() {
    for (IShape s : this.shapes.values()) {
      if (s.getVisibility()) {
        return true;
      }
    }
    return false;
  }
}
