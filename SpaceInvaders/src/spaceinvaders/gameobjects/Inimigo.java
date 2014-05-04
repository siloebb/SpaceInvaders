/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.gameobjects;

import java.util.logging.Level;
import java.util.logging.Logger;
import spaceinvaders.listenners.ColisaoEvent;
import spaceinvaders.listenners.ColisaoListenner;
import spaceinvaders.utils.GameObject;
import spaceinvaders.utils.Jogo;

/**
 *
 * @author Siloe
 */
public abstract class Inimigo extends GameObject implements ColisaoListenner {

    private Jogo jogo;
    private int tiroFrequencia = 120;
    private int contadorDeTiro = 0;

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public Inimigo(Jogo jogo) {
        this.setTag("inimigo");
        this.jogo = jogo;
    }

    @Override
    public void update() {
        movimentar();
        //Atira de tempos em tempos
        contadorDeTiro++;
        if (contadorDeTiro > tiroFrequencia) {
            //atira
            TiroInimigo ta;
            try {
                ta = new TiroInimigo(jogo);
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

    public void movimentar() {
        this.setY(this.getY() + 2);
    }

    @Override
    public void colidiu(ColisaoEvent c) {
        try {
            if (((GameObject) c.getGameObject()).getTag().equals("nave")) {
                System.out.println("Preciso matar a nave porque toquei nela");
            }

        } catch (Exception e) {
            //   e.getMessage();
        }
    }

}
