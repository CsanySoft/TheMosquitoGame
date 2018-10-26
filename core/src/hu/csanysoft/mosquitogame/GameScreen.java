package hu.csanysoft.mosquitogame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.csanysoft.mosquitogame.MyBaseClasses.Scene2D.MyScreen;

public class GameScreen extends MyScreen {

    GameStage gameStage;
    InputMultiplexer inputMultiplexer;

    public GameScreen(TheMosquitoGame game) {
        super(game);
    }

    @Override
    public void init() {
        gameStage = new GameStage(spriteBatch,game);
        setBackGroundColor(0.2f, 0.4f, 0.8f);
        inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(gameStage);
        Gdx.input.setInputProcessor(inputMultiplexer);
        gameStage.addBackEventStackListener();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);

        gameStage.resize(width, height);
        gameStage.getViewport().update(width, height, true);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        gameStage.act(delta);
        gameStage.draw();
    }
}
