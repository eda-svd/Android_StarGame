package com.mygdx.game.screen.menu;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

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
        super.show();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        batch.draw(background,0,0);
        if (Gdx.input.isTouched()){
            tap.x = Gdx.input.getX();
            tap.y = Gdx.input.getY();
        }

        batch.draw(play, 30,50, 50,50);
        batch.draw(pause,560,50,50,50);
        
        batch.draw(img,tap.x,Gdx.graphics.getHeight()-tap.y);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();
        background.dispose();
        img.dispose();
    }
}
