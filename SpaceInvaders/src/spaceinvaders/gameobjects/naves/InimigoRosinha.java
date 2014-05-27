/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.gameobjects.naves;

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
    private int tipo = 1;
    
    public InimigoRosinha(int posicaoX, int posicaoY, String caminho, Jogo jogo) throws Exception {
        super(jogo);

        this.sentido = 2;
        SpriteAnimated spInimigo = new SpriteAnimated();
        spInimigo.carregarSprite(caminho + "alien1.png", 1, 2);
        spInimigo.setX(posicaoX);
        spInimigo.setY(posicaoY);
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

    @Override
     public int getTipo(){
    
    return tipo;
    }
}
