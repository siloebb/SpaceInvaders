package spaceinvaders.gameobjects.elemetos_fase;

import java.util.logging.Level;
import java.util.logging.Logger;
import spaceinvaders.Resolucao;
import spaceinvaders.listenners.NaveEvent;
import spaceinvaders.listenners.NaveListener;
import spaceinvaders.utils.GameObject;
import spaceinvaders.utils.sprite.SpriteAnimated;

/**
 *
 * @author Siloe
 */
public class Life extends GameObject implements NaveListener {

    public Life() {
        
        
        SpriteAnimated sprite = new SpriteAnimated();
        try { //isso é uma chamada correta de resolução????
            sprite.carregarSprite((Resolucao.getInstance().getCaminho() + "/life.png"), 1, 4);
        } catch (Exception ex) {
            Logger.getLogger(Life.class.getName()).log(Level.SEVERE, null, ex);
        }
        sprite.setX(Resolucao.getInstance().getPosicaoLife());//resolucao.getPosicaoNave()[0]);
        sprite.setY(10);//resolucao.getPosicaoNave()[1]);
        sprite.setPosicaoAtual(0);

        this.setSprite(sprite);
    }

    @Override
    public void NavePerdeuVida(NaveEvent e) {
        if(e.getVida()== 3){
            ((SpriteAnimated)this.getSprite()).setPosicaoAtual(0);
        }
        else
        if(e.getVida() == 2){
           //  ((SpriteAnimated)this.getSprite()).setPosicaoAtual(1);
            ((SpriteAnimated)this.getSprite()).animate(1, 1, 1);
        }
        else
        if(e.getVida() == 1){
             //((SpriteAnimated)this.getSprite()).setPosicaoAtual(2);
             ((SpriteAnimated)this.getSprite()).animate(2, 2, 2);
        }
        else
        if(e.getVida() == 0){
            // ((SpriteAnimated)this.getSprite()).setPosicaoAtual(3);
             ((SpriteAnimated)this.getSprite()).animate(3, 3, 3);
        }
        
    }

}
