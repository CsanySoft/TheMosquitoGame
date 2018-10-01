package hu.csanysoft.mosquitogame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanysoft.mosquitogame.GlobalClasses.Assets;
import hu.csanysoft.mosquitogame.MyBaseClasses.Scene2D.MyStage;
import hu.csanysoft.mosquitogame.MyBaseClasses.UI.MyButton;

public class MenuStage extends MyStage {

    TextButton btnStart, btnExit;
    Music hatterzene = Assets.manager.get(Assets.MUSIC_MENU);
    final TheMosquitoGame gameFinal;

    public MenuStage(Batch batch, TheMosquitoGame game) {
        super(new ExtendViewport(1024f, 768f), batch, game);
        this.gameFinal = game;

        hatterzene.setVolume(2.5f);
        hatterzene.setLooping(true);
        hatterzene.play();

        btnStart = new MyButton("", game.btnStart());
        btnStart.addListener(new ClickListener() {

            @Override

            public void clicked(InputEvent event, float x, float y) {

                super.clicked(event, x, y);
                hatterzene.stop();
                gameFinal.setScreen(new GameScreen(gameFinal));

            }

        });
        addActor(btnStart);
        btnStart.setPosition(getWidth()/2-btnStart.getWidth()/2,getHeight()/2+btnStart.getHeight());

        btnExit = new MyButton("", game.btnExit());
        btnExit.addListener(new ClickListener() {

            @Override

            public void clicked(InputEvent event, float x, float y) {

                super.clicked(event, x, y);
                hatterzene.stop();
                Gdx.app.exit();

            }

        });
        addActor(btnExit);
        btnExit.setPosition(getWidth()/2-btnExit.getWidth()/2,getHeight()/2-btnExit.getHeight());
    }

    @Override
    public void init() {

    }
}
