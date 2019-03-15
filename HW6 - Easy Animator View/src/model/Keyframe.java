package model;

/**
 * Defines a Keyframe. Keyframes are either just unmoving frames or a movement.
 */
public class Keyframe {

  private String name;
  private int t1, x1, y1, w1, h1, r1, g1, b1, t2, x2, y2, w2, h2, r2, g2, b2;

  Keyframe(String name, int t1, int x1, int y1, int w1, int h1, int r1, int g1, int b1,
      int t2,
      int x2, int y2, int w2, int h2, int r2, int g2, int b2) {
    this.name = name;
    this.t1 = t1;
    this.x1 = x1;
    this.y1 = y1;
    this.w1 = w1;
    this.h1 = h1;
    this.r1 = r1;
    this.g1 = g1;
    this.b1 = b1;
    this.t2 = t2;
    this.x2 = x2;
    this.y2 = y2;
    this.w2 = w2;
    this.h2 = h2;
    this.r2 = r2;
    this.g2 = g2;
    this.b2 = b2;
  }

  Keyframe(String name, int t1, int x1, int y1, int w1, int h1, int r1, int g1, int b1) {
    this.name = name;
    this.t1 = t1;
    this.x1 = x1;
    this.y1 = y1;
    this.w1 = w1;
    this.h1 = h1;
    this.r1 = r1;
    this.g1 = g1;
    this.b1 = b1;
    this.t2 = t1;
    this.x2 = x1;
    this.y2 = y1;
    this.w2 = w1;
    this.h2 = h1;
    this.r2 = r1;
    this.g2 = g1;
    this.b2 = b1;
  }

  /**
   * Returns the name of the shape of this keyframe.
   * @return the name.
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the start time of this Keyframe.
   * @return the t1.
   */
  public int getT1() {
    return t1;
  }

  /**
   * Gets the starting x position of this keyframe.
   * @return the x1.
   */
  public int getX1() {
    return x1;
  }

  /**
   * Gets the starting y position of this keyframe.
   * @return the y1.
   */
  public int getY1() {
    return y1;
  }

  /**
   * Gets the starting width of the shape in this keyframe.
   * @return the w1.
   */
  public int getW1() {
    return w1;
  }

  /**
   * Gets the starting height of the shape in this keyframe.
   * @return h1.
   */
  public int getH1() {
    return h1;
  }

  /**
   * Gets the starting r value of the shape in this keyframe.
   * @return the r1.
   */
  public int getR1() {
    return r1;
  }

  /**
   * Gets the starting g value of the shape in this keyframe.
   * @return the g1.
   */
  public int getG1() {
    return g1;
  }

  /**
   * Gets the starting b value of the shape in this keyframe.
   * @return the b1.
   */
  public int getB1() {
    return b1;
  }

  /**
   * Gets the start time of this Keyframe.
   * @return the t2.
   */
  public int getT2() {
    return t2;
  }

  /**
   * Gets the starting x position of this keyframe.
   * @return the x2.
   */
  public int getX2() {
    return x2;
  }

  /**
   * Gets the starting x position of this keyframe.
   * @return the y2.
   */
  public int getY2() {
    return y2;
  }

  /**
   * Gets the starting width of the shape in this keyframe.
   * @return the w2.
   */
  public int getW2() {
    return w2;
  }

  /**
   * Gets the starting height of the shape in this keyframe.
   * @return the h2.
   */
  public int getH2() {
    return h2;
  }

  /**
   * Gets the starting r value of the shape in this keyframe.
   * @return the r2.
   */
  public int getR2() {
    return r2;
  }

  /**
   * Gets the starting g value of the shape in this keyframe.
   * @return the g2.
   */
  public int getG2() {
    return g2;
  }

  /**
   * Gets the starting g value of the shape in this keyframe.
   * @return the g2.
   */
  public int getB2() {
    return b2;
  }
}
