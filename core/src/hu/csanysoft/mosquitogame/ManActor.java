package hu.csanysoft.mosquitogame;

import com.badlogic.gdx.graphics.Texture;

import hu.csanysoft.mosquitogame.GlobalClasses.Assets;
import hu.csanysoft.mosquitogame.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;
import hu.csanysoft.mosquitogame.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class ManActor extends OneSpriteAnimatedActor {
    float pos, speed;
    short id;

    /**
     *
     * @param texture Az ember textúrája
     * @param pos Az ember kezdeti pozíciója
     * @param speed Az ember sebessége
     */

    public ManActor(Texture texture, float pos, float speed) {
        super(Assets.manager.get(Assets.WALK_TEXTUREATLAS));
        this.pos = pos;
        this.speed = speed;
        setPosition(pos, 100);
        setSize(getWidth()/3, getHeight()/3);
        System.out.println("getWidth() = " + getWidth());
    }

    public void setFlip(boolean x, boolean y) {
        sprite.setFlip(x, y);
    }

    public void setId(short id) {
        this.id = id;
    }

    public short getId() {
        return id;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        setX(getX() + speed);
    }
}
