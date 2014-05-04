/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spaceinvaders.listenners;

import java.util.EventObject;
import spaceinvaders.gameobjects.Inimigo;

/**
 *
 * @author Siloe
 */
public class InimigoEvent extends EventObject {
    
    private int pontos;

    public InimigoEvent(Inimigo source) {
        super(source);
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
    
}
