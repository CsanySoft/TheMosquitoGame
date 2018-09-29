package hu.csanysoft.mosquitogame.MyBaseClasses.Scene2D;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import hu.csanysoft.mosquitogame.MyBaseClasses.Game.InitableInterface;

/**
 * Created by tuskeb on 2016. 09. 30..
 */
abstract public class OneSpriteActor extends MyActor implements InitableInterface {
    protected Sprite sprite;

    public OneSpriteActor(Sprite sprite) {
        if (sprite!=null) {
            this.sprite = sprite;
            init();
        }
    }

    @Override
    public void init()
    {
        setSize(sprite.getWidth(), sprite.getHeight());
        sprite.setOrigin(getOriginX(), getOriginY());
        super.init();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        sprite.draw(batch);
        //System.out.println("Sprite "  + getOriginX());
    }


    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }


    @Override
    protected void positionChanged() {
        super.positionChanged();
        sprite.setPosition(getX(), getY());
    }

    @Override
    protected void rotationChanged() {
        super.rotationChanged();
        sprite.setRotation(getRotation());

    }

    @Override
    protected void sizeChanged() {
        super.sizeChanged();
        sprite.setSize(getWidth(), getHeight());
        sprite.setOrigin(getOriginX(), getOriginY());
    }

    @Override
    protected void originChanged() {
        super.originChanged();
        sprite.setOrigin(getOriginX(), getOriginY());
    }
}
