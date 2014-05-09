package spaceinvaders.gameobjects;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import spaceinvaders.Resolucao;
import spaceinvaders.listenners.ColisaoEvent;
import spaceinvaders.listenners.ColisaoListener;
import spaceinvaders.listenners.NaveEvent;
import spaceinvaders.listenners.NaveListener;
import spaceinvaders.utils.GameObject;
import spaceinvaders.utils.Jogo;
import spaceinvaders.utils.sprite.Sprite;

/**
 *
 * @author Siloe
 */
public class Nave extends GameObject implements ColisaoListener {

    private int tiroFrequencia = 60;
    private int contadorDeTiro = 0;
    private int life = 3;
    private int cont = 0;
    private Collection<NaveListener> naveListeners;
    private Jogo jogo;
    private int velocidade = 5;

    public Nave(Jogo jogo) {
        naveListeners = new ArrayList<NaveListener>();
        this.jogo = jogo;
    }

    public void perderLife() {

        if (cont == 0) {
            this.life--;

            if (this.life == 0) {
                this.selfDestroy();
                GameOver gameOver = new GameOver();
                jogo.addGameObject(gameOver);
            }
            cont = 60;
            this.disparaNavePerdeuVida();
        }

    }

    public void addNaveListener(NaveListener e) {
        if (!naveListeners.contains(e)) {
            naveListeners.add(e);
        }
    }

    public void removeNaveListener(NaveListener e) {
        if (naveListeners.contains(e)) {
            naveListeners.remove(e);
        }
    }

    public void disparaNavePerdeuVida() {
        if (naveListeners != null) {
            for (NaveListener naveListener : naveListeners) {
                NaveEvent naveEvent = new NaveEvent(this);
                naveEvent.setVida(life);
                naveListener.NavePerdeuVida(naveEvent);
            }
        }
    }

    @Override
    public void update() {
        if (cont > 0) {
            cont--;
        }
        if (keyPressed == KeyEvent.VK_LEFT) {
            if(getX()>= 0){
                this.setX(this.getX() - velocidade);
            }
           
            
        }
        if (keyPressed == KeyEvent.VK_RIGHT) {
            Resolucao resolucao = Resolucao.getInstance();
            if(getX() <= resolucao.getLarguraTela()- this.getWidth()){
                this.setX(this.getX() + velocidade);
            }
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
      /*  if(c.getGameObject().getTag().equals("paredeDaEsquerda")){
            this.setX(getX() + velocidade);
        }*/
    }

    public String getTag() {
        return "nave";
    }

}
