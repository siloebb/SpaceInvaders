
package spaceinvaders.utils.sprite;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author Siloe
 */
public class Background implements Printable {

    public static final int COLOR_WHITE =1, COLOR_BLACK =2;
    
    private int color=0;

    public Background() {
    }
    
    public Background(int color) {
        this.color = color;
    }

    @Override
    public void print(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        switch (color){
            case Background.COLOR_WHITE:
                g2d.setBackground(Color.WHITE);
                break;
            case Background.COLOR_BLACK:
                g2d.setBackground(Color.BLACK);
                g2d.fillRect(0, 175, 300, 50); // ground
                break;
            default:
                g2d.setBackground(Color.WHITE);
                break;
        }
    }
    
}
