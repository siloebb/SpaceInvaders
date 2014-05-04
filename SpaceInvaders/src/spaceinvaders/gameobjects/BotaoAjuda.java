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
public class BotaoAjuda extends GameObject{
    
    private SpaceInvaders spInvaders;

    public BotaoAjuda(SpaceInvaders spInvaders) {
        this.spInvaders = spInvaders;
    }
   
    @Override
    public void update() {
        super.update(); //To change body of generated methods, choose Tools | Templates.
        
         if(keyPressed == KeyEvent.VK_H){
         System.out.println("Ajuda");
         spInvaders.mostrarAjuda();
         System.out.println("Ajuda funfando");
    }
    
    
}
}
