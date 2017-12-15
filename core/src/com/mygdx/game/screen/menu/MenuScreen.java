package com.mygdx.game.screen.menu;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;


import math.Rect;
import stargame.engine.Base2DScreen;

/**
 * Created by ASUS on 10.12.2017.
 */

public class MenuScreen extends Base2DScreen {
    SpriteBatch batch;
    Texture img;
    Texture background;
    Texture play;
    Texture pause;
    Rect plButton;
    Rect pauButton;
    Vector2 tap = new Vector2();



    public MenuScreen(Game game){
        super(game);
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
        background = new Texture("background.jpg");
        play = new Texture("play.png");
        pause = new Texture("pause.png");
        plButton = new Rect(75,75,25,25);
        pauButton = new Rect(565,75,25,25);
        super.show();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        batch.draw(background,0,0);

        if (Gdx.input.isTouched()){
            tap.x = Gdx.input.getX();
            tap.y = Gdx.graphics.getHeight() - Gdx.input.getY();

        }

        if (plButton.isMe(tap)){
            batch.draw(play, plButton.scaleX(0.9),plButton.scaleY(0.9), plButton.scaleLX(0.9),plButton.scaleLY(0.9));
        }
        else {
            batch.draw(play, plButton.getLeft(),plButton.getBottom(), 50,50);
        }

        if (pauButton.isMe(tap)){
            batch.draw(pause,pauButton.scaleX(0.9),pauButton.scaleY(0.9), pauButton.scaleLX(0.9),pauButton.scaleLY(0.9));
        }
        else {
            batch.draw(pause, pauButton.getLeft(),pauButton.getBottom(), 50,50);
        }


        batch.end();
        tap.x = 0;
        tap.y = 0;
    }

    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();
        background.dispose();
        img.dispose();
        pause.dispose();
        play.dispose();
    }
}
