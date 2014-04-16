/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import spaceinvaders.Frame.JanelaPrincipal;
import spaceinvaders.utils.sprite.BackgroundImage;
import spaceinvaders.utils.sprite.SpriteAnimated;

/**
 *
 * @author Siloe
 */
public class Jogo {

    JanelaPrincipal janela;
    SpriteAnimated spNave;

    public Jogo() {
        iniciarJogo();
    }

    private void iniciarJogo() {
        janela = new JanelaPrincipal();

        BackgroundImage bg = new BackgroundImage("src/assets/background.jpg");
        spNave = new SpriteAnimated();
        try {
            spNave.carregarSprite("src/assets/nave1.png", 1, 2);
            spNave.setX(30);
            spNave.setY(40);
        } catch (Exception ex) {
            Logger.getLogger(SpaceInvaders.class.getName()).log(Level.SEVERE, null, ex);
        }

        janela.adicionarBackground(bg);
        janela.adicionarSprite(spNave);
        janela.requestFocus();

        //TODO FAzer de um jeito mas elegante
        janela.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ev) {
                if(ev.getKeyCode() == KeyEvent.VK_LEFT){
                    spNave.setX(spNave.getX() - 5);
                }
                if(ev.getKeyCode() == KeyEvent.VK_RIGHT){
                    spNave.setX(spNave.getX() + 5);
                }
            }
        });
        
    }

    public void start() {

        long delay = 33;
        long inicio = 0;
        inicio = System.currentTimeMillis();

        //Para verificar qual o FPS que está rodando o jogo
        long delayFPS = 1000;
        long inicioFPS = System.currentTimeMillis();
        int contadorFPS = 0;

        //EnterFrame
        while (true) {
            if ((System.currentTimeMillis() - inicio) > delay) {
                janela.repaint();
                inicio = System.currentTimeMillis();

                contadorFPS++;
            }

            //Mostrador do FPS
            if ((System.currentTimeMillis() - inicioFPS) > delayFPS) {
                System.out.println("FPS = " + contadorFPS);
                inicioFPS = System.currentTimeMillis();
                contadorFPS = 0;
            }
        }
    }

}
