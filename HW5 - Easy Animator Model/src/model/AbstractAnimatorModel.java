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
  private Map<String, IShape> shapes = new HashMap<String, IShape>();
  private ArrayList<Action> actions = new ArrayList<Action>();
  private StringBuilder state = new StringBuilder();

  @Override
  public void add(String name, String type, int height, int width, Posn posn, Color color,
      int appearTick, int disappearTick) {
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
      state.append("From time ").append(a.getStartTime()).append(" to ").append(a.getEndTime())
          .append(", ").append(a.getShape());

      this.appendMovement(a);
      this.appendSize(a);
      this.appendColor(a);

    } else {
      state.append("No such shape: ").append(a.getShape()).append("\n");
    }
  }

  private void appendMovement(Action a) {
    if (shapes.get(a.getShape()).getPosn().getX() != a.getToPosn().getX()
        || shapes.get(a.getShape()).getPosn().getY() != a.getToPosn().getY()) {
      state.append(" moves from (").append(shapes.get(a.getShape()).getPosn().getX())
          .append(",").append(shapes.get(a.getShape()).getPosn().getY()).append(") to (")
          .append(a.getToPosn().getX()).append(",").append(a.getToPosn().getY()).append("), ");
    } else {
      state.append("stays put at ").append("(")
          .append(shapes.get(a.getShape()).getPosn().getX())
          .append(",").append(shapes.get(a.getShape()).getPosn().getY()).append("), ");
    }
  }

  private void appendSize(Action a) {
    if (a.getGrowBy() == 1) {
      state.append("stays size ").append(shapes.get(a.getShape()).getWidth()).append("x")
          .append(shapes.get(a.getShape()).getHeight());
    } else if (a.getGrowBy() > 1 && a.getGrowBy() > 0) {
      state.append("shrinks to ").append(shapes.get(a.getShape()).getWidth() * a.getGrowBy())
          .append("x").append(shapes.get(a.getShape()).getHeight() * a.getGrowBy());
    } else {
      state.append("grows to ").append(shapes.get(a.getShape()).getWidth() * a.getGrowBy())
          .append("x").append(shapes.get(a.getShape()).getHeight() * a.getGrowBy());
    }
  }

  private void appendColor(Action a) {
    if (shapes.get(a.getShape()).getColor().equals(a.getNewColor())) {
      state.append(" and stays ").append(a.getNewColor().toString()).append(".");
    } else {
      state.append(" and changes to ").append(a.getNewColor().toString()).append(".\n");
    }
  }
}