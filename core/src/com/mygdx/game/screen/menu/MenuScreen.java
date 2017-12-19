package com.mygdx.game.screen.menu;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Background;
import com.mygdx.game.screen.Star;
import com.mygdx.game.screen.UI.ButtonExit;
import com.mygdx.game.screen.UI.ButtonNewGame;
import com.mygdx.game.screen.game.GameScreen;


import math.Rect;
import math.Rnd;
import stargame.engine.Base2DScreen;
import stargame.engine.BaseTexture;
import ui.ActionListener;

/**
 * Created by ASUS on 10.12.2017.
 */

public class MenuScreen extends Base2DScreen implements ActionListener{
    /*SpriteBatch batch;
    Texture img;
    Texture background;
    Texture play;
    Texture pause;
    Rect plButton;
    Rect pauButton;
    Vector2 tap = new Vector2();*/
    private static final float BUTTON_PRESS_SCALE = 0.9f;
    private static final float BUTTON_HEIGHT = 0.15f;
    private static final int STAR_COUNT = 256;
    private static final float STAR_WIDTH = 0.01f;

    private BaseTexture textureBackground;
    private Background background;
    private TextureAtlas textureAtlas;
    private ButtonExit buttonExit;
    private ButtonNewGame buttonNewGame;

    private Star star[];



    public MenuScreen(Game game){
        super(game);
    }

    @Override
    public void show() {
        /*batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
        background = new Texture("background.jpg");
        play = new Texture("play.png");
        pause = new Texture("pause.png");
        plButton = new Rect(75,75,25,25);
        pauButton = new Rect(565,75,25,25);*/
        super.show();
        textureBackground = new BaseTexture("background.jpg");
        background = new Background(new TextureRegion(textureBackground));
        textureAtlas = new TextureAtlas("menuAtlas.tpack");
        buttonExit = new ButtonExit(textureAtlas,this,BUTTON_PRESS_SCALE);
        buttonExit.setHeightProportion(BUTTON_HEIGHT);
        buttonNewGame = new ButtonNewGame(textureAtlas,this,BUTTON_PRESS_SCALE);
        buttonNewGame.setHeightProportion(BUTTON_HEIGHT);

        star = new Star[STAR_COUNT];
        for (int i = 0; i < star.length; i++) {
            star[i] = new Star(textureAtlas, Rnd.nextFloat(-0.005f,0.005f),Rnd.nextFloat(-0.5f,-0.1f),STAR_WIDTH);
        }
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        draw();
        /*batch.begin();
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
        tap.y = 0;*/
    }

    public void update(float delta){
        for (int i = 0; i < star.length; i++) {
            star[i].update(delta);
        }
    }

    public void draw(){
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        for (int i = 0; i < star.length; i++) {
            star[i].draw(batch);
        }
        buttonExit.draw(batch);
        buttonNewGame.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        textureAtlas.dispose();
        textureBackground.dispose();
        batch = null;
    }

    @Override
    protected void resize(Rect worldBounds) {
        background.resize(worldBounds);
        buttonExit.resize(worldBounds);
        buttonNewGame.resize(worldBounds);
        for (int i = 0; i < star.length; i++) {
            star[i].resize(worldBounds);
        }
    }

    @Override
    public void touchDown(Vector2 touch, int pointer) {
        buttonExit.touchDown(touch,pointer);
        buttonNewGame.touchDown(touch,pointer);
        System.out.println("touchdown.x "+ touch.x + " touchdown.y "+touch.y);
    }

    @Override
    public void touchUp(Vector2 touch, int pointer) {
        buttonExit.touchUp(touch,pointer);
        buttonNewGame.touchUp(touch,pointer);
        System.out.println("touchup.x "+ touch.x + " touchup.y "+touch.y);
    }

    @Override
    public void ActionPerformed(Object src) {
        if (src == buttonExit){
            Gdx.app.exit();
        } else if (src == buttonNewGame){
            game.setScreen(new GameScreen(game));
        } else {
            throw new RuntimeException("Unknown src ="+ src);
        }
    }
}
