/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spaceinvaders.listenner;

import java.awt.event.KeyEvent;
import java.util.EventObject;

/**
 *
 * @author Siloe
 */
public class ButtonEvent extends EventObject{

    KeyEvent keyEvent;

    public ButtonEvent(KeyEvent source) {
        super(source);
        
        this.keyEvent = keyEvent;
    }
    
    
            
}
