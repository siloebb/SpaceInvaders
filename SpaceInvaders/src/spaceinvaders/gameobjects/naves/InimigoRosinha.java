/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.gameobjects.naves;

import java.util.Random;
import spaceinvaders.listenners.ColisaoEvent;
import spaceinvaders.utils.Jogo;
import spaceinvaders.utils.sprite.SpriteAnimated;

/**
 *
 * @author suka
 */
public class InimigoRosinha extends Inimigo {

    private int sentido;
    private int cont = 0;
    private final Random random;

    public InimigoRosinha(int posicaoX, int posicaoY, String caminho, Jogo jogo) throws Exception {
        super(jogo);

        this.sentido = 2;
        
        
        random = new Random();
        this.sentido = random.nextInt(2)==1?-2:2;
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
        setY(this.getY() + ((sentido*sentido)/2) );
    }

    @Override
    public void colidiu(ColisaoEvent c) {

        try {
            //verifica se conlide com uma das paredes
            if (c.getGameObject().getTag().equals("paredeDaEsquerda")) {
                if (cont == 0) {
                    //setY(this.getY() + 60);
                    cont = 5;
                }
                this.sentido = 2;

            }
            if (c.getGameObject().getTag().equals("paredeDaDireita")) {
                if (cont == 0) {
                    //setY(this.getY() + 60);
                    cont = 5;
                }
                this.sentido = -2;

            }
        } catch (Exception e) {

        }
    }

}
