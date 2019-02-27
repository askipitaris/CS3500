package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.action.Action;
import model.shape.AbstractShape.ShapeType;
import model.shape.Circle;
import model.shape.IShape;
import model.shape.Rectangle;
import posn.Posn;

/**
 * Abstract class for AnimatorModel interface. Any types of Animations extend this class. Has
 * default methods for Animations. Implements {@link AnimatorModel}
 */
abstract class AbstractAnimatorModel implements AnimatorModel {

  int tick;
  // Not being used right now, but think we may use it in the future
  int winHeight;
  int winWidth;
  Color winColor;
  private ArrayList<Action> actions = new ArrayList<>();
  private Map<String, IShape> shapes = new HashMap<>();
  private StringBuilder state = new StringBuilder();

  @Override
  public void runAnimation() {
    for (Action a : actions) {
      this.executeAction(a);
    }
  }

  @Override
  public int numOfShapes() {
    return shapes.size();
  }

  @Override
  public boolean animationOver() {
    return actions.isEmpty();
  }

  private void executeAction(Action a) throws IllegalArgumentException {

    if (shapes.get(a.getShape()) == null) {
      throw new IllegalArgumentException("No such shape: " + a.getShape());
    }

    if (shapes.get(a.getShape()).getColor().getRGB() != a.getNewColor().getRGB()) {
      this.updateColor(a.getNewColor(), shapes.get(a.getShape()));
    }

    this.grow(shapes.get(a.getShape()), a.getGrowBy());

    this.move(shapes.get(a.getShape()), a.getToPosn(), a.getStartTime(), a.getEndTime(),
        a.getToPosn());
  }

  private void updateColor(Color c, IShape s) {
    s.changeColor(c);
  }

  private void grow(IShape s, double g) {
    s.updateHeightAndWidth(g);
  }


  public void move(IShape s, Posn p, int startTick, int endTick, Posn end) {
    double speedX = (end.getX() - s.getPosn().getX()) / (endTick - startTick);
    double speedY = (end.getY() - s.getPosn().getY()) / (endTick - startTick);

    for (int i = startTick; i < endTick; i++) {
      s.move(new Posn(s.getPosn().getX() + speedX, s.getPosn().getY() + speedY));
    }
  }

  public ArrayList<Action> getActions() {
    return this.actions;
  }

  @Override
  public String getState() {
    for (int i = 0; i < actions.size(); i++) {
      this.buildOutput(actions.get(i));
      if (i < actions.size() - 1) {
        this.state.append("\n");
      }
    }
    return state.toString();
  }

  /**
   * Builds the output of the state by checking which attributes of a shape are being changed by the
   * given action. If there is no such shape, it the output is returns no such shape.
   *
   * @param a is the action that determines which attributes of a shape are changed.
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

  @Override
  public void addShape(String name, ShapeType type, int height, int width, Posn posn, Color color,
      int appearTick, int disappearTick) {
    switch (type) {
      case Circle:
        IShape circle = new Circle(width, posn, color, appearTick, disappearTick, type);
        shapes.put(name, circle);
        break;
      case Square:
        IShape square = new Rectangle(height, width, posn, color, appearTick, disappearTick, type);
        shapes.put(name, square);
        break;
      case Rectangle:
        IShape rectangle = new Rectangle(height, width, posn, color, appearTick, disappearTick,
            type);
        shapes.put(name, rectangle);
        break;
      case Ellipse:
        IShape ellipse = new Rectangle(height, width, posn, color, appearTick, disappearTick, type);
        shapes.put(name, ellipse);
        break;
      default:
        throw new IllegalArgumentException("Must enter a valid type for a shape");
    }
  }

  @Override
  public void addAction(String shape, int startTime, int endTime, Posn toPosn, Posn fromPosn,
      double growBy, Color newColor) {
    actions.add(new Action(shape, startTime, endTime, toPosn, fromPosn, growBy, newColor));
  }

  @Override
  public IShape getShape(String name) {
    return shapes.get(name);
  }
}