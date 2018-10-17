package hu.csanysoft.mosquitogame;

import hu.csanysoft.mosquitogame.GlobalClasses.Assets;
import hu.csanysoft.mosquitogame.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;

public class ExplosionActor extends OneSpriteAnimatedActor {

    public ExplosionActor() {
        super(Assets.manager.get(Assets.EXPLOSION_TEXTURE));
        setFps(20);
    }

    @Override
    protected void repeated() {
        if(getStage()!=null) {
            getStage().getActors().removeValue(this, true);
        }
        super.repeated();
    }
}
