/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.listenners;

import java.util.EventObject;
import spaceinvaders.utils.Colisao;
import spaceinvaders.utils.GameObject;

/**
 *
 * @author suka
 */
public class ColisaoEvent extends EventObject {

    private GameObject gameObject;

    public ColisaoEvent(Colisao source, GameObject o) {
        super(source);
        this.gameObject = o;
        this.source = source;
    }

    public GameObject getGameObject() {
        return gameObject;
    }

    public void setGameObject(GameObject gameObject) {
        this.gameObject = gameObject;
    }

}
