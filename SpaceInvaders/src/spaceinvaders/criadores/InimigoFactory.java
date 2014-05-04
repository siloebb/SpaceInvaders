package spaceinvaders.criadores;

import java.util.logging.Level;
import java.util.logging.Logger;
import spaceinvaders.gameobjects.Inimigo;
import spaceinvaders.gameobjects.InimigoAmarelo;
import spaceinvaders.gameobjects.InimigoRosinha;
import spaceinvaders.gameobjects.InimigoVerde;
import spaceinvaders.utils.Jogo;
import spaceinvaders.utils.sprite.SpriteAnimated;

/**
 *
 * @author Siloe
 */
public class InimigoFactory {

    public Inimigo getInimigo(int posicaoX, int posicaoY, String caminho, Jogo jogo, int tipo) {

        if (tipo == 1) {
            InimigoRosinha alien1;
            try {
                alien1 = new InimigoRosinha(posicaoX, posicaoY, caminho, jogo);
                return alien1;
            } catch (Exception ex) {
                Logger.getLogger(InimigoFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (tipo == 2) {
            InimigoAmarelo alien2;
            try {
                alien2 = new InimigoAmarelo(posicaoX, posicaoY, caminho, jogo);
                return alien2;
            } catch (Exception ex) {
                Logger.getLogger(InimigoFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (tipo == 3) {
            InimigoVerde alien3;
            try {
                alien3 = new InimigoVerde(posicaoX, posicaoY, caminho, jogo);
                return alien3;
            } catch (Exception ex) {
                Logger.getLogger(InimigoFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

}
