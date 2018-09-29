package hu.csanysoft.mosquitogame.MyBaseClasses.UI;

import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import hu.csanysoft.mosquitogame.MyBaseClasses.Game.InitableInterface;

/**
 * Created by tuskeb on 2016. 09. 30..
 */
public class MyButton extends TextButton implements InitableInterface {

    public MyButton(String text, TextButtonStyle style) {
        super(text, style);
        init();
    }

    public void init() {
    }
}
