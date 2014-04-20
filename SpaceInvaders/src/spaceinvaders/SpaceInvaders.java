
package spaceinvaders;

import spaceinvaders.utils.Jogo;
import java.util.logging.Level;
import java.util.logging.Logger;
import spaceinvaders.gameobjects.Inimigo;
import spaceinvaders.gameobjects.Nave;
import spaceinvaders.utils.GameObject;
import spaceinvaders.utils.sprite.BackgroundImage;
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
        
        ///Adicionando nave
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
        //Adicionando inimigo
        Inimigo inimigo = new Inimigo();
        SpriteAnimated spInimigo = new SpriteAnimated();
        try {
            spInimigo.carregarSprite("src/assets_800x600/alien3.png",1,4);
            spInimigo.setX(10);
            spInimigo.setY(20);
            spInimigo.animate(0,3);
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
