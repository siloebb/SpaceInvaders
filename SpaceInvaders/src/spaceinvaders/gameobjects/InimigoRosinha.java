/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.gameobjects;

import spaceinvaders.Resolucao;
import spaceinvaders.listenner.ColisaoEvent;
import spaceinvaders.utils.sprite.SpriteAnimated;

/**
 *
 * @author suka
 */
public class InimigoRosinha extends Inimigo {

    private int sentido;
    private int cont = 0;

    public InimigoRosinha(Resolucao resolucao) throws Exception {
        this.sentido = 2;
        SpriteAnimated spInimigo = new SpriteAnimated();
        spInimigo.carregarSprite(resolucao.getCaminho() + "alien1.png", 1, 2);
        spInimigo.setX(50);
        spInimigo.setY(0);
        spInimigo.animate(0, 1, 15);
        this.sprite = spInimigo;
    }

    @Override
    public void update() {
        super.update();
        //evitando colisão dupla com a parede
        if (cont > 0) {
            cont--;
        }
    }

    @Override
    public void movimentar() {
        setX(this.getX() + sentido);
    }

    @Override
    public void colidiu(ColisaoEvent c) {

        try {

            if (c.getGameObject().getTag().equals("paredeDaEsquerda")) {
                if (cont == 0) {
                    setY(this.getY() + 60);
                    cont = 5;
                }
                this.sentido = 2;

            }
            if (c.getGameObject().getTag().equals("paredeDaDireita")) {
                if (cont == 0) {
                    setY(this.getY() + 60);
                    cont = 5;
                }
                this.sentido = -2;

            }
        } catch (Exception e) {

        }
    }

}
