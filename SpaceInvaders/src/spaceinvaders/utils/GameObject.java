package spaceinvaders.utils;

import spaceinvaders.utils.sprite.Sprite;

/**
 *
 * @author Siloe
 */
public class GameObject {

    public static int keyPressed = 0;
    protected Sprite sprite;
    private String tag = "semTag";

    private boolean flagSelfDestroy = false;

    public void update() {

    }

    public int getHeight() {
        return this.getSprite().getHeight();
    }

    public int getWidth() {
        return this.getSprite().getWidth();
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public void setX(int x) {
        sprite.setX(x);
    }

    public void setY(int y) {
        sprite.setY(y);
    }

    public int getX() {
        return sprite.getX();
    }

    public int getY() {
        return sprite.getY();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public boolean isFlagSelfDestroy() {
        return flagSelfDestroy;
    }

    /**
     * Alerta ao jogo que é para destroir este objeto
     */
    public final void selfDestroy() {
        //sprite = null;
        flagSelfDestroy = true;
    }

}
