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

    ArrayList<Background> backgroundList;
    ArrayList<GameObject> gameObjectList;

    private String tituloDoJogo = "Space Invaders";

    public JanelaPrincipal(ArrayList<GameObject> gameObjectList, ArrayList<Background> backgroundList) throws HeadlessException {
        //super("Space Invaders");
        this.gameObjectList = gameObjectList;
        this.backgroundList = backgroundList;

        this.setSize(800, 600);
        this.setVisible(true);
        this.setBackground(Color.BLACK);

        //Criando um Frame Pai, pois é necessário
        JFrame frame = new JFrame(tituloDoJogo);
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(this);
    }

//    public void adicionarBackground(Background background) throws Exception {
//        if (background != null) {
//            backgroundList.add(background);
//        } else {
//            throw new Exception("Background == null");
//        }
//    }

    /*public void adicionarSprite(Sprite sprite) throws Exception {
     if (sprite != null) {
     spriteList.add(sprite);
     }else{
     throw new Exception("Sprite == null");
     }
     }*/
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
