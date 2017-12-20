package com.mygdx.game.screen;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import math.Rect;
import sprite.Sprite;
import ui.ActionListener;
import ui.ScaledTouchUpButton;

/**
 * Created by ASUS on 20.12.2017.
 */

public class MainShip extends ScaledTouchUpButton {

    public MainShip(TextureAtlas atlas, ActionListener actionListener,float touchedScale) {
        super(atlas.findRegion("main_ship" ),actionListener,touchedScale);
    }

    @Override
    public void resize(Rect worldBounds) {
        setBottom(worldBounds.getBottom()+0.05f);
    }
}
