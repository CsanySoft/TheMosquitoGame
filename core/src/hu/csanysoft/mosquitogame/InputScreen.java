package hu.csanysoft.mosquitogame;

import com.badlogic.gdx.*;
import hu.csanysoft.mosquitogame.InputStage;
import hu.csanysoft.mosquitogame.MyBaseClasses.Scene2D.MyScreen;

public class InputScreen extends MyScreen {

    InputStage inputStage;
    InputMultiplexer inputMultiplexer;

    private float elapsedTime = 0;
    boolean r, g, b;
    float rf=0, gf=0, bf=0;

    public InputScreen(TheMosquitoGame game) {
        super(game);
        r = true;
        g = false;
        b = false;
    }

    @Override
    public void init() {
        inputStage = new InputStage(spriteBatch, game);
        setBackGroundColor(0.4f, 0.4f, 0.5f);
        inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(inputStage);
        Gdx.input.setInputProcessor(inputMultiplexer);
        inputStage.addBackEventStackListener();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);

        inputStage.resize(width, height);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        //if(inputStage.getElapsedTime()>1)
            //game.setScreen(new GameScreen(game));//Todo: Dummy, magyarán ez azért van, hogyha le van futtatva, akkor ne álljon meg és ne csináljon semmit
        inputStage.act(delta);
        inputStage.draw();


        if(r) {
            rf += delta/4;
            gf -= delta/4;
            bf -= delta/4;
        }
        if(g) {
            rf -= delta/4;
            gf += delta/4;
            bf -= delta/4;
        }
        if(b) {
            rf -= delta/4;
            gf -= delta/4;
            bf += delta/4;
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
}
