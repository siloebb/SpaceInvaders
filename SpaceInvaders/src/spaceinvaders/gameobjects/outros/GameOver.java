/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.gameobjects.outros;

import java.awt.event.KeyEvent;
import spaceinvaders.Resolucao;
import spaceinvaders.utils.GameObject;
import static spaceinvaders.utils.GameObject.keyPressed;
import spaceinvaders.utils.sprite.Sprite;

/**
 *
 * @author suka
 */
public class GameOver extends GameObject {

    Resolucao resolucao = Resolucao.getInstance();

    public GameOver() {
        Sprite sprite = new Sprite();
        sprite.carregarSprite(resolucao.getCaminho() + "game_over.png");
        this.setSprite(sprite);
    }

    @Override
    public void update() {
        if (keyPressed == KeyEvent.VK_F2) {

            resolucao.getSpaceInvaders().iniciarJogo();
            this.selfDestroy();
        }

    }

}
