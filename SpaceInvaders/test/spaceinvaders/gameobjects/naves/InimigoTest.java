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
import spaceinvaders.listenners.InimigoListener;
import spaceinvaders.utils.Jogo;
import spaceinvaders.telas.JanelaPrincipal;

/**
 *
 * @author Jéssica Magally
 */
public class InimigoTest {
    
    private static JanelaPrincipal janela;
    
    public InimigoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addInimigoListenner method, of class Inimigo.
     */
    @Test
    public void testAddInimigoListenner() {
        System.out.println("addInimigoListenner");
        InimigoListener il = null;
        Inimigo instance = null;
        instance.addInimigoListenner(il);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeInimigoListenner method, of class Inimigo.
     */
    @Test
    public void testRemoveInimigoListenner() {
        System.out.println("removeInimigoListenner");
        InimigoListener il = null;
        Inimigo instance = null;
        instance.removeInimigoListenner(il);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of disparaInimigoMorreu method, of class Inimigo.
     */
    @Test
    public void testDisparaInimigoMorreu() {
        System.out.println("disparaInimigoMorreu");
        Inimigo instance = null;
        instance.disparaInimigoMorreu();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of movimentar method, of class Inimigo.
     */
    @Test
    public void testMovimentar() {
        System.out.println("movimentar");
        
        //Tive que instanciar algumas coisas antes de realizar os teste mas tá dando erro
        Jogo j = new Jogo(tamTela[0] = 320, tamTela[1] =180);
        if (janela == null) {
            janela = new JanelaPrincipal(listaGameObject, listaBackground, listaText, tamTela); //janela tem mais um parametro
        } else {
            janela.alterarLista(listaGameObject, listaBackground, listaText);
        }
        janela.requestFocus();
        
        
        
        Inimigo inimigo = new Inimigo(j) {
        };
        inimigo.setY(10);
        inimigo.movimentar();
        
        assertEquals(12,inimigo.getY());
        
    }

    /**
     * Test of update method, of class Inimigo.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Inimigo instance = null;
        instance.update();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of colidiu method, of class Inimigo.
     */
    @Test
    public void testColidiu() {
        System.out.println("colidiu");
        ColisaoEvent c = null;
        Inimigo instance = null;
        instance.colidiu(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJogo method, of class Inimigo.
     */
    @Test
    public void testGetJogo() {
        System.out.println("getJogo");
        Inimigo instance = null;
        Jogo expResult = null;
        Jogo result = instance.getJogo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setJogo method, of class Inimigo.
     */
    @Test
    public void testSetJogo() {
        System.out.println("setJogo");
        Jogo jogo = null;
        Inimigo instance = null;
        instance.setJogo(jogo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPontos method, of class Inimigo.
     */
    @Test
    public void testGetPontos() {
        System.out.println("getPontos");
        Inimigo instance = null;
        int expResult = 0;
        int result = instance.getPontos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPontos method, of class Inimigo.
     */
    @Test
    public void testSetPontos() {
        System.out.println("setPontos");
        int pontos = 0;
        Inimigo instance = null;
        instance.setPontos(pontos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selfDestroy method, of class Inimigo.
     */
    @Test
    public void testSelfDestroy() {
        System.out.println("selfDestroy");
        Inimigo instance = null;
        instance.selfDestroy();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTipo method, of class Inimigo.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        Inimigo instance = null;
        int expResult = 0;
        int result = instance.getTipo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class InimigoImpl extends Inimigo {

        public InimigoImpl() {
            super(null);
        }
    }
    
}
