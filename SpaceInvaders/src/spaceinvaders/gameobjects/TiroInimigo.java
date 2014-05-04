/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spaceinvaders.gameobjects;
import spaceinvaders.listenners.ColisaoEvent;
import spaceinvaders.listenners.ColisaoListenner;
import spaceinvaders.utils.GameObject;
import spaceinvaders.utils.Jogo;
import spaceinvaders.utils.sprite.SpriteAnimated;
/**
 *
 * @author Siloe
 */
public class TiroInimigo extends GameObject implements ColisaoListenner{

    private Jogo jogo;
    public TiroInimigo(Jogo jogo) throws Exception {
        SpriteAnimated spTiro = new SpriteAnimated();
        spTiro.carregarSprite("src/assets_800x600/" + "tiro_inimigo.png", 1, 2);
        spTiro.setX(50);
        spTiro.setY(0);
        spTiro.animate(0, 1, 15);
        this.sprite = spTiro;
        this.jogo = jogo;
    }

    @Override
    public void update() {
        super.update(); 
        this.setY(this.getY() + 2);
    }
    
    
    @Override
    public void colidiu(ColisaoEvent c) {
        //Verifica se a tag tem o nome inimigo, se tiver cria uma explosão e auto destroi os 2
        if (c.getGameObject().getTag().equals("nave")) {
            Explosao explosao;
            explosao = new Explosao(c.getGameObject().getX(), c.getGameObject().getY());
            jogo.addGameObject(explosao);
            //c.getGameObject().selfDestroy();
            ((Nave)c.getGameObject()).perderLife();
            this.selfDestroy();
        }
    }
    
    
}
