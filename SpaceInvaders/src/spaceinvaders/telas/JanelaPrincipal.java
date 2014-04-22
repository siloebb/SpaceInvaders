package spaceinvaders.telas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JFrame;
import spaceinvaders.utils.GameObject;
import spaceinvaders.utils.sprite.Background;

/**
 *
 * @author Siloe
 */
public class JanelaPrincipal extends JComponent {

    private ArrayList<Background> backgroundList;
    private ArrayList<GameObject> gameObjectList;
    private JFrame frame;
    private static boolean frameNovo = true;

    private String tituloDoJogo = "Space Invaders";

    public JanelaPrincipal(ArrayList<GameObject> gameObjectList, ArrayList<Background> backgroundList) throws HeadlessException {
        //super("Space Invaders");
        this.gameObjectList = gameObjectList;
        this.backgroundList = backgroundList;

        this.setSize(800, 600);
        this.setVisible(true);
        this.setBackground(Color.BLACK);

        //Criando um Frame Pai, pois é necessário
        if (frameNovo == true) {
            frame = new JFrame(tituloDoJogo);            
        }
        System.out.println("Iniciando nova tela");
        
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(this);
    }

    public void alterarLista(ArrayList<GameObject> gameObjectList, ArrayList<Background> backgroundList) {
        this.gameObjectList = gameObjectList;
        this.backgroundList = backgroundList;
    }

    @Override
    public void paint(Graphics g) {

        if (backgroundList != null) {
            for (Background background : backgroundList) {
                background.print(g);
            }
        }

        if (gameObjectList != null) {
            for (GameObject go : gameObjectList) {
                if (go.getSprite() != null) {
                    go.getSprite().print(g);
                }
            }
        }

        this.repaint();
    }

    public String getTituloDoJogo() {
        return tituloDoJogo;
    }

    public void setTituloDoJogo(String tituloDoJogo) {
        this.tituloDoJogo = tituloDoJogo;
    }

}
