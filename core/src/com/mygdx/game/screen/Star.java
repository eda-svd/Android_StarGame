package com.mygdx.game.screen;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import math.Rect;
import math.Rnd;
import sprite.Sprite;

/**
 * Created by ASUS on 19.12.2017.
 */

public class Star extends Sprite {
    private final Vector2 v = new Vector2();
    private Rect worldBounds;

    public Star(TextureAtlas atlas, float vx, float vy, float width) {
        super(atlas.findRegion("star"));
        v.set(vx,vy);
        setWidthProportion(width);
    }

    @Override
    public void update(float deltaTime) {
        pos.mulAdd(v,deltaTime);
        checkAndHandleBounds();
    }

    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
        float posX = Rnd.nextFloat(this.worldBounds.getLeft(), this.worldBounds.getRight());
        float posY = Rnd.nextFloat(this.worldBounds.getTop(),this.worldBounds.getBottom());
        pos.set(posX,posY);
    }

    protected void checkAndHandleBounds(){
        if (getRight()<worldBounds.getLeft()){
            setLeft(worldBounds.getRight());
        }
        if (getLeft()>worldBounds.getRight()){
            setRight(worldBounds.getLeft());
        }
        if (getTop()<worldBounds.getBottom()){
            setBottom(worldBounds.getTop());
        }
        if (getBottom()>worldBounds.getTop()){
            setTop(worldBounds.getBottom());
        }
    }
}
