package spaceinvaders.utils;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import spaceinvaders.telas.JanelaPrincipal;
import spaceinvaders.utils.sprite.Background;

/**
 *
 * @author Siloe
 */
public class Jogo extends Thread{

    private static JanelaPrincipal janela;
    private boolean pause = false;
    private int keyPressed;

    private static ArrayList<GameObject> listaGameObject;
    private static ArrayList<Background> listaBackground;

    KeyAdapter ka;

    public Jogo() {
        iniciarJogo();
    }

    private void iniciarJogo() {
        listaGameObject = new ArrayList<>();
        listaBackground = new ArrayList<>();
        
        if(janela == null){
            janela = new JanelaPrincipal(listaGameObject, listaBackground);
        }else{
            janela.alterarLista(listaGameObject, listaBackground);
        }

        janela.requestFocus();

        //Capturando entrada de botões
        keyPressed = 0;

        if (ka == null) {
            ka = new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent ev) {
                    Jogo.this.keyPressed = ev.getKeyCode();

                }
            };

            janela.addKeyListener(ka);
        }
        
    }

    public void addGameObject(GameObject object) {
        listaGameObject.add(object);
    }

    public void removeGameObject(GameObject object) {
        listaGameObject.remove(object);
    }

    public void addBackground(Background background) throws Exception {
        listaBackground.add(background);
    }

    public void removeBackground(Background background) throws Exception {
        listaBackground.remove(background);
    }

    /**
     * O que acontece à cada frame
     */
    private void enterFrame() {
        janela.requestFocus();
        
        for (GameObject gameObject : listaGameObject) {
            gameObject.update();
        }
    }

    public void startGame() {

        long delay = 17;
        long inicio = System.currentTimeMillis();

        //Para verificar qual o FPS que está rodando o jogo
        long delayFPS = 1000;
        long inicioFPS = System.currentTimeMillis();
        int contadorFPS = 0;

        System.out.println("PASSO 1");
        //EnterFrame
        while (true) {
            if ((System.currentTimeMillis() - inicio) > delay && pause == false) {
                //janela.repaint();
                inicio = System.currentTimeMillis();
                GameObject.keyPressed = 0;
                GameObject.keyPressed = keyPressed;
                enterFrame();

                contadorFPS++;
                keyPressed = 0;
            }

            //Mostrador do FPS
            if ((System.currentTimeMillis() - inicioFPS) > delayFPS) {
                System.out.println("FPS = " + contadorFPS);
                inicioFPS = System.currentTimeMillis();
                contadorFPS = 0;
            }
        }
    }

    @Override
    public void run() {
        //super.run();
        this.startGame();
    }
    
    

    public boolean isPause() {
        return pause;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }

}
