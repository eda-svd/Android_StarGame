package com.mygdx.game.screen.UI;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import math.Rect;
import ui.ActionListener;
import ui.ScaledTouchUpButton;

/**
 * Created by ASUS on 19.12.2017.
 */

public class ButtonNewGame extends ScaledTouchUpButton {
    public ButtonNewGame(TextureAtlas atlas, ActionListener actionListener, float touchedScale) {
        super(atlas.findRegion("btPlay"), actionListener, touchedScale);
    }

    @Override
    public void resize(Rect worldBounds) {
        setBottom(worldBounds.getBottom());
        setLeft(worldBounds.getLeft());
    }
}
