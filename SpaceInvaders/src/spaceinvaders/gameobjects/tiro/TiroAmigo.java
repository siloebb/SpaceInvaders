/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.gameobjects.tiro;

import spaceinvaders.Resolucao;
import spaceinvaders.gameobjects.elemetos_fase.Explosao;
import spaceinvaders.listenners.ColisaoEvent;
import spaceinvaders.listenners.ColisaoListener;
import spaceinvaders.utils.GameObject;
import spaceinvaders.utils.Jogo;
import spaceinvaders.utils.sprite.SpriteAnimated;

/**
 *
 * @author Siloe
 */
public class TiroAmigo extends GameObject implements ColisaoListener {

    private Jogo jogo;
    private Resolucao resolucao;

    public TiroAmigo(Jogo jogo) throws Exception {
        resolucao = Resolucao.getInstance();
        SpriteAnimated spTiro = new SpriteAnimated();
        spTiro.carregarSprite(resolucao.getCaminho() + "tiro_amigo.png", 1, 2);
        spTiro.setX(50);
        spTiro.setY(0);
        spTiro.animate(0, 1, 15);
        this.sprite = spTiro;
        this.jogo = jogo;
    }

    @Override
    public void update() {
        this.setY(this.getY() - 3);
        if(this.getY() < -20){
            this.selfDestroy();
        }
    }

    @Override
    public void colidiu(ColisaoEvent c) {
        //Verifica se a tag tem o nome inimigo, se tiver cria uma explosão e auto destroi os 2
        if (c.getGameObject().getTag().contains("inimigo")) {
            Explosao explosao;
            explosao = new Explosao(c.getGameObject().getX(), c.getGameObject().getY());
            jogo.addGameObject(explosao);
            c.getGameObject().selfDestroy();
            this.selfDestroy();
        }

    }

}
