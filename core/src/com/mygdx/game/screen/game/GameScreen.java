package com.mygdx.game.screen.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Background;

import math.Rect;
import stargame.engine.Base2DScreen;
import stargame.engine.BaseTexture;

/**
 * Created by ASUS on 19.12.2017.
 */

public class GameScreen extends Base2DScreen {
    private BaseTexture textureBackground;
    private Background background;

    public GameScreen(Game game){
        super(game);
    }

    @Override
    public void show() {
        super.show();
        textureBackground = new BaseTexture("background.jpg");
        background = new Background(new TextureRegion(textureBackground));
    }

    @Override
    public void render(float delta) {
        update(delta);
        checkCollisions();
        deleteAllDestroyed();
        draw();

    }
    public void update(float delta){

    }
    public void checkCollisions(){

    }
    public void deleteAllDestroyed(){

    }

    public void draw(){
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        batch.end();
    }

    @Override
    protected void resize(Rect worldBounds) {
        background.resize(worldBounds);
    }

    @Override
    public void dispose() {
        textureBackground.dispose();
        super.dispose();
    }
}
