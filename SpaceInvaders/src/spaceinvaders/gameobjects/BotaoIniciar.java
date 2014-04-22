/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spaceinvaders.gameobjects;

import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import spaceinvaders.SpaceInvaders;
import spaceinvaders.utils.GameObject;
import spaceinvaders.utils.Jogo;
import spaceinvaders.utils.sprite.BackgroundImage;
import spaceinvaders.utils.sprite.SpriteAnimated;

/**
 *
 * @author Jéssica Magally
 */
public class BotaoIniciar extends GameObject {
    SpaceInvaders spInvaders;
    
    public BotaoIniciar(SpaceInvaders spInvaders){
        spInvaders= new SpaceInvaders();
    }

    @Override
    public void update() {
        if(keyPressed== KeyEvent.VK_ENTER){
            spInvaders.iniciarJogo();
             
        }
    }
    
       
}
