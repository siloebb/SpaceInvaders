package spaceinvaders.utils;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import spaceinvaders.telas.JanelaPrincipal;
import spaceinvaders.utils.sprite.Background;
import spaceinvaders.listenners.ColisaoListener;
import spaceinvaders.utils.sprite.Texto;

/**
 *
 * @author Siloe
 */
public class Jogo extends Thread {

    private static JanelaPrincipal janela;
    private boolean pause = false;
    private boolean finalizarJogo = false;
    private int keyPressed = 0;
    private Colisao colisao;

    private static ArrayList<GameObject> listaGameObject;
    private static ArrayList<Background> listaBackground;
    private static ArrayList<Texto> listaText;

    KeyAdapter ka;

    // o construtor passa a ter um parametro que será enviado a janela
    public Jogo(int[] tamTela) {
        iniciarJogo(tamTela);
    }

    private void iniciarJogo(int[] tamTela) {
        listaGameObject = new ArrayList<>();
        listaBackground = new ArrayList<>();
        listaText = new ArrayList<>();
        colisao = new Colisao();

        if (janela == null) {
            janela = new JanelaPrincipal(listaGameObject, listaBackground, listaText, tamTela); //janela tem mais um parametro
        } else {
            janela.alterarLista(listaGameObject, listaBackground, listaText);
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

                @Override
                public void keyReleased(KeyEvent e) {
                    Jogo.this.keyPressed = 0;
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

    public void addText(Texto texto) throws Exception {
        listaText.add(texto);
    }

    public void removeText(Texto texto) throws Exception {
        listaText.remove(texto);
    }

    public synchronized void addColisaoListener(ColisaoListener c) {
        colisao.addColisaoListener(c);
    }

    public synchronized void removeColisaoListener(ColisaoListener c) {
        colisao.removeColisaoListener(c);
    }

    /**
     * O que acontece à cada frame
     */
    private void enterFrame() {
        //Clonar a lista eh necessário para evitar erros de concorrência
        ArrayList<GameObject> listaClone = new ArrayList<>();
        listaClone.addAll(listaGameObject);

        for (GameObject gameObject : listaClone) {
            if (gameObject != null) {
                gameObject.update();
            }
        }
        colisao.verificarColisao();

        //Varre para ver se tem algum objeto para destruir
        for (GameObject gameObject : listaClone) {
            if (gameObject != null) {
                if (gameObject.isFlagSelfDestroy()) {
                    try {
                        //ele tenta tirar do colisionador
                        if (gameObject instanceof ColisaoListener) {
                            colisao.removeColisaoListener((ColisaoListener) gameObject);
                            //System.out.println("Arrancando da colisão");
                        }
                    } catch (Exception e) {
                        //Não faz nada
                        e.printStackTrace();
                    }
                    listaGameObject.remove(gameObject);
                    gameObject = null;
                }
            }
        }
        listaClone = null;

        janela.requestFocus();
        janela.repaint();
    }

    public void startGame() {

        long delay = 17;
        long inicio = System.currentTimeMillis();

        //Para verificar qual o FPS que está rodando o jogo
        long delayFPS = 1000;
        long inicioFPS = System.currentTimeMillis();
        int contadorFPS = 0;

        //EnterFrame
        while (!finalizarJogo) {
            if ((System.currentTimeMillis() - inicio) > delay && pause == false) {

                inicio = System.currentTimeMillis();

                //pega o botão pressionado
                GameObject.keyPressed = keyPressed;

                //atulaiza e repinta o jogo
                enterFrame();

                contadorFPS++;
            }

//            //Mostrador do FPS
//            if ((System.currentTimeMillis() - inicioFPS) > delayFPS) {
//                System.out.println("FPS = " + contadorFPS);
//                inicioFPS = System.currentTimeMillis();
//                contadorFPS = 0;
//            }
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

    public void finalizarJogo() {
        this.finalizarJogo = true;
        try {
            this.join(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Jogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
