/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spaceinvaders.gameobjects;

import java.awt.Color;
import spaceinvaders.listenners.InimigoEvent;
import spaceinvaders.listenners.InimigoListener;
import spaceinvaders.utils.sprite.Texto;

/**
 *
 * @author Siloe
 */
public class Score extends Texto implements InimigoListener{
    
    private int pontuacao;

    public Score(String texto, int x, int y, int size) {
        super(texto, x, y, size);
        this.setColor(Color.WHITE);
    }

    @Override
    public void inimigoMorreu(InimigoEvent e) {
        this.setPontuacao(this.getPontuacao() + e.getPontos());
        this.setTexto("Score: "+this.getPontuacao());
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
    
}
