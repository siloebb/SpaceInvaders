/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.gameobjects;

import spaceinvaders.listenner.ColisaoEvent;
import spaceinvaders.listenner.ColisaoListenner;
import spaceinvaders.utils.GameObject;

/**
 *
 * @author Siloe
 */
public class Inimigo extends GameObject implements ColisaoListenner {

    @Override
    public void update() {
        this.setY(this.getY() + 2);

    }

    @Override
    public void colidiu(ColisaoEvent c) {
        try{
        if(((GameObject)c.getGameObject()).getTag().equals("nave")){
            System.out.println("EU BATIIIIIIIIII!!!");
        }
        else{
            System.out.println("coisa eh:" + ((GameObject)c.getSource()).getTag());
        }
        } catch ( Exception e){
        //   e.getMessage();
        }
    }

}
