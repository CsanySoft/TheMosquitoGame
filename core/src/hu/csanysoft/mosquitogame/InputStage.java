package hu.csanysoft.mosquitogame;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import hu.csanysoft.mosquitogame.MyBaseClasses.Scene2D.MyStage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import java.util.ArrayList;
import java.util.HashMap;

import hu.csanysoft.mosquitogame.MyBaseClasses.UI.MyButton;
import hu.csanysoft.mosquitogame.MyBaseClasses.UI.MyInputField;
import hu.csanysoft.mosquitogame.MyBaseClasses.UI.MyTextField;
import hu.csanysoft.mosquitogame.TheMosquitoGame;

public class InputStage extends MyStage{


    MyInputField szunyogseb, ember1seb, ember2seb, szunyogtav, embertav, szel;
    MyButton startButton;
    public static int SZUNYOG_SEB = 0, EMBER1_SEB = 1, EMBER2_SEB = 2, SZUNYOG_TAV = 3, EMBER_TAV = 4, SZEL = 5;
    static ArrayList<Float> adatok;

    public InputStage(Batch batch, TheMosquitoGame game) {
        super(new ExtendViewport(game.SCREEN_WIDTH,game.SCREEN_HEIGHT), batch, game);
    }
    @Override
    public void init() {
        szunyogseb = new MyInputField("Szúnyog sebesség: ", "m/s",game.getTextFieldStyle_Black(), game.getTextFieldStyle_Red(), MyInputField.InputMode.POSITIVE_FlOAT_ONLY);
        szunyogseb.setPosition(10, 600);
        ember1seb = new MyInputField("Ember 1 sebesség: ", "m/s",game.getTextFieldStyle_Black(), game.getTextFieldStyle_Red(), MyInputField.InputMode.POSITIVE_FlOAT_ONLY);
        ember1seb.setPosition(10, 400);
        ember2seb = new MyInputField("Ember 2 sebesség: ", "m/s",game.getTextFieldStyle_Black(), game.getTextFieldStyle_Red(), MyInputField.InputMode.POSITIVE_FlOAT_ONLY);
        ember2seb.setPosition(10, 200);
        szunyogtav = new MyInputField("Szúnyog távolság: ","m",game.getTextFieldStyle_Black(), game.getTextFieldStyle_Red(), MyInputField.InputMode.POSITIVE_FlOAT_ONLY);
        szunyogtav.setPosition(600, 600);
        embertav = new MyInputField("Emberek közti táv: ","m",game.getTextFieldStyle_Black(), game.getTextFieldStyle_Red(), MyInputField.InputMode.POSITIVE_FlOAT_ONLY);
        embertav.setPosition(600, 400);
        szel = new MyInputField("Szél: ","m/s",game.getTextFieldStyle_Black(), game.getTextFieldStyle_Red(), MyInputField.InputMode.FLOAT);
        szel.setPosition(600, 200);
        startButton = new MyButton("", game.btnStart());
        startButton.setPosition(getWidth()/2-startButton.getWidth()/2, 50);
        startButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                kalkulacio();
            }
        });
        addActor(szunyogseb);
        addActor(ember1seb);
        addActor(ember2seb);
        addActor(szunyogtav);
        addActor(embertav);
        addActor(szel);
        addActor(startButton);

        adatok = new ArrayList<>();

    }

    @org.jetbrains.annotations.Contract(pure = true)
    public static float getValue(int i) {
        return adatok.get(i);
    }

    void kalkulacio(){
        if(szunyogseb.isValid() && ember1seb.isValid() && ember2seb.isValid() && szunyogtav.isValid() && embertav.isValid() && szel.isValid()){
            System.out.println("succ");
            adatok.add(szunyogseb.getValue());
            adatok.add(ember1seb.getValue());
            adatok.add(ember2seb.getValue());
            adatok.add(szunyogtav.getValue());
            adatok.add(embertav.getValue());
            adatok.add(szel.getValue());
            game.setScreen(new GameScreen(game));
        }else{
            System.out.println("no succ");
        }
    }


}
