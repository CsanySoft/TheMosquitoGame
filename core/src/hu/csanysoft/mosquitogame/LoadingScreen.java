package hu.csanysoft.mosquitogame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import hu.csanysoft.mosquitogame.GlobalClasses.Assets;
import hu.csanysoft.mosquitogame.MyBaseClasses.Scene2D.MyScreen;

public class LoadingScreen extends MyScreen {

    BitmapFont bitmapFont = new BitmapFont();

    public LoadingScreen(TheMosquitoGame game) {
        super(game);
    }


    @Override
    public void show() {
        Assets.manager.finishLoading();
        Assets.load();
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        spriteBatch.begin();
        bitmapFont.draw(spriteBatch, "Betöltés: " + Assets.manager.getLoadedAssets() + "/" + (Assets.manager.getQueuedAssets() + Assets.manager.getLoadedAssets()) + " (" + ((int) (Assets.manager.getProgress() * 100f)) + "%)", Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        spriteBatch.end();
        if (Assets.manager.update()) {
            Assets.afterLoaded();
            game.setScreen(new InputScreen(game));
        }
    }

    @Override
    public void hide() {

    }

    @Override
    public void init() {
        setBackGroundColor(0f, 0f, 0f);
    }
}
