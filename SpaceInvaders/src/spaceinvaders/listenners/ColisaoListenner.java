/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spaceinvaders.listenners;

import java.util.EventListener;

/**
 *
 * @author suka
 */
public interface ColisaoListenner extends EventListener{
    public void colidiu(ColisaoEvent c);
    public int getX();
    public int getY();
    public int getHeight();
    public int getWidth();
}
