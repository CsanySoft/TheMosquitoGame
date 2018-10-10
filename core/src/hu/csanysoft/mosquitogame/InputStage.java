package hu.csanysoft.mosquitogame;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.viewport.Viewport;
import hu.csanysoft.mosquitogame.MyBaseClasses.Scene2D.MyStage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.csanysoft.mosquitogame.MyBaseClasses.UI.MyInputField;
import hu.csanysoft.mosquitogame.MyBaseClasses.UI.MyTextField;
import hu.csanysoft.mosquitogame.TheMosquitoGame;

public class InputStage extends MyStage{


    MyInputField szunyogseb, ember1seb, ember2seb, szunyogtav, embertav, szel;

    public InputStage(Batch batch, TheMosquitoGame game) {
        super(new ExtendViewport(1024f,768f), batch, game);
    }//todo: megcsinálni az adatok bekérését, és hibás adatok visszadobása
    @Override
    public void init() {
        szunyogseb = new MyInputField("Szúnyog sebesség: ",game.getTextFieldStyle_Black(), game.getTextFieldStyle_Red(), MyInputField.InputMode.POSITIVE_FlOAT_ONLY);
        szunyogseb.setPosition(10, 700);
        ember1seb = new MyInputField("Ember 1 sebesség: ",game.getTextFieldStyle_Black(), game.getTextFieldStyle_Red(), MyInputField.InputMode.POSITIVE_FlOAT_ONLY);
        ember1seb.setPosition(10, 500);
        ember2seb = new MyInputField("Ember 2 sebesség: ",game.getTextFieldStyle_Black(), game.getTextFieldStyle_Red(), MyInputField.InputMode.POSITIVE_FlOAT_ONLY);
        ember2seb.setPosition(10, 300);
        szunyogtav = new MyInputField("Szúnyog távolság: ",game.getTextFieldStyle_Black(), game.getTextFieldStyle_Red(), MyInputField.InputMode.POSITIVE_FlOAT_ONLY);
        szunyogtav.setPosition(500, 700);
        embertav = new MyInputField("Emberek közti táv: ",game.getTextFieldStyle_Black(), game.getTextFieldStyle_Red(), MyInputField.InputMode.POSITIVE_FlOAT_ONLY);
        embertav.setPosition(500, 500);
        szel = new MyInputField("Szél: ",game.getTextFieldStyle_Black(), game.getTextFieldStyle_Red(), MyInputField.InputMode.FLOAT);
        szel.setPosition(500, 300);
        addActor(szunyogseb);
        addActor(ember1seb);
        addActor(ember2seb);
        addActor(szunyogtav);
        addActor(embertav);
        addActor(szel);

    }


}
