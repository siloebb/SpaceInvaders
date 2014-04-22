package spaceinvaders;

import spaceinvaders.utils.Jogo;
import java.util.logging.Level;
import java.util.logging.Logger;
import spaceinvaders.gameobjects.BotaoIniciar;
import spaceinvaders.gameobjects.Inimigo;
import spaceinvaders.gameobjects.Nave;
import spaceinvaders.utils.GameObject;
import spaceinvaders.utils.sprite.BackgroundImage;
import spaceinvaders.utils.sprite.Sprite;
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
        SpaceInvaders sp = new SpaceInvaders();
        sp.iniciarMenu(sp);
    }

    public void iniciarMenu(SpaceInvaders sp) {
        Jogo menuJogo = new Jogo();

        GameObject btIniciar = new BotaoIniciar(sp);
        Sprite spIniciar;

        spIniciar = new Sprite();
        try {
            spIniciar.carregarSprite("src/assets_320x180/button.png");
            spIniciar.setX(300);
            spIniciar.setY(150);
        } catch (Exception ex) {
            Logger.getLogger(SpaceInvaders.class.getName()).log(Level.SEVERE, null, ex);
        }
        btIniciar.setSprite(spIniciar);

        menuJogo.addGameObject(btIniciar);
        BackgroundImage bg = new BackgroundImage("src/assets_800x600/background.png");
        try {
            menuJogo.addBackground(bg);
        } catch (Exception ex) {
            Logger.getLogger(SpaceInvaders.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        menuJogo.start();
    }

    /*Caso precise testar o inicio do jogo deixe o metodo aqui, qualquer coisa pode excluir 
     O metodo tá implementado na classe BotaoIniciar*/
    public void iniciarJogo() {
        Jogo jogo = new Jogo();

        GameObject nave = new Nave();

        ///Adicionando nave
        SpriteAnimated spNave;
        spNave = new SpriteAnimated();
        try {
            spNave.carregarSprite("src/assets_800x600/nave.png", 1, 4);
            spNave.setX(30);
            spNave.setY(300);
            spNave.animate(0, 3, 15);
        } catch (Exception ex) {
            Logger.getLogger(SpaceInvaders.class.getName()).log(Level.SEVERE, null, ex);
        }
        nave.setSprite(spNave);

        jogo.addGameObject(nave);
        //Adicionando inimigo
        Inimigo inimigo = new Inimigo();
        SpriteAnimated spInimigo = new SpriteAnimated();
        try {
            spInimigo.carregarSprite("src/assets_800x600/alien3.png", 1, 4);
            spInimigo.setX(10);
            spInimigo.setY(20);
            spInimigo.animate(0, 3, 15);
        } catch (Exception ex) {
            Logger.getLogger(SpaceInvaders.class.getName()).log(Level.SEVERE, null, ex);
        }
        inimigo.setSprite(spInimigo);
        jogo.addGameObject(inimigo);

        BackgroundImage bg = new BackgroundImage("src/assets_800x600/background.png");
        try {
            jogo.addBackground(bg);
        } catch (Exception ex) {
            Logger.getLogger(SpaceInvaders.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        jogo.start();
        
    }

}
