import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

import cs3500.animator.view.IView;
import cs3500.animator.view.SVGView;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import model.AnimatorModel;
import model.AnimatorModelImpl;
import org.junit.Test;

/**
 * Tests for the SVG view.
 */
public class TestSVGView {

  @Test
  public void testMakeFile() {
    AnimatorModel m = new AnimatorModelImpl.Builder().setBounds(200, 70, 360, 360)
        .declareShape("R", "rectangle")
        .addKeyframe("R", 1, 200, 200, 50, 100, 255, 0, 0)
        .addMotion("R", 10, 200, 200, 50, 100, 255, 0, 0, 50,
            300, 300, 50, 100, 255, 0, 0)
        .build();

    IView v = new SVGView(m, "C:\\Easy Animator Output\\test.svg", 100);

    File f = new File("C:\\Easy Animator Output\\test.svg");
    assertTrue(f.exists());
  }

  @Test
  public void testCorrectStringOutputRectangle() {
    AnimatorModel m = new AnimatorModelImpl.Builder().setBounds(200, 70, 360, 360)
        .declareShape("R", "rectangle")
        .addKeyframe("R", 1, 200, 200, 50, 100, 255, 0, 0)
        .addMotion("R", 10, 200, 200, 50, 100, 255, 0, 0, 50,
            300, 300, 50, 100, 255, 0, 0)
        .build();
    IView v = new SVGView(m, "C:\\Easy Animator Output\\test.svg", 10);
    String content = "";
    try {
      content = new String(Files.readAllBytes(Paths.get("C:\\Easy Animator Output\\test.svg")),
          "UTF-8");
    } catch (IOException e) {
      e.printStackTrace();
    }

    assertEquals("<svg width=\"560\" height=\"430\" version=\"1.1\"\n"
        + "xmlns=\"http://www.w3.org/2000/svg\">\n"
        + "<rect id=\"R\" x=\"200\" y=\"200\" width=\"50\" height=\"100\" fill=\"rgb(255, 0, 0)\" "
        + "visibility=\"visible\" >\n"
        + "<animate attributeName=\"x\" attributeType=\"xml\" begin=\"10ms\" dur=\"0ms\" "
        + "fill=\"freeze\" from=\"200\" to=\"200\" />\n"
        + "<animate attributeName=\"y\" attributeType=\"xml\" begin=\"10ms\" dur=\"0ms\" "
        + "fill=\"freeze\" from=\"200\" to=\"200\" />\n"
        + "<animate attributeName=\"width\" attributeType=\"xml\" begin=\"10ms\" dur=\"0ms\" "
        + "fill=\"freeze\" from=\"50\" to=\"50\" />\n"
        + "<animate attributeName=\"height\" attributeType=\"xml\" begin=\"10ms\" dur=\"0ms\" "
        + "fill=\"freeze\" from=\"100\" to=\"100\" />\n"
        + "<animate attributeName=\"x\" attributeType=\"xml\" begin=\"100ms\" dur=\"400ms\" "
        + "fill=\"freeze\" from=\"200\" to=\"300\" />\n"
        + "<animate attributeName=\"y\" attributeType=\"xml\" begin=\"100ms\" dur=\"400ms\" "
        + "fill=\"freeze\" from=\"200\" to=\"300\" />\n"
        + "<animate attributeName=\"width\" attributeType=\"xml\" begin=\"100ms\" dur=\"400ms\" "
        + "fill=\"freeze\" from=\"50\" to=\"50\" />\n"
        + "<animate attributeName=\"height\" attributeType=\"xml\" begin=\"100ms\" dur=\"400ms\" "
        + "fill=\"freeze\" from=\"100\" to=\"100\" />\n"
        + "</rect>\n"
        + "</svg>", content);

  }

  @Test
  public void testCorrectStringOutputEllipse() {
    AnimatorModel m = new AnimatorModelImpl.Builder().setBounds(200, 70, 360, 360)
        .declareShape("R", "ellipse")
        .addKeyframe("R", 1, 200, 200, 50, 100, 255, 0, 0)
        .addMotion("R", 10, 200, 200, 50, 100, 255, 0, 0, 50,
            300, 300, 50, 100, 255, 0, 0)
        .build();
    IView v = new SVGView(m, "C:\\Easy Animator Output\\test.svg", 10);
    String content = "";
    try {
      content = new String(Files.readAllBytes(Paths.get("C:\\Easy Animator Output\\test.svg")),
          "UTF-8");
    } catch (IOException e) {
      e.printStackTrace();
    }

    assertEquals("<svg width=\"560\" height=\"430\" version=\"1.1\"\n"
        + "xmlns=\"http://www.w3.org/2000/svg\">\n"
        + "<ellipse id=\"R\" cx=\"200\" cy=\"200\" rx=\"50\" ry=\"100\" fill=\"rgb(255, 0, 0)\" "
        + "visibility=\"visible\" >\n"
        + "<animate attributeName=\"x\" attributeType=\"xml\" begin=\"10ms\" dur=\"0ms\" "
        + "fill=\"freeze\" from=\"200\" to=\"200\" />\n"
        + "<animate attributeName=\"y\" attributeType=\"xml\" begin=\"10ms\" dur=\"0ms\" "
        + "fill=\"freeze\" from=\"200\" to=\"200\" />\n"
        + "<animate attributeName=\"width\" attributeType=\"xml\" begin=\"10ms\" dur=\"0ms\" "
        + "fill=\"freeze\" from=\"50\" to=\"50\" />\n"
        + "<animate attributeName=\"height\" attributeType=\"xml\" begin=\"10ms\" dur=\"0ms\" "
        + "fill=\"freeze\" from=\"100\" to=\"100\" />\n"
        + "<animate attributeName=\"x\" attributeType=\"xml\" begin=\"100ms\" dur=\"400ms\" "
        + "fill=\"freeze\" from=\"200\" to=\"300\" />\n"
        + "<animate attributeName=\"y\" attributeType=\"xml\" begin=\"100ms\" dur=\"400ms\" "
        + "fill=\"freeze\" from=\"200\" to=\"300\" />\n"
        + "<animate attributeName=\"width\" attributeType=\"xml\" begin=\"100ms\" dur=\"400ms\" "
        + "fill=\"freeze\" from=\"50\" to=\"50\" />\n"
        + "<animate attributeName=\"height\" attributeType=\"xml\" begin=\"100ms\" dur=\"400ms\" "
        + "fill=\"freeze\" from=\"100\" to=\"100\" />\n"
        + "</ellipse>\n"
        + "</svg>", content);

  }


}
