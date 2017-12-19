package stargame.engine;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;

import math.MatrixUtils;
import math.Rect;
import sprite.Sprite;

/**
 * Created by ASUS on 10.12.2017.
 */

public class Base2DScreen implements Screen, InputProcessor {

    Sprite s;

    protected Game game;
    private Rect screenBounds; //Окно игры
    private Rect worldBounds; //границы креста посередине
    private Rect glBounds; //координаты от левого нижнего угла

    protected Matrix4 worldToGl; //Матрица преобразования мировых в Gl
    protected Matrix3 screenToWorld; //Матрица преобразования координат окна в крест посередине

    Vector2 touch = new Vector2();

    protected SpriteBatch batch;

    public Base2DScreen(Game game) {
        this.game = game;
        this.screenBounds = new Rect(); //текущие значения открытого окна присваиваются переменным
        this.worldBounds = new Rect();
        this.glBounds = new Rect(0,0,1f,1f);
        this.worldToGl = new Matrix4();
        this.screenToWorld = new Matrix3();
        if (this.batch != null){
            throw new RuntimeException("Повторная установка screen без dispose");
        }
        this.batch = new SpriteBatch();
    }

    @Override
    public void show() {
        System.out.println("show");
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {
        System.out.println("resize w "+width+" h "+height);
        screenBounds.setSize(width,height); //Присваиваем прямоугольнику размеры измененного окна
        screenBounds.setLeft(0);
        screenBounds.setBottom(0);
        float aspect = width/(float)height;
        worldBounds.setHeight(1f);
        worldBounds.setWidth(1f*aspect);
        MatrixUtils.calcTransitionMatrix(worldToGl,worldBounds,glBounds);
        batch.setProjectionMatrix(worldToGl);
        MatrixUtils.calcTransitionMatrix(screenToWorld,screenBounds,worldBounds);
        resize(worldBounds);        //????????????
    }

    protected void resize(Rect worldBounds) {
    }

    @Override
    public void pause() {
        System.out.println("pause");
    }

    @Override
    public void resume() {
        System.out.println("Resume");
    }

    @Override
    public void hide() {
        System.out.println("hide");
        dispose();
    }

    @Override
    public void dispose() {
        System.out.println("dispose");
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touch.set(screenX, screenBounds.getHeight() - 1f - screenY).mul(screenToWorld);
        touchDown(touch, pointer);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        touch.set(screenX, screenBounds.getHeight() - 1f - screenY).mul(screenToWorld);
        touchUp(touch, pointer);
        return false;
    }
    public void touchDown(Vector2 vector2, int touched){

    }
    public void touchUp(Vector2 vector2, int touched){

    }
    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
