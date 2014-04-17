package spaceinvaders.utils;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import spaceinvaders.telas.JanelaPrincipal;
import spaceinvaders.utils.GameObject;
import spaceinvaders.utils.sprite.BackgroundImage;

/**
 *
 * @author Siloe
 */
public class Jogo {

    JanelaPrincipal janela;
    boolean pause = false;
    int keyPressed;

    ArrayList<GameObject> listaGameObject;

    public Jogo() {
        iniciarJogo();
    }

    private void iniciarJogo() {
        listaGameObject = new ArrayList<>();
        janela = new JanelaPrincipal(listaGameObject);

        BackgroundImage bg = new BackgroundImage("src/assets/background.jpg");

        try {
            janela.adicionarBackground(bg);
        } catch (Exception ex) {
            Logger.getLogger(Jogo.class.getName()).log(Level.SEVERE, null, ex);
        }

        janela.requestFocus();

        //Capturando entrada de botões
        keyPressed = 0;
        janela.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ev) {
                Jogo.this.keyPressed = ev.getKeyCode();
                
            }
        });
    }

    public void addGameObject(GameObject object) {
        listaGameObject.add(object);
    }

    public void removeGameObject(GameObject object) {
        listaGameObject.remove(object);
    }

    /**
     * O que acontece à cada frame
     */
    private void enterFrame() {
        for (GameObject gameObject : listaGameObject) {
            gameObject.update();
        }
    }

    public void start() {

        long delay = 17;
        long inicio = System.currentTimeMillis();

        //Para verificar qual o FPS que está rodando o jogo
        long delayFPS = 1000;
        long inicioFPS = System.currentTimeMillis();
        int contadorFPS = 0;

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

    public boolean isPause() {
        return pause;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }

}
