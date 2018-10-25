package hu.csanysoft.mosquitogame;

import hu.csanysoft.mosquitogame.GlobalClasses.Assets;
import hu.csanysoft.mosquitogame.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class HelpHandActor extends OneSpriteStaticActor {

    public HelpHandActor(float x, float y) {
        super(Assets.manager.get(Assets.HELPHAND_TEXTURE));
        setPosition(x, y);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        System.out.println(elapsedTime);
        setSize(getWidth() + (float)Math.cos(elapsedTime*10)*2, getHeight() + (float)Math.sin(elapsedTime*10)*2);
    }
}
