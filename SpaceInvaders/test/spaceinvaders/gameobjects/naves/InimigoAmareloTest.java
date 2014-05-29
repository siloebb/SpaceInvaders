/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spaceinvaders.gameobjects.naves;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import spaceinvaders.listenners.ColisaoEvent;
import spaceinvaders.telas.JanelaPrincipal;
import spaceinvaders.utils.Jogo;
import spaceinvaders.utils.sprite.SpriteAnimated;

/**
 *
 * @author Jéssica Magally
 */
public class InimigoAmareloTest {
    
    private static JanelaPrincipal janela;
    
    
    public InimigoAmareloTest() {
    }
        
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of update method, of class InimigoAmarelo.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        InimigoAmarelo instance = null;
        instance.update();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of movimentar method, of class InimigoAmarelo.
     */
    @Test
    public void testMovimentar() throws Exception {
        System.out.println("movimentar");
        /**
         * Tiver que criar essa coisas antes pra poder instanciar um inimigo pra o teste, mas tá dando erro
         */
        Jogo j = new Jogo(tamTela[0] = 800, tamTela[1] = 600);
        if (janela == null) {
            janela = new JanelaPrincipal(listaGameObject, listaBackground, listaText, tamTela); //janela tem mais um parametro
        } else {
            janela.alterarLista(listaGameObject, listaBackground, listaText);
        }
        janela.requestFocus();
        
        /*
        * Testa se quando o inimigo movimenta muda a posição em 2
        */
        InimigoAmarelo inimigoAmarelo = new InimigoAmarelo(0, 0, "src/assets_800x600/", j);
        inimigoAmarelo.movimentar();
        
        
        inimigoAmarelo.setX(10);
        inimigoAmarelo.movimentar();
        
        assertEquals(12,inimigoAmarelo.getX());
    }
    
}
