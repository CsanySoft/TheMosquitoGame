package hu.csanysoft.mosquitogame;

import com.badlogic.gdx.Gdx;

import java.util.Random;

import hu.csanysoft.mosquitogame.MyBaseClasses.Scene2D.MyScreen;

public class MenuScreen extends MyScreen {

    protected MenuStage menuStage;
    Random rand;
    private float elapsedTime = 0;
    boolean r, g, b;
    float rf=0, gf=0, bf=0;

    public MenuScreen(TheMosquitoGame game) {
        super(game);
        rand = new Random();
        r = true;
        g = false;
        b = false;
        menuStage.addBackEventStackListener();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        menuStage.act();
        menuStage.draw();
        if(r) {
            rf += delta;
            gf -= delta;
            bf -= delta;
        }
        if(g) {
            rf -= delta;
            gf += delta;
            bf -= delta;
        }
        if(b) {
            rf -= delta;
            gf -= delta;
            bf += delta;
        }

        if(rf > 1) {
            r = false;
            g = false;
            b = true;
        } else if (gf > 1){
            r = false;
            g = true;
            b = false;
        } else if (bf > 1) {
            r = true;
            g = false;
            b = false;
        }
        setBackGroundColor((float)Math.sin(rf) , (float)Math.sin(gf), (float)Math.sin(bf));
    }

    @Override
    public void init() {
        menuStage = new MenuStage(spriteBatch, game);
        Gdx.input.setInputProcessor(menuStage);
    }
}
