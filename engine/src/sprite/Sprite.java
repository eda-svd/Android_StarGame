package sprite;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import math.Rect;

/**
 * Created by ASUS on 18.12.2017.
 */

public class Sprite  extends Rect{
    protected float angle;
    protected float scale = 1f;
    protected TextureRegion[] regions;
    protected int frame;

    public Sprite(TextureRegion region){  //Пока не понял зачем это нужно
        if(region ==null){
            throw new NullPointerException();
        }
        regions = new TextureRegion[1];
        this.regions[0]=region;
    }

    public void draw(SpriteBatch batch){  //Изменяем стандартный Draw используя наши методы из Rect
        batch.draw(regions[frame],
                getLeft(),getBottom(),
                halfWidth, halfHeight,
                getWidth(), getHeight(),
                scale,scale,
                angle
        );
    }

    public void setWidthProportion(float width){  //Устанавливает размеры Rect по заданной ширине
        setWidth(width);
        float aspect = regions[frame].getRegionWidth()/(float) regions[frame].getRegionHeight();
        setHeight(width/aspect);
    }

    public void setHeightProportion(float height){  //Устанавливает размеры Rect по заданной длинне
        setHeight(height);
        float aspect = regions[frame].getRegionWidth()/(float) regions[frame].getRegionHeight();
        setWidth(height*aspect);
    }

    public void resize(Rect worldBounds){
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public boolean touchDown(Vector2 touch, int pointer) {
        return false;
    }

    public boolean touchUp(Vector2 touch, int pointer) {
        return false;
    }

    public boolean touchDragged(Vector2 touch, int pointer) {
        return false;
    }

    public void update(float deltaTime) {

    }
}
