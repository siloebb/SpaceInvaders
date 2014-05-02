package spaceinvaders.gameobjects;

import java.util.logging.Level;
import java.util.logging.Logger;
import spaceinvaders.Resolucao;
import spaceinvaders.utils.GameObject;
import spaceinvaders.utils.sprite.Sprite;
import spaceinvaders.utils.sprite.SpriteAnimated;

/**
 *
 * @author Siloe
 */
public class Life extends GameObject {

    public Life(Resolucao resolucao) {

        SpriteAnimated sprite = new SpriteAnimated();
        try {
            sprite.carregarSprite((resolucao.getCaminho() + "/life.png"), 1, 4);
        } catch (Exception ex) {
            Logger.getLogger(Life.class.getName()).log(Level.SEVERE, null, ex);
        }
        sprite.setX(540);//resolucao.getPosicaoNave()[0]);
        sprite.setY(10);//resolucao.getPosicaoNave()[1]);
        sprite.setPosicaoAtual(0);

        this.setSprite(sprite);
    }

}
