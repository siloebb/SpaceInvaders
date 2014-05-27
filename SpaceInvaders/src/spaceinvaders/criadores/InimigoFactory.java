package spaceinvaders.criadores;

import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import spaceinvaders.gameobjects.naves.Inimigo;
import spaceinvaders.gameobjects.naves.InimigoAmarelo;
import spaceinvaders.gameobjects.naves.InimigoRosinha;
import spaceinvaders.gameobjects.naves.InimigoVerde;
import spaceinvaders.utils.Jogo;
import spaceinvaders.utils.sprite.SpriteAnimated;

/**
 *
 * @author Siloe
 */
public class InimigoFactory {

    private Random random = new Random();

    private BufferedImage[] spRosa;
    private BufferedImage[] spAmarelo;
    private BufferedImage[] spVerde;

    public Inimigo getInimigo(int posicaoX, int posicaoY, String caminho, Jogo jogo, int tipo) {

        if (tipo == 1) {
            InimigoRosinha alien1;
            try {
                alien1 = new InimigoRosinha(posicaoX, posicaoY, caminho, jogo);
                SpriteAnimated spInimigo = new SpriteAnimated();
                if (spRosa == null) {
                    spInimigo.carregarSprite(caminho + "alien1.png", 1, 2);
                    spRosa = spInimigo.getSpriteArray();
                }
                spInimigo.carregarSprite(spRosa);
                spInimigo.setX(posicaoX);
                spInimigo.setY(posicaoY);
                //spInimigo.animate(0, 3, 15); 
                spInimigo.animate(0, 1, 15);
                alien1.setSprite(spInimigo);

                return alien1;
            } catch (Exception ex) {
                Logger.getLogger(InimigoFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (tipo == 2) {
            InimigoAmarelo alien2;
            try {
                alien2 = new InimigoAmarelo(posicaoX, posicaoY, caminho, jogo);
                SpriteAnimated spInimigo = new SpriteAnimated();
                if (spAmarelo == null) {
                    spInimigo.carregarSprite(caminho + "alien2.png", 1, 2);
                    spAmarelo = spInimigo.getSpriteArray();
                }
                spInimigo.carregarSprite(spAmarelo);
                spInimigo.setX(posicaoX);
                spInimigo.setY(posicaoY);
                //spInimigo.animate(0, 3, 15); 
                spInimigo.animate(0, 1, 15);
                alien2.setSprite(spInimigo);
                
                return alien2;
            } catch (Exception ex) {
                Logger.getLogger(InimigoFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (tipo == 3) {
            InimigoVerde alien3;
            try {
                alien3 = new InimigoVerde(posicaoX, posicaoY, caminho, jogo);
                SpriteAnimated spInimigo = new SpriteAnimated();
                if (spVerde == null) {
                    spInimigo.carregarSprite(caminho + "alien3.png", 1, 4);
                    spVerde = spInimigo.getSpriteArray();
                }
                spInimigo.carregarSprite(spVerde);
                spInimigo.setX(posicaoX);
                spInimigo.setY(posicaoY);
                spInimigo.animate(0, 3, 15);                
                alien3.setSprite(spInimigo);

                return alien3;
            } catch (Exception ex) {
                Logger.getLogger(InimigoFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

}
