/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spaceinvaders.listenners;

import java.util.EventObject;
import spaceinvaders.gameobjects.Nave;

/**
 *
 * @author suka
 */
public class NaveEvent extends EventObject {

    private int vida;

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
    public NaveEvent(Nave source) {
        super(source);
    }
    
}
