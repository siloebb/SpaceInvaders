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

    public JanelaPrincipal(ArrayList<GameObject> gameObjectList, ArrayList<Background> backgroundList, int[] tamTela) throws HeadlessException {
        //super("Space Invaders");
        this.gameObjectList = gameObjectList;
        this.backgroundList = backgroundList;

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
        
        //Clonar a lista eh necessária para evitar erros de concorrência
        ArrayList<Background> backgroundListClone = new ArrayList<>();
        backgroundListClone.addAll(backgroundList);

        if (backgroundListClone != null) {
            for (Background background : backgroundListClone) {
                background.print(g);
            }
        }
        
        ArrayList<GameObject> gameObjectListClone = new ArrayList<>();
        gameObjectListClone.addAll(gameObjectList);

        if (gameObjectListClone != null) {
            for (GameObject go : gameObjectListClone) {
                if (go.getSprite() != null) {
                    go.getSprite().print(g);
                }
            }
        }

        //this.repaint();
    }

    public String getTituloDoJogo() {
        return tituloDoJogo;
    }

    public void setTituloDoJogo(String tituloDoJogo) {
        this.tituloDoJogo = tituloDoJogo;
    }

}
