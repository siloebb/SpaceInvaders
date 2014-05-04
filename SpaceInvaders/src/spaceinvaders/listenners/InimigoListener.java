/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spaceinvaders.listenners;

/**
 *
 * @author Siloe
 */
public interface InimigoListener {
    
    /**
     * O que acontece quando o inimigo morre
     * @param e 
     */
    public void inimigoMorreu(InimigoEvent e);
    
}
