/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spaceinvaders.gameobjects;

import java.awt.event.KeyEvent;
import spaceinvaders.SpaceInvaders;
import spaceinvaders.utils.GameObject;

/**
 *
 * @author Jéssica Magally
 */
public class BotaoIniciar extends GameObject {
    SpaceInvaders spInvaders;
    
    public BotaoIniciar(SpaceInvaders spInvaders){
        this.spInvaders = spInvaders;
    }

    @Override
    public void update() {
        if(keyPressed == KeyEvent.VK_ENTER){
            System.out.println("Iniciando jogo");
            spInvaders.iniciarJogo();
            System.out.println("Jogo carregado");
        }
    }
    
       
}
