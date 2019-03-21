package cs3500.animator.view;

import java.util.function.Consumer;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.AnimatorModel;

/**
 * Abstract class for views. Has common methods.
 */
public class AbstractViewClass extends JFrame implements IView {

  protected AnimatorModel m;
  int speed;


  @Override
  public void makeVisible() {
    this.setVisible(true);
  }

  @Override
  public void setCommandCallback(Consumer<String> callback) {
    // Must be overridden
  }


  @Override
  public void showErrorMessage(String error) {
    JOptionPane.showMessageDialog(this, error, "Error",
        JOptionPane.ERROR_MESSAGE);
  }

  @Override
  public void refresh() {
    this.repaint();
  }

  @Override
  public AnimatorModel getAnimatorModel() {
    return m;
  }

}
