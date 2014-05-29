/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spaceinvaders.utils;

import java.awt.image.BufferedImage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Siloe
 */
public class UtilsTest {
    
    public UtilsTest() {
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
     * Test of carregarImagem method, of class Utils.
     */
    @Test
    public void testCarregarImagem() {
        System.out.println("carregarImagem");
        String file = "src/assets_800x600/nave.png";        
        BufferedImage result = Utils.carregarImagem(file);
        assertNotNull(result);
                
    }

    /**
     * Test of dividirImagem method, of class Utils.
     */
    @Test
    public void testDividirImagem() throws Exception {
        System.out.println("dividirImagem");
        String file = "src/assets_800x600/nave.png";        
        BufferedImage img = Utils.carregarImagem(file);
        int rows = 1;
        int columns = 4;
        BufferedImage[] expResult = null;
        BufferedImage[] resultArray = Utils.dividirImagem(img, rows, columns);
        
        int result = resultArray.length;
        
        assertEquals(4, result);
    }
    
}
