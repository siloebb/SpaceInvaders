package spaceinvaders.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import spaceinvaders.telas.JanelaPrincipal;

/**
 *
 * @author Siloe
 */
public class Utils {

    /**
     * Retorna a imagem se o arquivo existir, caso não exista retorna null
     *
     * @param file
     * @return img ou null
     */
    public static BufferedImage carregarImagem(String file) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(file));
            return img;
        } catch (IOException ex) {
            Logger.getLogger(JanelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * @param img
     * @param rows
     * @param columns
     * @return Retorna um array de sprites com os sprites gerado pela divisão da imagem
     * @throws Exception Lança um erro caso rows <=0 ou columns <=0
     */
    public static BufferedImage[] dividirImagem(BufferedImage img, int rows, int columns) throws Exception {
        if (img == null) {
            return null;
        }
        if (rows <= 0 || columns <= 0) {
            throw new Exception("Linhas e colunas na divisão da imagem devem ser maiores que 1.");
        }

        int height = img.getHeight();
        int width = img.getWidth();
        int tamanhoDoArray = rows * columns;

        int heightDoRecorte = height / rows;
        int widthDoRecorte = width / columns;

        BufferedImage[] images = new BufferedImage[tamanhoDoArray];

        int contador = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {                
                images[contador] = img.getSubimage(widthDoRecorte * j, heightDoRecorte * i, widthDoRecorte, heightDoRecorte);
                contador++;
            }
        }
        //images[0] = img.getSubimage(0, 0, width / 2, height / 2);

        return images;
    }

}
