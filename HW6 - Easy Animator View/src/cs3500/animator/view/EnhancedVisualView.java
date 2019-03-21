package cs3500.animator.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import model.AnimatorModel;

/**
 * Enhances the original visual view.
 */
public class EnhancedVisualView extends JFrame implements IView, ActionListener {

  private Appendable ap;

  private AnimatorModel model;
  private Timer timer;

  /**
   * Constructs an EnhancedVisualView.
   */
  public EnhancedVisualView() {
    super();
    VisualPanel panel = new VisualPanel(model, 3);
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    panel.setPreferredSize(new Dimension(model.getWidth(), model.getHeight()));
    this.add(panel);

    JScrollPane scrollBar = new JScrollPane(panel,
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    this.add(scrollBar);

    // play and pause button, adds to view
    String playTitle = "Press to pause";
    JButton play = new JButton(playTitle);
    panel.add(play, BorderLayout.NORTH);

    // restart button, adds to view
    JButton restart = new JButton("Press to restart");
    panel.add(restart, BorderLayout.NORTH);

    // loop checkbox
    JCheckBox loop = new JCheckBox("Toggle to loop");
    panel.add(loop, BorderLayout.NORTH);

    // speed up button
    JButton speedUp = new JButton("Press to speed up");
    panel.add(speedUp, BorderLayout.NORTH);

    // slow down button
    JButton slowDown = new JButton("Press to slow down");
    panel.add(slowDown, BorderLayout.NORTH);

    this.setVisible(true);
    this.pack();
  }


  @Override
  public void makeVisible() {
    this.setVisible(true);
    // Must be overridden
  }

  @Override
  public void setCommandCallback(Consumer<String> callback) {
    // Must be overridden
  }

  @Override
  public void showErrorMessage(String error) {
    // Must be overridden
  }

  @Override
  public void refresh() {
    // Must be overridden
  }

  @Override
  public AnimatorModel getAnimatorModel() {
    return this.model;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    repaint();
  }





}
