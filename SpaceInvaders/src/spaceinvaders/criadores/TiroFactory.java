package spaceinvaders.criadores;

import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import spaceinvaders.Resolucao;
import spaceinvaders.gameobjects.tiro.TiroAmigo;
import spaceinvaders.gameobjects.tiro.TiroInimigo;
import spaceinvaders.utils.Jogo;
import spaceinvaders.utils.sprite.SpriteAnimated;

/**
 *
 * @author Siloe
 */
public class TiroFactory {

    private BufferedImage[] biAmigo;
    private BufferedImage[] biInimigo;
    private Resolucao resolucao;

    public TiroInimigo getTiroInimigo(Jogo jogo, int x, int y) {
        try {
            TiroInimigo tiroInimigo = new TiroInimigo(jogo);
            resolucao = Resolucao.getInstance();
            
            SpriteAnimated spTiro = new SpriteAnimated();
            if(biInimigo == null){
                spTiro.carregarSprite(resolucao.getCaminho() + "tiro_inimigo.png", 1, 2);
                biInimigo = spTiro.getSpriteArray();
            }else{
                spTiro.carregarSprite(biInimigo);
            }
            
            spTiro.animate(0, 1, 15);
            tiroInimigo.setSprite(spTiro);
            tiroInimigo.setX(x);
            tiroInimigo.setY(y);
            
            return tiroInimigo;
        } catch (Exception ex) {
            Logger.getLogger(TiroFactory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

   /* public TiroAmigo getTiroAmigo() {

    }*/

}
