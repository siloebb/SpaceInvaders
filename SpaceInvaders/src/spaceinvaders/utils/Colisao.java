/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.utils;

import java.util.ArrayList;
import java.util.Collection;
import spaceinvaders.gameobjects.naves.Nave;
import spaceinvaders.listenners.ColisaoEvent;
import spaceinvaders.listenners.ColisaoListener;

/**
 *
 * @author suka
 */
public class Colisao {

    Collection<ColisaoListener> listaColisao = new ArrayList<>();

    public synchronized void addColisaoListener(ColisaoListener c) {
        if (!listaColisao.contains(c)) {
            listaColisao.add(c);
        }
    }

    public synchronized void removeColisaoListener(ColisaoListener c) {
        if (listaColisao.contains(c)) {
            listaColisao.remove(c);
        }
    }

    /* private void disparaColidido() {
     Collection<ColisaoListenner> c2;
     synchronized (this) {
     c2 = (Collection) (((ArrayList) colisao).clone());
     }
     ColisaoEvent evento = new ColisaoEvent(this);
     for (ColisaoListenner c : c2) {
     c.colidiu(evento);
     }
     }*/
    /**
     * Verifica a colisão de todos os cadastrados e dispara o evento;
     */
    public void verificarColisao() {
        ArrayList<ColisaoListener> colisaoClone = new ArrayList<>();
        colisaoClone.addAll(listaColisao);
        ColisaoIterator ci = new ColisaoIterator(colisaoClone);
        ColisaoIterator cii = new ColisaoIterator(colisaoClone);
        //implementando iterator
        while (ci.hasNext()) {

            ColisaoListener c1 = ci.next();

            
            for (ColisaoListener c2 : colisaoClone) {
                if (!c1.equals(c2)) {
                    if (c1.getX() + c1.getWidth() > c2.getX() && c1.getX() < c2.getX() + c2.getWidth()
                            && c1.getY() + c1.getHeight() > c2.getY()
                            && c1.getY() < c2.getY() + c2.getHeight()) {

                        ColisaoEvent evento = new ColisaoEvent(this, (GameObject) c2);
                        c1.colidiu(evento);
                    }
                }
            }
        }
    }

}
