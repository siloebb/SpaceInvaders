
package spaceinvaders.utils.sprite;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import spaceinvaders.utils.Utils;

/**
 *
 * @author Siloe
 */
public class SpriteAnimated extends Sprite{
    
    private BufferedImage[] spriteArray;
    private int rows;
    private int columns;
    
    private int posicaoAtual=0;
    private int posicaoInicial=0;
    private int posicaoFinal=0;

    public SpriteAnimated() {
    }
    
    public void carregarSprite(String file, int rows, int columns) throws Exception{
        sprite = Utils.carregarImagem(file);        
        spriteArray = Utils.dividirImagem(sprite, rows, columns);
        sprite = spriteArray[posicaoInicial];        
    }
    
    public void animate(int inicio, int fim){
        posicaoInicial = inicio;
        posicaoFinal = fim;
        
        posicaoAtual = posicaoInicial;
    }
    
    @Override
    public void print(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        //Fazendo o loop para sempre incrementar o proximo sprite que será animado
        if(posicaoAtual < posicaoFinal){
            posicaoAtual++;
        }else{
            posicaoAtual = posicaoInicial;
        }
        
        sprite = spriteArray[posicaoAtual];
        
        g2d.drawImage(sprite, x, y, null);        
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getPosicaoAtual() {
        return posicaoAtual;
    }

    public void setPosicaoAtual(int posicaoAtual) {
        this.posicaoAtual = posicaoAtual;
    }

    public int getPosicaoInicial() {
        return posicaoInicial;
    }

    public void setPosicaoInicial(int posicaoInicial) {
        this.posicaoInicial = posicaoInicial;
    }

    public int getPosicaoFinal() {
        return posicaoFinal;
    }

    public void setPosicaoFinal(int posicaoFinal) {
        this.posicaoFinal = posicaoFinal;
    }
    
    
    
}
