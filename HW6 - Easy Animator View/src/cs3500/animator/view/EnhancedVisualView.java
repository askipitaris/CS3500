package cs3500.animator.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.Timer;
import model.AnimatorModel;

/**
 * Launches a version of visual view that allows the user to pause/play, restart, loop and change
 * the speed of the animation.
 */
public class EnhancedVisualView extends JFrame implements IView, ActionListener {

  private VisualPanel panel;
  private Appendable ap;

  private AnimatorModel model;
  private Timer timer;

  private JButton play;
  private String playTitle;
  private JButton restart;
  private JCheckBox loop;
  private JButton speedUp;
  private JButton slowDown;

  /**
   * Constructs an EnhancedVisualView.
   * @param m is the model that this view uses
   * @param speed is the base speed of the animation
   */
  public EnhancedVisualView(AnimatorModel m, int speed) {
    super();
    this.model = m;
    this.panel = new VisualPanel(model, 3);

    JScrollPane scrollBar = new JScrollPane(this.panel,
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    this.add(scrollBar);

    // play and pause button, adds to view
    this.playTitle = "Press to pause";
    this.play = new JButton(this.playTitle);
    panel.add(this.play, BorderLayout.NORTH);
    this.play.addActionListener(new PlayHandler(this));

    // restart button, adds to view
    this.restart = new JButton("Press to restart");
    panel.add(this.restart, BorderLayout.NORTH);
    this.restart.addActionListener(new RestartHandler(this));

    // loop checkbox
    this.loop = new JCheckBox("Toggle to loop");
    panel.add(this.loop, BorderLayout.NORTH);
    this.loop.addActionListener(new LoopHandler(this));
    // speed up button
    this.speedUp = new JButton("Press to speed up");
    panel.add(this.speedUp, BorderLayout.NORTH);
    this.speedUp.addActionListener(new SpeedUpHandler(this));

    // slow down button
    this.slowDown = new JButton("Press to slow down");
    panel.add(this.slowDown, BorderLayout.NORTH);
    this.slowDown.addActionListener(new SlowDownHandler(this));

    this.setVisible(true);
    this.pack();
  }


  @Override
  public void makeVisible() {
    this.setVisible(true);

  }

  VisualPanel getPanel() {
    return this.panel;
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

  public JButton getPlay() {
    return this.play;
  }

  /**
   * Gets the restart button.
   *
   * @return the restart button
   */
  public JButton getRestart() {
    return this.restart;
  }

  /**
   * Gets the loop checkbox.
   *
   * @return the loop checkbox
   */
  public JCheckBox getLoopCheckBox() {
    return this.loop;
  }

  /**
   * Gets the speedup button.
   *
   * @return the speedup button
   */
  public JButton getSpeedUp() {
    return this.speedUp;
  }

  /**
   * Gets the slow down button.
   *
   * @return the slow down button
   */
  public JButton getSlowDown() {
    return this.slowDown;
  }

  /**
   * Increases the timer.
   */
  public void increaseTimer() {
    int num = 100;
  }

  /**
   * Changes the title of the window.
   * @param s is the name of the title
   */
  public void setTitle(String s) {
    this.play.setText(s);
    this.playTitle = s;

  }

  /**
   * Gets the play title.
   * @return the playTitle
   */
  public String getPlayTitle() {
    return this.playTitle;
  }


}
