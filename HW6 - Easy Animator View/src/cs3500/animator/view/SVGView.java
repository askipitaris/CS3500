package cs3500.animator.view;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import model.AnimatorModel;
import model.Keyframe;

/**
 * Defines a view outputs SVG files. Can be run in web browsers.
 */
public class SVGView extends AbstractViewClass implements IView {

  Appendable ap = null;

  /**
   * Constructs a view that outputs an svg file.
   *
   * @param m is the model that this svg file will be based off of
   * @param out is the output path
   * @param speed is the speed that this svg file will run the animation at
   */
  public SVGView(AnimatorModel m, String out, int speed) {
    super.m = m;
    super.speed = speed;
    this.createSVGFile(out);
  }

  /**
   * Creates the outermost format of the SVG view.
   *
   * @return a string representing the SVG view
   */
  public String createSVG() {
    StringBuilder sb = new StringBuilder();

    sb.append("<svg width=\"");
    sb.append(m.getWidth() + m.getLeftX());
    sb.append("\" height=\"");
    sb.append(m.getHeight() + m.getTopY());
    sb.append("\" version=\"1.1\"\n");
    sb.append("xmlns=\"http://www.w3.org/2000/svg\">\n");

    // for every shape, append its SBV format to the stringbuilder
    for (String s : m.getAllShapes().keySet()) {
      if (m.getShape(s).equals("rectangle")) {
        sb.append(this.rectSVG(s));
      } else {
        sb.append(this.ellipseSVG(s));
      }

    }

    sb.append("</svg>");

    return sb.toString();

  }

  private StringBuilder ellipseSVG(String name) {
    StringBuilder ellipse = new StringBuilder();

    Keyframe base = null;

    for (int i = 0; i < m.getKeyframes().size(); i++) {
      Keyframe temp = m.getKeyframes().get(i);
      if (temp.getName().equals(name)) {
        base = temp;
        break;
      }
    }

    ellipse.append("<ellipse id=\"");
    ellipse.append(name); //name of shape
    ellipse.append("\" cx=\"");
    ellipse.append(base.getX1()); // x posn of shape
    ellipse.append("\" cy=\"");
    ellipse.append(base.getY1()); // y posn of shape
    ellipse.append("\" rx=\"");
    ellipse.append(base.getW1()); // width of shape
    ellipse.append("\" ry=\"");
    ellipse.append(base.getH1()); // height of shape
    ellipse.append("\" fill=\"rgb(");
    ellipse.append(base.getR1()).append(", ");
    ellipse.append(base.getG1()).append(", ");
    ellipse.append(base.getB1());

    ellipse.append(")\" visibility=\"visible\" >\n");

    for (Keyframe k : m.getKeyframes()) {
      if (k.getName().equals(name)) {
        // Every attribute, there needs to be animate thing
        ellipse.append("<animate attributeName=\"x\" ").append("attributeType=\"xml\" ")
            .append("begin=\"").append(k.getT1() * super.speed).append("ms\"")
            .append(" dur=\"").append((k.getT2() - k.getT1()) * super.speed)
            .append("ms\" fill=\"freeze\"")
            .append(" from=\"").append(k.getX1()).append("\"").append(" to=\"").append(k.getX2())
            .append("\"").append(" />\n");

        ellipse.append("<animate attributeName=\"y\" ").append("attributeType=\"xml\" ")
            .append("begin=\"").append(k.getT1() * super.speed).append("ms\"")
            .append(" dur=\"").append((k.getT2() - k.getT1()) * super.speed)
            .append("ms\" fill=\"freeze\"")
            .append(" from=\"").append(k.getY1()).append("\"").append(" to=\"").append(k.getY2())
            .append("\"").append(" />\n");

        ellipse.append("<animate attributeName=\"width\" ").append("attributeType=\"xml\" ")
            .append("begin=\"").append(k.getT1() * super.speed).append("ms\"")
            .append(" dur=\"").append((k.getT2() - k.getT1()) * super.speed)
            .append("ms\" fill=\"freeze\"")
            .append(" from=\"").append(k.getW1()).append("\"").append(" to=\"").append(k.getW2())
            .append("\"").append(" />\n");

        ellipse.append("<animate attributeName=\"height\" ").append("attributeType=\"xml\" ")
            .append("begin=\"").append(k.getT1() * super.speed).append("ms\"")
            .append(" dur=\"").append((k.getT2() - k.getT1()) * super.speed)
            .append("ms\" fill=\"freeze\"")
            .append(" from=\"").append(k.getH1()).append("\"").append(" to=\"").append(k.getH2())
            .append("\"").append(" />\n");
      }
    }

    ellipse.append("</ellipse>\n");

    return ellipse;
  }


