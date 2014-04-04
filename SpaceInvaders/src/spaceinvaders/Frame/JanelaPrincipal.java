
package spaceinvaders.Frame;

import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 *
 * @author Siloe
 */
public class JanelaPrincipal extends JFrame{

    public JanelaPrincipal() throws HeadlessException {
        super("Space Invaders");
        
        this.setSize(800,600);
        this.setVisible(true);
    }
       
    
}
