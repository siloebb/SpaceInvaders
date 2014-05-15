/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.gameobjects.elemetos_fase;

import spaceinvaders.gameobjects.naves.Inimigo;
import java.util.Random;
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
    private Random random;

    public GeradorDeEventos( Jogo jogo, Score score) {
        fabricaDeInimigo = new InimigoFactory();
        this.resolucao = Resolucao.getInstance();
        this.jogo = jogo;
        this.score = score;
        time = 0;
        tipo = 0;
        random = new Random();
    }

    @Override
    public void update() {
        time++;
        if (time >= 180) {
            //60 frames == 1 segundo

            try {
                int xRandom = random.nextInt(resolucao.getLarguraTela()-60);
                Inimigo alien = fabricaDeInimigo.getInimigo(xRandom, 0, resolucao.getCaminho(), jogo, sorteio());
                
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

        //int sorteio = (int) (Math.random() * 2);
        tipo = random.nextInt(3) + 1;

        return tipo;
    }
}
