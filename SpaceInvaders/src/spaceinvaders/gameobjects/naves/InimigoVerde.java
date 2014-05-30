/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.gameobjects.naves;

import java.util.Random;
import spaceinvaders.Resolucao;
import spaceinvaders.listenners.ColisaoEvent;
import spaceinvaders.utils.Jogo;
import spaceinvaders.utils.sprite.SpriteAnimated;

/**
 *
 * @author suka
 */
public class InimigoVerde extends Inimigo {

    private int sentido;
    private int cont = 0;
    private int sentidoY = 2;
    private Random random;
    private Resolucao resolucao;

    private int tipo = 3;
    
    public InimigoVerde(int posicaoX, int posicaoY, String caminho, Jogo jogo) throws Exception {
        super(jogo);
        
        random = new Random();
        resolucao = Resolucao.getInstance();
        
        this.sentido = random.nextInt(2)==1?-getVelocidadeInimigo():getVelocidadeInimigo();
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
        this.setX(this.getX() + sentido);
                
        this.setY(this.getY() + sentidoY);
        
        if(this.getY() < 0){
            sentidoY = getVelocidadeInimigo();
        }
        if(this.getY() > (resolucao.getAlturaTela() * 0.6)){
            sentidoY = -getVelocidadeInimigo();
        }
    }

    @Override
    public void colidiu(ColisaoEvent c) {

        try {
            //verifica se conlide com uma das paredes
            if (c.getGameObject().getTag().equals("paredeDaEsquerda")) {
                /*if (cont == 0) {
                    //setY(this.getY() + 60);
                    cont = 5;
                }*/
                this.sentido = getVelocidadeInimigo();

            }
            if (c.getGameObject().getTag().equals("paredeDaDireita")) {
                /*if (cont == 0) {
                    //setY(this.getY() + 60);
                    cont = 5;
                }*/
                this.sentido = -getVelocidadeInimigo();

            }
        } catch (Exception e) {

        }
    }
    
    
    @Override
    public int getTipo(){
    
    return tipo;
    }

}
