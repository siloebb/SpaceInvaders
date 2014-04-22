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

    @Override
    public void update() {
        if(keyPressed== KeyEvent.VK_ENTER){
             this.iniciarJogo();
        }
    }

   
    
    
    public void iniciarJogo() {
        Jogo jogo = new Jogo();

        GameObject nave = new Nave();

        ///Adicionando nave
        SpriteAnimated spNave;
        spNave = new SpriteAnimated();
        try {
            spNave.carregarSprite("src/assets/nave1.png", 1, 2);
            spNave.setX(30);
            spNave.setY(300);
            spNave.animate(0,1);
        } catch (Exception ex) {
            Logger.getLogger(SpaceInvaders.class.getName()).log(Level.SEVERE, null, ex);
        }
        nave.setSprite(spNave);

        jogo.addGameObject(nave);
        //Adicionando inimigo
        Inimigo inimigo = new Inimigo();
        SpriteAnimated spInimigo = new SpriteAnimated();
        try {
            spInimigo.carregarSprite("src/assets_800x600/alien3.png", 1, 4);
            spInimigo.setX(10);
            spInimigo.setY(20);
            spInimigo.animate(0, 3);
        } catch (Exception ex) {
            Logger.getLogger(SpaceInvaders.class.getName()).log(Level.SEVERE, null, ex);
        }
        inimigo.setSprite(spInimigo);
        jogo.addGameObject(inimigo);

        BackgroundImage bg = new BackgroundImage("src/assets/background.jpg");
        try {
            jogo.addBackground(bg);
        } catch (Exception ex) {
            Logger.getLogger(SpaceInvaders.class.getName()).log(Level.SEVERE, null, ex);
        }

        jogo.start();
    }

    
    
    
   
}
