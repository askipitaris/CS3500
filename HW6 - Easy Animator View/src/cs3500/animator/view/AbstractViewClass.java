package cs3500.animator.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.function.Consumer;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Abstract class for views. Has common methods.
 */
public class AbstractViewClass extends JFrame implements IView {

  private Consumer<String> commandCallback;
  private JPanel mainPanel;
  private JScrollPane scrollPane;

  public AbstractViewClass() {
    super();
    this.setTitle("Shapes");
    this.setSize(500, 500);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout());
    this.mainPanel = new ShapesPanel();
    mainPanel.setPreferredSize(new Dimension(500, 500));
    scrollPane = new JScrollPane(mainPanel);
    this.add(scrollPane, BorderLayout.CENTER);
    // ignored other stuff from Turtle that isn't relavent
    this.pack();

  }

  @Override
  public void display() {
    setVisible(true);
  }

  @Override
  public void makeVisible() {
    this.setVisible(true);
  }

  @Override
  public void setCommandCallback(Consumer<String> callback) {
    commandCallback = callback;
  }

  @Override
  public String getUserCommand() {
    return null;
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
}
