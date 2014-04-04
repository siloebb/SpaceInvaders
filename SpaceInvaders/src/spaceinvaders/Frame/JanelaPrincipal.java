package spaceinvaders.Frame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 *
 * @author Siloe
 */
public class JanelaPrincipal extends JFrame {

    public JanelaPrincipal() throws HeadlessException {
        super("Space Invaders");

        this.setSize(800, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        //Here is how we used to draw a square with width
        //of 200, height of 200, and starting at x=50, y=50.
        g.setColor(Color.red);
        g.drawRect(50, 50, 200, 200);

        //Let's set the Color to blue and then use the Graphics2D
        //object to draw a rectangle, offset from the square.
        //So far, we've not done anything using Graphics2D that
        //we could not also do using Graphics.  (We are actually
        //using Graphics2D methods inherited from Graphics.)
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.blue);
        g2d.drawRect(75, 75, 300, 200);
    }

}
