/*
import controller.Controller;
import cs3500.animator.view.SVGView;
import cs3500.animator.view.TextualView;
import cs3500.animator.view.VisualView;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.AnimatorModel;
import model.AnimatorModelImpl;

public final class RunShapes {

  public static void main(String[] args) throws IOException {
    String in = "";
    String view = "";
    String out = "System.out";
    int speed = 1;
    AnimatorModel model = new AnimatorModelImpl();
    Controller c;

    for (int i = 0; i < args.length - 1; i++) {
      if (args[i].equals("-in")) {
        in = args[i + 1];
      } else if (args[i].equals("-cs3500.animator.view")) {
        view = args[i + 1];
      } else if (args[i].equals("-out")) {
        out = args[i + 1];
      } else if (args[i].equals("-speed")) {
        if (Integer.parseInt(args[i + 1]) < 0) {
          throw new IllegalArgumentException("speed can't be negative");
        } else {
          speed = Integer.parseInt(args[i + 1]);
        }
      }
    }

    if (in.equals("") || view.equals("")) {
      JOptionPane.showMessageDialog(new JFrame(),
          "File and cs3500.animator.view need to be specified");
    }

    switch (view) {
      case "visual":
        c = new Controller(model, new VisualView(model), speed);
        break;
      case "text":
        c = new Controller(model, new TextualView(model, out), speed);
        break;
      case "svg":
        c = new Controller(model, new SVGView(model, out), speed);
        break;
      default:
        throw new IllegalArgumentException("Must provide a valid cs3500.animator.view");
    }

    c.go();
  }
}
*/
