package spaceinvaders;

import java.awt.Color;
import spaceinvaders.utils.Jogo;
import java.util.logging.Level;
import java.util.logging.Logger;
import spaceinvaders.gameobjects.BotaoAjuda;
import spaceinvaders.gameobjects.BotaoIniciar;
import spaceinvaders.gameobjects.BotaoSobre;
import spaceinvaders.gameobjects.GeradorDeEventos;
import spaceinvaders.gameobjects.Life;
import spaceinvaders.gameobjects.Nave;
import spaceinvaders.gameobjects.Parede;
import spaceinvaders.gameobjects.Score;
import spaceinvaders.telas.Tela1;
import spaceinvaders.utils.GameObject;
import spaceinvaders.utils.sprite.BackgroundImage;
import spaceinvaders.utils.sprite.Sprite;
import spaceinvaders.utils.sprite.SpriteAnimated;
import spaceinvaders.utils.sprite.Texto;

/**
 *
 * @author Siloe
 */
public class SpaceInvaders {

    /**
     * @param args the command line arguments
     */
    private Resolucao resolucao;

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
        GameObject btAjuda = new BotaoAjuda(sp);
        GameObject btSobre = new BotaoSobre(sp);

        Sprite spIniciar;
        Sprite spAjuda;
        Sprite spSobre;

        spIniciar = new Sprite();
        spAjuda = new Sprite();
        spSobre = new Sprite();

        try {
            spIniciar.carregarSprite(resolucao.getCaminho() + "button.png"); //ver comentários da classe Resolucao
            spIniciar.setX(resolucao.getPosicaoBotoes()[0]);
            spIniciar.setY(resolucao.getPosicaoBotoes()[1]);
        } catch (Exception ex) {
            Logger.getLogger(SpaceInvaders.class.getName()).log(Level.SEVERE, null, ex);
        }
        btIniciar.setSprite(spIniciar);
        menuJogo.addGameObject(btIniciar);

        BackgroundImage bg = new BackgroundImage(resolucao.getCaminho() + "background_com_titulo.png");
        try {
            menuJogo.addBackground(bg);
        } catch (Exception ex) {
            Logger.getLogger(SpaceInvaders.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            spAjuda.carregarSprite(resolucao.getCaminho() + "button2.png");
            spAjuda.setX(resolucao.getPosicaoBotoes()[0]);
            spAjuda.setY(resolucao.getPosicaoBotoes()[2]);
        } catch (Exception ex) {
            Logger.getLogger(SpaceInvaders.class.getName()).log(Level.SEVERE, null, ex);
        }
        btAjuda.setSprite(spAjuda);
        menuJogo.addGameObject(btAjuda);

        try {
            spSobre.carregarSprite(resolucao.getCaminho() + "button3.png");
            spSobre.setX(resolucao.getPosicaoBotoes()[0]);
            spSobre.setY(resolucao.getPosicaoBotoes()[3]);
        } catch (Exception ex) {
            Logger.getLogger(SpaceInvaders.class.getName()).log(Level.SEVERE, null, ex);
        }
        btSobre.setSprite(spSobre);
        menuJogo.addGameObject(btSobre);

        menuJogo.start();
    }

    public void iniciarJogo() {
        Jogo jogo = new Jogo(resolucao.getTamanhoTela()); //a resolução definida para a tela agora é parametro

        Nave nave = new Nave(jogo);

        ///Adicionando nave
        SpriteAnimated spNave;
        spNave = new SpriteAnimated();

        try {
            spNave.carregarSprite(resolucao.getCaminho() + "/nave.png", 1, 4);
            spNave.setX(resolucao.getPosicaoNave()[0]);
            spNave.setY(resolucao.getPosicaoNave()[1]);
            spNave.animate(0, 1, 15);
        } catch (Exception ex) {
            Logger.getLogger(SpaceInvaders.class.getName()).log(Level.SEVERE, null, ex);
        }
        nave.setSprite(spNave);

        jogo.addColisaoListener(nave);
        jogo.addGameObject(nave);

        BackgroundImage bg = new BackgroundImage(resolucao.getCaminho() + "background.png");
        try {
            jogo.addBackground(bg);
        } catch (Exception ex) {
            Logger.getLogger(SpaceInvaders.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Criando barra de life
        Life life = new Life(resolucao);
        jogo.addGameObject(life);

        nave.addNaveListener(life);

        //Cirando Paredes invisivéis para colisão
        Parede parede = new Parede();
        Parede paredeDireita = new Parede();

        parede.setHeight(resolucao.getTamanhoTela()[1]);
        parede.setWidth(2);
        parede.setX(0);
        parede.setY(0);
        parede.setTag("paredeDaEsquerda");
        jogo.addGameObject(parede);
        jogo.addColisaoListener(parede);

        paredeDireita.setHeight(resolucao.getTamanhoTela()[1]);
        paredeDireita.setWidth(2);
        paredeDireita.setX(resolucao.getTamanhoTela()[0]);
        paredeDireita.setY(0);
        paredeDireita.setTag("paredeDaDireita");
        jogo.addGameObject(paredeDireita);
        jogo.addColisaoListener(paredeDireita);

        //Adicionando score
        Score score = new Score("Score: 0", 20, 30, 40);
        try {
            jogo.addText(score);
        } catch (Exception ex) {
            Logger.getLogger(SpaceInvaders.class.getName()).log(Level.SEVERE, null, ex);
        }

        GeradorDeEventos ge = new GeradorDeEventos(resolucao, jogo, score);
        jogo.addGameObject(ge);

        //Iniciando Jogo
        jogo.start();

    }

    public void mostrarAjuda() {
        Jogo ajudaJogo = new Jogo(resolucao.getTamanhoTela()); //a resolução definida para a tela agora é parametro

        BackgroundImage bg = new BackgroundImage(resolucao.getCaminho() + "background_com_menu_ajuda.png");
        try {
            ajudaJogo.addBackground(bg);
        } catch (Exception ex) {
            Logger.getLogger(SpaceInvaders.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mostrarSobre() {
        Jogo sobreJogo = new Jogo(resolucao.getTamanhoTela()); //a resolução definida para a tela agora é parametro
        BackgroundImage bg = new BackgroundImage(resolucao.getCaminho() + "background_com_titulo.png");
        try {
            sobreJogo.addBackground(bg);
        } catch (Exception ex) {
            Logger.getLogger(SpaceInvaders.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
