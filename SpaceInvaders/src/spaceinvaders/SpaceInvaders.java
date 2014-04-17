
package spaceinvaders;

import spaceinvaders.utils.Jogo;
import java.util.logging.Level;
import java.util.logging.Logger;
import spaceinvaders.gameobjects.Nave;
import spaceinvaders.utils.GameObject;
import spaceinvaders.utils.sprite.SpriteAnimated;

/**
 *
 * @author Siloe
 */
public class SpaceInvaders {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Jogo jogo = new Jogo();
        
        
        GameObject nave = new Nave();
        
        SpriteAnimated spNave;
        spNave = new SpriteAnimated();
        try {
            spNave.carregarSprite("src/assets/nave1.png", 1, 2);
            spNave.setX(30);
            spNave.setY(300);
        } catch (Exception ex) {
            Logger.getLogger(SpaceInvaders.class.getName()).log(Level.SEVERE, null, ex);
        }
        nave.setSprite(spNave);
        
        jogo.addGameObject(nave);
        
        
        jogo.start();
    }
    
}
