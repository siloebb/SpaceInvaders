/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.gameobjects.naves;

import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import spaceinvaders.gameobjects.tiro.TiroInimigo;
import spaceinvaders.listenners.ColisaoEvent;
import spaceinvaders.listenners.ColisaoListener;
import spaceinvaders.listenners.InimigoEvent;
import spaceinvaders.listenners.InimigoListener;
import spaceinvaders.utils.GameObject;
import spaceinvaders.utils.Jogo;

/**
 *
 * @author Siloe
 */
public abstract class Inimigo extends GameObject implements ColisaoListener {

    private Jogo jogo;
    private int tiroFrequencia = 120;
    private int contadorDeTiro = 0;
    private Collection<InimigoListener> listaInimigosListeners;
    
    private int pontos = 10;

    public Inimigo(Jogo jogo) {
        this.setTag("inimigo");
        this.jogo = jogo;
        listaInimigosListeners = new ArrayList<>();
    }

    public void addInimigoListenner(InimigoListener il) {
        if (il != null) {
            if (!listaInimigosListeners.contains(il)) {
                listaInimigosListeners.add(il);
            }
        }
    }

    public void removeInimigoListenner(InimigoListener il) {
        if (il != null) {
            if (listaInimigosListeners.contains(il)) {
                listaInimigosListeners.remove(il);
            }
        }
    }
    
    public void disparaInimigoMorreu(){
        for (InimigoListener il : listaInimigosListeners) {
            InimigoEvent ev = new InimigoEvent(this);
            ev.setPontos(pontos);
            il.inimigoMorreu(ev);
        }
    }

    public void movimentar() {
        this.setY(this.getY() + 2);
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

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
    
    /**
     * Usar este metódo para destroir, se não não tem pontos
     */
    @Override
    public void selfDestroy(){
        super.selfDestroy();
        disparaInimigoMorreu();        
    }

}
