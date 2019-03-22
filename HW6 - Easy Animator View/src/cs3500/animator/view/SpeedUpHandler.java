package cs3500.animator.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Allows an animation to slow itself up.
 */
public class SpeedUpHandler implements ActionListener {

  private EnhancedVisualView v;

  /**
   * Constructs a SpeedUpHandler.
   * @param v is the EnhancedVisualView that will use this SpeedUpHandler
   */
  public SpeedUpHandler(EnhancedVisualView v) {
    this.v = v;
  }


  @Override
  public void actionPerformed(ActionEvent e) {
    //this.v.getPanel().setIsIncreasing(1);
  }
}
