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

    TextButton btnStart, btnExit, btnInput;
    Music hatterzene = Assets.manager.get(Assets.MUSIC_MENU);
    Music gombSound = Assets.manager.get(Assets.MUSIC_CLICK);
    final TheMosquitoGame gameFinal;

    public MenuStage(Batch batch, TheMosquitoGame game) {
        super(new ExtendViewport(game.SCREEN_WIDTH, game.SCREEN_HEIGHT), batch, game);
        this.gameFinal = game;

        hatterzene.setVolume(2.5f);
        hatterzene.setLooping(true);
        hatterzene.play();

 /*       btnStart = new MyButton("", game.btnStart());
        btnStart.addListener(new ClickListener() {

            @Override

            public void clicked(InputEvent event, float x, float y) {

                super.clicked(event, x, y);
                gombSound.play();
                hatterzene.stop();
                gameFinal.setScreen(new GameScreen(gameFinal));

            }

        });
        addActor(btnStart);
        btnStart.setPosition(getViewport().getWorldWidth() / 2 - btnStart.getWidth() / 2, getViewport().getWorldHeight() / 2 + btnStart.getHeight());
*/
        btnExit = new MyButton("", game.btnExit());
        btnExit.addListener(new ClickListener() {

            @Override

            public void clicked(InputEvent event, float x, float y) {

                super.clicked(event, x, y);
                gombSound.play();
                hatterzene.stop();
                Gdx.app.exit();

            }

        });
        addActor(btnExit);
        btnExit.setPosition(getViewport().getWorldWidth() / 2 - btnExit.getWidth() / 2, getViewport().getWorldHeight() / 2 - btnExit.getHeight());
        btnInput = new MyButton("input teszt", game.btnStart());
        btnInput.addListener(new ClickListener() {

            @Override

            public void clicked(InputEvent event, float x, float y) {

                super.clicked(event, x, y);
                gombSound.play();
                gameFinal.setScreen(new InputScreen(gameFinal));
            }

        });
        btnInput.setPosition(getViewport().getWorldWidth() / 2 - btnInput.getWidth() / 2, getViewport().getWorldHeight() / 2 + btnInput.getHeight()*2);
        addActor(btnInput);
    }

    @Override
    public void init() {

    }
}
