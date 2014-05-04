/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spaceinvaders.gameobjects;

import java.awt.event.KeyEvent;
import spaceinvaders.SpaceInvaders;
import spaceinvaders.utils.GameObject;
import static spaceinvaders.utils.GameObject.keyPressed;

/**
 *
 * @author Jéssica Magally
 */
public class BotaoSobre extends GameObject {
    
    SpaceInvaders spInvaders;

    public BotaoSobre(SpaceInvaders spInvaders) {
        this.spInvaders= spInvaders;
    }
    


    @Override
    public void update() {
        if(keyPressed == KeyEvent.VK_A){
         System.out.println("Sobre");
         spInvaders.mostrarSobre();
         System.out.println("Sobre funfando");
    }
    
    
    
    
}
}
