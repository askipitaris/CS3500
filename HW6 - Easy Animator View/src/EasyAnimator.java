import controller.Controller;
import cs3500.animator.util.AnimationReader;
import cs3500.animator.view.EnhancedVisualView;
import cs3500.animator.view.SVGView;
import cs3500.animator.view.TextualView;
import cs3500.animator.view.VisualView;
import java.io.FileNotFoundException;
import java.io.FileReader;
import model.AnimatorModel;
import model.AnimatorModelImpl.Builder;

/**
 * Main class for the Easy Animator. Creates and runs an animation with several views. There are the
 * textual view, which outputs the animation as text; the svg view which outputs the animation as an
 * svg file, which can then be displayed in a web browser; and a view which runs the animation in a
 * new window.
 */
public final class EasyAnimator {

  /**
   * The main method for the program. Takes in all the input in the form of command line arguments
   * and runs the views.
   *
   * @param args are the arguments passed into the program
   */
  public static void main(String[] args) {
    Readable inputFile = null;
    String outputPath = "System.out";
    String view = "";
    int speed = 1000;
    AnimatorModel m;

    Controller c = null;

    for (int i = 0; i < args.length; i++) {
      switch (args[i]) {
        case "-in":
          try {
            inputFile = new FileReader(args[i + 1]);
          } catch (FileNotFoundException e) {
            e.printStackTrace();
          }
          break;
        case "-out":
          outputPath = args[i + 1];
          break;
        case "-view":
          view = args[i + 1];
          break;
        case "-speed":
          speed = Integer.parseInt(args[i + 1]);
          break;
        default:
          break;
      }
    }

    try {
      m = AnimationReader.parseFile(inputFile, new Builder());
    } catch (NullPointerException npe) {
      throw new IllegalArgumentException("Input file cannot be null");
    }

    switch (view) {
      case "text":
        c = new Controller(new TextualView(m, outputPath));
        break;
      case "svg":
        c = new Controller(new SVGView(m, outputPath, speed));
        break;
      case "visual":
        c = new Controller(new VisualView(m, speed));
        break;
      case "interactive":
        c = new Controller(new EnhancedVisualView(m, speed));
        break;
      default:
        break;
    }

    try {
      c.runAll();
    } catch (NullPointerException npe) {
      throw new IllegalArgumentException("Controller cannot be null");
    }
  }
}