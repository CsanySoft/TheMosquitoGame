package hu.csanysoft.mosquitogame;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanysoft.mosquitogame.MyBaseClasses.Scene2D.MyStage;

public class LoadingStage extends MyStage {
    public LoadingStage(Batch batch, TheMosquitoGame game) {
        super(new ExtendViewport(game.SCREEN_WIDTH,game.SCREEN_HEIGHT), batch, game);
        System.out.println("Kész");
        fitWorldToWidth();

        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                System.out.println("x = " + x);
                System.out.println("y = " + y);
            }
        });
    }

    @Override
    public void init() {

    }

    @Override
    public void setViewport(Viewport viewport){
        super.setViewport(viewport);
    }

    @Override
    public void resize(int screenWidth, int screenHeight) {
        super.resize(screenWidth, screenHeight);
        System.out.println("fkfk");
        System.out.println("getViewport().getWorldWidth() = " + getViewport().getWorldWidth());
        System.out.println("getViewport().getScreenWidth() = " + getViewport().getScreenWidth());

        getViewport().setScreenSize(screenWidth, screenHeight);
        fitWorldToWidth();
        System.out.println(screenWidth);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw() {
        super.draw();
    }
}
