package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import math.Rect;
import sprite.Sprite;

/**
 * Created by ASUS on 19.12.2017.
 */

public class Background extends Sprite {
    public Background(TextureRegion region) {
        super(region);
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(worldBounds.getHeight());
        pos.set(worldBounds.pos);
    }
}
