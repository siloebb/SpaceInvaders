/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.gameobjects;

import java.util.logging.Level;
import java.util.logging.Logger;
import spaceinvaders.utils.GameObject;
import spaceinvaders.utils.Jogo;
import spaceinvaders.Resolucao;
import spaceinvaders.criadores.InimigoFactory;

/**
 *
 * @author Bianca Super deselegante e acoplado isso aqui gera inimigos
 * randomicos em posições randomicas classe para testar a implementação da
 * funcionalidade
 *
 */
public class GeradorDeEventos extends GameObject {

    private Resolucao resolucao;
    private Jogo jogo;
    private int time, tipo;
    private InimigoFactory fabricaDeInimigo;
    private Score score;

    public GeradorDeEventos( Jogo jogo, Score score) {
        fabricaDeInimigo = new InimigoFactory();
        this.resolucao = Resolucao.getInstance();
        this.jogo = jogo;
        this.score = score;
        time = 0;
        tipo = 0;
    }

    @Override
    public void update() {
        time++;
        if (time >= 180) {
            //60 frames == 1 segundo

            try {

                Inimigo alien = fabricaDeInimigo.getInimigo(50, 0, resolucao.getCaminho(), jogo, sorteio());
                alien.addInimigoListenner(score);
                this.jogo.addColisaoListener(alien);
                this.jogo.addGameObject(alien);
            } catch (Exception ex) {
                Logger.getLogger(GeradorDeEventos.class.getName()).log(Level.SEVERE, null, ex);
            }
            time = 0;

        }

    }

    public int sorteio() {

        int sorteio = (int) (Math.random() * 100);
        if (sorteio >= 0 && sorteio < 33) {
            tipo = 1;
        }
        if (sorteio >= 33 && sorteio < 66) {
            tipo = 2;
        }
        if (sorteio >= 66 && sorteio < 100) {
            tipo = 3;
        }

        return tipo;
    }
}
