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

/**
 *
 * @author Jéssica Magally
 */
public class InimigoVerdeTest {
    
    public InimigoVerdeTest() {
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
     * Test of update method, of class InimigoVerde.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        InimigoVerde instance = null;
        instance.update();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of movimentar method, of class InimigoVerde.
     */
    @Test
    public void testMovimentar() {
        System.out.println("movimentar");
        InimigoVerde instance = null;
        instance.movimentar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of colidiu method, of class InimigoVerde.
     */
    @Test
    public void testColidiu() {
        System.out.println("colidiu");
        ColisaoEvent c = null;
        InimigoVerde instance = null;
        instance.colidiu(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
