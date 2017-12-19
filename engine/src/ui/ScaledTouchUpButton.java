package ui;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import sprite.Sprite;

/**
 * Created by ASUS on 19.12.2017.
 */

public class ScaledTouchUpButton extends Sprite {

    private ActionListener actionListener;
    protected boolean touched;
    protected int pointer;
    public float touchedScale;

    public ScaledTouchUpButton(TextureRegion region,ActionListener actionListener, float touchedScale) {
        super(region);
        this.actionListener = actionListener;
        this.touchedScale = touchedScale;
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        System.out.println("touch");
        if (touched ||!isMe(touch)){
            return false;
        }
        this.pointer = pointer;
        scale = touchedScale;
        touched = true;
        return true;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer) {
        if (this.pointer!=pointer||!touched){
            return false;
        }
        touched = false;
        scale = 1f;
        if(isMe(touch)){
            actionListener.ActionPerformed(this);
            return true;
        }
        return false;
    }
}
