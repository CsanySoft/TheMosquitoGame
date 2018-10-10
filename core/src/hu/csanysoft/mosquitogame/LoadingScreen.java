package hu.csanysoft.mosquitogame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.csanysoft.mosquitogame.GlobalClasses.Assets;
import hu.csanysoft.mosquitogame.MyBaseClasses.Scene2D.MyActor;
import hu.csanysoft.mosquitogame.MyBaseClasses.Scene2D.MyScreen;
import hu.csanysoft.mosquitogame.MyBaseClasses.Scene2D.MyStage;

public class LoadingScreen extends MyScreen {

    BitmapFont bitmapFont = new BitmapFont();
    LoadingStage loadingStage;
    Image logo, loadingFrame, loadingBarHidden, screenBg, loadingBg;
    InputMultiplexer inputMultiplexer;

    float startX, endX, percent;

    MyActor loadingBar;

    public LoadingScreen(TheMosquitoGame game) {
        super(game);
    }


    @Override
    public void show() {
        super.show();
        Assets.manager.load("pictures/loading.pack", TextureAtlas.class);
        Assets.manager.finishLoading();



        TextureAtlas atlas = Assets.manager.get("pictures/loading.pack", TextureAtlas.class);

        logo = new Image(atlas.findRegion("libgdx-logo")); //TODO: Átrakni saját logora
        loadingFrame = new Image(atlas.findRegion("loading-frame"));
        loadingBarHidden = new Image(atlas.findRegion("loading-bar-hidden"));
        screenBg = new Image(atlas.findRegion("screen-bg"));
        loadingBg = new Image(atlas.findRegion("loading-frame-bg"));

        Animation animation = new Animation(.05f, atlas.findRegions("loading-bar-anim"));
        animation.setPlayMode(Animation.PlayMode.LOOP_REVERSED);
        loadingBar = new LoadingBar(animation);


        loadingStage.addActor(screenBg);
        loadingStage.addActor(loadingBar);
        loadingStage.addActor(loadingBg);
        loadingStage.addActor(loadingBarHidden);
        loadingStage.addActor(loadingFrame);
        loadingStage.addActor(logo);



        Assets.load();
    }

    float worldWidth, worldHeight;

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        //width = 1024 * width/1024;
        //height = 768;
        loadingStage.resize(width, height);

        System.out.println(width+"x"+height);

        worldWidth = loadingStage.getViewport().getWorldWidth();
        worldHeight = loadingStage.getViewport().getWorldHeight();

        loadingStage.getViewport().update(width, height, true);

        screenBg.setSize(worldWidth, worldHeight);

        logo.setX((worldWidth - logo.getWidth()) / 2);
        logo.setY((worldHeight- logo.getHeight()) / 2 + 100);

        //loadingBar.setX((worldWidth - loadingBar.getWidth()) / 4);
        loadingBar.setX(logo.getX() - (logo.getWidth()-loadingBar.getWidth())/8);
        loadingBar.setY((worldHeight - loadingBar.getHeight()) / 4);

        loadingFrame.setPosition(loadingBar.getX()-15, loadingBar.getY()-5);

        loadingBarHidden.setX(loadingBar.getX()+35);
        loadingBarHidden.setY(loadingBar.getY()-3);

        startX = loadingBarHidden.getX();
        endX = 440;

        loadingBg.setSize(450,50);
        loadingBg.setX(loadingBarHidden.getX() + 30);
        loadingBg.setY(loadingBarHidden.getY() + 3);

        System.out.println("screenBg = " + screenBg.getWidth());
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);



        if(Assets.manager.update()) {
            if(Gdx.input.isTouched()) {
                game.setScreen(new MenuScreen(game));
            }
        }

        percent = Interpolation.linear.apply(percent, Assets.manager.getProgress(), 0.1f);

        loadingBarHidden.setX(startX + endX * percent);
        loadingBg.setX(loadingBarHidden.getX() + 30);
        loadingBg.setWidth(450-(450)*percent);
        loadingBg.invalidate();



        loadingStage.act(delta);
        loadingStage.draw();

        spriteBatch.begin();
        if(Assets.manager.update()) {
            bitmapFont.draw(spriteBatch, "Betöltés kész, kattints a továbblépéshez!", loadingBar.getX()+loadingBar.getWidth()+loadingFrame.getWidth()/2-150, loadingBar.getY()+loadingFrame.getHeight()/2);
        } else bitmapFont.draw(spriteBatch, "Betöltés: " + Assets.manager.getLoadedAssets() + "/" + (Assets.manager.getQueuedAssets() + Assets.manager.getLoadedAssets()) + " (" + ((int) (Assets.manager.getProgress() * 100f)) + "%)", loadingBar.getX()+loadingBar.getWidth()+loadingFrame.getWidth()/2-75, loadingBar.getY()+loadingFrame.getHeight()/2);
        spriteBatch.end();
    }



    @Override
    public void hide() {
        super.hide();
        Assets.manager.unload("pictures/loading.pack");
    }

    @Override
    public void init() {
        setBackGroundColor(0f, 0f, 0f);
        loadingStage = new LoadingStage(spriteBatch, game);
        inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(loadingStage);
        Gdx.input.setInputProcessor(inputMultiplexer);
    }
}
