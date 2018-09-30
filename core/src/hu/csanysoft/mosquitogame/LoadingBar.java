package hu.csanysoft.mosquitogame;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import hu.csanysoft.mosquitogame.MyBaseClasses.Scene2D.MyActor;

public class LoadingBar extends MyActor {

    Animation animation;
    TextureRegion textureRegion;
    float stateTime;

    public LoadingBar(Animation animation) {
        this.animation = animation;
        textureRegion = (TextureRegion) animation.getKeyFrame(0);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        stateTime+=delta;
        textureRegion = (TextureRegion) animation.getKeyFrame(0);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(textureRegion, getX(), getY());
    }
}
