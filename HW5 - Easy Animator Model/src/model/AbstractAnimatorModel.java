package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.action.Action;
import model.shape.Circle;
import model.shape.IShape;
import model.shape.Rectangle;
import posn.Posn;

/**
 * Abstract class for AnimatorModel interface. Any types of Animations extend this class. Has
 * default methods for Animations. Implements {@link AnimatorModel}
 */
abstract class AbstractAnimatorModel implements AnimatorModel {

  protected int tick = 0;
  int winWidth;
  int winHeight;
  Color winColor;
  private Map<String, IShape> shapes = new HashMap<>();
  private ArrayList<Action> actions = new ArrayList<>();
  private StringBuilder state = new StringBuilder();

  @Override
  public void add(String name, String type, int height, int width, Posn posn, Color color,
      int appearTick, int disappearTick) {
    switch (type) {
      case "circle":
        IShape circle = new Circle(width, posn, color, appearTick, disappearTick, type);
        shapes.put(name, circle);
        break;
      case "square":
        IShape square = new Rectangle(height, width, posn, color, appearTick, disappearTick, type);
        shapes.put(name, square);
        break;
      case "rectangle":
        IShape rectangle = new Rectangle(height, width, posn, color, appearTick, disappearTick,
            type);
        shapes.put(name, rectangle);
        break;
      case "ellipse":
        IShape ellipse = new Rectangle(height, width, posn, color, appearTick, disappearTick, type);
        shapes.put(name, ellipse);
        break;
      default:
        throw new IllegalArgumentException("Must enter a valid type for a shape");
    }
  }

  @Override
  public int numOfShapes() {
    return this.shapes.size();
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
  public void grow(String shape, double s) {
    shapes.get(shape).grow(s);
  }

  @Override
  public void changeVisibility(String shape) {
    shapes.get(shape).setVisibility();
  }

  @Override
  public boolean animationOver() {
    return this.actions.size() <= 0;
  }

  @Override
  public void addActions(Action a) {
    actions.add(a);
  }

  @Override
  public IShape getShape(String name) {
    return shapes.get(name);
  }

  @Override
  public ArrayList<Action> getActions() {
    return actions;
  }

  @Override
  public String getState() {
    for (Action a : actions) {
      this.buildOutput(a);
    }
    return state.toString();
  }

  /**
   * Builds the output of the state by checking which attributes of a shape are being changed by the
   * given action. If there is no such shape, it the output is returns no such shape.
   *
   * @param a is the action that determines which attributes of a shape are changed.
   * @return the output of the given action.
   */
  private void buildOutput(Action a) {
    if (shapes.get(a.getShape()) != null) {
      state.append("shape ").append(a.getShape()).append(" ")
          .append(shapes.get(a.getShape()).getType()).append("\n");

      state.append("motion ").append(a.getShape()).append(" ").append(a.getStartTime()).append(" ")
          .append(a.getFromPosn().getX()).append(" ").append(a
          .getFromPosn().getY()).append(" ").append(shapes.get(a.getShape()).getWidth()).append(" ")
          .append(shapes
              .get(a.getShape()).getHeight()).append(" ")
          .append(shapes.get(a.getShape()).getColor().getRed()).append(" ")
          .append(shapes.get(a.getShape()).getColor().getGreen()).append(" ").append(shapes
          .get(a.getShape()).getColor().getBlue());

      state.append("    ");

      state.append(a.getEndTime()).append(" ").append(a.getToPosn().getX()).append(" ").append(a
          .getToPosn().getY()).append(" ").append(shapes.get(a.getShape()).getWidth()).append(" ")
          .append(shapes
              .get(a.getShape()).getHeight()).append(" ")
          .append(shapes.get(a.getShape()).getColor().getRed()).append(" ")
          .append(shapes.get(a.getShape()).getColor().getGreen()).append(" ")
          .append(shapes.get(a.getShape())
              .getColor().getBlue());
    } else {
      state.append("No such shape: ").append(a.getShape()).append("\n");
    }
  }
}