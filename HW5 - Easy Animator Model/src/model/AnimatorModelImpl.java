package model;

import java.awt.Color;

/**
 * Extends {@link AbstractAnimatorModel}. Has constructors for animations.
 */
public class AnimatorModelImpl extends AbstractAnimatorModel {

  /**
   * Constructs a default base animation with a windows size of 500x400 and a white background.
   */
  public AnimatorModelImpl() {
    super.winWidth = 500;
    super.winHeight = 400;
    super.winColor = Color.WHITE;
  }

  /**
   * Constructs a window with custom dimensions and a white background. Throws an
   * IllegalArgumentException if the dimensions are not positive.
   *
   * @param width is the custom width of the window.
   * @param height is the custom height of the window.
   * @throws IllegalArgumentException if the dimensions are invalid.
   */
  public AnimatorModelImpl(int width, int height) {
    if (width > 0 && height > 0) {
      super.winWidth = width;
      super.winHeight = height;
      super.winColor = Color.WHITE;
    } else {
      throw new IllegalArgumentException("Invalid dimensions");
    }
  }

  /**
   * Constructs a window with a custom background color and dimensions of 500x400.
   *
   * @param c is the custom background color.
   */
  public AnimatorModelImpl(Color c) {
    super.winWidth = 500;
    super.winHeight = 400;
    super.winColor = new Color(c.getRGB());
  }

  /**
   * Constructs a window with custom dimensions and a custom background color. Throws an
   * IllegalArgumentException if the dimensions are not positive.
   *
   * @param width is the custom width of the window.
   * @param height is the custom height of the window.
   * @param c is the custom background color.
   * @throws IllegalArgumentException if the dimensions are invalid.
   */
  public AnimatorModelImpl(int width, int height, Color c) {
    if (width > 0 && height > 0) {
      super.winWidth = width;
      super.winHeight = height;
      super.winColor = new Color(c.getRGB());
    } else {
      throw new IllegalArgumentException("Invalid dimensions");
    }
  }
}
