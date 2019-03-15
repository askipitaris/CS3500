package cs3500.animator.view;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import model.AnimatorModel;

/**
 * Textual view for animations. Outputs either console or a text file.
 */
public class TextualView extends AbstractViewClass implements IView {

  private AnimatorModel m;

  public TextualView(AnimatorModel m, String out) {
    this.m = m;
    if (!out.equals("System.out")) {
      this.createFile(out);
    } else {
      System.out.print(m.getState());
    }
  }

  private void createFile(String out) {

    try {
      File f = new File(out);
      FileWriter fw = new FileWriter(f);
      fw.write(m.getState());
      fw.close();

    } catch (IOException ioe) {
      ioe.printStackTrace();
    }

  }

  public void display() {
    setVisible(true);
  }
}
