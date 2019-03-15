package cs3500.animator.view;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import javax.swing.JPanel;

/**
 * Defines a panel that will be drawn onto.
 */
public class ShapesPanel extends JPanel {

  public ShapesPanel() {
    super();
    this.setBackground(Color.WHITE);

  }

  public void paintComponent(Graphics2D g) {
    super.paintComponent(g);

    Graphics2D g2D = g;

    g2D.setColor(Color.BLACK);

    AffineTransform ogTransform = g2D.getTransform();

  }

}
