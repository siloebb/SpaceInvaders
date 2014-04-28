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
import spaceinvaders.utils.sprite.SpriteAnimated;
import spaceinvaders.Resolucao;
import spaceinvaders.SpaceInvaders;

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
    private int time;

    public GeradorDeEventos(Resolucao resolucao, Jogo jogo) {
        this.resolucao = resolucao;
        this.jogo = jogo;
        time = 0;
    }

    @Override
    public void update() {
        time++;
        if (time >= 60) { //60 frames == 1 segundo
            Inimigo inimigo = new Inimigo();
            SpriteAnimated spInimigo = new SpriteAnimated();
            try {
                int posi;
                posi = (int) (Math.random() * 100);
                if (posi >= 0 && posi < 10) {
                    posi = 0;
                }
                if (posi >= 10 && posi < 20) {
                    posi = 1;
                }
                if (posi >= 20 && posi < 30) {
                    posi = 2;
                }
                if (posi >= 30 && posi < 40) {
                    posi = 3;
                }
                if (posi >= 40 && posi < 50) {
                    posi = 4;
                }
                if (posi >= 50 && posi < 60) {
                    posi = 5;
                }
                if (posi >= 60 && posi < 70) {
                    posi = 6;
                }
                if (posi >= 70 && posi < 100) {
                    posi = 7;
                }
                int alien = (int) (Math.random() * 100);
                if (alien >= 0 && alien < 33) {
                    spInimigo.carregarSprite(resolucao.getCaminho() + "alien1.png", 1, 2);
                    spInimigo.setX(resolucao.getPosicaoInimigo()[posi]);
                    spInimigo.setY(resolucao.getPosicaoInimigo()[8]);
                    spInimigo.animate(0, 1, 15);
                }
                if (alien >= 33 && alien < 66) {
                    spInimigo.carregarSprite(resolucao.getCaminho() + "alien2.png", 1, 2);
                    spInimigo.setX(resolucao.getPosicaoInimigo()[posi]);
                    spInimigo.setY(resolucao.getPosicaoInimigo()[8]);
                    spInimigo.animate(0, 1, 15);
                }
                if (alien >= 66 && alien < 100) {
                    spInimigo.carregarSprite(resolucao.getCaminho() + "alien3.png", 1, 4);
                    spInimigo.setX(resolucao.getPosicaoInimigo()[posi]);
                    spInimigo.setY(resolucao.getPosicaoInimigo()[8]);
                    spInimigo.animate(0, 3, 15);
                }

            } catch (Exception ex) {
                Logger.getLogger(SpaceInvaders.class.getName()).log(Level.SEVERE, null, ex);
            }
            inimigo.setSprite(spInimigo);
            jogo.addGameObject(inimigo);
            time = 0;
        }
    }

}
