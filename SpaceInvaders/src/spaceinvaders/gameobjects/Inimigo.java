/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spaceinvaders.gameobjects;

import spaceinvaders.utils.GameObject;

/**
 *
 * @author Siloe
 */
public class Inimigo extends GameObject{

    @Override
    public void update() {
        this.setY(this.getY() + 2);
    }
    
}
