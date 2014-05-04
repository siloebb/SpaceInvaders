
package spaceinvaders.criadores;

import java.util.logging.Level;
import java.util.logging.Logger;
import spaceinvaders.gameobjects.Inimigo;
import spaceinvaders.gameobjects.InimigoRosinha;
import spaceinvaders.utils.Jogo;
import spaceinvaders.utils.sprite.SpriteAnimated;

/**
 *
 * @author Siloe
 */
public class InimigoFactory {
    
    public Inimigo getInimigo(int posicaoX, int posicaoY, String caminho, Jogo jogo) {
        int alien = (int) (Math.random() * 100);
        //if (alien >= 0 && alien < 33) {
            InimigoRosinha alien1;
        try {
            alien1 = new InimigoRosinha(posicaoX, posicaoY, caminho, jogo);
            return alien1;
        } catch (Exception ex) {
            Logger.getLogger(InimigoFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
            
         
          return null;
        }
        
    
}



