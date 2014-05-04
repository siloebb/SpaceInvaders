package spaceinvaders.gameobjects;

import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import spaceinvaders.listenners.ColisaoEvent;
import spaceinvaders.utils.GameObject;
import spaceinvaders.utils.sprite.Sprite;
import spaceinvaders.listenners.ColisaoListenner;
import spaceinvaders.utils.Jogo;

/**
 *
 * @author Siloe
 */
public class Nave extends GameObject implements ColisaoListenner {

    private int tiroFrequencia = 60;
    private int contadorDeTiro = 0;
    private int life = 3;
    private int cont = 0;

    private Jogo jogo;

    public Nave(Jogo jogo) {
        this.jogo = jogo;
    }

    public void perderLife() {
        
        if (cont == 0) {
            this.life--;

            if (this.life == 0) {
                this.selfDestroy();
            }
            cont = 60;
        }
    }

    @Override
    public void update() {
        if(cont>0){
            cont--;
        }
        if (keyPressed == KeyEvent.VK_LEFT) {
            this.setX(this.getX() - 5);
        }
        if (keyPressed == KeyEvent.VK_RIGHT) {
            this.setX(this.getX() + 5);
        }

        //Atira de tempos em tempos
        contadorDeTiro++;
        if (contadorDeTiro > tiroFrequencia) {
            //atira
            TiroAmigo ta;
            try {
                ta = new TiroAmigo(jogo);
                ta.setX(this.getX() + 50);
                ta.setY(this.getY() + 20);
                jogo.addGameObject(ta);
                jogo.addColisaoListener(ta);
            } catch (Exception ex) {
                Logger.getLogger(Nave.class.getName()).log(Level.SEVERE, null, ex);
            }
            contadorDeTiro = 0;
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
        //System.out.println("SUENNY DISSE Q BATEU!");
    }

    public String getTag() {
        return "nave";
    }

}
