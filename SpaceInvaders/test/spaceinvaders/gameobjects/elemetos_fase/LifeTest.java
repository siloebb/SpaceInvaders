/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spaceinvaders.gameobjects.elemetos_fase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import spaceinvaders.listenners.NaveEvent;

/**
 *
 * @author Jéssica Magally
 */
public class LifeTest {
    
    public LifeTest() {
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
     * Test of NavePerdeuVida method, of class Life.
     */
    @Test
    public void testNavePerdeuVida() {
        System.out.println("NavePerdeuVida");
        NaveEvent e = null;
        Life instance = new Life();
        instance.NavePerdeuVida(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
