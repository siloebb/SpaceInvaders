/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spaceinvaders.gameobjects.elemetos_fase;

import java.util.logging.Level;
import java.util.logging.Logger;
import spaceinvaders.utils.GameObject;
import spaceinvaders.utils.sprite.SpriteAnimated;

/**
 *
 * @author Siloe
 */
public class Explosao extends GameObject{
    
    private int contador = 0;
    private int time = 10;

    public Explosao(int x, int y) {
        try {
            SpriteAnimated spExplosion = new SpriteAnimated();
            spExplosion.carregarSprite("src/assets_800x600/" + "explosao.png", 4, 4);
            spExplosion.setX(x);
            spExplosion.setY(y);
            spExplosion.animate(0, 15, time);
            this.sprite = spExplosion;
        } catch (Exception ex) {
            Logger.getLogger(Explosao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update() {
        if(contador > ((SpriteAnimated)sprite).getPosicaoFinal() * time){
            this.selfDestroy();
        }
        contador++;
    }
    
    
    
}
