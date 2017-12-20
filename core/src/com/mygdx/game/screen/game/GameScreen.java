package com.mygdx.game.screen.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Background;
import com.mygdx.game.screen.MainShip;
import com.mygdx.game.screen.Star;

import math.Rect;
import math.Rnd;
import stargame.engine.Base2DScreen;
import stargame.engine.BaseTexture;
import ui.ActionListener;

/**
 * Created by ASUS on 19.12.2017.
 */

public class GameScreen extends Base2DScreen implements ActionListener{
    private BaseTexture textureBackground;
    private Background background;

    private Star star[];
    private TextureAtlas mainAtlas;
    private MainShip mainShip;
    int STAR_COUNT = 200;
    float STAR_WIDTH = 0.005f;

    public GameScreen(Game game){
        super(game);
    }

    @Override
    public void show() {
        super.show();
        textureBackground = new BaseTexture("background.jpg");
        background = new Background(new TextureRegion(textureBackground));
        mainAtlas = new TextureAtlas("mainAtlas.tpack");
        mainShip = new MainShip(mainAtlas,this,0.5f);
        mainShip.setHeightProportion(0.18f);
        star = new Star[STAR_COUNT];
        for (int i = 0; i < star.length; i++) {
            star[i] = new Star(mainAtlas, Rnd.nextFloat(-0.005f,0.005f),Rnd.nextFloat(-0.5f,-0.1f),STAR_WIDTH);
        }
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        checkCollisions();
        deleteAllDestroyed();
        draw();

    }
    public void update(float delta){
        for (int i = 0; i < star.length; i++) {
            star[i].update(delta);
        }

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
        for (int i = 0; i < star.length; i++) {
            star[i].draw(batch);
        }
        mainShip.draw(batch);
        batch.end();
    }

    @Override
    protected void resize(Rect worldBounds) {
        background.resize(worldBounds);
        mainShip.resize(worldBounds);
        for (int i = 0; i < star.length; i++) {
            star[i].resize(worldBounds);
        }
    }

    @Override
    public void dispose() {
        textureBackground.dispose();
        mainAtlas.dispose();
        batch = null;
        super.dispose();
    }

    @Override
    public void ActionPerformed(Object src) {

    }

    @Override
    public void touchDown(Vector2 vector2, int touched) {
        super.touchDown(vector2, touched);
    }

    @Override
    public void touchUp(Vector2 vector2, int touched) {
        super.touchUp(vector2, touched);
    }
}
