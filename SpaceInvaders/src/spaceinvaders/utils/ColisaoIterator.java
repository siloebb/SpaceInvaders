/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.utils;

import java.util.ArrayList;
import spaceinvaders.listenners.ColisaoListener;

/**
 *
 * @author suka
 */
public class ColisaoIterator implements Iterator<ColisaoListener> {

    private ArrayList<ColisaoListener> listaColisao;
    private int posicao = 0;

    public ColisaoIterator(ArrayList<ColisaoListener> listaColisao) {
        this.listaColisao = listaColisao;
    }

    @Override
    public boolean hasNext() {
        return listaColisao.size() > posicao ? true : false;
    }

    @Override
    public ColisaoListener next() {
        if (hasNext()) {
            ColisaoListener get = listaColisao.get(posicao);
            posicao++;
            return get;

        } else {
            return null;
        }
    }

}
