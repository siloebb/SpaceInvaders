/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spaceinvaders.gameobjects;

import spaceinvaders.listenners.ColisaoEvent;
import spaceinvaders.listenners.ColisaoListenner;
import spaceinvaders.utils.GameObject;

/**
 *
 * @author suka
 */
public class Parede extends GameObject implements ColisaoListenner{
    private int height;
    private int width;
    private int x;
    private int y;
    
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public void setHeight(int h){
        this.height = h;
    }
    public void setWidth(int w){
        this.width = w;
    }
    public int getHeight(){
        return this.height;
    }
    public int getWidth(){
        return this.width;
    }

    @Override
    public void colidiu(ColisaoEvent c) {
       // System.out.println("bati na parede! que coisa!!");
    }
            
}
