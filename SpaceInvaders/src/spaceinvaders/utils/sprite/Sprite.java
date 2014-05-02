
package spaceinvaders.utils.sprite;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import spaceinvaders.utils.Utils;

/**
 *
 * @author Siloe
 */
public class Sprite implements Printable{
    
    protected BufferedImage sprite;
    protected int x = 0;
    protected int y = 0;

    public Sprite() {
    }
    
    public void carregarSprite(String file){
        sprite = Utils.carregarImagem(file);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void print(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(sprite, x, y, null);        
    }

    public int getHeight() {
        return sprite.getHeight();
    }

    public int getWidth() {
        return sprite.getWidth();
    }

}
