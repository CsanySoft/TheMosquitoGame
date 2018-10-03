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
        szunyogseb = new MyInputField("Szúnyog sebesség: ",game.getTextFieldStyle_Black(), game.getTextFieldStyle_Red());
        szunyogseb.setPosition(100, 700);
        ember1seb = new MyInputField("Ember 1 sebesség: ",game.getTextFieldStyle_Black(), game.getTextFieldStyle_Red());
        ember1seb.setPosition(100, 500);
        ember2seb = new MyInputField("Ember 2 sebesség: ",game.getTextFieldStyle_Black(), game.getTextFieldStyle_Red());
        ember2seb.setPosition(100, 300);
        szunyogtav = new MyInputField("Szúnyog távolság: ",game.getTextFieldStyle_Black(), game.getTextFieldStyle_Red());
        szunyogtav.setPosition(600, 700);
        embertav = new MyInputField("Emberek közti táv: ",game.getTextFieldStyle_Black(), game.getTextFieldStyle_Red());
        embertav.setPosition(600, 500);
        szel = new MyInputField("Szél: ",game.getTextFieldStyle_Black(), game.getTextFieldStyle_Red());
        szel.setPosition(600, 300);
        addActor(szunyogseb);
        addActor(ember1seb);
        addActor(ember2seb);
        addActor(szunyogtav);
        addActor(embertav);
        addActor(szel);

    }


}
