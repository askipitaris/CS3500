package cs3500.animator.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Allows an animation to slow itself down.
 */
public class SlowDownHandler implements ActionListener {

  private EnhancedVisualView v;

  /**
   * Constructs a SlowDownHandler.
   * @param v is the EnhancedVisualView that will use this SlowDownHandler
   */
  public SlowDownHandler(EnhancedVisualView v) {
    this.v = v;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    //this.v.getPanel().setIsIncreasing(-1);
  }
}
