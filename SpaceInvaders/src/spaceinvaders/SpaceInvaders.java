package spaceinvaders;

import spaceinvaders.utils.Jogo;
import java.util.logging.Level;
import java.util.logging.Logger;
import spaceinvaders.gameobjects.BotaoAjuda;
import spaceinvaders.gameobjects.BotaoIniciar;
import spaceinvaders.gameobjects.Inimigo;
import spaceinvaders.gameobjects.Nave;
import spaceinvaders.telas.Tela1;
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
    
    private   Resolucao resolucao;
    
    public static void main(String[] args) {
        SpaceInvaders sp = new SpaceInvaders();
        
        /*
        * Em vez de chamar o metodo iniciarMenu, é chamada a tela para o usuário
        * definir a resolução padrão
        */
        
        Tela1 tela = new Tela1(sp);
        tela.setVisible(true);
    }

     public void selecionarResolucao(SpaceInvaders sp, String resolucao_escolhida) {
        /*
        * quando o usuário define a resolução Tela1 chama este método
        * acoplamento mode on
        * isso não é elegante, mas por enquanto resolve o problema
        */
        resolucao = new Resolucao(resolucao_escolhida);
        
        resolucao.definirPosicoes();
        sp.iniciarMenu(sp);
    }   
    
    
     public void iniciarMenu(SpaceInvaders sp) {
        Jogo menuJogo = new Jogo(resolucao.getTamanhoTela()); //a resolução definida para a tela agora é parametro

        GameObject btIniciar = new BotaoIniciar(sp);
        GameObject btAjuda = new BotaoAjuda();
        Sprite spIniciar;
        Sprite spAjuda;
        
        spIniciar = new Sprite();
        spAjuda = new Sprite();
        try {
            spIniciar.carregarSprite(resolucao.getCaminho()+"button.png"); //ver comentários da classe Resolucao
            spIniciar.setX(resolucao.getPosicaoBotoes()[0]);
            spIniciar.setY(resolucao.getPosicaoBotoes()[1]);
        } catch (Exception ex) {
            Logger.getLogger(SpaceInvaders.class.getName()).log(Level.SEVERE, null, ex);
        }
        btIniciar.setSprite(spIniciar);

        menuJogo.addGameObject(btIniciar);
        
       BackgroundImage bg = new BackgroundImage(resolucao.getCaminho() +"background.png");
        try {
            menuJogo.addBackground(bg);
        } catch (Exception ex) {
            Logger.getLogger(SpaceInvaders.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            spAjuda.carregarSprite(resolucao.getCaminho()+"button2.png");
            spAjuda.setX(resolucao.getPosicaoBotoes()[0]);
            spAjuda.setY(resolucao.getPosicaoBotoes()[2]);
        } catch (Exception ex) {
            Logger.getLogger(SpaceInvaders.class.getName()).log(Level.SEVERE, null, ex);
        }
        btAjuda.setSprite(spAjuda);
        menuJogo.addGameObject(btAjuda);
        
        menuJogo.start();
    }

   
    public void iniciarJogo() {
       Jogo jogo = new Jogo(resolucao.getTamanhoTela()); //a resolução definida para a tela agora é parametro


        GameObject nave = new Nave();

        ///Adicionando nave
        SpriteAnimated spNave;
        spNave = new SpriteAnimated();
        try {
           spNave.carregarSprite(resolucao.getCaminho() +"/nave.png", 1, 4);
            spNave.setX(resolucao.getPosicaoNave()[0]);
            spNave.setY(resolucao.getPosicaoNave()[1]);
            spNave.animate(0, 1, 15);
        } catch (Exception ex) {
            Logger.getLogger(SpaceInvaders.class.getName()).log(Level.SEVERE, null, ex);
        }
        nave.setSprite(spNave);

        jogo.addGameObject(nave);
        //Adicionando inimigo
        Inimigo inimigo = new Inimigo();
        SpriteAnimated spInimigo = new SpriteAnimated();
        try {
            spInimigo.carregarSprite(resolucao.getCaminho() + "alien3.png", 1, 4);
            spInimigo.setX(resolucao.getPosicaoInimigo()[0]);
            spInimigo.setY(resolucao.getPosicaoInimigo()[8]);
            spInimigo.animate(0, 3, 15);
        } catch (Exception ex) {
            Logger.getLogger(SpaceInvaders.class.getName()).log(Level.SEVERE, null, ex);
        }
        inimigo.setSprite(spInimigo);
        jogo.addGameObject(inimigo);

        BackgroundImage bg = new BackgroundImage(resolucao.getCaminho()+"background.png");
        try {
            jogo.addBackground(bg);
        } catch (Exception ex) {
            Logger.getLogger(SpaceInvaders.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        jogo.start();
        
    }

}
