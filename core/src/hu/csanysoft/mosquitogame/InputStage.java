package hu.csanysoft.mosquitogame;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.viewport.Viewport;
import hu.csanysoft.mosquitogame.MyBaseClasses.Scene2D.MyStage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.csanysoft.mosquitogame.MyBaseClasses.UI.MyInputField;
import hu.csanysoft.mosquitogame.MyBaseClasses.UI.MyTextField;
import hu.csanysoft.mosquitogame.TheMosquitoGame;

public class InputStage extends MyStage{


    MyInputField szoveg;

    public InputStage(Batch batch, TheMosquitoGame game) {
        super(new ExtendViewport(1024f,768f), batch, game);
    }//todo: megcsinálni az adatok bekérését, és hibás adatok visszadobása
    @Override
    public void init() {
        szoveg = new MyInputField("lol",game.getTextFieldStyle_Black(), game.getTextFieldStyle_Red());
        szoveg.setPosition(100, 700);
        addActor(szoveg);
    }


}
