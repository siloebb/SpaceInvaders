package spaceinvaders.telas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JFrame;
import spaceinvaders.utils.GameObject;
import spaceinvaders.utils.sprite.Background;
import spaceinvaders.utils.sprite.Texto;

/**
 *
 * @author Siloe
 */
public class JanelaPrincipal extends JComponent {

    private ArrayList<Background> backgroundList;
    private ArrayList<GameObject> gameObjectList;
    private ArrayList<Texto> texttList;
    private JFrame frame;
    private static boolean frameNovo = true;

    private String tituloDoJogo = "Space Invaders";

    public JanelaPrincipal(ArrayList<GameObject> gameObjectList, ArrayList<Background> backgroundList,
            ArrayList<Texto> texttList, int[] tamTela) throws HeadlessException {
        //super("Space Invaders");
        this.gameObjectList = gameObjectList;
        this.backgroundList = backgroundList;
        this.texttList = texttList;

        this.setSize(tamTela[0], tamTela[1]); //agora o tamanho é definido assim
        this.setVisible(true);
        this.setBackground(Color.BLACK);

        //Criando um Frame Pai, pois é necessário
        if (frameNovo == true) {
            frame = new JFrame(tituloDoJogo);
        }
        System.out.println("Iniciando nova tela");

        frame.setSize(tamTela[0], tamTela[1]);//agora o tamanho é definido assim
        frame.setVisible(true);
        //frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(this);
    }

    public void alterarLista(ArrayList<GameObject> gameObjectList, ArrayList<Background> backgroundList,
            ArrayList<Texto> textList) {
        this.gameObjectList = gameObjectList;
        this.backgroundList = backgroundList;
        this.texttList = textList;

    }

    @Override
    public void paint(Graphics g) {

        //Clonar a lista eh necessária para evitar erros de concorrência
        ArrayList<Background> backgroundListClone = new ArrayList<>();
        backgroundListClone.addAll(backgroundList);

        if (backgroundListClone != null) {
            for (Background background : backgroundListClone) {
                background.print(g);
            }
        }
        backgroundListClone = null;

        ArrayList<GameObject> gameObjectListClone = new ArrayList<>();
        gameObjectListClone.addAll(gameObjectList);

        if (gameObjectListClone != null) {
            for (GameObject go : gameObjectListClone) {
                if (go != null) {
                    if (go.getSprite() != null) {
                        go.getSprite().print(g);
                    }
                }
            }
        }

        gameObjectListClone = null;

        ArrayList<Texto> textListClone = new ArrayList<>();
        textListClone.addAll(texttList);

        if (textListClone != null) {
            for (Texto t : textListClone) {
                if (t != null) {
                    t.print(g);
                }
            }
        }

        textListClone = null;

        //this.repaint();
    }

    public String getTituloDoJogo() {
        return tituloDoJogo;
    }

    public void setTituloDoJogo(String tituloDoJogo) {
        this.tituloDoJogo = tituloDoJogo;
    }

}
