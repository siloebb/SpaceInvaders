package spaceinvaders.gameobjects.botoes;

import java.awt.event.KeyEvent;
import spaceinvaders.Resolucao;
import spaceinvaders.SpaceInvaders;
import spaceinvaders.utils.GameObject;
import static spaceinvaders.utils.GameObject.keyPressed;
import spaceinvaders.utils.sprite.SpriteAnimated;

/**
 *
 * @author Siloe
 */
public class Menu extends GameObject {

    private SpaceInvaders spInvaders;
    private Resolucao resolucao;
    private int opcao = 0;
    private int contadorDelay = 0;
    private boolean precisaSair = false;

    public Menu(SpaceInvaders spInvaders) throws Exception {
        this.spInvaders = spInvaders;
        resolucao = Resolucao.getInstance();
        ;

        SpriteAnimated spMenu = new SpriteAnimated();
        spMenu.carregarSprite("src/assets_800x600/" + "menu.png", 4, 1);
        spMenu.setX(resolucao.getPosicaoBotoes()[0]);
        spMenu.setY(resolucao.getPosicaoBotoes()[1]);

        this.sprite = spMenu;
    }

    @Override
    public void update() {
        if (contadorDelay > 0) {
            contadorDelay--;
        }

        if (keyPressed == KeyEvent.VK_DOWN && !precisaSair) {
            if (opcao < 2 && contadorDelay <= 0) {
                opcao += 1;
                ((SpriteAnimated) this.getSprite()).setPosicaoAtual(opcao);
                ((SpriteAnimated) this.getSprite()).setPosicaoInicial(opcao);
                ((SpriteAnimated) this.getSprite()).setPosicaoFinal(opcao);
                System.out.println("Teste " + opcao);

                //dah um delay de 15 frames para não sair pulando os botões
                contadorDelay = 15;
            }
        }
        if (keyPressed == KeyEvent.VK_UP && !precisaSair) {
            if (opcao > 0 && contadorDelay <= 0) {
                opcao -= 1;
                ((SpriteAnimated) this.getSprite()).setPosicaoAtual(opcao);
                ((SpriteAnimated) this.getSprite()).setPosicaoInicial(opcao);
                ((SpriteAnimated) this.getSprite()).setPosicaoFinal(opcao);
                
                //dah um delay de 15 frames para não sair pulando os botões
                contadorDelay = 15;
            }
        }

        if (keyPressed == KeyEvent.VK_ESCAPE) {
            precisaSair = false;
            spInvaders.mostrarBGNormal();
            opcao = 0;

            ((SpriteAnimated) this.getSprite()).setPosicaoAtual(opcao);
            ((SpriteAnimated) this.getSprite()).setPosicaoInicial(opcao);
            ((SpriteAnimated) this.getSprite()).setPosicaoFinal(opcao);
        }

        if (keyPressed == KeyEvent.VK_ENTER && !precisaSair) {
            if (opcao == 0) {
                System.out.println("Iniciando jogo");
                spInvaders.iniciarJogo();
                System.out.println("Jogo carregado");
            } else if (opcao == 1) {
                spInvaders.mostrarAjuda();

                ((SpriteAnimated) this.getSprite()).setPosicaoAtual(3);
                ((SpriteAnimated) this.getSprite()).setPosicaoInicial(3);
                ((SpriteAnimated) this.getSprite()).setPosicaoFinal(3);
                
                precisaSair = true;

            } else if (opcao == 2) {
                spInvaders.mostrarSobre();
                
                ((SpriteAnimated) this.getSprite()).setPosicaoAtual(3);
                ((SpriteAnimated) this.getSprite()).setPosicaoInicial(3);
                ((SpriteAnimated) this.getSprite()).setPosicaoFinal(3);
                
                precisaSair = true;
            }
        }
    }

}
