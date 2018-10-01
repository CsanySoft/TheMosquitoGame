package hu.csanysoft.mosquitogame;

import com.badlogic.gdx.Gdx;

import hu.csanysoft.mosquitogame.MyBaseClasses.Scene2D.MyScreen;

public class MenuScreen extends MyScreen {

    protected MenuStage menuStage;

    public MenuScreen(TheMosquitoGame game) {
        super(game);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        menuStage.act();
        menuStage.draw();
    }

    @Override
    public void init() {
        setBackGroundColor(0.5f, 0.8f,0.5f);

        menuStage = new MenuStage(spriteBatch, game);
        Gdx.input.setInputProcessor(menuStage);
    }
}
