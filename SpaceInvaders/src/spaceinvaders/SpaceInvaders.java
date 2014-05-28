package spaceinvaders;

import spaceinvaders.utils.Jogo;
import java.util.logging.Level;
import java.util.logging.Logger;
import spaceinvaders.gameobjects.botoes.Menu;
import spaceinvaders.gameobjects.elemetos_fase.GeradorDeEventos;
import spaceinvaders.gameobjects.elemetos_fase.Life;
import spaceinvaders.gameobjects.naves.Nave;
import spaceinvaders.gameobjects.elemetos_fase.Parede;
import spaceinvaders.gameobjects.elemetos_fase.Score;
import spaceinvaders.telas.Tela1;
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
    private Resolucao resolucao = Resolucao.getInstance();
    private Jogo jogo;
    private BackgroundImage bgMenu;
    private Menu menu;

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

        resolucao.definirResolucao(resolucao_escolhida);
        resolucao.setSpaceInvaders(sp);
        sp.iniciarMenu(sp);
    }

    public void iniciarMenu(SpaceInvaders sp) {
        Jogo menuJogo = new Jogo(resolucao.getTamanhoTela()); //a resolução definida para a tela agora é parametro
        
        bgMenu = new BackgroundImage(resolucao.getCaminho() + "background_com_titulo.png");
        try {
            menuJogo.addBackground(bgMenu);
        } catch (Exception ex) {
            Logger.getLogger(SpaceInvaders.class.getName()).log(Level.SEVERE, null, ex);
        }

        menu = null;
        try {
            menu = new Menu(sp);
        } catch (Exception ex) {
            Logger.getLogger(SpaceInvaders.class.getName()).log(Level.SEVERE, null, ex);
        }
        menuJogo.addGameObject(menu);

        menuJogo.start();
    }

    public void iniciarJogo() {
        jogo = new Jogo(resolucao.getTamanhoTela()); //a resolução definida para a tela agora é parametro

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
        Life life = new Life();
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
        Score score = new Score("Score: 0", resolucao.getPosiScore()[0], resolucao.getPosiScore()[1], resolucao.getPosiScore()[2]);
        try {
            jogo.addText(score);
        } catch (Exception ex) {
            Logger.getLogger(SpaceInvaders.class.getName()).log(Level.SEVERE, null, ex);
        }

        GeradorDeEventos ge = new GeradorDeEventos(jogo, score);
        jogo.addGameObject(ge);

        //Iniciando Jogo
        jogo.start();
    }

    public void finalizarJogo() {
        jogo.finalizarJogo();
    }

    public void mostrarAjuda() {
        bgMenu.carregarSprite(resolucao.getCaminho() + "background_com_menu_ajuda.png");
    }

    public void mostrarSobre() {
        bgMenu.carregarSprite(resolucao.getCaminho() + "background_creditos.png");        
    }
    
    public void mostrarBGNormal() {
        bgMenu.carregarSprite(resolucao.getCaminho() + "background_com_titulo.png");        
    }
}
