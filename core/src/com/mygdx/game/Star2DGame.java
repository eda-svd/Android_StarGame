package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.mygdx.game.screen.menu.MenuScreen;

/**
 * Created by ASUS on 10.12.2017.
 */

public class Star2DGame extends Game{
    @Override
    public void create() {
        setScreen(new MenuScreen(this));
    }
}
