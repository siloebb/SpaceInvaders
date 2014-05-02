package spaceinvaders.gameobjects;

import java.awt.event.KeyEvent;
import spaceinvaders.listenner.ColisaoEvent;
import spaceinvaders.utils.GameObject;
import spaceinvaders.utils.sprite.Sprite;
import spaceinvaders.listenner.ColisaoListenner;

/**
 *
 * @author Siloe
 */
public class Nave extends GameObject implements ColisaoListenner{

    public Nave() {
        
    }

    @Override
    public void update() {
        if (keyPressed == KeyEvent.VK_LEFT) {
            this.setX(this.getX() - 5);
        }
        if (keyPressed == KeyEvent.VK_RIGHT) {
            this.setX(this.getX() + 5);
        }
    }

    //Os metódos abaixo são apenas para demonstração, pois já estão implementados na classe pai da mesma forma;
    @Override
    public Sprite getSprite() {
        return sprite;
    }

    @Override
    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    @Override
    public void setX(int x) {
        sprite.setX(x);
    }

    @Override
    public void setY(int y) {
        sprite.setY(y);
    }

    @Override
    public int getX() {
        return sprite.getX();
    }

    @Override
    public int getY() {
        return sprite.getY();
    }

    @Override
    public void colidiu(ColisaoEvent c) {
        System.out.println("SUENNY DISSE Q BATEU!");
    }
    
    public String getTag(){
        return "nave";
    }

}
