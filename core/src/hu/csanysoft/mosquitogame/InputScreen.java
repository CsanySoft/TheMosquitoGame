package hu.csanysoft.mosquitogame;

import com.badlogic.gdx.*;
import hu.csanysoft.mosquitogame.InputStage;
import hu.csanysoft.mosquitogame.MyBaseClasses.Scene2D.MyScreen;

public class InputScreen extends MyScreen {

    InputStage inputStage;
    InputMultiplexer inputMultiplexer;

    public InputScreen(TheMosquitoGame game) {
        super(game);
    }

    @Override
    public void init() {
        inputStage = new InputStage(spriteBatch, game);
        setBackGroundColor(0.4f, 0.4f, 0.5f);
        inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(inputStage);
        Gdx.input.setInputProcessor(inputMultiplexer);
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);

        inputStage.resize(width, height);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        if(inputStage.getElapsedTime()>1)
            //game.setScreen(new GameScreen(game));//Todo: Dummy, magyarán ez azért van, hogyha le van futtatva, akkor ne álljon meg és ne csináljon semmit
        inputStage.act(delta);
        inputStage.draw();
    }
}
