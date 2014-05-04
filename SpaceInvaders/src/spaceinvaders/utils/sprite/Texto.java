package spaceinvaders.utils.sprite;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author Siloe
 */
public class Texto implements Printable {

    private String texto;
    private int x;
    private int y;
    private String font;
    private int style;
    private int size;
    private Color color;

    public Texto(String texto, int x, int y, int size, Color color) {
        this.texto = texto;
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
        this.font = "TimesRoman";
        this.style = Font.PLAIN;
    }

    public Texto(String texto, int x, int y) {
        this.texto = texto;
        this.x = x;
        this.y = y;
        this.font = "TimesRoman";
        this.style = Font.PLAIN;
        this.size = 10;
        this.color = Color.YELLOW;
    }

    public Texto(String texto, int x, int y, String font, int style, int size) {
        this.texto = texto;
        this.x = x;
        this.y = y;
        this.font = font;
        this.style = style;
        this.size = size;
        this.color = Color.YELLOW;
    }

    public Texto(String texto, int x, int y, int size) {
        this.texto = texto;
        this.x = x;
        this.y = y;
        this.size = size;
        this.font = "TimesRoman";
        this.style = Font.PLAIN;
        this.color = Color.YELLOW;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        this.style = style;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void print(Graphics g) {
        g.setFont(new Font(font, style, size));
        g.setColor(color);
        g.drawString(texto, x, y);
    }

}
