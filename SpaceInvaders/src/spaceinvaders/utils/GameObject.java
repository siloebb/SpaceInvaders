package spaceinvaders.utils;

import java.awt.event.KeyEvent;
import spaceinvaders.utils.sprite.Sprite;

/**
 *
 * @author Siloe
 */
public class GameObject {

    public static int keyPressed = 0;
    protected Sprite sprite;

    public void update() {

    }

    public Sprite getSprite() {
        return sprite;
    }

    
    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    
    public void setX(int x) {
        sprite.setX(x);
    }

    
    public void setY(int y) {
        sprite.setY(y);
    }

    
    public int getX() {
        return sprite.getX();
    }

    
    public int getY() {
        return sprite.getY();
    }

}
