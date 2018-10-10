package hu.csanysoft.mosquitogame;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import hu.csanysoft.mosquitogame.MyBaseClasses.Scene2D.MyStage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.csanysoft.mosquitogame.MyBaseClasses.UI.MyButton;
import hu.csanysoft.mosquitogame.MyBaseClasses.UI.MyInputField;
import hu.csanysoft.mosquitogame.MyBaseClasses.UI.MyTextField;
import hu.csanysoft.mosquitogame.TheMosquitoGame;

public class InputStage extends MyStage{


    MyInputField szunyogseb, ember1seb, ember2seb, szunyogtav, embertav, szel;
    MyButton startButton;

    public InputStage(Batch batch, TheMosquitoGame game) {
        super(new ExtendViewport(game.SCREEN_WIDTH,game.SCREEN_HEIGHT), batch, game);
    }//todo: megcsinálni az adatok bekérését, és hibás adatok visszadobása
    @Override
    public void init() {
        szunyogseb = new MyInputField("Szúnyog sebesség: ",game.getTextFieldStyle_Black(), game.getTextFieldStyle_Red(), MyInputField.InputMode.POSITIVE_FlOAT_ONLY);
        szunyogseb.setPosition(10, 600);
        ember1seb = new MyInputField("Ember 1 sebesség: ",game.getTextFieldStyle_Black(), game.getTextFieldStyle_Red(), MyInputField.InputMode.POSITIVE_FlOAT_ONLY);
        ember1seb.setPosition(10, 400);
        ember2seb = new MyInputField("Ember 2 sebesség: ",game.getTextFieldStyle_Black(), game.getTextFieldStyle_Red(), MyInputField.InputMode.POSITIVE_FlOAT_ONLY);
        ember2seb.setPosition(10, 200);
        szunyogtav = new MyInputField("Szúnyog távolság: ",game.getTextFieldStyle_Black(), game.getTextFieldStyle_Red(), MyInputField.InputMode.POSITIVE_FlOAT_ONLY);
        szunyogtav.setPosition(600, 600);
        embertav = new MyInputField("Emberek közti táv: ",game.getTextFieldStyle_Black(), game.getTextFieldStyle_Red(), MyInputField.InputMode.POSITIVE_FlOAT_ONLY);
        embertav.setPosition(600, 400);
        szel = new MyInputField("Szél: ",game.getTextFieldStyle_Black(), game.getTextFieldStyle_Red(), MyInputField.InputMode.FLOAT);
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

    }

    void kalkulacio(){
        if(szunyogseb.isValid() && ember1seb.isValid() && ember2seb.isValid() && szunyogtav.isValid() && embertav.isValid() && szel.isValid()){
            System.out.println("succ");
        }else{
            System.out.println("no succ");
        }
    }


}
