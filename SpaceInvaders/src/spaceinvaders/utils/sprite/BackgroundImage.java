
package spaceinvaders.utils.sprite;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import spaceinvaders.utils.Utils;

/**
 *
 * @author Siloe
 */
public class BackgroundImage extends Background implements Printable{
    
    private Sprite sprite;
    //private BufferedImage sprite;

    public BackgroundImage(int color) {
        super(color);
    }

    public BackgroundImage() {
        super();
    }

    public BackgroundImage(String file) {
        carregarSprite(file);
    }
    
    public void carregarSprite(String file){
        sprite = new Sprite();
        sprite.carregarSprite(file);
    }

    @Override
    public void print(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        //g2d.drawImage(sprite, 0, 0, null);
        sprite.print(g);
    }
    
}
