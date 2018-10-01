package hu.csanysoft.mosquitogame;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.csanysoft.mosquitogame.MyBaseClasses.Scene2D.MyStage;

public class LoadingStage extends MyStage {
    public LoadingStage(Batch batch, TheMosquitoGame game) {
        super(new ExtendViewport(1024f,768f), batch, game);
        System.out.println("Kész");
    }

    @Override
    public void init() {

    }

    @Override
    public void draw() {
        super.draw();
    }
}
