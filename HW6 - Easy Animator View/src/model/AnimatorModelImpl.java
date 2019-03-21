package model;

import cs3500.animator.util.AnimationBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * An implementation of the AnimatorModel interface. Creates a model that retrives and enforces the
 * state of the game.
 */
public final class AnimatorModelImpl implements AnimatorModel {

  private int winHeight;
  private int winWidth;
  private int leftX;
  private int topY;
  private Map<String, String> shapes;
  private ArrayList<Keyframe> keyFrames;

  private AnimatorModelImpl(Builder b) {
    this.shapes = b.shapes;
    this.keyFrames = b.keyFrames;
    this.winHeight = b.winHeight;
    this.winWidth = b.winWidth;
    this.leftX = b.leftX;
    this.topY = b.topY;
  }

  @Override
  public String getState() {
    StringBuilder sb = new StringBuilder();

    sb.append("canvas ").append(this.leftX).append(" ").append(this.topY).append(" ")
        .append(this.winWidth).append(" ").append(this.winHeight).append("\n");

    for (String s : shapes.keySet()) {
      sb.append("shape ").append(s).append(" ").append(shapes.get(s)).append("\n");

      for (Keyframe k : keyFrames) {
        if (k.getName().equals(s)) {
          sb.append("motion ").append(s).append(" ").append(k.getT1()).append(" ").append(k.getX1())
              .append(" ").append(k.getY1()).append(" ").append(k.getW1()).append(" ")
              .append(k.getH1()).append(" ").append(k.getR1()).append(" ").append(k.getG1())
              .append(" ").append(k.getB1());

          sb.append("  ").append(s).append(" ").append(k.getT2()).append(" ").append(k.getX2())
              .append(" ").append(k.getY2()).append(" ").append(k.getW2()).append(" ")
              .append(k.getH2()).append(" ").append(k.getR2()).append(" ").append(k.getG2())
              .append(" ").append(k.getB2()).append("\n");
        }
      }

    }

    return sb.toString();
  }

  @Override
  public int getWidth() {
    return this.winWidth;
  }

  @Override
  public int getHeight() {
    return this.winHeight;
  }

  public int getLeftX() {
    return this.leftX;
  }

  public int getTopY() {
    return this.topY;
  }

  @Override
  public String getShape(String s) {
    return shapes.get(s);
  }

  @Override
  public ArrayList<Keyframe> getKeyframes() {
    return this.keyFrames;
  }

  @Override
  public Map<String, String> getAllShapes() {
    return this.shapes;
  }

  @Override
  public int numOfShapes() {
    return this.shapes.size();
  }

  /**
   * Represents the builder. Builds a new Model based off of the parameters given to it.
   */
  public static final class Builder implements AnimationBuilder<AnimatorModel> {

    Map<String, String> shapes = new HashMap<>();
    int leftX;
    int topY;
    int winHeight;
    int winWidth;
    private ArrayList<Keyframe> keyFrames = new ArrayList<>();

    @Override
    public AnimatorModel build() {
      return new AnimatorModelImpl(this);
    }

    @Override
    public AnimationBuilder<AnimatorModel> setBounds(int x, int y, int width, int height) {
      this.leftX = x;
      this.topY = y;
      this.winHeight = height;
      this.winWidth = width;
      return this;
    }

    @Override
    public AnimationBuilder<AnimatorModel> declareShape(String name, String type) {
      shapes.put(name, type);
      return this;
    }

    @Override
    public AnimationBuilder<AnimatorModel> addMotion(String name, int t1, int x1, int y1, int w1,
        int h1, int r1, int g1, int b1, int t2, int x2, int y2, int w2, int h2, int r2, int g2,
        int b2) {

      for (Keyframe k : keyFrames) {
        if (k.getName().equals(name) && k.getT1() >= t1 && t2 <= k.getT2()) {
          throw new IllegalArgumentException("Cannot have inconsistent motions");
        }
      }

      this.keyFrames.add(new Keyframe(name, t1, x1, y1, w1, h1, r1, g1, b1, t2, x2, y2, w2, h2, r2,
          g2, b2));
      return this;

    }

    @Override
    public AnimationBuilder<AnimatorModel> addKeyframe(String name, int t, int x, int y, int w,
        int h, int r, int g, int b) {
      this.keyFrames.add(new Keyframe(name, t, x, y, w, h, r, g, b));
      return this;
    }
  }
}