/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spaceinvaders.gameobjects.tiro;
import spaceinvaders.Resolucao;
import spaceinvaders.gameobjects.elemetos_fase.Explosao;
import spaceinvaders.gameobjects.naves.Nave;
import spaceinvaders.listenners.ColisaoEvent;
import spaceinvaders.listenners.ColisaoListener;
import spaceinvaders.utils.GameObject;
import spaceinvaders.utils.Jogo;
import spaceinvaders.utils.sprite.SpriteAnimated;
/**
 *
 * @author Siloe
 */
public class TiroInimigo extends GameObject implements ColisaoListener{

    private Jogo jogo;
    private Resolucao resolucao;
    
    public TiroInimigo(Jogo jogo) throws Exception {
        
        this.jogo = jogo;
        
        this.resolucao = Resolucao.getInstance();
    }

    @Override
    public void update() {
        super.update(); 
        this.setY(this.getY() + 2);
        
        if(this.getY() > resolucao.getAlturaTela()){
            this.selfDestroy();
        }
    }
    
    
    @Override
    public void colidiu(ColisaoEvent c) {
        //Verifica se a tag tem o nome inimigo, se tiver cria uma explosão e auto destroi os 2
        if (c.getGameObject().getTag().equals("nave")) {
            Explosao explosao;
            explosao = new Explosao(c.getGameObject().getX(), c.getGameObject().getY());
            jogo.addGameObject(explosao);
            //c.getGameObject().selfDestroy();
            ((Nave)c.getGameObject()).perderLife();
            this.selfDestroy();
        }
    }
    
    
}
