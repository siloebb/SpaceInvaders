/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.utils;

import java.util.ArrayList;
import java.util.Collection;
import spaceinvaders.gameobjects.Nave;
import spaceinvaders.listenner.ColisaoEvent;
import spaceinvaders.listenner.ColisaoListenner;

/**
 *
 * @author suka
 */
public class Colisao {

    Collection<ColisaoListenner> colisao = new ArrayList<ColisaoListenner>();

    public synchronized void addColisaoListener(ColisaoListenner c) {
        if (!colisao.contains(c)) {
            colisao.add(c);
        }
    }

    public synchronized void removeColisaoListener(ColisaoListenner c) {
        colisao.remove(c);
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

    public void verificarColisao() {
        Collection<ColisaoListenner> colisaoClone = new ArrayList<ColisaoListenner>();
        colisaoClone.addAll(colisao);
        for (ColisaoListenner c1 : colisaoClone) {

            for (ColisaoListenner c2 : colisaoClone) {
                if (!c1.equals(c2)) {
                    if (c1.getX() + c1.getWidth() > c2.getX() && c1.getX() < c2.getX() + c2.getWidth() && c1.getY() + c1.getHeight() > c2.getY() && c1.getY() < c2.getY() + c2.getHeight()) {
                        ColisaoEvent evento = new ColisaoEvent(this, (GameObject)c2);
                        c1.colidiu(evento);
                    }
                }
            }
        }
    }
}
