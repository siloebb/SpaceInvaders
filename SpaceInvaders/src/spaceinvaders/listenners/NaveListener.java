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
public interface NaveListener extends EventListener {
    public void NavePerdeuVida(NaveEvent e);
        
}
