package model;

import cs3500.animator.util.AnimationBuilder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
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
  private ArrayList<String> shapes2;
  private ArrayList<Keyframe> keyFrames;

  private AnimatorModelImpl(Builder b) {
    this.shapes = b.shapes;
    this.shapes2 = b.shapes2;
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

  /**
   * Constructs a Keyframe that has motion.
   *
   * @param tick is the tick that this will occur at
   * @return the new interpolated keyframe
   */
  public ArrayList<Keyframe> interpolate(double tick) {
    double newX;
    double newY;
    double newWidth;
    double newHeight;
    double newR;
    double newG;
    double newB;

    ArrayList<Keyframe> interpKF = new ArrayList<>();

    for (Keyframe k : this.keyFrames) {
      if (k.getT2() - k.getT1() == 0) {
        interpKF.add(k);
      } else if (tick >= k.getT1() && tick <= k.getT2()) {
        newX = (k.getX1() * ((k.getT2() - tick) / (k.getT2() - k.getT1())))
            + (k.getX2() * ((tick - k.getT1()) / (k.getT2() - k.getT1())));
        newY = (k.getY1() * ((k.getT2() - tick) / (k.getT2() - k.getT1())))
            + (k.getY2() * (
            (tick - k.getT1()) / (k.getT2() - k.getT1())));
        newWidth = (k.getW1() * ((k.getT2() - tick) / (k.getT2() - k.getT1())))
            + (k.getW2() * (
            (tick - k.getT1()) / (k.getT2() - k.getT1())));
        newHeight = (k.getH1() * ((k.getT2() - tick) / (k.getT2() - k.getT1()))) + ((k.getH2() * (
            (tick - k.getT1()) / (k.getT2() - k.getT1()))));
        newR = (k.getR1() * ((k.getT2() - tick) / (k.getT2() - k.getT1())))
            + (k.getR2() * ((tick - k.getT1()) / (k.getT2() - k.getT1())));
        newG = (k.getG1() * ((k.getT2() - tick) / (k.getT2() - k.getT1())))
            + (k.getG2() * ((tick - k.getT1()) / (k.getT2() - k.getT1())));
        newB = (k.getB1() * ((k.getT2() - tick) / (k.getT2() - k.getT1())))
            + (k.getB2() * ((tick - k.getT1()) / (k.getT2() - k.getT1())));

        interpKF.add(
            new Keyframe(k.getName(), tick, newX, newY, newWidth, newHeight, newR, newG,
                newB,
                tick, newX, newY, newWidth, newHeight, newR, newG, newB));
      }
    }
    return interpKF;

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


  @Override
  public double getLargestTick() {
    double max = 0;
    for (Keyframe k : keyFrames) {
      if (k.getT2() > max) {
        max = k.getT2();
      }
    }
    return max;

  }

  /**
   * Represents the builder. Builds a new Model based off of the parameters given to it.
   */
  public static final class Builder implements AnimationBuilder<AnimatorModel> {

    Map<String, String> shapes = new LinkedHashMap<>();
    int leftX;
    int topY;
    int winHeight;
    int winWidth;
    private ArrayList<Keyframe> keyFrames = new ArrayList<>();
    private ArrayList<String> shapes2 = new ArrayList<>();

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

      for (String s : shapes.keySet()) {
        if (name.equals(s)) {
          throw new IllegalArgumentException("Cannot have two shapes with the same name");
        }


      }

      shapes2.add(name);
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