  private StringBuilder rectSVG(String name) {
    StringBuilder rect = new StringBuilder();

    Keyframe base = null;

    for (int i = 0; i < m.getKeyframes().size(); i++) {
      Keyframe temp = m.getKeyframes().get(i);
      if (temp.getName().equals(name) && temp.getT1() == 1) {
        base = temp;
        break;
      }
    }

    rect.append("<rect id=\"");
    rect.append(name); //name of shape
    rect.append("\" x=\"");
    rect.append(base.getX1()); // x posn of shape
    rect.append("\" y=\"");
    rect.append(base.getY1()); // y posn of shape
    rect.append("\" width=\"");
    rect.append(base.getW1()); // width of shape
    rect.append("\" height=\"");
    rect.append(base.getH1()); // height of shape
    rect.append("\" fill=\"rgb(");
    rect.append(base.getR1()).append(", ");
    rect.append(base.getG1()).append(", ");
    rect.append(base.getB1());

    rect.append(")\" visibility=\"visible\" >\n");

    for (Keyframe k : m.getKeyframes()) {
      if (k.getName().equals(name)) {
        // Every attribute, there needs to be animate thing
        rect.append("<animate attributeName=\"x\" ").append("attributeType=\"xml\" ")
            .append("begin=\"").append(k.getT1() * super.speed).append("ms\"")
            .append(" dur=\"").append((k.getT2() - k.getT1()) * super.speed)
            .append("ms\" fill=\"freeze\"")
            .append(" from=\"").append(k.getX1()).append("\"").append(" to=\"").append(k.getX2())
            .append("\"").append(" />\n");

        rect.append("<animate attributeName=\"y\" ").append("attributeType=\"xml\" ")
            .append("begin=\"").append(k.getT1() * super.speed).append("ms\"")
            .append(" dur=\"").append((k.getT2() - k.getT1()) * super.speed)
            .append("ms\" fill=\"freeze\"")
            .append(" from=\"").append(k.getY1()).append("\"").append(" to=\"").append(k.getY2())
            .append("\"").append(" />\n");

        rect.append("<animate attributeName=\"width\" ").append("attributeType=\"xml\" ")
            .append("begin=\"").append(k.getT1() * super.speed).append("ms\"")
            .append(" dur=\"").append((k.getT2() - k.getT1()) * super.speed)
            .append("ms\" fill=\"freeze\"")
            .append(" from=\"").append(k.getW1()).append("\"").append(" to=\"").append(k.getW2())
            .append("\"").append(" />\n");

        rect.append("<animate attributeName=\"height\" ").append("attributeType=\"xml\" ")
            .append("begin=\"").append(k.getT1() * super.speed).append("ms\"")
            .append(" dur=\"").append((k.getT2() - k.getT1()) * super.speed)
            .append("ms\" fill=\"freeze\"")
            .append(" from=\"").append(k.getH1()).append("\"").append(" to=\"").append(k.getH2())
            .append("\"").append(" />\n");
      }
    }

    rect.append("</rect>\n");

    return rect;
  }

  private void createSVGFile(String out) {

    try {
      File f = new File(out);
      FileWriter fw = new FileWriter(f);
      fw.write(this.createSVG());
      fw.close();

    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

}
